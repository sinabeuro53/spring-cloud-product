package com.example.springcloudproduct.core.product.service;

import com.example.springcloudproduct.core.product.domain.PrdDescEntity;

/**
 * packageName  :   com.example.springcloudproduct.core.product.service
 * fileName     :   PrdDescService
 * author       :   sinabeuro53
 * date         :   2022-03-17
 * description  :
 */
public interface PrdDescService {

    PrdDescEntity getPrdDescInfo(Long prdNo);
}
