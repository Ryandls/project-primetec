<template>
  <div>
    <div id="nav">
      <div class="d-flex mt-2">
        <router-link to="/">Início</router-link>
        <p>|</p>

        <router-link to="/follow">Acompanhamento</router-link>
      </div>
      <div class="d-flex">
        <button>Ordem de Serviço</button>
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

button {
  width: 230px;
  height: 3rem;

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
</style>
