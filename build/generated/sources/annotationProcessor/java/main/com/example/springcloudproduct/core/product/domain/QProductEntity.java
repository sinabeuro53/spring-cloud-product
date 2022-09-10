package com.example.springcloudproduct.core.product.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductEntity is a Querydsl query type for ProductEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProductEntity extends EntityPathBase<ProductEntity> {

    private static final long serialVersionUID = 1116628032L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductEntity productEntity = new QProductEntity("productEntity");

    public final com.example.springcloudproduct.core.common.domain.QBaseEntity _super = new com.example.springcloudproduct.core.common.domain.QBaseEntity(this);

    public final DateTimePath<java.time.LocalDateTime> aprvCpltDt = createDateTime("aprvCpltDt", java.time.LocalDateTime.class);

    public final NumberPath<Long> aprvCpltNo = createNumber("aprvCpltNo", Long.class);

    public final DateTimePath<java.time.LocalDateTime> aprvReqDt = createDateTime("aprvReqDt", java.time.LocalDateTime.class);

    public final NumberPath<Long> aprvReqNo = createNumber("aprvReqNo", Long.class);

    public final NumberPath<Long> brandNo = createNumber("brandNo", Long.class);

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

    public final QPriceEntity priceEntity;

    public final StringPath refundYn = createString("refundYn");

    public final com.example.springcloudproduct.core.enterprise.domain.QSelAcntEntity selAcntEntity;

    public final StringPath selYr = createString("selYr");

    public final StringPath siteCd = createString("siteCd");

    public final NumberPath<Long> stdCtgrNo = createNumber("stdCtgrNo", Long.class);

    public final ListPath<com.example.springcloudproduct.core.option.domain.StockEntity, com.example.springcloudproduct.core.option.domain.QStockEntity> stockEntityList = this.<com.example.springcloudproduct.core.option.domain.StockEntity, com.example.springcloudproduct.core.option.domain.QStockEntity>createList("stockEntityList", com.example.springcloudproduct.core.option.domain.StockEntity.class, com.example.springcloudproduct.core.option.domain.QStockEntity.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDt = _super.updateDt;

    //inherited
    public final NumberPath<Long> updateNo = _super.updateNo;

    public final StringPath useYn = createString("useYn");

    public final StringPath vtaxTypCd = createString("vtaxTypCd");

    public QProductEntity(String variable) {
        this(ProductEntity.class, forVariable(variable), INITS);
    }

    public QProductEntity(Path<? extends ProductEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductEntity(PathMetadata metadata, PathInits inits) {
        this(ProductEntity.class, metadata, inits);
    }

    public QProductEntity(Class<? extends ProductEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.priceEntity = inits.isInitialized("priceEntity") ? new QPriceEntity(forProperty("priceEntity"), inits.get("priceEntity")) : null;
        this.selAcntEntity = inits.isInitialized("selAcntEntity") ? new com.example.springcloudproduct.core.enterprise.domain.QSelAcntEntity(forProperty("selAcntEntity")) : null;
    }

}

