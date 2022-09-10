package com.example.springcloudproduct.core.product.controller;

import com.example.springcloudproduct.core.common.domain.ResponseData;
import com.example.springcloudproduct.core.product.domain.PrdGroupEntity;
import com.example.springcloudproduct.core.product.repository.PrdGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName  :   com.example.backend.core.product.controller
 * fileName     :   PrdGroupController
 * author       :   sinabeuro53
 * date         :   2022-03-16
 * description  :
 */
@RestController
@RequestMapping("/prdGroup")
@RequiredArgsConstructor
public class PrdGroupController {

    private final PrdGroupRepository prdGroupRepository;

    @GetMapping("/selectPrdGroupInfo/{prdGroupNo}")
    public ResponseData selectPrdGroupInfo(@PathVariable("prdGroupNo") Long prdGroupNo) {
        PrdGroupEntity result = prdGroupRepository.selectPrdGroupInfo(prdGroupNo);
        return ResponseData.builder().body(result).build();
    }

}
