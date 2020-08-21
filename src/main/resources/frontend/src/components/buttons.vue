<template>
  <el-main id="main">
    <el-row>
      <el-button id="buttonl" type="primary" plain @click="check_ask">我有问题</el-button>
      <el-button id="buttonr" type="success" plain @click="check_answer">我能解答</el-button>
    </el-row>
    <el-row type="flex" justify="center">
      <el-button id="buttonl1" type="primary" plain @click="check_ask" >我有问题</el-button>
      <el-button id="buttonr1" type="success" plain @click="check_answer" >我能解答</el-button>
    </el-row>
  </el-main>



</template>

<script>
    export default {
        name: "buttons",
      methods:{
          check_ask(){
            if(this.$store.state.Authorization!=null && this.$store.state.Authorization !== '' && this.$store.state.Authorization !== undefined){
              this.$router.push('/ask');
            }else{
              this.$router.push('/login');
            }
          },
          check_answer(){
            if(this.$store.state.Authorization!=null && this.$store.state.Authorization !== '' && this.$store.state.Authorization !== undefined){
              this.$router.push('/answer');
            }else{
              this.$router.push('/login');
            }
          }
        }
    }
</script>

<style scoped>
  #buttonl,
  #buttonr{
    width:240px;
    height:240px;
    margin:auto;
  position:relative;
    top:20px;
  }



  #buttonl{
    right:20px;
  }

  #buttonr{
    left:20px;
  }

  @media screen and (min-width: 769px) {
    #buttonl1,#buttonr1{
      visibility:hidden;
    }
  }

  #buttonl1{
    right:20px;
  }

  #buttonr1{
    left:20px;
  }

  @media screen and (max-width: 768px) {
    #main{
      visibility:hidden;
    }
    #buttonl1,#buttonr1{
      visibility:visible;
      margin-top:0px;
      padding-top:0px;
      bottom:400px;
      width:240px;
      height:240px;
      position:relative;
    }

  }

</style>
