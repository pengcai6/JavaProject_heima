import com.cai.dao.BrandMapper;
import com.cai.pojo.Brand;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.cai.util.mybatisUtil.getSession;

public class BrandMapperTest {

    @Test
    public void testFindAllBrand() {
        SqlSession sqlSession = getSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brandList = brandMapper.FindAllBrand();
        sqlSession.close();
        for (Brand brand : brandList) {
            System.out.println(brand);
        }

    }

    @Test
    public void testFindById() {
        SqlSession sqlSession = getSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = brandMapper.findById(1);
        sqlSession.close();
        System.out.println(brand);

    }
    @Test
    public void testFindBrandByCondition() {
        SqlSession sqlSession = getSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brandList = brandMapper.FindBrandByCondition(null,"华为技术有限公司",1);

        for (Brand brand : brandList) {
            System.out.println(brand);
        }
        sqlSession.close();
    }
    @Test
    public void testFindBrandByCondition2() {
        SqlSession sqlSession = getSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand1 = new Brand();
        brand1.setBrandName("华为");
        //brand1.setCompanyName("华为技术有限公司");
        //brand1.setStatus(1);
        List<Brand> brandList = brandMapper.FindBrandByCondition2(brand1);

        for (Brand brand : brandList) {
            System.out.println(brand);
        }
        sqlSession.close();
    }
    @Test
    public void testFindBrandByCondition3() {
        SqlSession sqlSession = getSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Map<String, String> map = new HashMap<>();
        map.put("brandName","华为");
        map.put("companyName","华为技术有限公司");
        map.put("status","1");

        List<Brand> brandList = brandMapper.FindBrandByCondition3(map);

        for (Brand brand : brandList) {
            System.out.println(brand);
        }
        sqlSession.close();
    }

    @Test
    public void testaddBrand() {
        SqlSession sqlSession = getSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand=new Brand();
        brand.setBrandName("苹果股份");
        brand.setCompanyName("苹果");
        brand.setOrdered(1);
        brand.setDescription("好用");
        brand.setStatus(9);


        int rowCount= brandMapper.addBrand(brand);
        if(rowCount>0){
            sqlSession.commit();
            System.out.println("添加成功");
        }

        sqlSession.close();
    }
    @Test
    public void testupdateBrand() {
        SqlSession sqlSession = getSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand=new Brand();
      //  brand.setBrandName("苹果股份");
       // brand.setCompanyName("苹果123 ");
        brand.setOrdered(1);
        brand.setDescription("差不多得了 ");
        brand.setStatus(5);
        brand.setId(4);

        int rowCount= brandMapper.updateBrand(brand);
        if(rowCount>0){
            sqlSession.commit();
            System.out.println("修改成功");
        }

        sqlSession.close();
    }

    @Test
    public void testdeleteById() {
        SqlSession sqlSession = getSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        int rowCount= brandMapper.deleteById(4);
        if(rowCount>0){
            sqlSession.commit();
            System.out.println("删除成功");
        }
        sqlSession.close();
    }


}
