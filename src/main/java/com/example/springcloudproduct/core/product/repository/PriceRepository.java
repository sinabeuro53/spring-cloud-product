package com.example.springcloudproduct.core.product.repository;

import com.example.springcloudproduct.core.product.domain.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName  :   com.example.springcloudproduct.core.product.repository
 * fileName     :   PriceRepository
 * author       :   sinab
 * date         :   2022-03-15
 * description  :
 */
public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

    PriceEntity findByPrdNo(Long prdNo);
}
