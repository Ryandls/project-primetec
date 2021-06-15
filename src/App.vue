<template>
  <div>
    <Header/>
    <router-view />
  </div>
</template>

<script>
import Header from "./components/Header.vue";
export default {
  name: "Header",
  components: {
    Header,
  },
};
</script>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: "roboto", sans-serif !important;
}
</style>
