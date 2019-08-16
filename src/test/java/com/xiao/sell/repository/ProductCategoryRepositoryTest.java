package com.xiao.sell.repository;

import com.xiao.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findByIdTest() {
        Optional<ProductCategory> productCategory = repository.findById(1);
        System.out.println(productCategory);
    }

    @Test
    @Transactional    //测试数据不显示在数据库
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory("男生最爱",3);
        ProductCategory category = repository.save(productCategory);
        Assert.assertNotNull(category);
        /*Assert.assertNotEquals(null,category);*/

    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(2,3);
        List<ProductCategory> categoryTypeIn = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,categoryTypeIn);
    }
}