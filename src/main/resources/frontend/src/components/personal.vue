<template>
<el-container>
<el-aside width="200px" id="leftside">
  <span id="greeting">尊敬的{{username}}</span>

  <el-card class="box-card" style="margin-top: 30px">
    <div slot="header" class="clearfix">
      <span>信息菜单</span>
    </div>
    <div class="text-item">
      <router-link to="#" tag="span">个人资料</router-link>
      <br><br>
      <router-link to="/personal" tag="span">个人统计</router-link>
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
            data_stars:0,
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
                }else{
                  _this.data_civil=0;
                }

                axios.get('/queryCategory',{
                  params:{
                    uid:_this.uid,
                    category:'行政'
                  },}).then(response=>{
                  if(response.data!=''||response.data!=null||response.data!=undefined||response.data!=0){
                    _this.data_admin=response.data;
                  }else{
                    _this.data_admin=0;
                  }
                  axios.get('/queryCategory',{
                    params:{
                      uid:_this.uid,
                      category:'刑事'
                    },}).then(response=>{
                    if(response.data!=''||response.data!=null||response.data!=undefined||response.data!=0){
                      _this.data_crime=response.data;
                    }else{
                      _this.data_crime=0;
                    }
                    axios.get('/queryCategory',{
                      params:{
                        uid:_this.uid,
                        category:'不清楚'
                      },}).then(response=>{
                      if(response.data!=''||response.data!=null||response.data!=undefined||response.data!=0){
                        _this.data_uncertain=response.data;
                      }else{
                        _this.data_uncertain=0;
                      }

                      //use uid to query counts from reply

                      axios.get('/queryReplyData',{
                        params:{
                          uid:_this.uid,
                        }}).then(response=>{
                        if(response.data!=''||response.data!=null||response.data!=undefined||response.data!=0){
                          _this.data_reply=response.data;
                          console.log(_this.data_reply)
                        }else{
                          _this.data_reply=0;
                          console.log(_this.data_reply)
                        }
                        axios.get('/queryReplyStars',{
                          params:{
                            uid:_this.uid
                          }}).then(response=>{
                          if(response.data!=''||response.data!=null||response.data!=undefined||response.data!=0){
                          _this.data_stars=response.data;
                            console.log(_this.data_stars)
                        }else{
                          _this.data_stars=0;
                            console.log(_this.data_stars)
                        }
                          axios.get('/queryReplySolve',{
                            params:{
                              uid:_this.uid
                            }}).then(response=>{
                            if(response.data!=''||response.data!=null||response.data!=undefined||response.data!=0){
                              _this.data_solved=response.data;
                              console.log(_this.data_solved)
                            }else{
                              _this.data_solved=0;
                              console.log(_this.data_solved)
                            }
                            axios.get('/queryReplyBest',{
                              params:{
                                uid:_this.uid
                              }}).then(response=>{
                              if(response.data!=''||response.data!=null||response.data!=undefined||response.data!=0){
                                _this.data_best=response.data;
                                console.log(_this.data_best)
                              }else{
                                _this.data_best=0;
                                console.log(_this.data_best)
                              }

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
                                  data: [_this.data_reply, _this.data_stars, _this.data_solved,_this.data_best]
                                }]
                              }
                              myChart1.setOption(option1);
                              window.addEventListener('resize',function() {myChart.resize()});
                              window.addEventListener('resize',function() {myChart1.resize()});
                            })
                          })
                        })
                      })



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

  .text-item:hover{
    cursor: pointer;
  }

  @media screen and (max-width: 768px) {
    .box-card{
      position:relative;
      top:360px;
      left:65px;
      width:65%;
    }

    #greeting{
      display:none;
    }

  }

</style>
