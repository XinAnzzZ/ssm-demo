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
  <div style="width: 60%;margin-left: 20%">
    <el-table :data="tableData.data" ref="selectedData"
              @selection-change="handleSelectChange"
              @sort-change="handleSortChange"
              :stripe="true" tooltip-effect="dark" border>
      <el-table-column type="selection"></el-table-column>
      <el-table-column prop="username" label="用户名" sortable="custom"></el-table-column>
      <el-table-column prop="password" label="密码" sortable="custom"></el-table-column>
      <el-table-column prop="description" label="Description" sortable="custom"></el-table-column>
    </el-table>
    <el-pagination background @current-change="handleCurrentChange" @size-change="handleSizeChange"
                   :page-size="tableData.pageSize" :page-sizes="[5, 10, 15, 20]" :total="tableData.total"
                   layout="total, sizes, prev, pager, next">
    </el-pagination>
    <el-button @click="handleDelete" type="primary">删除选择的数据</el-button>
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
      },
      tableData: {
        data: [],
        total: 0,
        pageNum: 1,
        pageSize: 5,
        orderColumn: "username",
        orderType: "ASC",
      },
      selectedData: [],
    },
    methods: {
      save() {
        const _this = this;
        $.ajax({
          url: '/user',
          type: 'post',
          data: JSON.stringify(this.userForm),
          contentType: 'application/json',
          success: function (response) {
            if (response.code === 200) {
              _this.$message({message: 'save success！', type: 'success'});
              _this.handleCurrentChange();
            }
          }
        });
      },
      keydown() {
        if (event.keyCode === 13) {
          this.save();
        }
      },
      handleSelectChange(val) {
        this.selectedData = val;
      },
      handleDelete() {
        const _this = this;
        $.ajax({
          url: '/user',
          type: 'delete',
          data: JSON.stringify(this.selectedData),
          contentType: 'application/json',
          success: function (response) {
            if (response.code === 200) {
              _this.$message({message: 'delete success！', type: 'success'});
              _this.handleCurrentChange();
            }
          }
        });
      },
      handleCurrentChange(pageNumber) {
        if (pageNumber) {
          this.tableData.pageNum = pageNumber;
        }
        const _this = this;
        console.log(this.tableData);
        $.get('/user/list/data', this.tableData, function (response) {
          if (response.code === 200) {
            _this.tableData.data = response.data.list;
            _this.tableData.total = response.data.total;
            _this.tableData.pageNum = response.data.pageNum;
            _this.tableData.pageSize = response.data.pageSize;
          }
        });
      },
      handleSizeChange(pageSize) {
        this.tableData.pageSize = pageSize;
        this.handleCurrentChange();
      },
      handleSortChange(data) {
        this.tableData.orderColumn = data.prop;
        if (data.order === 'ascending') {
          this.tableData.orderType = 'ASC';
        }
        if (data.order === 'descending') {
          this.tableData.orderType = 'DESC';
        }
        this.handleCurrentChange();
      }
    },
    created() {
      this.handleCurrentChange();
    },
  });
</script>
</body>
</html>
