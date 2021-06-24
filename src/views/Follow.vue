<template>
  <div>
    <Header />
    <body class="background">
      <div class="text-center mt-5">
        <h1>Acompanhamento</h1>
      </div>
      <div id="search" class="ml-4">
        <div class="row">
          <div :class="labelClass">
            <label for="cpf">CPF:</label>
          </div>
          <div :class="inputClass">
            <input id="cpf" />
          </div>
          <button>Buscar</button>
        </div>
      </div>
      <div id="footer">
        <h3 class="mt-5 ml-4">Resultados:</h3>
      </div>
    </body>
    <Footer />
  </div>
</template>

<script>
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";

export default {
  components: {
    Header,
    Footer,
  },
};
</script>
<style>
h1,
h3 {
  font-weight: bold;
}
#search {
  margin-top: 5rem;
  font-size: 1.5rem;
}
#search input {
  width: 17rem;
  border: 3px solid #000000;
  margin-left: 1.5rem;
}
#search button {
  margin-left: 3rem;
  width: 10rem;
  height: 3rem;

  background: #5fcb5d;
  color: white;

  border-radius: 16px;
  border: none;
}
#footer {
  margin-bottom: 35rem;
}
</style>
