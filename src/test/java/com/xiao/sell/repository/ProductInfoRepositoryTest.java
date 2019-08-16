package com.xiao.sell.repository;

import com.xiao.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo("123456", "皮蛋粥", new BigDecimal(3.2), 50, "很好喝", "xxx.jpg", 0, 2);
        ProductInfo info = repository.save(productInfo);
        Assert.assertNotNull(info);
    }


    @Test
    public void findByProductStatus() {
        List<ProductInfo> productStatus = repository.findByProductStatus(0);
        Assert.assertNotEquals(0,productStatus.size());
    }
}