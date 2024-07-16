<template>
  <div>
    <h1>This is index page</h1>
    <el-row>
      <el-col :span="4">
        <el-button type="primary" :i="Service" @click="toTtsProcess"
          >TTS-工序
        </el-button>
      </el-col>
      <el-col :span="4">
        <el-button type="success" :icon="Connection" @click="toChatPerson"
          >聊天室
        </el-button>
      </el-col>
    </el-row>
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
