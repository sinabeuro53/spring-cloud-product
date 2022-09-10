package com.example.springcloudproduct.core.product.service;

import com.example.springcloudproduct.core.product.domain.PrdAttrMapEntity;

import java.util.List;

/**
 * packageName  :   com.example.backend.core.product.service
 * fileName     :   PrdAttrService
 * author       :   sinabeuro53
 * date         :   2022-03-17
 * description  :
 */
public interface PrdAttrService {


    List<PrdAttrMapEntity> getPrdAttrList(Long prdNo);
}
