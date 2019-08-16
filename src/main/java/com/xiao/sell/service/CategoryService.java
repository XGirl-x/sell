package com.xiao.sell.service;

import com.xiao.sell.dataobject.ProductCategory;

import java.util.List;
import java.util.Optional;

/**
 * 类目
 */
public interface CategoryService {

    Optional<ProductCategory> findById(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}

