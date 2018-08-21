<%--
  Created by IntelliJ IDEA.
  User: XinAnzzZ
  Date: 2018/8/13
  Time: 11:14
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Title</title>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/vue/vue.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/vue/index.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/axios/axios.js"></script>
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/vue/index.css">
</head>
<body>
<div id="app">
  <div style="width: 30%;margin-left: 35%;margin-top: 200px">
    <el-form ref="loginForm" :model="loginForm" label-width="80px">
      <el-form-item label="用户名">
        <el-input v-model="loginForm.username" placeholder="请输入用户名"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="loginForm.password" type="password" placeholder="请输入密码" @keydown.native="keydown"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="login">登录</el-button>
        <el-button @click="register">注册</el-button>
      </el-form-item>
    </el-form>
  </div>
</div>
<script type="text/javascript">
  let formData;
  new Vue({
    el: "#app",
    data: {
      loginForm: {
        username: "xinan",
        password: "xinan",
      },
      hello: "hello",
    },
    methods: {
      login() {
        axios.post('/login', this.loginForm)
          .then((response) => {
            if (response.data.code === 200) {
              this.$message({message: '登录成功！', type: 'success'});
              setTimeout(() => {
                location.href = '/index';
              }, 1000);
            } else {
              this.$message({type: 'error', message: response.data['msg']});
            }
          })
          .catch(() => {
            this.$message.error('未知错误');
          });
      },
      register() {
        location.href = '/register';
      },
      keydown() {
        if (event.keyCode === 13) {
          this.login();
        }
      }
    },
    mounted() {
      formData = this.loginForm;
    },
  });
</script>
</body>
</html>
