<template>
         <el-form
        :model="ruleForm"
        :rules="rules"
        ref="ruleForm"
       
        class="demo-ruleForm"
        >
        <el-row type="flex" justify="center">
        <el-col :span="5">
            <el-form-item prop="username">
            <el-input
            type="text"
            placeholder="请输入用户名"
            required="required"
            v-model="ruleForm.username"
            prefix-icon="el-icon-user-solid"
            ></el-input>
            </el-form-item>
        </el-col>
        </el-row>
        <el-row type="flex" justify="center">
        <el-col :span="5">
            <el-form-item prop="password">
            <el-input
            type="password"
            placeholder="请输入密码"
            prefix-icon="el-icon-lock"
            v-model="ruleForm.password"
            ></el-input>
            </el-form-item>
        </el-col>
        </el-row>
        <el-row type="flex" justify="center">
        <el-col :span="5">
            <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
            </el-form-item>
        </el-col>
        </el-row>
    </el-form>
   
</template>

<script>
import axios from 'axios'
 export default {
    data() {
      return {
        ruleForm: {
          username: '',
          password: ''
        },
        rules: {
          username: [
            { required: true, message: '请输入用户名', trigger: 'blur' },
          ],
          password: [
            { required: true, message: '请输入密码', trigger: 'blur' }
          ]
        }
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            //TODO:向后台发送异步请求，携带请求数据完成登录
              //1.定义变量，保存后端服务器的地址,由于在config/index.js中已经配置了后端服务器三要素，所以在这里只需要书写不含三要素的地址
              let url="/user/loginServlet";
              //2.定义变量保存  向后端发送的请求数据
              let params=`username=${this.ruleForm.username}&pwd=${this.ruleForm.password}`;
              //3.发送异步请求
              axios.post(url,params)
              .then(resp=>{
                /*
                TODO:前端响应处理：
                1.如果后端响应true表示登陆成功，跳转到主页
                2.如果后端响应false表示登陆失败，在当前页面提示用户名或者密码错误 
                 */
                //4.判断
                if(resp.data){
                  //如果后端响应true表示登陆成功，跳转到主页
                  //过程：#/success ===>router/index.js ===>path:'/success' ===> component: success
                  //===>import success from '@/views/user/success'
                  //===>src/views/user/success.vue组件
                  location.href="#/success"
                }
                else{
                  //如果后端响应false表示登陆失败，在当前页面提示用户名或者密码错误 
                  this.$message.error('用户名或者密码错误');
                }
              });
          } else {
            //表单校验失败
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }

</script>

<style>
 
</style>