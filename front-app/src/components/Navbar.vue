<template>
  <div id="navbar">
    <router-link>
        <img src="" alt="tFood">
    </router-link>
    <router-link to="/">Home</router-link> |
    <router-link to="/costumers">Costumers</router-link> |
    <router-link to="/orders">Orders</router-link>
  </div>
</template>

<script>
export default {
    name:"Navbar"
};
</script>

<style scoped>
</style>