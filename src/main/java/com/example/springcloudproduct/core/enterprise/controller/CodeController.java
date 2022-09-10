package com.example.springcloudproduct.core.enterprise.controller;

import com.example.springcloudproduct.core.common.domain.ResponseData;
import com.example.springcloudproduct.core.enterprise.domain.CodeDetailEntity;
import com.example.springcloudproduct.core.enterprise.repository.CodeDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * packageName  :   com.example.backend.core.enterprise.controller
 * fileName     :   CodeController
 * author       :   sinabeuro53
 * date         :   2022-03-17
 * description  :
 */
@RestController
@RequestMapping("/code")
@RequiredArgsConstructor
public class CodeController {

    private final CodeDetailRepository codeDetailRepository;

    @GetMapping("/getCommonCodeList/{grpCd}")
    public ResponseEntity getCommonCodeList(
            @PathVariable(name = "grpCd") String grpCd
    ) {
        List<CodeDetailEntity> result = codeDetailRepository.findByGrpCdOrderByPrrtRnkAsc(grpCd);
        return ResponseData.builder().body(result).build();
    }
}
