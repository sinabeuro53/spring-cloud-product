package com.example.springcloudproduct.core.product.service;

import com.example.springcloudproduct.core.product.domain.ProductDetailDTO;
import com.example.springcloudproduct.core.product.domain.ProductEntity;

public interface ProductDetailService {

    // 상품상세
    ProductDetailDTO selectProductDetail(Long prdNo);

    ProductEntity saveProductDetailPolicy(ProductDetailDTO productDetailDTO);
}
