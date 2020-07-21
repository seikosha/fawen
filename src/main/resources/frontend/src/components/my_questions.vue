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
      },

      forward(row){
        let thisRowData=this;
        thisRowData=row;
        let rowTitle = row.title;
        let rowTime = row.create_time;
        this.$store.commit('saveContent',{CurrentContent: rowTime+rowTitle});
        this.$router.push('/specific_content');
      }

      },
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
            },
            {
              column_name:"reply_count",column_comment: "回复数"
            }
          ],
          items:[{column_name:'',cid:0,uid:0,title:'虽然很艰难',content:'日子还要过',category:'',location:'',create_time:'2020-1-1',update_time:'2020-1-2',reply_count:0}],
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

          //get table contents
          axios.get('/queryContentByUid',{
            params:{
              uid:this.uid
            },}).then(response=>{
            for (let i = 0; i < response.data.length; i++) {
              _this.items.push({cid:response.data[i].id,uid:response.data[i].uid,title:response.data[i].title,content:response.data[i].content,category:response.data[i].category,location:response.data[i].location,create_time:response.data[i].create_time,reply_count:0,update_time:''})
            }
            _this.items.shift();

            //get reply_count & update_time
            for (let i = 0; i < response.data.length ; i++) {
              axios.get('/queryReplyCount',{
                params:{
                  uid:_this.items[i].uid,
                  cid:_this.items[i].cid
                },}).then(response=>{
                _this.items[i].reply_count=response.data;

                //get last update time
                axios.get('/queryLastUpdateTime',{
                  params:{
                    cid:_this.items[i].cid
                  },}).then(response=>{
                    _this.items[i].update_time=response.data;
                })

              })
            }
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

#column{
  cursor: pointer;
}
</style>

