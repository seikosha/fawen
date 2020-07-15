<template>
  <div>
    <el-table :data="items" v-for="item in items" :key="item.guru">
      <el-table-column  property="bb" label="fart" >{{item.guru}}</el-table-column>
    </el-table>
  </div>
</template>

<script>
    export default {
        name: "test",
      data(){
          return{
              items:[{guru:'爱你'},{guru:'不爱你'}]
            }
          }
      }

</script>

<style scoped>

</style>
