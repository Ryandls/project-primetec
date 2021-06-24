<template>
  <div id="nav" class="text-center">
    <div class="container">
    Bloco 6 - Box 10 - Feira Permanente | Sobradinho 2 /DF
  <p class="text-center mt-3">
    <img src="../assets/wpp-icone.png" alt="Icone do Whatsapp"> (61) 99359-0117
  </p>
  <p class="text-center">
    © 2021 Primetec. Direitos reservados.
  </p>
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
  height: 150%;
  padding: 20px;
  background-color: #013115;
  font-weight: bold;
  color: white;
}
img {
  width: 20px;
  height: 20px;
}
@media (min-width: 1000px) {
  #nav {
    margin-top: 12rem;
  }
}
</style>
