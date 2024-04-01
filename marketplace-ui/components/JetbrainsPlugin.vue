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
  <UContainer class="p-4 size-full min-w-40">
    <UCard :ui="{divide: ''}">
      <template #header>
        <div class="flex flex-row font-sans">
          <div class="basis-1/6"><img src="https://placehold.co/49" /></div>
          <div class="basis-5/6">
            <p class="font-bold text-xl pl-4">{{ plugin.name }}</p>
            <p class="font-extralight text-sm text-gray-400 pl-4">{{plugin.vendor}}</p>
          </div>
        </div>
      </template>
      <ul>
        <li><p class="font-thin">Version: {{ plugin.version }}</p></li>
        <li><p class="font-thin">Since build: {{ plugin.sinceBuild }}</p></li>
        <li><p class="font-thin">Until build: {{ plugin.untilBuild }}</p></li>
      </ul>
      <template #footer>
        <NuxtLink class="font-thin text-sm text-gray-400" :to="plugin.url">Download</NuxtLink>
      </template>
    </UCard>
  </UContainer>

</template>

<style scoped>

</style>