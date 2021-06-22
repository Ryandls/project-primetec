import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home'
import Follow from '../views/Follow'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/follow',
    component: Follow
  },
]

const router = new VueRouter({
  routes
})

export default router
