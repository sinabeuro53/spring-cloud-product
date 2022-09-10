package com.example.springcloudproduct.core.delivery.service;

import com.example.springcloudproduct.core.delivery.domain.DlvPrdMapEntity;

import java.util.List;

public interface DeliveryService {

    DlvPrdMapEntity selectDlvPrdMapByPrdNo(Long prdNo);

    List<DlvPrdMapEntity> selectDlvPrdMapByDlvTmpltSeq(Long dlvTmpltSeq);

    DlvPrdMapEntity selectDlvPrdMap(Long prdNo, Long dlvTmpltSeq);

}
