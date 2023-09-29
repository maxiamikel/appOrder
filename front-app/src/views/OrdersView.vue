<template>
    <div class="main_container">
        <h1>
            Orders
        </h1>
    </div>
</template>

<script>
export default{
    name:"OrderView",

data(){
    return{
       orders:[]
    }
},
methods:{
    async getOrders(){
       const req= await fetch("http://www.localhost:8080/api/orders/")
        const data = await req.json();
        
        console.log(data)
    }
},
mounted(){
    this.getOrders();
}
}
</script>

<style scoped>

</style>
