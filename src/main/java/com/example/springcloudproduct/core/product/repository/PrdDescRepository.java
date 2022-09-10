package com.example.springcloudproduct.core.product.repository;

import com.example.springcloudproduct.core.product.domain.PrdDescEntity;
import com.example.springcloudproduct.core.product.service.PrdDescService;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName  :   com.example.springcloudproduct.core.product.repository
 * fileName     :   PrdDescRepository
 * author       :   sinabeuro53
 * date         :   2022-03-17
 * description  :
 */
public interface PrdDescRepository extends JpaRepository<PrdDescEntity, Long>, PrdDescService {

    PrdDescEntity findByPrdNo(Long prdNo);
}
