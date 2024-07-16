<template>
  <div>
    <el-button type="primary" :loading-icon="Service" loading
      >TTS - 工序</el-button
    >

    <el-button type="info" round @click="commonUseWs">commonUseWs</el-button>
    <el-button type="info" round @click="sockJSWs">sockJSWs</el-button>
    <el-button type="info" round @click="speak">speak</el-button>
  </div>
</template>

<script setup>
import { onMounted, onUnmounted } from "vue";
import { Service } from "@element-plus/icons-vue";
import SockJS from "sockjs-client";

function commonUseWs() {
  let socket = new WebSocket("ws://10.10.80.108:40715/ws/commonUse/websocket");
  socket.onopen = function (ev) {
    console.log(ev);
    console.log("Connected to WebSocket server.");
    socket.send("Hello, Server!");
  };
  socket.onmessage = function (event) {
    console.log("Received data from server: " + event.data);
  };
  socket.onerror = function (error) {
    console.log("WebSocket Error: " + error);
  };
  socket.onclose = function (event) {
    if (event.wasClean) {
      console.log(
        "Connection closed cleanly, code=" +
          event.code +
          " reason=" +
          event.reason
      );
    } else {
      console.log("Connection died");
    }
  };
}
function sockJSWs() {
  // 假设你的WebSocket服务器运行在localhost:8080上
  let sock = new SockJS("http://10.10.80.108:40715/ws/wsSockJS"); // 注意：这里需要后端支持SockJS协议

  sock.onopen = function () {
    console.log("Connected to the SockJS server!");
    sock.send("Hello, server!");
  };

  sock.onmessage = function (event) {
    console.log("Received message from server: " + event.data);
  };

  sock.onclose = function () {
    console.log("Disconnected from the SockJS server.");
  };
}
function speak() {
  // 创建一个新的 utterance
  let utterance = new SpeechSynthesisUtterance("我操你们");

  // 监听结束事件（可选）
  utterance.onend = () => {
    console.log("朗读结束");
    // 你可以在这里重置一些状态或者进行其他操作
  };

  // 将 utterance 添加到队列中进行朗读
  window.speechSynthesis.speak(utterance);
}

onMounted(() => {
  // connectWebSocket();
});

onUnmounted(() => {
  // disconnectWebSocket();
});
</script>
<style></style>
