package com.example.springcloudproduct.core.delivery.repository;

import com.example.springcloudproduct.core.delivery.domain.DlvPrdMapEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DlvPrdMapRepositoryTest {

    @Autowired
    private DlvPrdMapRepository dlvPrdMapRepository;

    @Test
    void findByPrdNo() {
        DlvPrdMapEntity dlvPrdMapEntity = dlvPrdMapRepository.findByPrdNo(314055633L);
        System.out.println(dlvPrdMapEntity);
    }

    @Test
    void findByDlvTmpltSeq() {
        List<DlvPrdMapEntity> dlvPrdMapEntities = dlvPrdMapRepository.findTop10ByDlvTmpltSeqOrderByPrdNoDesc(206922L);
        System.out.println(dlvPrdMapEntities);
    }

    @Test
    void findByPrdNoAndDlvTmpltSeq() {
        DlvPrdMapEntity dlvPrdMapEntity = dlvPrdMapRepository.findByPrdNoAndDlvTmpltSeq(314055633L, 206922L);
    }
}