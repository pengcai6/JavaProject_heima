<template>
     <div id="div">
            <div class="content-header common-search-border1" style="margin : 10px">
                <!-- TODO:点击新增用户按钮执行handleCreate函数 -->
                <el-button type="primary" class="butAdd" @click="handleCreate"> 新增用户
                </el-button>
            </div>

        <div class="app-container">
            <div class="box common-search-border2">
                <div class="filter-container">
                    <!-- TODO: 搜索栏 -->
                    <!--
                        :inline="true	行内表单模式 (表单项横向排列)
                        :model="queryParams"  数据绑定
                         ref="queryParams" 用于找到本表单使用
                    -->
                    <el-form :inline="true" :model="queryParams" ref="queryParams"
                             class="formInfo">
                        <el-form-item label="用户名称" label-width="80px">
                            <el-input placeholder="请输入" v-model="queryParams.username"
                                      style="width: 200px;" class="filter-item"></el-input>
                        </el-form-item>
                        <el-form-item>
                            <el-button @click="handleRest">清除</el-button>
                            <el-button type="primary" class="butOK" @click="handleSearch">搜索</el-button>
                        </el-form-item>
                    </el-form>
                </div>
            </div>
            <div class="box common-table-border" style="margin:8px 0 0;">
                <!--
                    TODO: 用户列表
                -->
                <!--
                    TODO:element中对于el-table表格标签通过data属性注入数据 
                        应该将后台查询的数据赋值给userList，然后通过data属性值注入带表格中
                    data	显示的数据
                    fit	列的宽度是否自撑开
                -->
                <el-table
                        :data="userList"
                        fit
                        style="width: 100%;">

                    <el-table-column label="编号" width="50px" align="center" prop="id">
                    </el-table-column>
                    <el-table-column label="用户名" align="center" prop="username">
                    </el-table-column>
                    <el-table-column label="邮箱" align="center"  prop="email">
                    </el-table-column>
                    <el-table-column label="创建日期" align="center" prop="createTime">
                    </el-table-column>
                    <el-table-column label="修改日期" align="center" prop="updateTime">
                    </el-table-column>

                    <el-table-column
                            label="角色"
                            width="120"
                            align="center">
                        <!--
                           slot-scope = "scope"
                               用于指定当前的数据(本案例是userList中的当前行元素)
                       -->
                        <template slot-scope="scope">
                            <!--
                                如果要将页面1 test.vue的作为独立的组件应用在另一个页面上2上，
                                并需要以弹框形式打开，可在页面2上直接引入，在页面2中使用el-popover组件，将其插入：
                                悬浮提示信息展示框
                                    trigger = "hover" 鼠标移上去触发
                                    placement="left" 悬浮框显示位置在左边

                            -->
                            <el-popover v-for="role in scope.row.roles" trigger="hover" placement="left">
                                <!-- 前两个p标签是提示信息, div标签是展示信息 -->
                                <p style="font-size: 10px;color: blue">角色编号: {{ role.id }}</p>
                                <p style="font-size: 10px;color: blue">角色描述: {{ role.description }}</p>
                                <div slot="reference" class="name-wrapper">
                                    <el-tag size="medium">{{ role.name }}</el-tag>
                                </div>
                            </el-popover>
                        </template>
                    </el-table-column>
                    <el-table-column label="操作" width="180">
                        <template slot-scope="scope">
                            <!--
                                 TODO: 修改和删除
                                 v-if 判断如果是admin用户就不要出现修改和删除按钮
                             -->
                             <!--TODO: 点击修改按钮执行 handleUpdate函数,scope.row表示当前行对象 -->
                            <div class="operation" v-if="scope.row.username != 'admin'">
                                <el-button type="primary" size="mini" @click="handleUpdate(scope.row)">修改
                                </el-button>
                                <!-- TODO: 点击删除按钮执行 handleDeleted函数，scope.row表示当前行对象-->
                                <el-button size="mini" type="danger" @click="handleDeleted(scope.row)"> 删除
                                </el-button>
                            </div>
                        </template>
                    </el-table-column>

                </el-table>
                <!--
                     TODO: 分页组件
                       @size-change： 当改变每页条数时触发的函数
                       @current-change：当改变页码时触发的函数
                       current-page ：默认的页码
                       :page-sizes：每页条数选择框中显示的值
                       :page-size : 默认的每页条数
                       layout： 分页组件的布局
                           total（总条数）, sizes(每页条数), prev（上一页）, pager(所有的页码), next(下一页), jumper（跳转页码）
                       :total: 总条数
                 -->
                <div class="pagination-container">
                    <el-pagination
                            class="pagiantion"
                            v-show="pagination.total>0"
                            @size-change="handleSizeChange"
                            @current-change="handleCurrentChange"
                            :current-page="pagination.pageNum"
                            :page-sizes="[3, 5, 10, 15]"
                            :page-size="pagination.pageSize"
                            layout="total, sizes, prev, pager, next, jumper"
                            :total="pagination.total">
                    </el-pagination>
                </div>
            </div>
            <!--TODO: 新增用户弹层
                   :visible.sync 是否显示 (dialogFormVisible=true 显示, =false隐藏)
            -->
            <el-dialog title="新增用户" align="left" :visible.sync="dialogFormVisible" width="40%" top="8vh">
                <!--
                    model	表单数据对象
                    rules	表单验证规则
                -->
                <el-form label-width="120px" :model="addUser" :rules="rules" ref="form">
                    <!--
                    prop	表单域 model 字段，在使用 validate、resetFields 方法的情况下，该属性是必填的
                    -->
                    <el-form-item label="用户名称：" prop="username">
                            <!-- v-model 双向数据绑定  autocomplete=off 取消自动补全功能-->
                            <!-- 
                                当我们在浏览器中输入表单信息的时候，往往input文本输入框会记录下之前提交表单的信息，
                                以后每次只要双击 input文本输入框就会出现之前输入的文本，这样有时会觉得比较方便，
                                但有时也会暴露用户的隐藏数据，那么如何让input表单输入框不记录输入过信息的方法呢？
                                在不想使用缓存的input中添加 autocomplete=”off”
                             -->
                        <el-input v-model="addUser.username" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="邮箱：" prop="email">
                        <el-input v-model="addUser.email" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="密码：" prop="password">
                        <el-input type="password" v-model="addUser.password" autocomplete="off"></el-input>
                    </el-form-item>
                    <!--
                        TODO: 动态获取角色
                    -->
                    <el-form-item label="角色: " prop="roleIds">
                        <!--
                         value / v-model	绑定值 (双向数据绑定)
                            multiple	是否多选
                            注意: 这是多选组件, addUser.roleIds是数组!!!
                        -->
                        <el-select v-model="addUser.roleIds" multiple placeholder="请选择至少一个角色">
                            <!--
                                v-for : 遍历, roleList是被遍历的数组
                                value	选项的值	string/number/object
                                label	选项的标签，若不设置则默认与 value 相同 (显示出来的标签名)
                                key     文档中没有说明, 就是取值跟value相同,删除也不影响本组件使用
                            -->
                            <el-option
                                    v-for="role in roleList"
                                    :key="role.id"
                                    :label="role.name"
                                    :value="role.id">
                            </el-option>
                        </el-select>
                    </el-form-item>

                    <el-form-item label="备注：" prop="remark">
                        <el-input v-model="addUser.remark" autocomplete="off"></el-input>
                    </el-form-item>
                </el-form>
                <div slot="footer" class="dialog-footer">
                    <el-button @click="handleCreateCancel">取 消</el-button>
                    <!-- 点击确定执行 handleCreateConfirm函数将数据提交到后端-->
                    <el-button type="primary" @click="handleCreateConfirm">确 定</el-button>
                </div>
            </el-dialog>
            <!-- end -->
            <!-- 修改用户弹层 -->
            <el-dialog title="修改用户" align="left" :visible.sync="dialogUptFormVisible" width="40%" top="8vh">
                <el-form label-width="120px" :model="updateUser" :rules="rules" ref="uptForm">
                    <el-form-item label="用户名称：" prop="username">
                        <el-input v-model="updateUser.username" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="邮箱：" prop="email">
                        <el-input v-model="updateUser.email" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="密码：" prop="password">
                        <el-input type="password" v-model="updateUser.password" autocomplete="off"></el-input>
                    </el-form-item>

                    <el-form-item label="角色: " prop="roleIds">
                        <el-select v-model="updateUser.roleIds" multiple placeholder="请选择至少一个角色">
                            <el-option
                                    v-for="role in roleList"
                                    :key="role.id"
                                    :label="role.name"
                                    :value="role.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-form>
                <div slot="footer" class="dialog-footer">
                    <el-button @click="handleUpdateCancel">取 消</el-button>
                    <el-button type="primary" @click="handleUpdateConfirm">确 定</el-button>
                </div>
            </el-dialog>
            <!-- end -->
        </div>
    </div>
</template>

<script>
import axios from 'axios'
export default {
    data(){
        return {
            pagination: {
                total: 0,  //总条数
                pageNum: 1, // //当前页
                pageSize: 5 //每页显示条数
            },
            userList: [],  //用户列表数据
            roleList: [], // 角色列表数据
            queryParams: { // 搜索条件
                username: ''
            },
            dialogFormVisible: false, // 添加窗口显示状态
            dialogUptFormVisible: false,//修改窗口显示状态
            addUser: { // 用户数据
                username: '',
                email: '',
                password: '',
                remark: '',
                roleIds: []
            },
            updateUser: { //用户的修改数据
                id: "",
                username: '',
                email: '',
                password: '',
                roleIds: []
            },
            rules: { //校验规则
                username: [
                    {required: true, message: '请填写', trigger: 'blur'}
                ],
                email: [
                    {required: true, message: '请填写', trigger: 'blur'},
                    {type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change']}
                ],
                password: [
                    {required: true, message: '请填写', trigger: 'blur'}
                ]
            }

        }
    },
    //TODO:钩子函数当页面加载时会自动执行，准备数据即向后台发送请求获取数据
    created() {
            //分页查询用户列表
            this.getUserList()
            //查询所有的角色 TODO ?
            //  (添加用户和修改用户的时候要展示所有角色以供选择)
            this.getRoleList()
        },
        methods: {
            //TODO: 获取用户分页数据
            getUserList() {

                /* TODO: 去后台查询数据
                请求参数：select * from 表名 limit 起始索引数，每页条数
                        1.当前页码
                        2.每页条数
                        起始索引=（当前页码-1）*每页条数
                响应处理：
                    1.将后端响应的数据放到userList:[]中显示用户和角色信息
                    2.将后端查询的用户表的总记录的值赋给数据模型中的  
                pagination: {
                total: 0,  //总条数
                pageNum: 1, // //当前页
                pageSize: 5 //每页显示条数
            },
                */
               //1.定义变量保存后端地址
               let url="/user/findAll"; //@WebServlet("/user/*")
               //2.定义变量保存请求参数
               let params=`{"currentPage":${this.pagination.pageNum},"pageSize":${this.pagination.pageSize}}`;
                //3.发送请求
               axios.post(url,params).then(
                resp=>{
                //4.定义变量接受后端响应的数据    
                    let obj=resp.data;
                    //5.判断是否查询成功
                    if(obj.flag){
                        //查询成功
                        //6.提示信息
                        this.$message({
                        message: obj.message,   
                        type: 'success'
                        });
                        //7.将查询结果中的用户和角色信息赋值给数据模型的userList[],然后vue就会自动注入到表格中
                        this.userList=obj.result.rows;
                        //8.将后端查询的用户表的总记录的值赋给数据模型中的pagination
                        this.pagination.total=obj.result.total;

                    }
                    else{
                        //查询失败
                        //9.查询失败
                        this.$message.error(obj.message);
                    }
               
                }

               )


            },
            //TODO: 查询角色表
            getRoleList() {
               //TODO:  这里向后端发送请求，从t_role角色表中查询所有角色信息数据赋值给  roleList: [], // 角色列表数据
               let url="/role/findAllRose";
               axios.post(url)
                    .then(resp=>{
                        // console.log(resp.data);
                        //1.定义变量接受响应数据
                        let obj=resp.data;
                        //2.判断
                        if(obj.flag){
                            //查询成功
                             //6.提示信息
                        this.$message({
                        message: obj.message,   
                        type: 'success'
                        });

                       // 将查询结果中角色信息赋值给数据模型的roleList[]
                            this.roleList=obj.result;
                        }
                        else{
                            //查询失败
                        this.$message.error(obj.message);
                        }
                    });

            },
            //将查询条件置空
            handleRest() {
                this.queryParams = {
                    username: ''
                }
            },
            //搜索
            handleSearch() {
                //将当前页码设置为1
                this.pagination.pageNum = 1;
                this.getUserList();
            },
            //每页数量改变的时候
            handleSizeChange(val) {
                this.pagination.pageSize = val;
                this.pagination.pageNum = 1;
                this.getUserList();
            },
            //当前页码改变的时候
            handleCurrentChange(val) {
                this.pagination.pageNum = val;
                this.getUserList();
            },
            // 新增用户
            handleCreate() {
                /*
                    Vue 为简化DOM获取方法提出了ref 属性和$ refs 对象。
                    一般的操作流程是:ref 绑定控件，$refs 获取控件
                    ref 绑定控件:
                    <el-form label-width="120px" :model="addUser" :rules="rules" ref="form">
                    this.$refs['form']表示获取上面的整个添加用户的form表单控件
                */
                if (this.$refs['form']) {
                    this.$refs['form'].resetFields();
                }
                this.dialogFormVisible = true;

            },
            //新增用户确定 TODO:
            handleCreateConfirm() {
                this.$refs['form'].validate((valid) => {
                    if (valid) {
                        //添加用户表单校验通过，向后台请求添加用户的servlet
                        //1.定义变量保存请求地址
                        let url="/user/add";
                        //2.直接发送请求，携带addUser
                        axios.post(url,this.addUser)
                        .then(resp=>{
                           //1.定义变量接受响应数据
                           let obj=resp.data;
                            //2.判断
                            if(obj.flag){
                             //添加成功
                             //6.提示信息
                        this.$message({
                        message: obj.message,   
                        type: 'success'
                        });

                       // 7.关闭添加窗口
                            this. dialogFormVisible=false;
                              //8.再次查询
                              this.getUserList();
                        }
                        else{
                            //添加失败
                        this.$message.error(obj.message);
                        }
                        })
                    }
                });
            },
            //新增用户取消
            handleCreateCancel() {
                this.dialogFormVisible = false;
            },
            //修改用户 数据回显
            handleUpdate(row) {//row=scope.row,表示当前行对象
                var t = this;
                if (t.$refs['uptForm']) {
                    t.$refs['uptForm'].resetFields();
                }
                //当前行对象的id值(row.id)赋值给vue中data中的updateUser中的id
                t.updateUser.id = row.id;
                t.updateUser.username = row.username;
                t.updateUser.password = row.password;
                t.updateUser.email = row.email;

                //遍历取出此用户所有的角色id
                let roleIds = [];
                 /*
                    1.一个用户有多个角色，我们在查询用户的时候，用户对象中会保存多个角色的容器roles
                        row表示当前行：
                        row.roles 表示获取当前行的所有角色对象
                        王五用户扮演的角色：roles=[{id:1,name:管理员},{id:2,name:会员},{id:3,name:游客}]
                */
                for(let i=0;i< row.roles.length; i++){
                    //row.roles[i].id 获取每个角色的id
                    //roleIds[i]存储当前用户的角色id
                    //举例：roleIds = [1,2,3]
                    roleIds[i] = row.roles[i].id;
                }
                 //将当前用户的角色id数组赋值给updateUser中的roleIds
                t.updateUser.roleIds = roleIds;
                // dialogUptFormVisible: false,//修改窗口显示状态 默认值是false表示隐藏弹出框，值是true表示显示弹出框
                t.dialogUptFormVisible = true;

            },
            //修改用户确定 TODO
            handleUpdateConfirm() {
                this.$refs['uptForm'].validate((valid) => {
                    if (valid) {
                        //TODO:向后台发送请求修改用户和角色，向后台提交数据模型中的updateUser
                    //     updateUser: { //用户的修改数据
                    //     id: "",
                    //     username: '',
                    //     email: '',
                    //     password: '',
                    //     roleIds: []
                    // },
                    //1.定义变量保存地址
                    let  url="/user/update";
                    //2.直接发送请求，携带请求参数 updateUser本身为JSON格式，直接传递
                    axios.post(url,this.updateUser)
                         .then(resp=>{
                            //3.定义变量接受后端的响应数据
                           let obj= resp.data;
                            //4.判断
                            if(obj.flag){
                                //更新成功
                                //提示信息
                                this.$message({
                                message: obj.message,
                                type: 'success'
                                });
                                //隐藏修改弹框
                                this.dialogUptFormVisible=false;
                                //再次查询
                                this.getUserList();
                            }
                            else{
                                //更新失败
                                //提示信息
                                this.$message.error( obj.message);
                            }

                         });    

                    }
                });
            },
            //修改用户取消
            handleUpdateCancel() {
                this.dialogUptFormVisible = false;
            },
            // 删除 TODO:
            handleDeleted(row) {//row就是当前行对象
                //点击确认走then,点击取消走catch
                this.$confirm('此操作将永久删除用户 ' + ', 是否继续?', '提示', {
                    type: 'warning'
                }).then(() => {
                    //书写向后台发送请求的代码：delete from 表名 where id=? 前端向后台提交的是当前删除行的id
                    //1.定义变量保存地址
                    let url="/user/delete";
                    //2.定义变量保存当前行id
                    let RowId=row.id;
                    //3.发送id给后端进行删除
                    axios.post(url,RowId)
                    .then(
                        resp=>{
                            //4.定义变量保存接收的后端数据
                            let obj=resp.data;
                            //5.判断
                            if(obj.flag)
                        {//删除成功
                            //6. //提示信息
                            this.$message({
                                message: obj.message,
                                type: 'success'
                                });
                                //7.再次查询
                                this.getUserList();
                        }else{
                            //删除失败
                           //提示信息
                                 this.$message.error( obj.message);
                        }


                        }
                    )

                }).catch(() => {
                    this.$message.info('已取消操作!')
                });
            }
        }
}
</script>
<style>
</style>