package com.cai.dao;

import com.cai.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    /**
     * 查询全部的Brand
     * @return 存储品牌信息的集合
     */
    List<Brand> FindAllBrand();

    /**
     * 根据id查询品牌详情
     * @param id 品牌id
     * @return 品牌对象
     */
    Brand findById(Integer id);

    /**
     * 根据条件查询品牌数据
     * @param brandName 品牌名
     * @param companyName 企业名
     * @param status 状态
     * @return 品牌列表
     */
    List<Brand> FindBrandByCondition(@Param("brandName") String brandName,
                                     @Param("companyName") String companyName,
                                     @Param("status") int status);
    List<Brand> FindBrandByCondition2(Brand brand);
    List<Brand> FindBrandByCondition3(Map<String, String> brandmap);

    /**
     * 添加品牌信息
     * @param brand 品牌对象
     * @return 受影响行数
     */
    int addBrand(Brand brand);

    /**
     * 修改品牌信息
     * @param brand 品牌对象
     * @return  受影响行数
     */
    int updateBrand(Brand brand);

 /**
  * 通过id删除品牌信息
  * @param ids 品牌id
  * @return 受影响行数
  */
 int deleteBrandById(@Param("ids") List<Integer> ids);
}
