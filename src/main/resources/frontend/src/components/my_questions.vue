<template>
  <el-container>
    <el-main>
      您提过的问题：<br>
      <el-col :span="5"><span>&nbsp;</span></el-col>
      <el-col :span="14">
        <div style="margin-top: 15px">
        <el-table
          :data="tableData"
          style="width: 100%"
          :row-class-name="tableRowClassName">
          <el-table-column
            prop="id"
            label="序号"
            width="60"
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
            width="120"
            align="center">
          </el-table-column>
          <el-table-column
            prop="follow"
            label="跟帖数"
            width="80"
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
          id:1,
          date: '2016-05-02',
          name: '王小虎',
          follow: 1,
        }, {
          id:2,
          date: '2016-05-04',
          name: '王小虎',
          follow: 2
        }, {
          id:3,
          date: '2016-05-01',
          name: '王小虎',
          follow: 3,
        }, {
          id:4,
          date: '2016-05-03',
          name: '王小虎',
          follow: 4
        }]
      }}
  }
</script>

<style scoped>
.block{
  float:left;
}
</style>

