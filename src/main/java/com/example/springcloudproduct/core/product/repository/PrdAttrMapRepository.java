package com.example.springcloudproduct.core.product.repository;

import com.example.springcloudproduct.core.product.domain.PrdAttrMapCompositeKey;
import com.example.springcloudproduct.core.product.domain.PrdAttrMapEntity;
import com.example.springcloudproduct.core.product.service.PrdAttrService;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName  :   com.example.backend.core.product.repository
 * fileName     :   PrdAttrMapRepository
 * author       :   sinabeuro53
 * date         :   2022-03-17
 * description  :
 */
public interface PrdAttrMapRepository extends JpaRepository<PrdAttrMapEntity, PrdAttrMapCompositeKey>, PrdAttrService {

    void deleteByPrdNo(Long PrdNo);

}
