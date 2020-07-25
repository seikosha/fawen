<template>
  <el-aside id="rightside" width="200px">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>按地区热度浏览问题</span>

      </div>
      <div v-for="(item,index) in items" :key="item.location" class="text item" id="links" @click="forward(index)">
        {{item.location}}
      </div>
      <router-link tag="span" to="/more_locations" style="font-size:small" id="links1">更多地区</router-link>
    </el-card>
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>按类型浏览历史回答</span>

      </div>
      <div v-for="(item,index) in items1" :key="o" class="text item">
        {{}}
      </div>
    </el-card>
  </el-aside>
</template>

<script>
    export default {
        name: "right_card",
        data(){
          return{
            items:[{location:''}]
          }
        },
        methods:{
          forward(index){
            this.$store.commit('saveLocation',{CurrentLocation: this.items[index].location});
            console.log(this.$store.state.CurrentLocation)
            this.$router.push('/specific_location');
          }
        },

        beforeCreate() {
          let _this = this;
          const axios = require('axios')
          axios.get('/queryContentByCountLocation')
          .then(response=>{
            for (let i = 0; i < 3 ; i++) {
              _this.items.push({location:response.data[i].location})
            }
            _this.items.shift();
          })
        }
    }
</script>

<style scoped>
  #rightside{
    position:relative;
    top:20px;
    right:16px;
  }

  #links, #links1{
    cursor: pointer;
  }
</style>
