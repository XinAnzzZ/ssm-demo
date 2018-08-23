<%--
  Created by IntelliJ IDEA.
  User: XinAnzzZ
  Date: 2018/8/23
  Time: 15:00
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>list</title>
</head>
<body>
<div id="app">
  <div style="width: 30%;margin-left: 35%;margin-top: 20px">
    <el-form :model="userForm" ref="userForm" label-width="80px">
      <el-form-item>
        <el-input v-model="userForm.username" placeholder="用户名"></el-input>
      </el-form-item>
      <el-form-item>
        <el-input v-model="userForm.password" placeholder="密码"></el-input>
      </el-form-item>
      <el-form-item>
        <el-input v-model="userForm.description" placeholder="描述" @keydown.native="keydown"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="save">保存用户</el-button>
      </el-form-item>
    </el-form>
  </div>
  <div>

  </div>
</div>
<script type="application/javascript">
  new Vue({
    el: "#app",
    data: {
      userForm: {
        username: '',
        password: '',
        description: '',
      }
    },
    methods: {
      save() {
        request.post('/user', this.userForm)
          .then((response) => {
            if (response.data.code === 200) {
              this.$message({message: '保存成功！', type: 'success'});
            } else {
              this.$message({type: 'error', message: response.data['msg']});
            }
          })
          .error(() => {
            this.$message.error('未知错误');
          });
      },
      keydown() {
        if (event.keyCode === 13) {
          this.save();
        }
      }
    }
  });
</script>
</body>
</html>
