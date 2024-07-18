import axios from "axios";

export const prodProcessPageCondition = async (param) => {
  let url = "http://10.10.80.108:40713/rest/prod/process/page/condition";
  let result = {};
  await axios
    .post(url, param)
    .then(async function (response) {
      //判断服务器响应状态 http.status=200, 响应结果code=0成功
      if (response.status === 200 && response.data.code === "0") {
        result = response.data.data;
      }
    }) //请求异常处理
    .catch(function (error) {
      console.error("Error [/rest/prod/process/page/condition] Data:", error);
    });
  return result;
};
