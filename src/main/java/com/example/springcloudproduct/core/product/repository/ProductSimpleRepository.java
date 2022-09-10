package com.example.springcloudproduct.core.product.repository;

import com.example.springcloudproduct.core.product.domain.ProductSimpleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName  :   com.example.springcloudproduct.core.product.repository
 * fileName     :   ProductSimpleRepository
 * author       :   sinabeuro53
 * date         :   2022-03-17
 * description  :
 */
public interface ProductSimpleRepository extends JpaRepository<ProductSimpleEntity, Long> {

    ProductSimpleEntity findByPrdNo(Long PrdNo);
}
