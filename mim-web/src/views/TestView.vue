<template>
  <div>
    <h1>This is index page</h1>
    <el-button type="primary" @click="testUserNo">测试</el-button>
    <el-button type="danger" @click="showTestValue" plain>
      消息提示测试变量
    </el-button>
  </div>
</template>

<script setup>
import { ref } from "vue";
import axios from "axios";
import { useRouter } from "vue-router";
import { ElMessage } from "element-plus";

//-路由对象
const router = useRouter();
//data
let test = ref({
  testV: "666",
});

function testUserNo() {
  let url = "http://127.0.0.1:40713/rest/sys/user/user-no/1";
  //get()请求部分
  axios
    .get(url) //服务响应后，调用的函数  response 响应对象
    .then(function (response) {
      console.log(response.data);
      //判断服务器响应状态 200成功
      if (response.status === 200) {
        test.value.testV = response.data;
        //1、记录登录状态  sessionStorage
        //存储在浏览器的缓存中，超时或浏览器关闭 数据丢失
        //存：sessionStorage.setItem("自定义键",值)
        //取： sessionStorage.getItem("自定义键")
        //sessionStorage.setItem("user_token",response.data.access_token)
        //sessionStorage.setItem("isAuthenticated", true);
        //登录成功到首页
        showTestValue();
        router.push("/home");
      }
    }) //请求异常处理
    .catch(function (error) {
      console.log(error);
    });
}
function showTestValue() {
  ElMessage({
    message: test.value.testV,
    type: "success",
  });
}
</script>
<style></style>
