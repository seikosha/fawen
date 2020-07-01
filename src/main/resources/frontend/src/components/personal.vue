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
            username:'username'
          }
        },
        mounted(){

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
              data: [5, 20, 36, 10]
            }]}
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
          myChart.setOption(option);
          myChart1.setOption(option1);
          window.addEventListener('resize',function() {myChart.resize()});
          window.addEventListener('resize',function() {myChart1.resize()});
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
