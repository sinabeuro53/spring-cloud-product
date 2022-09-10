package com.example.springcloudproduct.core.brand.repository;

import com.example.springcloudproduct.core.brand.domain.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<BrandEntity, Long> {

    BrandEntity findByBrandNo(Long brandNo);
}
