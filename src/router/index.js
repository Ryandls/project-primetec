import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home";
import Follow from "../views/Follow";
import FormOrder from "../views/FormOrder";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/follow",
    name: "Follow",
    component: Follow,
  },
  {
    path: "/form",
    name: "Form",
    component: FormOrder,
  },
];

const router = new VueRouter({
  routes,
});

export default router;
