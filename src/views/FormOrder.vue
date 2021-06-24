<template>
  <div>
    <Header />
    <body class="background container">
      <div class="text-center mt-5">
        <h1>Ordem de Serviço</h1>
      </div>
      <div>
        <h4 class="mt-5 mb-4 ">Dados do cliente</h4>
      </div>
      <div class="">
        <div class="row">
          <div :class="labelClass">
            <label for="nome">Nome:</label>
          </div>
          <div :class="inputClass">
            <input id="nome" />
          </div>
        </div>
        <div class="row">
          <div :class="labelClass">
            <label for="cpf">CPF:</label>
          </div>
          <div :class="inputClass">
            <input id="cpf" />
          </div>
        </div>
        <div class="row">
          <div :class="labelClass">
            <label for="telefone">Telefone:</label>
          </div>
          <div :class="inputClass">
            <input id="telefone" />
          </div>
        </div>
      </div>
      <div>
        <h4 class="mt-5 mb-4 ">Local de busca do Aparelho</h4>
      </div>
      <div class="">
        <div class="row">
          <div :class="labelClass">
            <label for="endereco">Endereço:</label>
          </div>
          <div :class="inputClass">
            <input id="endereco" />
          </div>
        </div>
        <div class="row">
          <div :class="labelClass">
            <label for="numero">Número:</label>
          </div>
          <div :class="inputClass">
            <input id="numero" />
          </div>
        </div>
        <div class="row">
          <div :class="labelClass">
            <label for="cidade">Cidade:</label>
          </div>
          <div :class="inputClass">
            <input id="cidade" />
          </div>
        </div>
      </div>
      <div>
        <h4 class="mt-5 mb-4 ">Dados do Aparelho</h4>
      </div>
      <div class="">
        <div class="row">
          <div :class="labelClass">
            <label for="marca">Marca:</label>
          </div>
          <div :class="inputClass">
            <input id="marca" />
          </div>
        </div>
        <div class="row">
          <div :class="labelClass">
            <label for="modelo">Modelo:</label>
          </div>
          <div :class="inputClass">
            <input id="modelo" />
          </div>
        </div>
        <div class="row">
          <div :class="labelClass">
            <label for="imei">IMEI:</label>
          </div>
          <div :class="inputClass">
            <input id="imei" />
          </div>
        </div>
        <div class="row">
          <div :class="labelClass">
            <label for="descricao">Descrição:</label>
          </div>
          <div :class="inputClass">
            <textarea id="descricao" cols="40" rows="6"></textarea>
          </div>
        </div>
      </div>
      <div>
        <h4 class="mt-5 mb-4 ">Checklist</h4>
      </div>

      <div class="row " id="checklist" >
        <div v-for="defeito in defeitos" :key="defeito.id" class="col-12 col-md-4">
        <input type="checkbox" :value="defeito.id"  v-model="checkedList" />
        <label class="pl-2">{{defeito.label}}</label>
        </div>

      </div>
      <div class="d-flex justify-content-center">

      <button class="my-5">Enviar</button>
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
      inputClass: "col-7 col-md-6",
      labelClass: "col-3 col-md-1 text-center",
      checkedList: [],
      defeitos: [{
        id: 1,
        label: "Tela Trincada",
        },
        {        
        id: 2,
        label: "Câmera Frontal",
        },
                {        
        id: 2,
        label: "Câmera Frontal",
        },
                {        
        id: 2,
        label: "Câmera Frontal",
        },
                {        
        id: 2,
        label: "Câmera Frontal",
        },
                {        
        id: 2,
        label: "Câmera Frontal",
        }
        ,        {        
        id: 2,
        label: "Câmera Frontal",
        }
        ,        {        
        id: 2,
        label: "Câmera Frontal",
        },
                {        
        id: 2,
        label: "Câmera Frontal",
        },
                {        
        id: 2,
        label: "Câmera Frontal",
        },        {        
        id: 2,
        label: "Câmera Frontal",
        },

      ]
    };
  },
};
</script>
<style >
h1 {
  font-weight: bold;
}
input {
  border: 2px solid #000000;
}
input[type = ""] {
  width: 100% !important;
}
textarea {
  border: 2px solid #000000;
  resize: none;
}
button {
  display: flex;
  align-items: center;
  justify-content: center;
  
  width: 10rem;
  height: 3rem;

  padding: 1rem;
  background: #5fcb5d;
  color: white;
  border-radius: 16px;
  border: none;
}

@media (min-width: 100px) {
  #content {
    height: 91vh;
  }
  #checklist {
  max-width: 60vw;
}
}
</style>
