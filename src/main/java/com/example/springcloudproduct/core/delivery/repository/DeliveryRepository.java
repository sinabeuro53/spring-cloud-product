package com.example.springcloudproduct.core.delivery.repository;

import com.example.springcloudproduct.core.delivery.domain.DeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<DeliveryEntity, Long> {

    DeliveryEntity findByDlvTmpltSeq(Long dlvTmpltSeq);
}
