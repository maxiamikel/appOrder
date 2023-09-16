<template>
  <div id="navbar">
    <router-link to="/"  id="logo">
        <img :src="site_image" :alt="site_name" id="logo_size" >
    </router-link>
    <router-link to="/">Home</router-link> 
    <router-link to="/costumers">Costumers</router-link> 
    <router-link to="/orders">Orders</router-link>
    <router-link to="/helps">Helps</router-link>
  </div>
</template>

<script>
export default {
    name:"Navbar",
    props:["site_image", "site_name"]
};
</script>

<style scoped>

    #navbar{
        background-color: #87CEFA;
        display: flex;
        justify-content: flex-end;
        align-items: center;
        border-bottom: solid 4px #999;
        padding:12px 47px;
    }

    #navbar #logo{
        margin: auto;
        margin-left: 0;
    }

    #logo_size{
        width: 45px;
        height: 45px;
    }

    #navbar a{
        text-decoration: none;
        margin: 12px;
        transition: .5s;
        color: #000;
        font-size: 15px;
        text-transform: uppercase;
        font-weight: bold;
    }

    #navbar a:hover{
        color: #ddd000;
    }
</style>