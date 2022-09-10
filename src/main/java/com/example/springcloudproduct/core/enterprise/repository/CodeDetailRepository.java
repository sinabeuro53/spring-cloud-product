package com.example.springcloudproduct.core.enterprise.repository;

import com.example.springcloudproduct.core.enterprise.domain.CodeDetailCompositeKey;
import com.example.springcloudproduct.core.enterprise.domain.CodeDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CodeDetailRepository extends JpaRepository<CodeDetailEntity, CodeDetailCompositeKey> {

//    List<CodeDetailEntity> findBy

    List<CodeDetailEntity> findByGrpCdOrderByPrrtRnkAsc(String grpCd);

    CodeDetailEntity findByGrpCdAndDtlsCd(String grpCd, String dtlsCd);

//    CodeDetailEntity findByCodeDetailCompositeKey(CodeDetailCompositeKey codeDetailCompositeKey);

}
