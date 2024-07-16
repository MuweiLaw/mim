<template>
  <div>
    <h1>CHAT</h1>
    <el-button
      type="primary"
      :loading-icon="Service"
      loading
      @click="toTtsProcess"
      >TTS-工序</el-button
    >
    <el-button
      type="success"
      :loading-icon="Connection"
      loading
      @click="toChatPerson"
      >聊天室</el-button
    >
  </div>
</template>

<script setup>
import { useRouter } from "vue-router";
import { Service, Connection } from "@element-plus/icons-vue";
//-路由对象
const router = useRouter();

function toTtsProcess() {
  router.push("/tts/process");
}
function toChatPerson() {
  router.push("/chat/person");
}
</script>
<style></style>
