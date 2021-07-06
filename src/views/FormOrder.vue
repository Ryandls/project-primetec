<template>
  <div>
    <Header />
    <body class="background container">
      <div class="text-center mt-5">
        <h1>Ordem de Serviço</h1>
      </div>
      <div>
        <h4 class="mt-5 mb-4">Dados do cliente</h4>
      </div>
      <div>
        <div class="row">
          <div :class="labelClass">
            <label for="nome">Nome:</label>
          </div>
          <div :class="inputClass">
            <input
              v-model="form.nome"
              :disabled="existente"
              type="text"
              id="nome"
            />
          </div>
        </div>
        <div class="row">
          <div :class="labelClass">
            <label for="cpf">CPF:</label>
          </div>
          <div :class="inputClass">
            <input
              v-model="form.cpf"
              @blur="verificarCpf()"
              type="number"
              id="cpf"
              :disabled="existente"
            />
          </div>
        </div>
        <div class="row">
          <div :class="labelClass">
            <label for="email">Email:</label>
          </div>
          <div :class="inputClass">
            <input
              v-model="form.email"
              :disabled="existente"
              type="email"
              id="email"
            />
          </div>
        </div>
        <div class="row">
          <div :class="labelClass">
            <label for="telefone">Telefone:</label>
          </div>
          <div :class="inputClass">
            <input
              v-model="form.telefone"
              :disabled="existente"
              type="number"
              id="telefone"
            />
          </div>
        </div>
      </div>
      <div>
        <h4 class="mt-5 mb-4 ">Local de busca do Aparelho</h4>
      </div>
      <div>
        <div class="row">
          <div :class="labelClass">
            <label for="cidade">Cidade:</label>
          </div>
          <div :class="inputClass">
            <input
              v-model="form.cidade"
              :disabled="existente"
              type="text"
              id="cidade"
            />
          </div>
        </div>
        <div class="row">
          <div :class="labelClass">
            <label for="endereco">Endereço:</label>
          </div>
          <div :class="inputClass">
            <input
              v-model="form.endereco"
              :disabled="existente"
              type="text"
              id="endereco"
            />
          </div>
        </div>
        <div class="row">
          <div :class="labelClass">
            <label for="numero">Número:</label>
          </div>
          <div :class="inputClass">
            <input
              v-model="form.numero"
              :disabled="existente"
              type="number"
              id="numero"
            />
          </div>
        </div>

        <div class="row">
          <div :class="labelClass">
            <label for="complemento">Complemento:</label>
          </div>
          <div :class="inputClass">
            <input
              v-model="form.complemento"
              :disabled="existente"
              type="text"
              id="complemento"
            />
          </div>
        </div>
      </div>
      <div>
        <h4 class="mt-5 mb-4 ">Dados do Aparelho</h4>
      </div>
      <div class="">
        <div class="row">
          <div :class="labelClass">
            <label type="" for="marca">Marca:</label>
          </div>
          <div :class="inputClass">
            <input v-model="form.marca" type="text" id="marca" />
          </div>
        </div>
        <div class="row">
          <div :class="labelClass">
            <label for="modelo">Modelo:</label>
          </div>
          <div :class="inputClass">
            <input v-model="form.modelo" type="text" id="modelo" />
          </div>
        </div>
        <div class="row">
          <div :class="labelClass">
            <label for="imei">IMEI:</label>
          </div>
          <div :class="inputClass">
            <input v-model="form.imei" type="number" id="imei" />
          </div>
        </div>
        <div class="row">
          <div :class="labelClass">
            <label for="descricao">Descrição:</label>
          </div>
          <div :class="inputClass">
            <textarea
              v-model="form.descricao"
              type="text"
              id="descricao"
              cols="40"
              rows="6"
            ></textarea>
          </div>
        </div>
      </div>
      <div>
        <h4 class="mt-5 mb-4 ">Checklist de Defeitos</h4>
      </div>

      <div class="row " id="checklist">
        <div
          v-for="defeito in defeitos"
          :key="defeito.id"
          class="col-12 col-md-4"
        >
          <input type="checkbox" :value="defeito.id" v-model="form.checklist" />
          <label class="pl-2">{{ defeito.descricao }}</label>
        </div>
      </div>
      <p v-if="enviando" class="text-center loading-email mt-5">
        Aguarde, sua Ordem de Serviço está sendo resgitrada...
      </p>
      <div class="d-flex justify-content-center">
        <button :disabled="enviando" class="my-5" @click="submitForm()">
          Enviar
        </button>
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
      inputClass: "col-7 col-md-6",
      labelClass: "col-3 col-md-2 text-center",
      defeitos: [],
      form: {
        nome: "",
        cpf: "",
        email: "",
        telefone: "",
        cidade: "",
        endereco: "",
        numero: "",
        complemento: "",
        marca: "",
        modelo: "",
        imei: "",
        descricao: "",
        checklist: [],
      },
      enviando: false,
      existente: false,
    };
  },
  mounted() {
    axios
      .get("http://localhost:8080/defeitos")
      .then((res) => (this.defeitos = res.data))
      .catch((error) => console.log(error));
  },
  methods: {
    submitForm() {
      if (this.verificarForm()) {
        this.enviando = true;
        axios
          .post("http://localhost:8080/clientes/", this.form)
          .then(() => {
            alert("Sua Ordem de Serviço foi enviar com sucesso!!");
            this.$router.push("Follow");
          })
          .catch((error) => {
            console.log(error);
          })
          .finally(() => {});
      }
    },
    verificarForm() {
      const valuesNulls = Object.keys(this.form).filter(
        (campo) => !this.form[campo]
      );

      if (valuesNulls.length) {
        alert("Preenchar esses campos: " + valuesNulls.toString());

        return false;
      } else if (!this.form.checklist.length) {
        alert("Pelo menos um defeito deve ser selecionado.");

        return false;
      }
      return true;
    },
    verificarCpf() {
      if (!this.form.cpf) {
        return;
      }
      axios
        .get("http://localhost:8080/clientes/" + this.form.cpf)
        .then((res) => {
          if (res.data) {
            this.existente = true;
            this.form = { ...this.form, ...res.data };
          }
        });
    },
  },
};
</script>
<style>
h1 {
  font-weight: bold;
}
input {
  border: 2px solid #000000;
}
input[type=""] {
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

button:disabled {
  opacity: 0.5;
}
.loading-email {
  font-size: 24px;
}

@media (min-width: 100px) {
  #content {
    height: 91vh;
  }
  #checklist {
    max-width: 60vw;
  }
  textarea {
    max-width: 70vw;
  }
}
</style>
