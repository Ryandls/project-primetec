<template>
  <div>
    <Header />
    <body class="background container">
      <div class="text-center mt-5">
        <h1>Acompanhamento</h1>
      </div>
      <div id="search" class="ml-4">
        <div id="cpf" class="row">
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

        <div v-for="resultado in resultados" :key="resultado.id"  class="text-center"> 
          <div id="card-order" class="m-3">
            <span><strong>Número da O.S: </strong>{{ resultado.id }}</span>
            <span><strong>Marca: </strong>{{ resultado.marca }}</span>
            <span><strong>Modelo: </strong>{{ resultado.modelo }}</span>
            <span><strong>Andamento: </strong>{{ resultado.andamento }}</span>
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

export default {
  components: {
    Header,
    Footer,
  },
  data() {
    return {
      resultados: [
        {
          id: 0,
          marca: "Apple",
          modelo: "Iphone C",
          andamento: "Finalizado",
        },
                {
          id: 1,
          marca: "Xiaomi",
          modelo: "Redmi Note 9",
          andamento: "Em progresso",
        },
                {
          id: 2,
          marca: "Samsung",
          modelo: "A10",
          andamento: "Finalizado",
        },
                {
          id: 3,
          marca: "Motorola",
          modelo: "Moto G8",
          andamento: "Em progresso",
        },
      ],
    };
  },
}
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
}
#search button {
  margin-left: 3rem;
  width: 10rem;
  height: 2.5rem;

  background: #5fcb5d;
  color: white;

  border-radius: 16px;
  border: none;
}
#card-order {
    border: 2px solid #000000;
    background: white;
    padding: 1rem;
}

@media (max-width: 500px ){
  #cpf{
    flex-direction: column;
    align-items: center;
    margin-right:20px;
  }
  #cpf input {
    display:flex;
    margin-right: 30px;
  
  }
  #cpf button {
    display: flex;
    margin-top: 1rem;
    margin-right: 50px;
  
  }
  h1{
    font-size: 30px;
  }
  span {
    display:flex;
    font-size: 20px;
  }
  span strong {
    margin-right: 1rem;
  }
}
</style>
