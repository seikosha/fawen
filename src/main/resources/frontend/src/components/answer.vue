<template>
  <el-container>
    <el-main>
      <span>您提过的问题：</span><br>
      <el-col :span="2"><span>&nbsp;</span></el-col>
      <el-col :span="20">
        <div  style="margin-top: 15px">
        <el-table
          :data="tableData"
          style="width: 100%"
          :row-class-name="tableRowClassName"
          >

        <el-table-column
          prop="id"
          label="序号"
          width="60"
          id="id"
          align="center">
        </el-table-column>

        <el-table-column
          prop="name"
          label="标题"
          width="545"
          align="center">
        </el-table-column>
        <el-table-column
          prop="date"
          label="最后更新时间"
          width="120"
          align="center">
        </el-table-column>
          <el-table-column
            prop="follow"
            label="跟帖数"
            width="70"
            align="center">
          </el-table-column>
          <el-table-column
            prop="replyer"
            label="最新回复者"
            width="120"
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
      <el-col :span="2"><span>&nbsp;</span></el-col>

    </el-main>
  </el-container>
</template>

<script>
    export default {
        name: "answer",
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
            name: '我被人打了怎么办？',
            follow:1,
            replyer: 'Jacky',
          }, {
            id:2,
            date: '2016-05-04',
            name: '别人欠我钱没还怎么办',
            follow:2,
            replyer: 'Becky'
          }, {
            id:3,
            date: '2016-05-01',
            name: '老婆要跟我离婚，怎么分财产？',
            follow:3,
            replyer: 'Frade',
          }, {
            id:4,
            date: '2016-05-03',
            name: '我被车撞了怎么索赔？',
            follow:4,
            replyer: 'Dinesh'
          }]
        }}
    }
</script>

<style scoped>
.block{
  float:left;
}
</style>
