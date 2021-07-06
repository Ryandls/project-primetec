<template>
  <div>
    <Header />
    <body class="background container fundo-pagina">
      <div class="text-center mt-5">
        <h1>Acompanhamento</h1>
      </div>
      <div id="search" class="ml-4">
        <div id="cpf" class="row">
          <div :class="labelClass">
            <label for="cpf">CPF:</label>
          </div>
          <div :class="inputClass">
            <input id="cpf" v-model="cpf" />
          </div>
          <button @click="fecthAcompanhamento()">Buscar</button>
        </div>
      </div>
      <div id="body">
        <h3 class="mt-5 ml-4">Resultados:</h3>

        <div
          v-for="(acompanhamento, index) in resultado.acompanhamentos"
          :key="index"
          class="text-center"
        >
          <div
            id="card-order"
            class="m-3"
            :class="{
              'fundo-completo': acompanhamento.andamento === 'Finalizado',
            }"
          >
            <input
              type="checkbox"
              name="completar"
              title="Finalizar Ordem"
              @change="finalizarOrdem(acompanhamento.id_OS)"
              v-if="acompanhamento.andamento !== 'Finalizado'"
            />
            <span
              ><strong>Número da O.S: </strong>{{ acompanhamento.id_OS }}</span
            >
            <span><strong>Marca: </strong>{{ acompanhamento.marca }}</span>
            <span><strong>Modelo: </strong>{{ acompanhamento.modelo }}</span>
            <span
              ><strong>Andamento: </strong>{{ acompanhamento.andamento }}</span
            >
          </div>
        </div>
      </div>
    </body>
    <Footer />
  </div>
</template>

<script>
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";
import axios from "axios";

export default {
  components: {
    Header,
    Footer,
  },
  data() {
    return {
      cpf: "",
      resultado: {},
    };
  },
  methods: {
    fecthAcompanhamento() {
      axios
        .get("http://localhost:8080/clientes/acompanhamento/" + this.cpf)
        .then((res) => (this.resultado = res.data))
        .catch(() => alert("CPF não localizado"));
    },
    finalizarOrdem(id) {
      axios
        .put("http://localhost:8080/ordem-servico/finalizar/" + id)
        .then(() => this.fecthAcompanhamento());
    },
  },
};
</script>
<style>
h1,
h3 {
  font-weight: bold;
}
span {
  font-size: 23px;
}
span strong {
  margin-left: 2rem;
}

#search {
  margin-top: 5rem;
  font-size: 1.5rem;
}
#search input {
  width: 17rem;
  border: 3px solid #000000;
  margin-left: 1.5rem;
  margin-top: 2px;
}
#search button {
  margin-left: 3rem;
  width: 10rem;
  height: 2.8rem;

  background: #5fcb5d;
  color: white;

  border-radius: 16px;
  border: none;
}
#search label {
  margin-top: 3px;
}
#card-order {
  border: 2px solid #000000;
  background: white;
  padding: 1rem;
}

@media (max-width: 500px) {
  #cpf {
    flex-direction: column;
    align-items: center;
    margin-right: 20px;
  }
  #cpf input {
    display: flex;
    margin-right: 30px;
  }
  #cpf button {
    display: flex;
    margin-top: 1rem;
    margin-right: 50px;
  }
  h1 {
    font-size: 30px;
  }
  span {
    display: flex;
    font-size: 20px;
  }
  span strong {
    margin-right: 1rem;
  }
}
.fundo-pagina {
  min-height: 90vh;
}
.fundo-completo {
  background-color: #85dd84!important;
}
</style>
