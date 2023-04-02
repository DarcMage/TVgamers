import { createRouter, createWebHistory } from 'vue-router'
import IndexView from '../views/IndexView.vue'
import PersonasView from '../views/PersonasView.vue'
import UsuariosView from '../views/UsuariosView.vue'
import MenusView from '../views/MenusView.vue'
import DistritoView from '../views/DistritoView.vue'
import JuegoView from '../views/JuegoView.vue'
import ClientesView from '../views/ClientesView.vue'
import LoginView from '../views/LoginView.vue'
import ProveedorView from '../views/ProveedorView.vue'
import OrdenPedidoView from '../views/OrdenPedidoView.vue'
import CategoriaView from '../views/CategoriaView.vue'
import ProductoView from '../views/ProductoView.vue'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: IndexView
    },
    {
      path: '/persona',
      name: 'persona',
      component: PersonasView
    },
    {
      path: '/juego',
      name: 'juego',
      component: JuegoView
    },
    {
      path:  '/cliente',
      name: '/cliente',
      component:ClientesView
    },
    {
      path: '/usuarios',
      name: 'usuarios',
      component: UsuariosView
    },
    {
      path: '/menu',
      name: 'menu',
      component: MenusView
    },
    {
      path: '/distrito',
      name: 'distrito',
      component: DistritoView
    },
    {
      path: '/login',
      name: 'login',
      component: LoginView
    },
    {
      path: '/proveedor',
      name: 'proveedor',
      component: ProveedorView

    },
    {
      path: '/ordenpedido',
      name: 'ordenpedido',
      component: OrdenPedidoView

    },
    {
      path: '/categoria',
      name: 'categoria',
      component: CategoriaView

    },
    {
      path: '/producto',
      name: 'producto',
      component: ProductoView

    },

  ]
})

export default router