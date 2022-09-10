package com.example.springcloudproduct.core.product.service;

import com.example.springcloudproduct.core.category.domain.QStdCtgrEntity;
import com.example.springcloudproduct.core.common.utils.ConvertUtils;
import com.example.springcloudproduct.core.brand.domain.QBrandEntity;
import com.example.springcloudproduct.core.enterprise.domain.QCodeDetailEntity;
import com.example.springcloudproduct.core.enterprise.domain.QEmpEntity;
import com.example.springcloudproduct.core.enterprise.domain.QSelAcntEntity;
import com.example.springcloudproduct.core.product.domain.*;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

//@Repository
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final JPAQueryFactory queryFactory;

    // 상품
    QProductEntity qProduct = QProductEntity.productEntity;
    // 가격
    QPriceEntity qPrice = QPriceEntity.priceEntity;
    // 판매업체
    QSelAcntEntity qSelAcnt = QSelAcntEntity.selAcntEntity;
    // 직원 및 업체
    QEmpEntity qEmp = QEmpEntity.empEntity;
    // 브랜드
    QBrandEntity qBrand = QBrandEntity.brandEntity;
    // 공통코드
    QCodeDetailEntity qCodeDetail = QCodeDetailEntity.codeDetailEntity;

    @Override
    public List<ProductResponseDTO> selectProductList(ProductRequestDTO params) {
        // querydsl
        // https://data-make.tistory.com/615
        // https://ict-nroo.tistory.com/117
        // querydsl 설정
        // https://madplay.github.io/post/introduction-to-querydsl

        // 카테고리
        QStdCtgrEntity qStdCtgr1 = new QStdCtgrEntity("qStdCtgr1");
        QStdCtgrEntity qStdCtgr2 = new QStdCtgrEntity("qStdCtgr2");
        QStdCtgrEntity qStdCtgr3 = new QStdCtgrEntity("qStdCtgr3");

        List<ProductResponseDTO> resultList = queryFactory
                .select(Projections.fields(ProductResponseDTO.class,
                        qProduct.prdNo, qProduct.prdNm, qProduct.prdCd, qProduct.prdStatCd, qProduct.prdSelCd
                        , ExpressionUtils.as(JPAExpressions.select(qCodeDetail.dtlsComNm).from(qCodeDetail).where(qCodeDetail.grpCd.eq("PD124").and(qCodeDetail.dtlsCd.eq(qProduct.prdStatCd))), "prdStatNm")
                        , ExpressionUtils.as(JPAExpressions.select(qCodeDetail.dtlsComNm).from(qCodeDetail).where(qCodeDetail.grpCd.eq("PD155").and(qCodeDetail.dtlsCd.eq(qProduct.prdSelCd))), "prdSelNm")
                        , qProduct.createDt, qProduct.createNo, qProduct.updateDt, qProduct.updateNo
                        , qPrice.selPrc, qPrice.normPrc
                        , qSelAcnt.selAcntNo, qSelAcnt.selAcntNm, qSelAcnt.mrgnRt
                        , qBrand.brandNo, qBrand.mainNmKr.as("brandNm")
                        , ExpressionUtils.as(JPAExpressions.select(qEmp.empNm).from(qEmp).where(qEmp.empNo.eq(qProduct.createNo)), "createNm")          // 서브쿼리
                        , qStdCtgr1.stdCtgrNo.as("stdCtgrNo1"), qStdCtgr1.stdCtgrNm.as("stdCtgrNm1")
                        , qStdCtgr2.stdCtgrNo.as("stdCtgrNo2"), qStdCtgr2.stdCtgrNm.as("stdCtgrNm2")
                        , qStdCtgr3.stdCtgrNo.as("stdCtgrNo3"), qStdCtgr3.stdCtgrNm.as("stdCtgrNm3")
                        , Expressions.as(qStdCtgr1.stdCtgrNm.concat(" > ").concat(qStdCtgr2.stdCtgrNm).concat(" > ").concat(qStdCtgr3.stdCtgrNm), "stdCtgrPath")
                ))
                .from(qProduct)
                .leftJoin(qPrice).on(qProduct.prdNo.eq(qPrice.prdNo))
//                .innerJoin(qProduct.selAcntEntity, qSelAcnt)
                .innerJoin(qBrand).on(qProduct.brandNo.eq(qBrand.brandNo))
                .innerJoin(qSelAcnt).on(qProduct.selAcntEntity.selAcntNo.eq(qSelAcnt.selAcntNo))
                .leftJoin(qStdCtgr3).on(qProduct.stdCtgrNo.eq(qStdCtgr3.stdCtgrNo))
                .leftJoin(qStdCtgr2).on(qStdCtgr3.hgrnkCtgrNo.eq(qStdCtgr2.stdCtgrNo))
                .leftJoin(qStdCtgr1).on(qStdCtgr2.hgrnkCtgrNo.eq(qStdCtgr1.stdCtgrNo))
                .where(
//                    qProduct.prdNo.in(prdNoParam)
                        queryCondition(params, qProduct)
                )
                .orderBy(qProduct.prdNo.desc())
//                .limit(1000)
                .fetch();
//.list(qProduct.id, qProduct.prdNm, qPrice.selPrc, qPrice.normPrc)

        return resultList;
    }

    private BooleanBuilder queryCondition(ProductRequestDTO params, QProductEntity qProduct) {
        BooleanBuilder builder = new BooleanBuilder();

        // https://tistory.linkube.com/entry/jpa-querydsl-%ED%91%9C%ED%98%84%EC%8B%9D
        builder.and(qProduct.prdNo.gt(308300000));

        // 협력사 번호 검색
        if(Objects.nonNull(params.getSelAcntNo())) {
            builder.and(qProduct.selAcntEntity.selAcntNo.eq(params.getSelAcntNo()));
        }
        // 상품명 검색
        if(StringUtils.isNotBlank(params.getPrdNm())) {
            builder.and(qProduct.prdNm.contains(params.getPrdNm()));
        }

        if(params.getPrdStatCdArray() != null && params.getPrdStatCdArray().length > 0) {
            builder.and(qProduct.prdStatCd.in(params.getPrdStatCdArray()));
        }

        if(params.getPrdStatCdArray() != null && params.getPrdSelCdArray().length > 0) {        // 판매상태
            builder.and(qProduct.prdSelCd.in(params.getPrdSelCdArray()));
        }

        if(StringUtils.isNotBlank(params.getPrdCdTyp()) && params.getPrdCdArray().length > 0) {
            if(params.getPrdCdTyp().equals("01")) {     // 상품번호
                builder.and(qProduct.prdNo.in(ConvertUtils.StringArrayToLongArray(params.getPrdCdArray())));
            } else if(params.getPrdCdTyp().equals("02")) {      // 상품코드
                builder.and(qProduct.prdCd.in(params.getPrdCdArray()));
            }
        }

        if(params.getPrdStatCdArray() != null && params.getStdCtgrNoArray().length > 0) {
            builder.and(qProduct.stdCtgrNo.in(params.getStdCtgrNoArray()));
        }

        return builder;
    }

}
