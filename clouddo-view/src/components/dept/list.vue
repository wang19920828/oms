<template>
  <el-row class="wrap">
    <el-col :span="24" class="warp-breadcrum">
      <el-breadcrumb>
        <el-breadcrumb-item>首页</el-breadcrumb-item>
        <el-breadcrumb-item>部门管理</el-breadcrumb-item>
      </el-breadcrumb>
    </el-col>
    <el-col :span="24" class="wrap-main">
   
      <!--列表-->
      <el-table :data="dept" highlight-current-row v-loading="loading" style="width: 100%;">
        <el-table-column type="index" width="60">
        </el-table-column>
        <el-table-column label="序号" prop="deptId" width="80">
        </el-table-column>
        <el-table-column prop="parentId" label="父部门ID" width="120" sortable>
        </el-table-column>
        <el-table-column prop="name" label="部门名称" width="120" sortable>
        </el-table-column>
        <el-table-column prop="orderNum" label="排序" width="100" :formatter="formatSex" sortable>
        </el-table-column>
        <el-table-column prop="delFlag" label="是否删除" min-width="160" sortable>
        </el-table-column>
        <el-table-column label="操作" width="150">
          <template slot-scope="scope">
            <el-button size="mini" @click="showEditDialog(scope.$index,scope.row)">编辑</el-button>
            <el-button size="mini" type="danger" @click="remove(scope.$index,scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-col>
    <!--工具条-->
    <el-col :span="24" class="toolbar">
      <el-pagination layout="total,prev, pager, next" @current-change="search" :page-size="limit"
                     :total="total"
                     style="float:right;">
      </el-pagination>
    </el-col>
  </el-row>
</template>

<script>
  import API from '../../api/api_dept'

  export default {
    name: "list",
    data() {
      return {
        limit: 10,
        total: 0,
        rows: []
      }
    },
    methods: {
      search: function (val) {
        let that = this
        that.page = val
        let params = {
          limit: that.limit,
          page: val
        }
        API.list(params).then(res => {
          if (res.code === 0) {
            that.rows = res.page.rows
            that.total = res.page.total
          }
        })

      },
      remove: function (id) {
        let that = this
        API.remove({id: id}).then(res => {
          if (res.code === 0) {
            that.$message.success(res.msg)
            that.search(that.page)
          }
        })
      },
    },

    mounted() {
      this.search(1);
    }
  }
</script>

<style scoped>

</style>
