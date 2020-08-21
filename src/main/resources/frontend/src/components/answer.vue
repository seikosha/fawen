<template>
  <el-container>
    <left_card id="left_card"></left_card>
    <el-main id="maintable">
      <el-col :span="1"><span>&nbsp;</span></el-col>
      <el-col :span="23">
        <div  style="margin-top: 15px">
          <h2>法问上的最新问题：</h2>
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

      </el-col>

    </el-main>
    <right_card id="right_card"></right_card>
  </el-container>
</template>

<script>
    import left_card from "./left_card";
    import right_card from "./right_card";

    export default {
        name: "answer",
      components:{
        left_card,
        right_card
      },
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

        handleCurrentChange(val){
          let _this=this;
          const axios = require('axios')
          this.current_page=val;
          this.start = (val-1)*10;
          axios.get('/queryContentList',{
            params:{
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
        }

        },
      data() {
        return {
          total:0,
          limit:10,
          start:0,
          current_page:1,
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
          items:[{column_name:'',poster:'',title:'',category:'',location:'',create_time:''}],
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
          axios.get('/queryContentPageWithoutUid',{
            params:{
              limit:this.limit,
            }}).then(response=>{
              this.total=response.data.totalNum;
            axios.get('/queryContentList',{
              params:{
                start:this.start,
                limit:this.limit
              }}).then(response=>{
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
        if(_this.$store.state.Authorization==null|_this.$store.state.Authorization===''||_this.$store.state.Authorization===undefined){
          this.$router.push('/login')};
      }


    }

</script>

<style scoped>
.block{
  float:left;
}
#rightside{
  position:relative;
  left:33px;
}

#leftside
{
  position:relative;
  right:5px;
}

#column{
  cursor: pointer;
}

@media screen and (max-width: 768px) {
  #maintable{
    position:relative;
  }

  #left_card,#right_card{
    display:none;
  }
}

</style>
