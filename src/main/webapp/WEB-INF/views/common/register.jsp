<%--
  Created by IntelliJ IDEA.
  User: XinAnzzZ
  Date: 2018/8/15
  Time: 12:28
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>注册</title>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/vue/vue.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/vue/index.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/axios/axios.js"></script>
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/vue/index.css">
</head>
<body>
<div id="app">
  <div style="width: 30%;margin-left: 35%;margin-top: 200px">
    <el-form :model="registerForm" ref="registerForm" label-width="80px">
      <el-form-item label="用户名">
        <el-input v-model="registerForm.username" placeholder="请输入用户名"></el-input>
      </el-form-item>
      <el-form-item lable="密码">
        <el-input v-model="registerForm.password" placeholder="请输入密码"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="register" type="primary">注册</el-button>
        <el-button @click="login">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</div>
<script type="application/javascript">
  new Vue({
    el: "#app",
    data: {
      registerForm: {
        username: '',
        password: '',
      },
    },
    methods: {
      register() {
        if (this.registerForm.username === '' || this.registerForm.password === '') {
          this.$message.error('用户名或密码不能为空！');
          return;
        }
        axios.post('/register', this.registerForm)
          .then((response) => {
            if (response.data.code === 200) {
              this.$message({type: 'success', message: response.data['msg']});
              setTimeout(() => {
                location.href = '/index';
              }, 1000);
            } else {
              this.$message.error(response.data['msg']);
            }
          })
          .catch((error) => {
            console.log(error);
            this.$message.error('未知错误');
          })
      },
      login() {
        location.href = '/login';
      },
    },
  });
</script>
</body>
</html>
