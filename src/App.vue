<template>
  <div>
    <div class="background">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>

export default {
  name: "app",
  components: {
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
.background {
  background-color: #f1f1f1;
}
</style>
