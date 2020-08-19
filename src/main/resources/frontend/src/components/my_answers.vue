<template>
  <el-container>
    <el-col span="2" :xs="8">
    <el-aside width="160px" id="leftside">

    </el-aside>
    </el-col>

    <el-col span="20" :xs="16" id="maintable">
    <el-main>
      您的回复：<br>
      <div style="margin-top: 20px">

          <el-table
            style="width: 100%"
            :data="items"
            @row-click="forward"
            id="column"
          >
            <template v-for="(item,index) in tableHead">
              <el-table-column align="center" :prop="item.column_name" :label="item.column_comment" :key="item.create_time"></el-table-column>
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
        </el-main>
    </el-col>

    <el-col span="2">
        <el-aside id="rightside" width="160px">

        </el-aside>
    </el-col>
  </el-container>
</template>

<script>
    export default {
      name: "my_answers",
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
          let _this = this;
          const axios = require('axios')
          this.current_page=val;
          this.start = (val-1)*10;
          axios.get('/queryReplyWithPage',{
            params:{
              uid:this.uid,
              start:this.start,
              limit:this.limit
            },}).then(response=>{
              _this.items=[];
            for (let i = 0; i < response.data.length ; i++) {
              _this.items.push({title:response.data[i].content,create_time:response.data[i].create_time,stars: response.data[i].stars,challenges: response.data[i].challenges,solved: response.data[i].solve});
              if(_this.items[i].solved === true){
                _this.items[i].solved = '是';
              }else{
                _this.items[i].solved ='否';
              }
            }
          })
        }
        },
      data(){
        return{
          total:0,
          limit:10,
          start:0,
          current_page:1,
          tableHead:[
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
          items:[{column_name:'',title:'',create_time:'',stars:0,challenges:0,solved:''}],
        }},

      beforeCreate() {
        let _this = this;
        const axios = require('axios')
        //authenticate user
        axios.get('/queryUserByUsername',{
          params:{
            username:this.$store.state.Authorization
          },}).then(response=>(
          this.uid=response.data.id,
          axios.get('/queryReplyPage',{
            params:{
              limit:this.limit,
              uid:this.uid
            }}).then(response=>{
            this.total=response.data.totalNum;
            axios.get('/queryReplyWithPage',{
              params:{
                uid:this.uid,
                start:this.start,
                limit:this.limit
              },}).then(response=>{
              for (let i = 0; i < response.data.length ; i++) {

                _this.items.push({title:response.data[i].content,create_time:response.data[i].create_time,stars: response.data[i].stars,challenges: response.data[i].challenges,solved: response.data[i].solve});
                if(_this.items[i].solved === true){
                  _this.items[i].solved = '是';
                }else{
                  _this.items[i].solved ='否';
                }
              }
              _this.items.shift();
            })
          })




        ))
        if(this.$store.state.Authorization==null|this.$store.state.Authorization===''||this.$store.state.Authorization===undefined){
          this.$router.push('/login');}
      }}

</script>

<style scoped>
  .block{
    float:left;
  }

  #leftside
  {
    position:relative;
    top:20px;
    left:33px;
  }

  #rightside{
    position:relative;
    top:20px;
    left:20px;
  }

  body > .el-container {
    margin-bottom: 40px;
  }

  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }

  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }

  #column{
    cursor: pointer;
  }

  @media screen and (max-width: 768px) {
    #maintable{
      position:relative;
      bottom:40px;
    }
  }
</style>
