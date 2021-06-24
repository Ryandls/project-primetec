<template>
  <div id="nav">
    <div  class="container d-flex justify-content-between">
      <div class="d-flex mt-3 ">
        <router-link to="/">Início</router-link>
        <p>|</p>

        <router-link to="/follow">Acompanhamento</router-link>
      </div>
      <div class="d-flex mt-1">
        <router-link id="button" to="/form"> Ordem de Serviço </router-link>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Header",
};
</script>

<style scoped>
#nav {
  align-items: flex-start;
  padding: 20px;
  background-color: #008037;
  display: flex;
  justify-content: space-between;
}

#nav a {
  font-weight: bold;
  color: white;
}

p {
  margin-left: 5px;
  margin-right: 5px;
  font-weight: bold;
  color: white;
}

#button {
  display:flex;

  width: 230px;
  height: 3rem;

  justify-content: center;
  align-items: center;

  margin-right: 2rem;

  border: none;
  border-radius: 8px;

  font-weight: bold;

  background-color: #5fcb5d;
  color: white;
}
button:hover {
  background-color: #85dd84;
}
@media (max-width: 500px)
{
  #nav{
    font-size:13px;
  }
  #button {
    width: 8rem;
    font-size: 13px;
    height: 2.3rem;
    margin-top: 4px;
    margin-left: 7px;
  }
}
</style>
