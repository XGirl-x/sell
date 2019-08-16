package com.xiao.sell.service;

import com.xiao.sell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * 商品
 */
public interface ProductService {
    Optional<ProductInfo> findById(String productId);

    /**
     * 查询所有在架 的商品列表
     * @return
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存
}
