<template>
<el-container>
  <left_card></left_card>

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

    <div class="block">
      <el-pagination
        layout="prev, pager, next"
        :total="1000">
      </el-pagination>
    </div>
  </el-main>

  <right_card></right_card>
</el-container>

</template>

<script>

  import left_card from "./left_card";
  import right_card from "./right_card";

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
        }},
      components:{
          left_card,
        right_card
      }
    }
</script>

<style scoped>

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
