package com.itheima.case2.service.impl;
import com.itheima.case2.dao.RoleMapper;
import com.itheima.case2.pojo.po.Role;
import com.itheima.case2.service.roleService;
import com.itheima.case2.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import java.util.List;
public class roleServiceImpl implements roleService {
    //TODO: 用户下拉框查询角色的方法
    @Override
    public List<Role> findAllRose() {
        //1.获取mybatis会话对象
        SqlSession sqlSession = SqlSessionUtil.getSession();
        //2.获取接口代理对象
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        //3.调用查询所有角色的方法
        List<Role> list = mapper.findAllRose();
        //4.释放资源
        sqlSession.close();
        //5.返回角色列表给web层
        return list;
    }
}
