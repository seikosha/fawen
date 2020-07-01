<template>
  <el-container>
    <el-main>
      <span>最新问题：</span><br>
      <el-col :span="5">
        <el-aside id="leftside" width="200px">
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span>按照类型浏览案件</span>

            </div>
            <div v-for="o in 4" :key="o" class="text item">
              {{'列表内容 ' + o }}
            </div>
          </el-card>
        </el-aside>
      </el-col>
      <el-col :span="14">
        <div  style="margin-top: 15px">
        <el-table
          :data="tableData"
          style="width: 100%"
          :row-class-name="tableRowClassName"
          >

        <el-table-column
          prop="id"
          label="序号"
          id="id"
          align="center">
        </el-table-column>

        <el-table-column
          prop="name"
          label="标题"
          align="center">
        </el-table-column>
        <el-table-column
          prop="date"
          label="最后更新时间"
          align="center">
        </el-table-column>
          <el-table-column
            prop="follow"
            label="跟帖数"
            align="center">
          </el-table-column>
          <el-table-column
            prop="replyer"
            label="最新回复者"
            align="center">
          </el-table-column>
          <el-table-column
            prop="type"
            label="案件类型"
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

      <el-col :span="5">
        <el-aside id="rightside" width="200px">
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span>如何解答法律问题？</span>

            </div>
            <div v-for="o in 4" :key="o" class="text item">
              {{'列表内容 ' + o }}
            </div>
          </el-card>
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span>历史精选答案</span>

            </div>
            <div v-for="o in 4" :key="o" class="text item">
              {{'列表内容 ' + o }}
            </div>
          </el-card>
        </el-aside>
      </el-col>

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
            type:'刑事'
          }, {
            id:2,
            date: '2016-05-04',
            name: '别人欠我钱没还怎么办',
            follow:2,
            replyer: 'Becky',
            type:'民事'
          }, {
            id:3,
            date: '2016-05-01',
            name: '老婆要跟我离婚，怎么分财产？',
            follow:3,
            replyer: 'Frade',
            type:'民事'
          }, {
            id:4,
            date: '2016-05-03',
            name: '我被车撞了怎么索赔？',
            follow:4,
            replyer: 'Dinesh',
            type:'民事'
          }]
        }}
    }
</script>

<style scoped>
.block{
  float:left;
}
#rightside{
  position:relative;
  left:33px;
}

#leftside
{
  position:relative;
  right:5px;
}
</style>
