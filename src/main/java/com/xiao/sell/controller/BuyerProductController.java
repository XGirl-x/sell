package com.xiao.sell.controller;

import com.xiao.sell.VO.ProductInfoVO;
import com.xiao.sell.VO.ProductVO;
import com.xiao.sell.VO.ResultVO;
import com.xiao.sell.dataobject.ProductCategory;
import com.xiao.sell.dataobject.ProductInfo;
import com.xiao.sell.service.CategoryService;
import com.xiao.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 买家商品
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list(){
        //1.查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2.查询类目（一次性查询）
        List<Integer> categoryTypeList = new ArrayList<>();
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3.数据拼装
        ResultVO resultVO = new ResultVO();
        ProductVO productVO = new ProductVO();
        ProductInfoVO productInfoVO = new ProductInfoVO();

        productVO.setProductInfoVOList(Arrays.asList(productInfoVO));

        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(Arrays.asList(productVO));

        return resultVO;
    }
}
