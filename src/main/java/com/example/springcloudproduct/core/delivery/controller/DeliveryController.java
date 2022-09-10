package com.example.springcloudproduct.core.delivery.controller;

import com.example.springcloudproduct.core.common.domain.ResponseData;
import com.example.springcloudproduct.core.delivery.domain.DeliveryEntity;
import com.example.springcloudproduct.core.delivery.repository.DeliveryRepository;
import com.example.springcloudproduct.core.enterprise.domain.CodeDetailEntity;
import com.example.springcloudproduct.core.enterprise.repository.CodeDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName  :   com.example.springcloudproduct.core.delivery.controller
 * fileName     :   deliveryController
 * author       :   sinabeuro53
 * date         :   2022-03-16
 * description  :
 */
@RestController
@RequestMapping("/dlvTmplt")
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryRepository deliveryRepository;
    private final CodeDetailRepository codeDetailRepository;

    @GetMapping("/selectDlvTmpltInfo/{dlvTmpltSeq}")
    public ResponseData selectDlvTmpltInfo(@PathVariable("dlvTmpltSeq") Long dlvTmpltSeq) {
        DeliveryEntity result = deliveryRepository.findByDlvTmpltSeq(dlvTmpltSeq);
        CodeDetailEntity codeDetailEntity1 = codeDetailRepository.findByGrpCdAndDtlsCd("PD117", result.getDlvCmpnyCd());
        result.setDlvCmpnyNm(codeDetailEntity1.getDtlsComNm());
        CodeDetailEntity codeDetailEntity2 = codeDetailRepository.findByGrpCdAndDtlsCd("PD117", result.getRtrnCmpnyCd());
        result.setRtrnCmpnyNm(codeDetailEntity2.getDtlsComNm());
        return ResponseData.builder().body(result).build();
    }

}
