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
            style="width: 100%"
            :data="items"
            @row-click="forward"
            id="column"
          >
            <template v-for="(item,index) in tableHead">
              <el-table-column align="center" :prop="item.column_name" :label="item.column_comment" :key="item.update_time" ></el-table-column>
            </template>

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

        },
        forward(row){
          let thisRowData=this;
          thisRowData=row;
          let rowTitle = row.title;
          let rowTime = row.create_time;
          this.$store.commit('saveContent',{CurrentContent: rowTime+rowTitle});
          this.$router.push('/specific_content');
        }



        },
      data() {
        return {
          tableHead:[
            {
              column_name:"poster",column_comment:"提问人"
            },
            {
              column_name: "title",column_comment: "标题"
            },
            {
              column_name: "category",column_comment: "类型"
            },
            {
              column_name:"location",column_comment: "地区"
            },
            {
              column_name:"create_time",column_comment:"发帖时间"
            }
          ],
          items:[{column_name:'',poster:'',title:'',category:'',location:'',create_time:'2020-1-1'}],
        }},

      beforeCreate() {
        let _this = this;
        const axios = require('axios')

        //authenticate user
        axios.get('/queryUserByUsername',{
          params:{
            username:this.$store.state.Authorization
          }}).then(response=>(
            console.log('名字放进去'+response.data.id),
          this.uid=response.data.id,
            console.log('uid赋值'+this.uid),

          axios.get('/queryContentList').then(response=>{
            console.log('提取内容列表'+response.data)
            for (let i = 0; i < response.data.length; i++) {
              _this.items.push({poster:response.data[i].uid,title:response.data[i].title,category:response.data[i].category,location:response.data[i].location,create_time:response.data[i].create_time})
            }
            _this.items.shift();
            for (let i = 0; i < response.data.length; i++) {
              axios.get('/queryUsernameById',{
                params:{
                  id:_this.items[i].poster
                }}).then(response=>{
                  _this.items[i].poster=response.data
              })

            }

          })
      ))




        if(_this.$store.state.Authorization==null|_this.$store.state.Authorization===''||_this.$store.state.Authorization===undefined){
          this.$router.push('/login')};
      }


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

#column{
  cursor: pointer;
}

</style>
