package com.example.springcloudproduct.core.option.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStockEntity is a Querydsl query type for StockEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStockEntity extends EntityPathBase<StockEntity> {

    private static final long serialVersionUID = -155279793L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStockEntity stockEntity = new QStockEntity("stockEntity");

    public final com.example.springcloudproduct.core.common.domain.QBaseEntity _super = new com.example.springcloudproduct.core.common.domain.QBaseEntity(this);

    public final NumberPath<Long> addPrc = createNumber("addPrc", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDt = _super.createDt;

    //inherited
    public final NumberPath<Long> createNo = _super.createNo;

    public final ListPath<OptionValueEntity, QOptionValueEntity> optionValueEntityList = this.<OptionValueEntity, QOptionValueEntity>createList("optionValueEntityList", OptionValueEntity.class, QOptionValueEntity.class, PathInits.DIRECT2);

    public final NumberPath<Integer> optPrrtRnk = createNumber("optPrrtRnk", Integer.class);

    public final StringPath optStockCd = createString("optStockCd");

    public final StringPath optValueArf = createString("optValueArf");

    public final NumberPath<Long> prdNo = createNumber("prdNo", Long.class);

    public final com.example.springcloudproduct.core.product.domain.QProductEntity productEntity;

    public final NumberPath<Long> realStckQty = createNumber("realStckQty", Long.class);

    public final NumberPath<Long> selAcntNo = createNumber("selAcntNo", Long.class);

    public final NumberPath<Long> selQty = createNumber("selQty", Long.class);

    public final NumberPath<Long> stockNo = createNumber("stockNo", Long.class);

    public final StringPath stockOptCd = createString("stockOptCd");

    public final NumberPath<Long> tempStckQty = createNumber("tempStckQty", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDt = _super.updateDt;

    //inherited
    public final NumberPath<Long> updateNo = _super.updateNo;

    public final StringPath useYn = createString("useYn");

    public QStockEntity(String variable) {
        this(StockEntity.class, forVariable(variable), INITS);
    }

    public QStockEntity(Path<? extends StockEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStockEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStockEntity(PathMetadata metadata, PathInits inits) {
        this(StockEntity.class, metadata, inits);
    }

    public QStockEntity(Class<? extends StockEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.productEntity = inits.isInitialized("productEntity") ? new com.example.springcloudproduct.core.product.domain.QProductEntity(forProperty("productEntity"), inits.get("productEntity")) : null;
    }

}

