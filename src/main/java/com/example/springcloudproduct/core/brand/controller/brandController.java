package com.example.springcloudproduct.core.brand.controller;

import com.example.springcloudproduct.core.brand.domain.BrandEntity;
import com.example.springcloudproduct.core.brand.repository.BrandRepository;
import com.example.springcloudproduct.core.common.domain.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName  :   com.example.backend.core.brand.controller
 * fileName     :   brandController
 * author       :   sinabeuro53
 * date         :   2022-03-16
 * description  :
 */
@RestController
@RequestMapping("/brand")
@RequiredArgsConstructor
public class brandController {

    private final BrandRepository brandRepository;

    @GetMapping("/selectBrandInfo/{brandNo}")
    public ResponseData selectBrandInfo(@PathVariable("brandNo") Long brandNo) {
        BrandEntity result = brandRepository.findByBrandNo(brandNo);
        return ResponseData.builder().body(result).build();
    }
}
