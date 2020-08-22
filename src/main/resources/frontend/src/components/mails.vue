<template>
<el-container>
  <el-col span="4"  style="margin-top: 15px"></el-col>

  <el-col span="16"  style="margin-top: 15px" id="main">
  <h2>您的站内私信：</h2>
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

  <el-col span="4" style="margin-top: 15px"></el-col>
</el-container>
</template>

<script>
    export default {
        name: "mails",
        data() {
          return {
            total:0,
            limit:10,
            start:0,
            current_page:1,
            tableHead:[
              {
                column_name:"title",column_comment:"标题"
              },
              {
                column_name: "sender_name",column_comment: "发信人"
              },
              {
                column_name: "send_time",column_comment: "发信时间"
              }
            ],
            items:[{column_name:'',title:'',sender_name:'',send_time:''}],
        }},

      methods:{
        forward(row){
          let thisRowData=this;
          thisRowData=row;
          let rowTitle = thisRowData.title;
          let rowTime = thisRowData.send_time;
          this.$store.commit('saveMail',{CurrentMail:rowTime+rowTitle});
          this.$router.push('/mail_specific')
        },
        handleCurrentChange(val){
          let _this = this;
          const axios = require('axios')
          this.current_page=val;
          this.start = (val-1)*10;
          axios.get('/queryMailWithPage',{
            params:{
              receiver_id:_this.uid,
              start:this.start,
              limit:this.limit
            }}).then(response=>{
              _this.items=[];
            for (let i = 0; i < response.data.length ; i++) {
              _this.items.push({title:response.data[i].title,send_time:response.data[i].send_time,sender_name:response.data[i].sender_id});
            }
            _this.items.shift();

            for (let i = 0; i < response.data.length ; i++) {
              axios.get('/queryUsernameById',{
                params:{
                  id:response.data[i].sender_id
                }}).then(response=>{
                _this.items[i].sender_name=response.data;
              })
            }
          })
        }
      },

      beforeCreate() {
        let _this = this;
        const axios = require('axios')

        axios.get('/queryUserByUsername',{
          params:{
            username:this.$store.state.Authorization
          },}).then(response=>(
          this.uid=response.data.id,
            axios.get('/queryMailPage',{
              params:{
                limit:this.limit,
                uid:this.uid
              }}).then(response=>{
                this.total=response.data.totalNum;
              axios.get('/queryMailWithPage',{
                params:{
                  receiver_id:_this.uid,
                  start:this.start,
                  limit:this.limit
                },}).then(response=>{
                for (let i = 0; i < response.data.length ; i++) {
                  _this.items.push({title:response.data[i].title,send_time:response.data[i].send_time,sender_name:response.data[i].sender_id});
                }
                _this.items.shift();

                for (let i = 0; i < response.data.length ; i++) {
                  axios.get('/queryUsernameById',{
                    params:{
                      id:response.data[i].sender_id
                    }}).then(response=>{
                    _this.items[i].sender_name=response.data;
                  })
                }
              })
            })
        ))
        if(this.$store.state.Authorization==null|this.$store.state.Authorization===''||this.$store.state.Authorization===undefined){
          this.$router.push('/login');
        }}}

</script>

<style scoped>
  #leftside
  {
    position:relative;
    top:30px;
    left:33px;
    width:200px;
  }
  #main{
    position:relative;
    left:20px;
  }

  #column{
    cursor: pointer;
  }

  @media screen and (max-width: 768px) {
    #main{
      position:relative;

    }
  }
</style>
