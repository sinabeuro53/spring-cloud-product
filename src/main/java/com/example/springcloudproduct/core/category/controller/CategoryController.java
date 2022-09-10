package com.example.springcloudproduct.core.category.controller;

import com.example.springcloudproduct.core.category.domain.StdCtgrEntity;
import com.example.springcloudproduct.core.category.repository.StdCtgrRepository;
import com.example.springcloudproduct.core.common.domain.ResponseData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private StdCtgrRepository stdCtgrRepository;

    @GetMapping ("/selectStdCtgrList")
    public ResponseEntity selectStdCtgrList(
            @RequestParam(value="siteCd", defaultValue = "1") String siteCd
            , @RequestParam(value="hgrnkCtgrNo") Long hgrnkCtgrNo
            , @RequestParam(value="useYn", defaultValue = "Y") String useYn
    ) {
        List<StdCtgrEntity> result = stdCtgrRepository.findByHgrnkCtgrNoAndSiteCdAndUseYnOrderByStdCtgrNoAsc(hgrnkCtgrNo, siteCd, useYn);
        return ResponseData.builder().body(result).build();
    }

}
