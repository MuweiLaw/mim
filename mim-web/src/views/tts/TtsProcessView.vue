<template>
  <div>
    <el-row>
      <el-button type="primary" :loading-icon="Service" loading
        >TTS - 工序
      </el-button>

      <el-button type="info" round @click="commonUseWs">commonUseWs</el-button>
      <el-button type="info" round @click="sockJSWs">sockJSWs</el-button>
      <el-button type="info" round @click="speak">speak</el-button>
    </el-row>
    <el-table
      ref="multipleTableRef"
      :data="tableData"
      style="width: 100%"
      @selection-change="handleSelectionChange"
      size="small"
    >
      <el-table-column type="index" width="55" />
      <el-table-column type="selection" width="55" />
      <el-table-column property="processNo" label="流程编号" width="200" />
      <el-table-column property="processTitle" label="标题" min-width="120" />
      <el-table-column property="processBody" label="内容" min-width="300" />
      <el-table-column label="创建时间" min-width="180">
        <template #default="scope">{{ scope.row.createTime }}</template>
      </el-table-column>
      <el-table-column label="更新时间" min-width="180">
        <template #default="scope">{{ scope.row.updateTime }}</template>
      </el-table-column>
    </el-table>
    <div style="margin-top: 20px">
      <el-button @click="toggleSelection([tableData[1], tableData[2]])">
        Toggle selection status of second and third rows
      </el-button>
      <el-button @click="toggleSelection()">Clear selection</el-button>
    </div>
  </div>
</template>

<script setup>
import { onMounted, ref } from "vue";
import { Service } from "@element-plus/icons-vue";
import SockJS from "sockjs-client";
import { prodProcessPageCondition } from "@/api/tts/prodProcess.js";
import { ElTable } from "element-plus";

const multipleTableRef = ref(null);
const multipleSelection = [];
const tableData = ref([{}]);

const toggleSelection = (rows) => {
  if (rows) {
    rows.forEach((row) => {
      multipleTableRef.value.toggleRowSelection(row, undefined);
    });
  } else {
    multipleTableRef.value.clearSelection();
  }
};
const handleSelectionChange = (val) => {
  multipleSelection.value = val;
};

function commonUseWs() {
  let socket = new WebSocket(
    "ws://10.10.80.108:40715/ws/commonUse/websocket/ttsProcess/666"
  );
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
async function getProdProcessPageCondition() {
  let result = ref({});
  try {
    // 调用接口
    result.value = await prodProcessPageCondition({ size: 10, current: 1 });
    tableData.value = result.value.records;
  } catch (error) {
    console.error("Failed to prodProcessPageCondition() data:", error);
  }
}

onMounted(() => {
  getProdProcessPageCondition();
});
</script>
<style></style>
