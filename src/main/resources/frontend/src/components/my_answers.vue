<template>
  <el-container>
    <el-col span="5">
    <el-aside width="160px" id="leftside">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>今日的赞同：{{agrees}}</span>
        </div>
        <div v-for="o in 4" :key="o" class="text item">
          {{'列表内容 ' + o }}
        </div>
      </el-card>

      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>今日的挑战：{{battles}}</span>
        </div>
        <div v-for="o in 4" :key="o" class="text item">
          {{'列表内容 ' + o }}
        </div>
      </el-card>
    </el-aside>
    </el-col>

    <el-col span="14">
    <el-main>
      您的回复：<br>
      <div style="margin-top: 20px">
          <el-table
            :data="tableData"
            style="width: 100%"
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
    </el-col>

    <el-col span="5">
        <el-aside id="rightside" width="160px">
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span>按状态浏览回答</span>

            </div>
            <div v-for="o in 4" :key="o" class="text item">
              {{'列表内容 ' + o }}
            </div>
          </el-card>
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span>按类型浏览回答</span>

            </div>
            <div v-for="o in 4" :key="o" class="text item">
              {{'列表内容 ' + o }}
            </div>
          </el-card>
        </el-aside>
    </el-col>
  </el-container>
</template>

<script>
    export default {
        name: "my_answers",
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
  .block{
    float:left;
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
    left:20px;
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
</style>
