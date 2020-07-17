<template>
<el-container>
<el-aside width="200px" id="leftside">
  <span>尊敬的{{username}}，<br>
  您已经在本站：</span>
  <el-card class="box-card" style="margin-top: 30px">
    <div slot="header" class="clearfix">
      <span>已获得的评价</span>
    </div>
    <div v-for="o in 4" :key="o" class="text item">
      {{'列表内容 ' + o }}
    </div>
  </el-card>
  <el-card class="box-card" style="margin-top: 30px">
    <div slot="header" class="clearfix">
      <span>个人资料信息</span>
    </div>
    <div v-for="o in 4" :key="o" class="text item">
      {{'列表内容 ' + o }}
    </div>
  </el-card>
</el-aside>

<el-main>
  <span style="margin-top: 20px">{{username}}的数据统计</span>
  <div id="type_chart" style="margin-top: 30px"></div>
  <div id="review_chart" style="margin-top: 30px"></div>
</el-main>
</el-container>
</template>

<script>
  import echarts from 'echarts'
    export default {
        name: "personal",
        data(){
          return{
            username:this.$store.state.Authorization,
            uid:0,
            data_civil:0,
            data_admin:0,
            data_crime:0,
            data_uncertain:0,
            data_reply:0,
            data_star:0,
            data_solved:0,
            data_best:0
          }
        },


        mounted(){
          let _this = this;
          const axios = require('axios')
          //authenticate user
          axios.get('/queryUserByUsername',{
            params:{
              username:this.$store.state.Authorization
            },}).then(response=>(
            _this.uid=response.data.id,


              //use uid to query category
              axios.get('/queryCategory',{
                params:{
                  uid:_this.uid,
                  category:'民事'
                },}).then(response=>{
                if(response.data!=''||response.data!=null||response.data!=undefined||response.data!=0){
                  _this.data_civil=response.data;
                  console.log('civil:'+_this.data_civil)
                }else{
                  _this.data_civil=0;
                  console.log('civil:'+_this.data_civil)
                }

                axios.get('/queryCategory',{
                  params:{
                    uid:_this.uid,
                    category:'行政'
                  },}).then(response=>{
                  if(response.data!=''||response.data!=null||response.data!=undefined||response.data!=0){
                    _this.data_admin=response.data;
                    console.log('admin:'+_this.data_admin)
                  }else{
                    _this.data_admin=0;
                    console.log('admin:'+_this.data_admin)
                  }
                  axios.get('/queryCategory',{
                    params:{
                      uid:_this.uid,
                      category:'刑事'
                    },}).then(response=>{
                    if(response.data!=''||response.data!=null||response.data!=undefined||response.data!=0){
                      _this.data_crime=response.data;
                      console.log('crime:'+_this.data_crime)
                    }else{
                      _this.data_crime=0;
                      console.log('crime:'+_this.data_crime)
                    }
                    axios.get('/queryCategory',{
                      params:{
                        uid:_this.uid,
                        category:'不清楚'
                      },}).then(response=>{
                      if(response.data!=''||response.data!=null||response.data!=undefined||response.data!=0){
                        _this.data_uncertain=response.data;
                        console.log('uncertain:'+_this.data_uncertain)
                      }else{
                        _this.data_uncertain=0;
                        console.log('uncertain:'+_this.data_uncertain)
                      }
                      console.log('后面的数据：'+_this.data_civil)
                      let myChart = echarts.init(document.getElementById('type_chart'));
                      let myChart1 = echarts.init(document.getElementById('review_chart'));
                      let option = {
                        title: {
                          text: '解答问题类型'
                        },
                        tooltip: {},
                        yAxis: {
                          data: ['刑事', '民事', '行政', '其他']
                        },
                        xAxis: {},
                        series: [{
                          name: '解答数',
                          type: 'bar',
                          data: [_this.data_crime,_this.data_civil,_this.data_admin,_this.data_uncertain]
                        }]}
                      myChart.setOption(option);

                        let option1 = {
                          title:{
                            text: '回答质量'
                          },
                          tooltip:{},
                          yAxis:{
                            data: ['回答','赞同','解决问题','最佳答案']
                          },
                          xAxis:{},
                          series: [{
                            name: '获评数',
                            type: 'bar',
                            data: [50, 30, 10,20]
                          }]
                        }
                        myChart1.setOption(option1);
                        window.addEventListener('resize',function() {myChart.resize()});
                        window.addEventListener('resize',function() {myChart1.resize()});

                    })
                  })
                })
              })

          ))






          if(this.$store.state.Authorization==null|this.$store.state.Authorization===''||this.$store.state.Authorization===undefined) {
            this.$router.push('/login');
          }




          }
    }
</script>

<style scoped>
  #type_chart,
  #review_chart{
    border: 1px;
    margin: 0 auto;
    height:300px;
    width:600px;
  }

  #leftside
  {
    position:relative;
    top:30px;
    left:33px;
  }

</style>
