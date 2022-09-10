package com.example.springcloudproduct.core.product.service;

import com.example.springcloudproduct.core.enterprise.domain.QCodeDetailEntity;
import com.example.springcloudproduct.core.enterprise.domain.QEmpEntity;
import com.example.springcloudproduct.core.product.domain.PrdGroupEntity;
import com.example.springcloudproduct.core.product.domain.QPrdGroupEntity;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrdGroupServiceImpl implements PrdGroupService {

    private final JPAQueryFactory queryFactory;

    private QPrdGroupEntity qPrdGroup = QPrdGroupEntity.prdGroupEntity;
    private QCodeDetailEntity qCodeDetail = QCodeDetailEntity.codeDetailEntity;
    private QEmpEntity qEmp = QEmpEntity.empEntity;

    @Override
    public PrdGroupEntity selectPrdGroupInfo(Long prdGroupNo) {

        return queryFactory.select(Projections.fields(PrdGroupEntity.class
                    , qPrdGroup.prdGroupNo
                    , qPrdGroup.prdGroupCd
                    , qPrdGroup.prdGroupNm
                    , qPrdGroup.selAcntNo
                    , qPrdGroup.siteCd
                    , qPrdGroup.brandNo
                    , qPrdGroup.brdCd
                    , qPrdGroup.mrgnRt
                    , qPrdGroup.defaultMdNo
                    , qPrdGroup.bigo
                    , qPrdGroup.useYn
                    , qPrdGroup.dlvTypCd
                    , qPrdGroup.bizTypCd
                    , qPrdGroup.pchsTypCd
                    , qPrdGroup.sttlTypCd
                    , qPrdGroup.centerGubun
                    , qPrdGroup.wmsYn
                    , qPrdGroup.registNo
                    , ExpressionUtils.as(JPAExpressions.select(qCodeDetail.dtlsComNm).from(qCodeDetail).where(qCodeDetail.grpCd.eq("PD126").and(qCodeDetail.dtlsCd.eq(qPrdGroup.dlvTypCd))), "dlvTypNm")
                    , ExpressionUtils.as(JPAExpressions.select(qCodeDetail.dtlsComNm).from(qCodeDetail).where(qCodeDetail.grpCd.eq("PD127").and(qCodeDetail.dtlsCd.eq(qPrdGroup.bizTypCd))), "bizTypNm")
                    , ExpressionUtils.as(JPAExpressions.select(qCodeDetail.dtlsComNm).from(qCodeDetail).where(qCodeDetail.grpCd.eq("PD128").and(qCodeDetail.dtlsCd.eq(qPrdGroup.pchsTypCd))), "pchsTypNm")
                    , ExpressionUtils.as(JPAExpressions.select(qCodeDetail.dtlsComNm).from(qCodeDetail).where(qCodeDetail.grpCd.eq("PD129").and(qCodeDetail.dtlsCd.eq(qPrdGroup.sttlTypCd))), "sttlTypNm")
                    , ExpressionUtils.as(JPAExpressions.select(qEmp.empNm).from(qEmp).where(qEmp.empNo.eq(qPrdGroup.registNo)), "registNm")          // 서브쿼리
                    , qPrdGroup.createDt
                    , qPrdGroup.createNo
                    , ExpressionUtils.as(JPAExpressions.select(qEmp.empNm).from(qEmp).where(qEmp.empNo.eq(qPrdGroup.createNo)), "createNm")          // 서브쿼리
                    , qPrdGroup.updateDt
                    , qPrdGroup.updateNo
                    , ExpressionUtils.as(JPAExpressions.select(qEmp.empNm).from(qEmp).where(qEmp.empNo.eq(qPrdGroup.updateNo)), "updateNm")          // 서브쿼리
                ))
                .from(qPrdGroup)
                .where(qPrdGroup.prdGroupNo.eq(prdGroupNo))
                .fetchOne();
    }
}
