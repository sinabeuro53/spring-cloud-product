package com.example.springcloudproduct.core.product.service;

import com.example.springcloudproduct.core.enterprise.domain.CodeDetailEntity;
import com.example.springcloudproduct.core.enterprise.domain.QCodeDetailEntity;
import com.example.springcloudproduct.core.enterprise.repository.CodeDetailRepository;
import com.example.springcloudproduct.core.product.domain.PrdAttrMapEntity;
import com.example.springcloudproduct.core.product.domain.QPrdAttrMapEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName  :   com.example.backend.core.product.service
 * fileName     :   PrdAttrServiceImpl
 * author       :   sinabeuro53
 * date         :   2022-03-17
 * description  :
 */
@Service
@RequiredArgsConstructor
public class PrdAttrServiceImpl implements PrdAttrService {

    private final JPAQueryFactory queryFactory;

    QPrdAttrMapEntity qPrdAttrMap = QPrdAttrMapEntity.prdAttrMapEntity;
    QCodeDetailEntity qCodeDetail = QCodeDetailEntity.codeDetailEntity;

    private final CodeDetailRepository codeDetailRepository;

    public List<PrdAttrMapEntity> getGenderList() {
        return this.commonCodeToPrdAttrMapEntity("AC001");
    }

    public List<PrdAttrMapEntity> getSeasonList() {
        return this.commonCodeToPrdAttrMapEntity("AC002");
    }

    private List<PrdAttrMapEntity> commonCodeToPrdAttrMapEntity(String grpCd) {
        List<CodeDetailEntity> codeDetailEntityList = codeDetailRepository.findByGrpCdOrderByPrrtRnkAsc(grpCd);
        List<PrdAttrMapEntity> result = new ArrayList<>();
        codeDetailEntityList.forEach(codeDetailEntity -> {
            PrdAttrMapEntity prdAttrMapEntity = new PrdAttrMapEntity();
            prdAttrMapEntity.setAttrGrpCd(grpCd);
            prdAttrMapEntity.setAttrCd(codeDetailEntity.getDtlsCd());
            prdAttrMapEntity.setAttrNm(codeDetailEntity.getDtlsComNm());
            result.add(prdAttrMapEntity);
        });
        return result;
    }

    @Override
    public List<PrdAttrMapEntity> getPrdAttrList(Long prdNo) {
        List<PrdAttrMapEntity> result = queryFactory
                .select(Projections.fields(PrdAttrMapEntity.class
                        , qPrdAttrMap.prdNo, qPrdAttrMap.attrGrpCd, qPrdAttrMap.attrCd
                        , new CaseBuilder()
                                .when(qPrdAttrMap.attrGrpCd.eq("AC001")).then("성별")
                                .when(qPrdAttrMap.attrGrpCd.eq("AC002")).then("시즌")
                                .otherwise("").as("attrGrpNm")
                        , qCodeDetail.dtlsComNm.as("attrNm")
                        , qPrdAttrMap.createDt, qPrdAttrMap.createNo, qPrdAttrMap.updateDt, qPrdAttrMap.updateNo
                ))
                .from(qPrdAttrMap)
                .innerJoin(qCodeDetail).on(qPrdAttrMap.attrGrpCd.eq(qCodeDetail.grpCd).and(qPrdAttrMap.attrCd.eq(qCodeDetail.dtlsCd)))
                .where(qPrdAttrMap.prdNo.eq(prdNo)).fetch();
        return result;
    }
}
