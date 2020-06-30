<template>
<el-container>
<el-aside width="200px" id="leftside">
  <el-card class="box-card">
    <div slot="header" class="clearfix">
      <span>法问</span>

    </div>
    <div v-for="o in 4" :key="o" class="text item">
      {{'列表内容 ' + o }}
    </div>
  </el-card>
</el-aside>

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

      <el-upload
        class="upload-demo"
        action="https://jsonplaceholder.typicode.com/posts/"
        :on-preview="handlePreview"
        :on-remove="handleRemove"
        :before-remove="beforeRemove"
        multiple
        :limit="3"
        :on-exceed="handleExceed"
        :file-list="fileList"
        style="margin-top: 5px">
        <el-button size="small" type="primary">点击上传</el-button>
        <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
      </el-upload>

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
      <span>按地区浏览历史回答</span>

    </div>
    <div v-for="o in 4" :key="o" class="text item">
      {{'列表内容 ' + o }}
    </div>
  </el-card>
  <el-card class="box-card">
    <div slot="header" class="clearfix">
      <span>按类型浏览历史回答</span>

    </div>
    <div v-for="o in 4" :key="o" class="text item">
      {{'列表内容 ' + o }}
    </div>
  </el-card>
</el-aside>
</el-container>
</template>

<script>
    export default {
        name: "ask",
        methods: {
          handleRemove(file, fileList) {
            console.log(file, fileList);
          },
          handlePreview(file) {
            console.log(file);
          },
          handleExceed(files, fileList) {
            this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
          },
          beforeRemove(file, fileList) {
            return this.$confirm(`确定移除 ${ file.name }？`);
          },
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
          fileList: [{name: 'food.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'}],

          options: [{
            value: '选项1',
            label: '黄金糕'
          }, {
            value: '选项2',
            label: '双皮奶'
          }, {
            value: '选项3',
            label: '蚵仔煎'
          }, {
            value: '选项4',
            label: '龙须面'
          }, {
            value: '选项5',
            label: '北京烤鸭'
          }],
          category_options: [{
            value: '选项1',
            label: '黄金糕'
          }, {
            value: '选项2',
            label: '双皮奶'
          }, {
            value: '选项3',
            label: '蚵仔煎'
          }, {
            value: '选项4',
            label: '龙须面'
          }, {
            value: '选项5',
            label: '北京烤鸭'
          }],
          input:'',
          textarea:'',
          value: ''
        };
      },
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
