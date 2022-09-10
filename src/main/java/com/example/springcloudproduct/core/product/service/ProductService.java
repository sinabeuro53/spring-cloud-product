package com.example.springcloudproduct.core.product.service;

import com.example.springcloudproduct.core.product.domain.ProductRequestDTO;
import com.example.springcloudproduct.core.product.domain.ProductResponseDTO;

import java.util.List;

public interface ProductService {

    // 상품리스트 조회
    List<ProductResponseDTO> selectProductList(ProductRequestDTO params);


}
