<template>
  <div class="main_container">
    <h1>New Order</h1>

    <OrderForm  :titulo="tit" />
  </div>
</template>

<script>
 import OrderForm from '../components/OrderForm.vue';
 
 export default{
  name: 'Home',
  components: {
    OrderForm
  },
  data() {
    return{
      tit:"Formulario de cadastro de cliente"
    }
    
  }
 }
</script>
