<script setup lang="ts">
import MenuComponent from '../components/menu/MenuComponent.vue'
import PersonaComponent from '../components/content/JuegosComponent.vue'
import TopComponent from '../components/top/TopComponent.vue'
import FooterComponent from '../components/footer/FooterComponent.vue'
if(sessionStorage.getItem("usuario_usuario")==null||sessionStorage.getItem("usuario_codigo")==null){
window.location.href=window.location.origin+"/login"
}
</script>
<template>
    <MenuComponent />
    <JuegosComponent />
    <TopComponent />
    <PersonaComponent/> 
    <FooterComponent />
</template>