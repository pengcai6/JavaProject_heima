package com.cai.dao;
import com.cai.pojo.Account;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AccountDao {
    //根据id查询
    @Select("select * from tbl_account where id = #{id} ")
    Account findById(Integer id);
    //指定账户减钱
    @Update("update tbl_account set money=money-#{money} where name=#{name}")
    void outMoney(@Param("name") String name,@Param("money") Double money);
        //指定账户加钱
        @Update("update tbl_account set money=money+#{money} where name=#{name}")
    void inMoney(@Param("name") String name,@Param("money") Double money);



}