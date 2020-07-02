<template>
<el-container>
  <el-aside id="leftside" width="200px">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>在法问，请发问！</span>
      </div>
      <div class="text item">
        <router-link to="/historic_selection" tag="span" class="left_card">历史精选贴</router-link><br><br>
        <span>明星回答者</span><br><br>
        <span>论坛公约</span><br><br>
        <span>网站公告</span>
      </div>
    </el-card>
  </el-aside>

  <el-main id="main">
    <el-table
      :data="tableData"
      style="width: 80%"
      :row-class-name="tableRowClassName">
      <el-table-column
        prop="id"
        label="序号"

        align="center">
      </el-table-column>
      <el-table-column
        prop="name"
        label="标题"
        align="center">
      </el-table-column>
      <el-table-column
        prop="date"
        label="更新日期"
        align="center">
      </el-table-column>
      <el-table-column
        prop="follow"
        label="跟帖数"
        align="center">
      </el-table-column>
      <el-table-column
        prop="agree"
        label="赞同"

        align="center">
      </el-table-column>
      <el-table-column
        prop="battle"
        label="挑战"

        align="center">
      </el-table-column>
      <el-table-column
        prop="solved"
        label="是否解决"

        align="center">
      </el-table-column>
    </el-table>
    </div>

    <div class="block">
      <el-pagination
        layout="prev, pager, next"
        :total="1000">
      </el-pagination>
    </div>
  </el-main>
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
        name: "historic_selection",
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
          agrees:6,
          battles:2,
          tableData: [{
            id:1,
            date: '2016-05-02',
            name: '王小虎',
            follow: 1,
            agree:1,
            battle:2,
            solved:'否'
          }, {
            id:2,
            date: '2016-05-04',
            name: '王小虎',
            follow: 2,
            agree:1,
            battle:2,
            solved:'否'
          }, {
            id:3,
            date: '2016-05-01',
            name: '王小虎',
            follow: 3,
            agree:1,
            battle:2,
            solved:'是'
          }, {
            id:4,
            date: '2016-05-03',
            name: '王小虎',
            follow: 4,
            agree:1,
            battle:2,
            solved:'是'
          }]
        }}
    }
</script>

<style scoped>
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
  .left_card:hover{
    cursor: pointer;
  }

  .block{
    float:left;
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

  #main{
    position:relative;
    left:40px;
  }
</style>
