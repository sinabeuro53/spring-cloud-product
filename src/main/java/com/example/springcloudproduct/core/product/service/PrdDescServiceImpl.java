package com.example.springcloudproduct.core.product.service;

import com.example.springcloudproduct.core.enterprise.domain.QCodeDetailEntity;
import com.example.springcloudproduct.core.product.domain.PrdDescEntity;
import com.example.springcloudproduct.core.product.domain.QPrdDescEntity;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * packageName  :   com.example.springcloudproduct.core.product.service
 * fileName     :   PrdDescServiceImpl
 * author       :   sinabeuro53
 * date         :   2022-03-17
 * description  :
 */
@Service
@RequiredArgsConstructor
public class PrdDescServiceImpl implements PrdDescService {

    private final JPAQueryFactory queryFactory;

    QCodeDetailEntity qCodeDetail = QCodeDetailEntity.codeDetailEntity;
    QPrdDescEntity qPrdDesc = QPrdDescEntity.prdDescEntity;

    @Override
    public PrdDescEntity getPrdDescInfo(Long prdNo) {

        PrdDescEntity result = queryFactory
                .select(Projections.fields(PrdDescEntity.class,
                        qPrdDesc.prdNo, qPrdDesc.prdDescTypCd, qPrdDesc.prdDescContClob
                        , qPrdDesc.orgnCd, qPrdDesc.orgnTypCd
                        , ExpressionUtils.as(JPAExpressions.select(qCodeDetail.dtlsComNm).from(qCodeDetail).where(qCodeDetail.grpCd.eq("PD003").and(qCodeDetail.dtlsCd.eq(qPrdDesc.orgnTypCd))), "orgnTypNm")
                        , ExpressionUtils.as(JPAExpressions.select(qCodeDetail.dtlsComNm).from(qCodeDetail).where(qCodeDetail.grpCd.eq("MB047").and(qCodeDetail.dtlsCd.eq(qPrdDesc.orgnCd))), "orgnNm")
                        , qPrdDesc.createDt, qPrdDesc.createNo, qPrdDesc.updateDt, qPrdDesc.updateNo
                ))
                .from(qPrdDesc)
                .where(qPrdDesc.prdNo.eq(prdNo))
                .fetchOne();
        return result;
    }
}
