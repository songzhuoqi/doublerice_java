<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="用户账号" prop="userId">
      <el-input v-model="dataForm.userId" placeholder="用户账号"></el-input>
    </el-form-item>
    <el-form-item label="订单编号" prop="orderId">
      <el-input v-model="dataForm.orderId" placeholder="订单编号"></el-input>
    </el-form-item>
    <el-form-item label="维权说明" prop="rightExplain">
      <el-input v-model="dataForm.rightExplain" placeholder="维权说明"></el-input>
    </el-form-item>
    <el-form-item label="申请时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="申请时间"></el-input>
    </el-form-item>
    <el-form-item label="处理记录" prop="dealRecord">
      <el-input v-model="dataForm.dealRecord" placeholder="处理记录"></el-input>
    </el-form-item>
    <el-form-item label="最后处理时间" prop="lastDealTime">
      <el-input v-model="dataForm.lastDealTime" placeholder="最后处理时间"></el-input>
    </el-form-item>
    <el-form-item label="状态 1.待处理 2.处理中 3.已解约 4.已赔付买方 5.已赔付卖方" prop="status">
      <el-input v-model="dataForm.status" placeholder="状态 1.待处理 2.处理中 3.已解约 4.已赔付买方 5.已赔付卖方"></el-input>
    </el-form-item>
    <el-form-item label="最后操作账号" prop="lastAccount">
      <el-input v-model="dataForm.lastAccount" placeholder="最后操作账号"></el-input>
    </el-form-item>
    <el-form-item label="操作状态1.赔付买方2.赔付卖方3.和平解约" prop="operateStatus">
      <el-input v-model="dataForm.operateStatus" placeholder="操作状态1.赔付买方2.赔付卖方3.和平解约"></el-input>
    </el-form-item>
    <el-form-item label="照片路径" prop="picUrl">
      <el-input v-model="dataForm.picUrl" placeholder="照片路径"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          userId: '',
          orderId: '',
          rightExplain: '',
          createTime: '',
          dealRecord: '',
          lastDealTime: '',
          status: '',
          lastAccount: '',
          operateStatus: '',
          picUrl: ''
        },
        dataRule: {
          userId: [
            { required: true, message: '用户账号不能为空', trigger: 'blur' }
          ],
          orderId: [
            { required: true, message: '订单编号不能为空', trigger: 'blur' }
          ],
          rightExplain: [
            { required: true, message: '维权说明不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '申请时间不能为空', trigger: 'blur' }
          ],
          dealRecord: [
            { required: true, message: '处理记录不能为空', trigger: 'blur' }
          ],
          lastDealTime: [
            { required: true, message: '最后处理时间不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '状态 1.待处理 2.处理中 3.已解约 4.已赔付买方 5.已赔付卖方不能为空', trigger: 'blur' }
          ],
          lastAccount: [
            { required: true, message: '最后操作账号不能为空', trigger: 'blur' }
          ],
          operateStatus: [
            { required: true, message: '操作状态1.赔付买方2.赔付卖方3.和平解约不能为空', trigger: 'blur' }
          ],
          picUrl: [
            { required: true, message: '照片路径不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/generator/terraceinvolved/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.userId = data.terraceinvolved.userId
                this.dataForm.orderId = data.terraceinvolved.orderId
                this.dataForm.rightExplain = data.terraceinvolved.rightExplain
                this.dataForm.createTime = data.terraceinvolved.createTime
                this.dataForm.dealRecord = data.terraceinvolved.dealRecord
                this.dataForm.lastDealTime = data.terraceinvolved.lastDealTime
                this.dataForm.status = data.terraceinvolved.status
                this.dataForm.lastAccount = data.terraceinvolved.lastAccount
                this.dataForm.operateStatus = data.terraceinvolved.operateStatus
                this.dataForm.picUrl = data.terraceinvolved.picUrl
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/generator/terraceinvolved/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'userId': this.dataForm.userId,
                'orderId': this.dataForm.orderId,
                'rightExplain': this.dataForm.rightExplain,
                'createTime': this.dataForm.createTime,
                'dealRecord': this.dataForm.dealRecord,
                'lastDealTime': this.dataForm.lastDealTime,
                'status': this.dataForm.status,
                'lastAccount': this.dataForm.lastAccount,
                'operateStatus': this.dataForm.operateStatus,
                'picUrl': this.dataForm.picUrl
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
