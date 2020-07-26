<template>
  <el-container>
    <left_card></left_card>
    <el-main>
      法问上的明星回答者：<br>
      <el-col :span="2"><span>&nbsp;</span></el-col>
      <el-col :span="20">
        <div style="margin-top: 15px">
          <el-table
            style="width: 100%"
            :data="items"
            @row-click="forward"
            id="column"
          >
            <template v-for="(item,index) in tableHead">
              <el-table-column align="center" :prop="item.column_name" :label="item.column_comment" :key="item.update_time"></el-table-column>
            </template>

          </el-table>
        </div>

        <div class="block">
          <el-pagination
            layout="prev, pager, next"
            :total="1000">
          </el-pagination>
        </div>
      </el-col>
      <el-col :span="2"><span>&nbsp;</span></el-col>

    </el-main>
    <right_card></right_card>
  </el-container>
</template>

<script>
  import left_card from "./left_card";
  import right_card from "./right_card";
  export default {
    name: "star_user",
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
        let username = row.username;

        this.$store.commit('saveUser',{CurrentUser: username});
        this.$router.push('/personal_specific');
      }
    },
    data() {
      return {
        tableHead:[
          {
            column_name:"username",column_comment:"用户名"
          },
          {
            column_name: "location",column_comment: "地区"
          },
          {
            column_name:"stars",column_comment: "赞同数"
          },
          {
            column_name:"best",column_comment: "最佳数"
          },
          {
            column_name:"solve",column_comment: "解决问题数"
          }
        ],
        items:[{column_name:'',username:'',location:'',stars:0,best:0,solve:0}],
      }},

      beforeCreate() {
        let _this = this;
        const axios = require('axios')
        //get Points of users
        axios.get('/queryPoints').then(response=>{
          for (let i = 0; i < response.data.length ; i++) {
            _this.items.push({location:'',username:response.data[i].uid,stars:response.data[i].sum_stars,best:response.data[i].sum_best,solve:response.data[i].sum_solve})
          }
          _this.items.shift();

          //get other user info
          for (let i = 0; i < response.data.length ; i++) {
            axios.get('/queryUserById',{
              params:{
                id:_this.items[i].username
              }}).then(response=>{
                _this.items[i].username=response.data[0].username;
                _this.items[i].location=response.data[0].location;
            })

          }

        })
      }
      }



</script>

<style scoped>
  .block{
    float:left;
  }

  #column{
    cursor: pointer;
  }
</style>
