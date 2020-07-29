<template>
  <el-container>
    <el-main id="maintable">
      <el-col :xs="8"></el-col>
      <el-col :xs="16">
      <span>关键字为:"{{this.$store.state.CurrentKeyword}}"的提问</span><br>

        <div  style="margin-top: 15px">
          <el-table
            style="width: 100%"
            :data="items"
            @row-click="forward"
            id="column"
          >
            <template v-for="(item,index) in tableHead">
              <el-table-column align="center" :prop="item.column_name" :label="item.column_comment" :key="item.update_time" ></el-table-column>
            </template>
          </el-table>
        </div>

      <div class="block">
        <el-pagination
          layout="prev, pager, next"
          @current-change="handleCurrentChange"
          :page-size="limit"
          current-page="current_page"
          :total="total">
        </el-pagination>
      </div>

      <br><br>
      <span>关键字为:"{{this.$store.state.CurrentKeyword}}"的回答</span><br>

      <div style="margin-top: 30px">

        <el-table
          style="width: 100%"
          :data="items1"
          @row-click="forward1"
          id="column1"
        >
          <template v-for="(item,index) in tableHead1">
            <el-table-column align="center" :prop="item.column_name" :label="item.column_comment" :key="item.create_time"></el-table-column>
          </template>

        </el-table>
      </div>

      <div class="block">
        <el-pagination
          layout="prev, pager, next"
          @current-change="handleCurrentChange1"
          :page-size="limit1"
          current-page="current_page1"
          :total="total1">
        </el-pagination>
      </div>
      </el-col>
    </el-main>
  </el-container>
</template>

<script>
    export default {
        name: "search_result",
      methods: {
        tableRowClassName({row, rowIndex}) {
          if (rowIndex === 1) {
            return 'warning-row';
          } else if (rowIndex === 3) {
            return 'success-row';
          }
          return '';

        },
        forward(row){
          let thisRowData=this;
          thisRowData=row;
          let rowTitle = row.title;
          let rowTime = row.create_time;
          this.$store.commit('saveContent',{CurrentContent: rowTime+rowTitle});
          this.$router.push('/specific_content');
        },
        forward1(row){
          let thisRowData=this;
          const axios = require('axios')
          thisRowData=row;
          console.log(row.title)

          let rowTitle = row.title;
          let rowTime = row.create_time;
          let rowCid = 0;
          axios.get('/queryCidByTitleAndTime',{
            params:{
              title:rowTitle,
              time:rowTime
            }}).then(response=>{
            rowCid=response.data;
            console.log(rowCid)
            axios.get('/queryContentByCid',{
              params:{
                cid:rowCid
              }}).then(response=>{
              console.log(response.data)
              rowTitle=response.data.title,
                rowTime=response.data.create_time
              this.$store.commit('saveContent',{CurrentContent: rowTime+rowTitle});
              this.$router.push('/specific_content');
            })
          })
        },
        handleCurrentChange(val){
          let _this=this;
          const axios = require('axios')
          this.current_page = val;
          this.start = (val-1)*10;
          axios.get('/queryContentByKeyword',{
            params:{
              keyword:this.$store.state.CurrentKeyword,
              start:this.start,
              limit:this.limit
            }}).then(response=>{
              _this.items=[];
            for (let i = 0; i < response.data.length; i++) {
              _this.items.push({poster:response.data[i].uid,title:response.data[i].title,category:response.data[i].category,location:response.data[i].location,create_time:response.data[i].create_time})
            }
            for (let i = 0; i < response.data.length; i++) {
              axios.get('/queryUsernameById',{
                params:{
                  id:_this.items[i].poster
                }}).then(response=>{
                _this.items[i].poster=response.data
              })
            }
          })
        },
        handleCurrentChange1(val){
          let _this = this;
          const axios = require('axios')
          this.current_page1 = val;
          this.start1 = (val-1)*10;
          axios.get('/queryReplyByKeyword',{
            params:{
              keyword:this.$store.state.CurrentKeyword,
              start:this.start1,
              limit:this.limit1
            }}).then(response=>{
              _this.items1=[];
            for (let i = 0; i < response.data.length ; i++) {
              _this.items1.push({title:response.data[i].content,create_time:response.data[i].create_time,stars:response.data[i].stars,challenges:response.data[i].challenges,solved:response.data[i].solve});
              if(_this.items1[i].solved === true){
                _this.items1[i].solved = '是';
              }else{
                _this.items1[i].solved ='否';
              }
            }
          })
        }



      },
      data() {
        return {
          total:0,
          total1:0,
          limit:10,
          limit1:10,
          start:0,
          start1:0,
          current_page:1,
          current_page1:1,
          keyword:'',
          tableHead:[
            {
              column_name:"poster",column_comment:"提问人"
            },
            {
              column_name: "title",column_comment: "标题"
            },
            {
              column_name: "category",column_comment: "类型"
            },
            {
              column_name:"location",column_comment: "地区"
            },
            {
              column_name:"create_time",column_comment:"发帖时间"
            }
          ],
          items:[{column_name:'',poster:'',title:'',category:'',location:'',create_time:'2020-1-1'}],
          tableHead1:[
            {
              column_name:"title",column_comment:"标题"
            },
            {
              column_name: "create_time",column_comment: "跟帖日期"
            },
            {
              column_name: "stars",column_comment: "赞同数"
            },
            {
              column_name:"challenges",column_comment: "挑战数"
            },
            {
              column_name: "solved",column_comment: "是否解决问题"
            }
          ],
          items1:[{column_name:'',title:'虽然很艰难',create_time:'',stars:0,challenges:0,solved:''}],
        }},

      beforeCreate() {
        let _this = this;
        const axios = require('axios')


        //authenticate user
        axios.get('/queryUserByUsername',{
          params:{
            username:this.$store.state.Authorization
          }}).then(response=>(
          this.uid=response.data.id,
          axios.get('/queryContentPageByKeyword',{
            params:{
              limit:this.limit,
              keyword:this.$store.state.CurrentKeyword
            }}).then(response=>{
              console.log(response.data)
              this.total=response.data.totalNum;
            axios.get('/queryContentByKeyword',{
              params:{
                keyword:this.$store.state.CurrentKeyword,
                start:this.start,
                limit:this.limit,
              }
            }).then(response=>{
              for (let i = 0; i < response.data.length; i++) {
                _this.items.push({poster:response.data[i].uid,title:response.data[i].title,category:response.data[i].category,location:response.data[i].location,create_time:response.data[i].create_time})
              }
              _this.items.shift();
              for (let i = 0; i < response.data.length; i++) {
                axios.get('/queryUsernameById',{
                  params:{
                    id:_this.items[i].poster
                  }}).then(response=>{
                  _this.items[i].poster=response.data
                })
              }
            })
          })
        ))
        axios.get('/queryReplyPageByKeyword',{
          params:{
            limit:this.limit1,
            keyword:this.$store.state.CurrentKeyword
          }}).then(response=>{
            console.log(response.data)
            this.total1=response.data.totalNum;
          axios.get('/queryReplyByKeyword',{
            params:{
              keyword:this.$store.state.CurrentKeyword,
              start:this.start1,
              limit:this.limit1
            }}).then(response=>{
            for (let i = 0; i < response.data.length ; i++) {
              _this.items1.push({title:response.data[i].content,create_time:response.data[i].create_time,stars:response.data[i].stars,challenges:response.data[i].challenges,solved:response.data[i].solve});
              if(_this.items1[i].solved === true){
                _this.items1[i].solved = '是';
              }else{
                _this.items1[i].solved ='否';
              }
            }
            _this.items1.shift();
          })
        })









        if(_this.$store.state.Authorization==null|_this.$store.state.Authorization===''||_this.$store.state.Authorization===undefined){
          this.$router.push('/login')};
      }


    }

</script>

<style scoped>
  #column,column1{
    cursor: pointer;
  }
  @media screen and (max-width: 768px) {
    #maintable{
      position:relative;
      left:280px;
      bottom:40px;
    }
  }
</style>
