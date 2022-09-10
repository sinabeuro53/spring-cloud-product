package com.example.springcloudproduct.core.enterprise.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CodeDetailRepositoryTest {

    @Autowired
    private CodeDetailRepository codeDetailRepository;

    @Test
    void codeDetailRepositoryTest() {

        codeDetailRepository.findByGrpCdOrderByPrrtRnkAsc("PD124");
        codeDetailRepository.findByGrpCdAndDtlsCd("PD124", "01");
    }
}