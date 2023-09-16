<template>
  <div id="main_form">
    <div>
      <div id="message">
        <p>Componente de mensage</p>
      </div>
      <form id="order_form">
        <div class="form_input">
          <label for="order">Order ID</label>
          <input type="text" name="order_id" v-model="order_id" id="order_id" />
        </div>
        <div class="form_input">
          <label for="order">Select the costumer</label>
          <select name="costumer" id="costumer" v-model="costumer">
            <option value="Amikel">Amikel</option>
            <option value="Myrlande">Myrlande</option>
            <option value="Rose Marie">Rose Marie</option>
          </select>
        </div>
        <div class="form_input">
          <input type="submit" class="submit_btn" value="Create new Order" />
        </div>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "OrderForm",
  props: ["titulo"], 
  data() {
    return{
        custumers:null,
        orders:null,
        id:null, 
        costumer:null
    }
  }
};
</script>

<style scoped>
#main_form {
  max-width: 59%;
  display: flex;
  flex-direction: row;
  justify-content: flex-end;
}
#order_form {
  margin: 0 auto;
  max-width: 400px;
}

.form_input {
  display: flex;
  flex-direction: column;
  margin-bottom: 25px;
}

input,
select {
  width: 300px;
  padding: 5px 10px;
  font-family: Arial, Helvetica, sans-serif;
}

label {
  font-weight: bold;
  margin-bottom: 13px;
  padding: 5px 10px;
  border-left: solid 4px #999;
}

.submit_btn {
  background-color: #87cefa;
  padding: 15px 5px;
  border: none;
  font-weight: bold;
  font-size: 20px;
  cursor: pointer;
  transition: 0.5s;
  border-radius: 5px;
}

.submit_btn:hover {
  background-color: transparent;
  border: solid 1px #999;
  border-radius: 5px;
}
</style>