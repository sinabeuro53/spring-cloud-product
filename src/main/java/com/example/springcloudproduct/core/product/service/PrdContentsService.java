package com.example.springcloudproduct.core.product.service;

import com.example.springcloudproduct.core.product.domain.PrdImgMultipartFileDTO;
import com.example.springcloudproduct.core.product.domain.ProductDetailDTO;
import com.example.springcloudproduct.core.product.domain.ProductEntity;

/**
 * packageName  :   com.example.backend.core.product.service
 * fileName     :   PrdDetailContentsService
 * author       :   sinabeuro53
 * date         :   2022-03-17
 * description  :
 */
public interface PrdContentsService {

    // 상품상세 - 컨텐츠 정보 조회
    ProductDetailDTO getPrdContentsInfo(Long prdNo);

    ProductEntity savePrdDetailContents(ProductDetailDTO productDetailDTO, PrdImgMultipartFileDTO prdImgMultipartFileDTO) throws Exception;
}
