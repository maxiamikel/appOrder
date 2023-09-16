<template>
  <Navbar :site_image="logo" :site_name="app_name"/>
  <router-view/>
  <Footer />
</template>

<script>
import Navbar from "./components/Navbar.vue";
import Footer from "./components/Footer.vue";
export default {
  components:{
    Navbar, Footer
  },
  data(){
    return{
      logo: "/img/logo.png",
    app_name:"tFood Restaurant"
    }
  }
}
</script>

<style>
  *{
    font-family:'Courier New', Courier, monospace;
    margin: 0;
    padding: 0;
    box-sizing: border-box;
  }

  .main_container{
    margin: 47px;
    min-height: 500px;
  }

  h1{
    font-size: 40px;
    margin-bottom: 25px;
    text-align: center;
  }
</style>
