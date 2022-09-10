package com.example.springcloudproduct.core.product.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProductSimpleEntity is a Querydsl query type for ProductSimpleEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProductSimpleEntity extends EntityPathBase<ProductSimpleEntity> {

    private static final long serialVersionUID = -958694702L;

    public static final QProductSimpleEntity productSimpleEntity = new QProductSimpleEntity("productSimpleEntity");

    public final com.example.springcloudproduct.core.common.domain.QBaseEntity _super = new com.example.springcloudproduct.core.common.domain.QBaseEntity(this);

    public final DateTimePath<java.time.LocalDateTime> aprvCpltDt = createDateTime("aprvCpltDt", java.time.LocalDateTime.class);

    public final NumberPath<Long> aprvCpltNo = createNumber("aprvCpltNo", Long.class);

    public final DateTimePath<java.time.LocalDateTime> aprvReqDt = createDateTime("aprvReqDt", java.time.LocalDateTime.class);

    public final NumberPath<Long> aprvReqNo = createNumber("aprvReqNo", Long.class);

    public final StringPath certiTypCd = createString("certiTypCd");

    public final DateTimePath<java.time.LocalDateTime> cntsCrDt = createDateTime("cntsCrDt", java.time.LocalDateTime.class);

    public final NumberPath<Long> cntsCrNo = createNumber("cntsCrNo", Long.class);

    public final DateTimePath<java.time.LocalDateTime> codeCrDt = createDateTime("codeCrDt", java.time.LocalDateTime.class);

    public final NumberPath<Long> codeCrNo = createNumber("codeCrNo", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDt = _super.createDt;

    //inherited
    public final NumberPath<Long> createNo = _super.createNo;

    public final StringPath dispYn = createString("dispYn");

    public final NumberPath<Long> mdNo = createNumber("mdNo", Long.class);

    public final StringPath pcode = createString("pcode");

    public final DateTimePath<java.time.LocalDateTime> plcyCrDt = createDateTime("plcyCrDt", java.time.LocalDateTime.class);

    public final NumberPath<Long> plcyCrNo = createNumber("plcyCrNo", Long.class);

    public final StringPath prdCd = createString("prdCd");

    public final NumberPath<Long> prdGroupNo = createNumber("prdGroupNo", Long.class);

    public final StringPath prdNm = createString("prdNm");

    public final NumberPath<Long> prdNo = createNumber("prdNo", Long.class);

    public final StringPath prdRegCd = createString("prdRegCd");

    public final StringPath prdSelCd = createString("prdSelCd");

    public final StringPath prdStatCd = createString("prdStatCd");

    public final StringPath prdTypCd = createString("prdTypCd");

    public final StringPath refundYn = createString("refundYn");

    public final StringPath selYr = createString("selYr");

    public final StringPath siteCd = createString("siteCd");

    public final NumberPath<Long> stdCtgrNo = createNumber("stdCtgrNo", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDt = _super.updateDt;

    //inherited
    public final NumberPath<Long> updateNo = _super.updateNo;

    public final StringPath useYn = createString("useYn");

    public final StringPath vtaxTypCd = createString("vtaxTypCd");

    public QProductSimpleEntity(String variable) {
        super(ProductSimpleEntity.class, forVariable(variable));
    }

    public QProductSimpleEntity(Path<? extends ProductSimpleEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductSimpleEntity(PathMetadata metadata) {
        super(ProductSimpleEntity.class, metadata);
    }

}

