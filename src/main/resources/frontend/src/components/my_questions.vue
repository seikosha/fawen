<template>
  <el-container>
    <el-main>
      您提过的问题：<br>
      <el-col :span="5"><span>&nbsp;</span></el-col>
      <el-col :span="14">
        <el-table
          :data="tableData"
          style="width: 100%"
          :row-class-name="tableRowClassName">
          <el-table-column
            prop="date"
            label="日期"
            width="120">
          </el-table-column>
          <el-table-column
            prop="name"
            label="标题"
            width="120">
          </el-table-column>
          <el-table-column
            prop="address"
            label="最新回复">
          </el-table-column>
        </el-table>
      </el-col>
      <el-col :span="5"><span>&nbsp;</span></el-col>

    </el-main>
  </el-container>
</template>

<script>
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
        tableData: [{
          date: '2016-05-02',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄',
        }, {
          date: '2016-05-04',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          date: '2016-05-01',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄',
        }, {
          date: '2016-05-03',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }]
      }}
  }
</script>

<style scoped>

</style>

