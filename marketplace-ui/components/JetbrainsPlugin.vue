<script setup lang="ts">
interface JetbrainsPlugin {
  id: string,
  name: string,
  vendor: string,
  url: string,
  version: string,
  sinceBuild: string,
  untilBuild: string
}

const props = defineProps<{
  plugin: JetbrainsPlugin
}>()
</script>

<template>
  <UContainer class="p-4 size-full">
    <UCard>
      <template #header>
        <p class="font-bold text-xl">{{ plugin.name }}</p>
      </template>
      <ul>
        <li>Version: {{ plugin.version }}</li>
        <li>Since build: {{ plugin.sinceBuild }}</li>
        <li>Until build: {{ plugin.untilBuild }}</li>
      </ul>
      <template #footer>
        <p>{{ plugin.vendor }}</p>
      </template>
    </UCard>
  </UContainer>

</template>

<style scoped>

</style>