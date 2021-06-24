<template>
  <div>
    <Header/>
    <div class="text-center"> 
    <img src="../assets/logotipo.png" alt="Logo">
    </div>
    <Footer/>
  </div>
</template>

<script>
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";

export default {
  name: "Home",
  components: {
    Header,
    Footer,
  },
};
</script>
<style>

img{
  width: 45%;
  height: 45%;
}
@media (min-width: 100px ){
    img{
      height:91vh;
    }
}
</style>
