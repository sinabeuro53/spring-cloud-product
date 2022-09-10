package com.example.springcloudproduct.core.enterprise.controller;

import com.example.springcloudproduct.core.common.domain.ResponseData;
import com.example.springcloudproduct.core.enterprise.domain.SelAcntEntity;
import com.example.springcloudproduct.core.enterprise.repository.SelAcntRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName  :   com.example.springcloudproduct.core.enterprise.controller
 * fileName     :   SelAcntController
 * author       :   sinabeuro53
 * date         :   2022-03-16
 * description  :
 */
@RestController
@RequestMapping("/selAcnt")
@RequiredArgsConstructor
public class SelAcntController {

    private final SelAcntRepository selAcntRepository;

    @GetMapping("/selectSelAcntInfo/{selAcntNo}")
    public ResponseData selectSelAcntInfo(@PathVariable("selAcntNo") Long selAcntNo) {
        SelAcntEntity result = selAcntRepository.findBySelAcntNo(selAcntNo);
        return ResponseData.builder().body(result).build();
    }

}
