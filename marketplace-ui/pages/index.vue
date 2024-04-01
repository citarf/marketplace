<script setup lang="ts">
import JetbrainsPlugin from "~/components/JetbrainsPlugin.vue";

const { data: plugins } = await useFetch('http://localhost:8080/plugins')
</script>

<template>
  <h1>Explore plugins for Jetbrains products</h1>
  <UContainer class="grid grid-cols-3">
    <JetbrainsPlugin v-for="plugin in plugins" v-bind:plugin></JetbrainsPlugin>
  </UContainer>
</template>