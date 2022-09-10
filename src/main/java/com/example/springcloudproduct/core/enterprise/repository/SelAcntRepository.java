package com.example.springcloudproduct.core.enterprise.repository;

import com.example.springcloudproduct.core.enterprise.domain.SelAcntEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SelAcntRepository extends JpaRepository<SelAcntEntity, Long> {
    SelAcntEntity findBySelAcntNo(Long selAcntNo);
}
