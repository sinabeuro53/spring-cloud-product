package com.example.springcloudproduct.core.product.repository;

import com.example.springcloudproduct.core.product.domain.PrdGroupEntity;
import com.example.springcloudproduct.core.product.service.PrdGroupService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrdGroupRepository extends JpaRepository<PrdGroupEntity, Long>, PrdGroupService {
    PrdGroupEntity findByPrdGroupNo(Long prdGroupNo);
}
