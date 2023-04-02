<script setup lang="ts">
import MenuComponent from '../components/menu/MenuComponent.vue'
import ClientesComponent from '../components/content/ClientesComponent.vue'
import TopComponent from '../components/top/TopComponent.vue'
import FooterComponent from '../components/footer/FooterComponent.vue'
if(sessionStorage.getItem("usuario_usuario")==null||sessionStorage.getItem("usuario_codigo")==null){
window.location.href=window.location.origin+"/login"
}
</script>
<template>
    <MenuComponent />
    <ClientesComponent />
    <TopComponent />
    <PersonaComponent/> 
    <FooterComponent />
</template>