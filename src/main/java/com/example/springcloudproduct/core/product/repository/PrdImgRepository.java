package com.example.springcloudproduct.core.product.repository;

import com.example.springcloudproduct.core.product.domain.PrdImgEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName  :   com.example.springcloudproduct.core.product.repository
 * fileName     :   PrdImgRepository
 * author       :   sinabeuro53
 * date         :   2022-03-17
 * description  :
 */
public interface PrdImgRepository extends JpaRepository<PrdImgEntity, Long> {

    PrdImgEntity findByPrdNo(Long prdNo);
}
