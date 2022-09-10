package com.example.springcloudproduct.core.statistic.controller;

import com.example.springcloudproduct.core.common.domain.ResponseData;
import com.example.springcloudproduct.core.statistic.domain.PrdStatisticEntity;
import com.example.springcloudproduct.core.statistic.repository.PrdStatisticRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName  :   com.example.springcloudproduct.core.statistic.controller
 * fileName     :   StatisticController
 * author       :   sinabeuro53
 * date         :   2022-03-22
 * description  :
 */
@RestController
@RequestMapping("/statistic")
@RequiredArgsConstructor
public class StatisticController {

    private final PrdStatisticRepository prdStatisticRepository;

    @GetMapping("/getPrdStatistic/{selAcntNo}")
    public ResponseData selectPrdGroupInfo(@PathVariable("selAcntNo") Long selAcntNo) {
        PrdStatisticEntity result = prdStatisticRepository.findBySelAcntNo(selAcntNo);
        if(result != null) {
            result.setPrdOnRegCnt(result.getSelCd01Cnt());
            long prdRegedCnt = result.getSelCd02Cnt() + result.getSelCd03Cnt() + result.getSelCd04Cnt() + result.getSelCd05Cnt();
            result.setPrdRegedCnt(prdRegedCnt);
        }
        return ResponseData.builder().body(result).build();
    }

}
