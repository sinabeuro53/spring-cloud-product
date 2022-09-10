package com.example.springcloudproduct.core.delivery.service;

import com.example.springcloudproduct.core.delivery.domain.DlvPrdMapEntity;
import com.example.springcloudproduct.core.delivery.domain.QDeliveryEntity;
import com.example.springcloudproduct.core.delivery.domain.QDlvPrdMapEntity;
import com.example.springcloudproduct.core.product.domain.QProductEntity;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final JPAQueryFactory queryFactory;
    // 상품
    QProductEntity qProduct = QProductEntity.productEntity;
    QDlvPrdMapEntity qDlvPrdMap = QDlvPrdMapEntity.dlvPrdMapEntity;
    QDeliveryEntity qDelivery = QDeliveryEntity.deliveryEntity;


    @Override
    public DlvPrdMapEntity selectDlvPrdMapByPrdNo(Long prdNo) {
        return null;
    }

    @Override
    public List<DlvPrdMapEntity> selectDlvPrdMapByDlvTmpltSeq(Long dlvTmpltSeq) {
        return null;
    }

    @Override
    public DlvPrdMapEntity selectDlvPrdMap(Long prdNo, Long dlvTmpltSeq) {
        return null;
    }

    public void selectDlvPrdMapBy(Long prdNo, Long dlvTmpltSeq) {

        List<Object> o = queryFactory.select(Projections.fields(Object.class,
                qProduct.prdNo, qProduct.prdNm
                , qDelivery.dlvTmpltSeq, qDelivery.dlvTmpltNm
                ))
                .from(qDlvPrdMap)
                .innerJoin(qProduct).on(qDlvPrdMap.prdNo.eq(qProduct.prdNo))
                .innerJoin(qDelivery).on(qDlvPrdMap.dlvTmpltSeq.eq(qDelivery.dlvTmpltSeq))
                .where(this.queryCondition(prdNo, dlvTmpltSeq, qDlvPrdMap))
                .limit(10)
                .fetch();
        System.out.println(o.toString());
    }

    private BooleanBuilder queryCondition(Long prdNo, Long dlvTmpltSeq, QDlvPrdMapEntity qDlvPrdMap) {
        BooleanBuilder builder = new BooleanBuilder();

        if(Objects.nonNull(prdNo) && prdNo != 0L) {
            builder.and(qDlvPrdMap.prdNo.eq(prdNo));
        }
        if(Objects.nonNull(dlvTmpltSeq) && dlvTmpltSeq != 0L) {
            builder.and(qDlvPrdMap.dlvTmpltSeq.eq(dlvTmpltSeq));
        }

        return builder;
    }
}
