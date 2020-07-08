<template>
<el-container>
<left_card></left_card>

<el-main>
  <el-col :span="4">&nbsp;</el-col>
  <el-col :span="16" id="main">
    <div class="demo-input-suffix" id="input_area">

      <span>标题：</span>

      <el-input
        placeholder="请输入标题"
        v-model="input"
        >
      </el-input>

      <div style="margin-top:15px">
      <span>详细描述：</span>
      <el-input type="textarea" placeholder="请输入对问题的详细描述" v-model="textarea" resize="none" rows="10"></el-input>
      </div>

      <div style="margin-top:15px">
      <span>问题类型:</span>
      <el-select v-model="value" placeholder="请选择">
        <el-option
          v-for="item in category_options"
          :key="item.value"
          :label="item.label"
          :value="item.value">
        </el-option>
      </el-select>
      <br>
      </div>

      <div style="margin-top:15px">
        <span>问题发生所在地区:</span>
        <el-select v-model="value" placeholder="请选择">
          <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
        <br>
      </div>

      <div style="margin-top:15px">
      <el-button type="info">提交</el-button>
      </div>

    </div>
  </el-col>
  <el-col :span="4">&nbsp;</el-col>


</el-main>

<el-aside id="rightside" width="200px">
  <el-card class="box-card">
    <div slot="header" class="clearfix">
      <span>如何正确描述问题？</span>

    </div>
    <div v-for="o in 4" :key="o" class="text item">
      {{'列表内容 ' + o }}
    </div>
  </el-card>
  <el-card class="box-card">
    <div slot="header" class="clearfix">
      <span>历史精选提问</span>

    </div>
    <div v-for="o in 4" :key="o" class="text item">
      {{'列表内容 ' + o }}
    </div>
  </el-card>
</el-aside>
</el-container>
</template>

<script>
  import left_card from "./left_card";

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
          options: [{
            value: '北京',
            label: '北京'
          }, {
            value: '天津',
            label: '天津'
          }, {
            value: '河北',
            label: '河北'
          }, {
            value: '山西',
            label: '山西'
          }, {
            value: '内蒙古',
            label: '内蒙古'
          }, {
            value: '辽宁',
            label: '辽宁'
          }, {
            value: '吉林',
            label: '吉林'
          }, {
            value: '黑龙江',
            label: '黑龙江'
          }, {
            value: '上海',
            label: '上海'
          }, {
            value: '江苏',
            label: '江苏'
          }, {
            value: '浙江',
            label: '浙江'
          }, {
            value: '安徽',
            label: '安徽'
          }, {
            value: '福建',
            label: '福建'
          }, {
            value: '江西',
            label: '江西'
          }, {
            value: '山东',
            label: '山东'
          }, {
            value: '河南',
            label: '河南'
          }, {
            value: '湖北',
            label: '湖北'
          }, {
            value: '湖南',
            label: '湖南'
          }, {
            value: '广东',
            label: '广东'
          }, {
            value: '广西',
            label: '广西'
          }, {
            value: '海南',
            label: '海南'
          }, {
            value: '重庆',
            label: '重庆'
          }, {
            value: '四川',
            label: '四川'
          }, {
            value: '贵州',
            label: '贵州'
          }, {
            value: '云南',
            label: '云南'
          }, {
            value: '西藏',
            label: '西藏'
          }, {
            value: '陕西',
            label: '陕西'
          }, {
            value: '甘肃',
            label: '甘肃'
          }, {
            value: '青海',
            label: '青海'
          }, {
            value: '宁夏',
            label: '宁夏'
          }, {
            value: '新疆',
            label: '新疆'
          }, {
            value: '台湾',
            label: '台湾'
          }, {
            value: '香港',
            label: '香港'
          }, {
            value: '澳门',
            label: '澳门'
          }],
          category_options: [{
            value: '背景',
            label: '刑事'
          }, {
            value: '民事',
            label: '民事'
          }, {
            value: '行政',
            label: '行政'
          }, {
            value: '不清楚',
            label: '不清楚'
          }],
          input:'',
          textarea:'',
          value: ''
        };
      },
      components:{
          left_card
      }
    }
</script>

<style scoped>
  #main{
    text-align: left;
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
    right:16px;
  }

  #input_area{
    position:relative;
    top:5px;
  }
</style>
