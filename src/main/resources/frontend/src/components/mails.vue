<template>
<el-container>
  <el-col span="4" style="margin-top: 15px"></el-col>


  <el-col span="16" style="margin-top: 15px" id="main">

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
  </el-col>

  <el-col span="4" style="margin-top: 15px"></el-col>
</el-container>
</template>

<script>
    export default {
        name: "mails",
        data() {
          return {
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
            items:[{column_name:'',title:'标题',sender_name:'',send_time:''}],
        }},

      methods:{
        forward(row){
          let thisRowData=this;
          thisRowData=row;
          let rowTitle = thisRowData.title;
          let rowTime = thisRowData.send_time;
          this.$store.commit('saveMail',{CurrentMail:rowTime+rowTitle});
          this.$router.push('/mail_specific')
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
            axios.get('/queryMail',{
              params:{
                receiver_id:_this.uid
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
</style>
