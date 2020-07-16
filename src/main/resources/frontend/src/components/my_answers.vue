<template>
  <el-container>
    <el-col span="5">
    <el-aside width="160px" id="leftside">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>今日的赞同：{{agrees}}</span>
        </div>
        <div v-for="o in 4" :key="o" class="text item">
          {{'列表内容 ' + o }}
        </div>
      </el-card>

      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>今日的挑战：{{battles}}</span>
        </div>
        <div v-for="o in 4" :key="o" class="text item">
          {{'列表内容 ' + o }}
        </div>
      </el-card>
    </el-aside>
    </el-col>

    <el-col span="14">
    <el-main>
      您的回复：<br>
      <div style="margin-top: 20px">

<!--        标题、跟帖日期、赞同数、挑战数、是否解决问题-->

          <el-table
            style="width: 100%"
            :data="items"
          >
            <template v-for="(item,index) in tableHead">
              <el-table-column align="center" :prop="item.column_name" :label="item.column_comment" :key="item.create_time"></el-table-column>
            </template>

          </el-table>
        </div>


        <div class="block">
          <el-pagination
            layout="prev, pager, next"
            :total="1000">
          </el-pagination>
        </div>
        </el-main>
    </el-col>

    <el-col span="5">
        <el-aside id="rightside" width="160px">
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span>按状态浏览回答</span>

            </div>
            <div v-for="o in 4" :key="o" class="text item">
              {{'列表内容 ' + o }}
            </div>
          </el-card>
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span>按类型浏览回答</span>

            </div>
            <div v-for="o in 4" :key="o" class="text item">
              {{'列表内容 ' + o }}
            </div>
          </el-card>
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
        }},
      data(){
        return{
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
          items:[{column_name:'',title:'虽然很艰难',create_time:'',stars:0,challenges:0,solved:''}],
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
          axios.get('/queryReplyByUid',{
            params:{
              uid:this.uid
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
            console.log(_this.items);
          })



        ))
        if(this.$store.state.Authorization==null|this.$store.state.Authorization===''||this.$store.state.Authorization===undefined){
          this.$router.push('/login');
    }}}

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
</style>
