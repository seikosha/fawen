<template>
  <el-container>
    <el-main>
      您提过的问题：<br>
      <el-col :span="5"><span>&nbsp;</span></el-col>
      <el-col :span="14">
        <div style="margin-top: 15px">
        <el-table
          style="width: 100%"
          :data="items"
          >
          <template v-for="(item,index) in tableHead">
            <el-table-column :prop="item.column_name" :label="item.column_comment" :key="index"></el-table-column>
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
      <el-col :span="5"><span>&nbsp;</span></el-col>

    </el-main>
  </el-container>
</template>

<script>
  export default {
    name: "ask",
    methods: {
      tableRowClassName({row, rowIndex}) {
        if (rowIndex === 1) {
          return 'warning-row';
        } else if (rowIndex === 3) {
          return 'success-row';
        }
        return '';
      }},
      data() {
        return {
          tableHead:[
            {
              column_name:"title",column_comment:"标题"
            },
            {
              column_name: "create_time",column_comment: "创建时间"
            },
            {
              column_name: "update_time",column_comment: "更新时间"
            }
          ],
          items:[{column_name:'',cid:0,uid:0,title:'虽然很艰难',content:'日子还要过',category:'',location:'',create_time:'2020-1-1',update_time:'2020-1-2',count_reply:0}],
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
          axios.get('/queryContentByUid',{
            params:{
              uid:this.uid
            },}).then(response=>{
            for (let i = 0; i < response.data.length; i++) {
              _this.items.push({cid:response.data[i].id,uid:response.data[i].uid,title:response.data[i].title,content:response.data[i].content,category:response.data[i].category,location:response.data[i].location,create_time:response.data[i].create_time,update_time:response.data[i].update_time})
            }
            _this.items.shift();
            console.log(_this.items)
          })

        ))

        if(_this.$store.state.Authorization==null|_this.$store.state.Authorization===''||_this.$store.state.Authorization===undefined){
          this.$router.push('/login')};






  }}


</script>

<style scoped>
.block{
  float:left;
}
</style>

