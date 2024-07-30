<template>
  <div>
    <h1>axios和json综合</h1>
    <input type="button" value="请求和响应都是普通字符串" @click="method01()"> <br>
    <input type="button" value="响应数据改成json字符串" @click="method02()"> <br>
    <input type="button" value="请求数据也改成json字符串" @click="method03()"> <br>
    <hr>
    <h3>好友列表</h3>
    <div id="messageDiv"></div>
    <table width="500px" cellspacing="0px" cellpadding="5px" border="1px" id="myTable">
      <tr>
        <th>name</th>
        <th>password</th>
      </tr>
      <!-- <tr>
                <td></td>
                <td></td>
                <td></td>
            </tr>-->
    </table>
  </div>

</template>

<script>
  import axios from 'axios'
  export default {
    methods: {
      //1.请求和响应都是普通字符串
      method01() {
        //1.定义变量保存后端地址值
        let url = "/ajaxJsonTest01Servlet";
        //1.2定义变量保存请求参数‘
        let params = "username=你好&password=1234";
        //1.3发送请求
        axios.post(url, params)
          .then(resp => {
            console.log(resp.data)
          });
      },
      //2.请求是普通字符串，响应数据改成json字符串
      method02() {
        //2.定义变量保存后端地址值
        let url = "/ajaxJsonTest02Servlet";
        //2.2定义变量保存请求参数‘
        let params = "username=你好&password=1234";
        //2.3发送请求
        axios.post(url, params)
          .then(resp => {
            console.log(resp.data)
          });
      },
      //3.请求是json字符串，响应数据改成json字符串
      // method03() {
      //   //3.1定义请求地址  
      //   let url = "/ajaxJsonTest03Servlet";
      //   //3.2定义变量保存请求参数是Json格式
      //   let params = " {\"name\":\"刘燕\",\"password\":\"123\"}";
      //   //3.3发送请求
      //   axios.post(url, params)
      //     .then(resp => {
      //       // console.log(resp.data)
      //       //3.4定义变量保存响应数据
      //       let arr=resp.data;
      //       //3.5定义变量保存取出的数据
      //       let context="";
      //       //遍历取出
      //    for(let obj of arr)
      //         //将obj的数据与Context拼接
      //       context=context+`
      //                       <tr>
      //                           <td>${obj.name}</td>
      //                           <td>${obj.password}</td>
      //                       </tr>`;
      //     //console.log(context)                  
      //     //3.8将Context放到table中
      //     document.getElementById("myTable").innerHTML+=context;
      //     });
      // }
      method03() {
        //3.1定义请求地址  
        let url = "/ajaxJsonTest04Servlet";
        //3.2定义变量保存请求参数是Json格式
        let params = " {\"name\":\"刘燕\",\"password\":\"123\"}";
        //3.3发送请求
        axios.post(url, params)
          .then(resp => {
            // console.log(resp.data)
            //3.4定义变量保存响应数据
            let obj=resp.data;
            // console.log(arr)
            //判断
            if(obj.flag)
          {
            //查询成功
            document.getElementById("messageDiv").innerHTML=obj.message;
          //处理数据
            let arr=obj.valueData;
                  //3.5定义变量保存取出的数据
            let context="";
            //遍历取出
         for(let obj of arr)
              //将obj的数据与Context拼接
            context+=`
                            <tr>
                                <td>${obj.name}</td>
                                <td>${obj.password}</td>
                            </tr>`;
          //console.log(context)                  
          //3.8将Context放到table中
          document.getElementById("myTable").innerHTML+=context;

          }
          else{
            //查询失败
            document.getElementById("messageDiv").innerHTML=obj.message;

          }
          });
      }
    }
  }

</script>

<style>

</style>
