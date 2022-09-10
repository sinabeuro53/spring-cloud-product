package com.example.springcloudproduct.core.delivery.repository;

import com.example.springcloudproduct.core.delivery.domain.DlvPrdMapCompositeKey;
import com.example.springcloudproduct.core.delivery.domain.DlvPrdMapEntity;
import com.example.springcloudproduct.core.delivery.service.DeliveryService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DlvPrdMapRepository extends JpaRepository<DlvPrdMapEntity, DlvPrdMapCompositeKey>, DeliveryService {

    DlvPrdMapEntity findByPrdNo(Long PrdNo);

    List<DlvPrdMapEntity> findTop10ByDlvTmpltSeqOrderByPrdNoDesc(Long dlvTmpltSeq);

    DlvPrdMapEntity findByPrdNoAndDlvTmpltSeq(Long PrdNo, Long dlvTmpltSeq);
}
