package com.example.springcloudproduct.core.product.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPriceEntity is a Querydsl query type for PriceEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPriceEntity extends EntityPathBase<PriceEntity> {

    private static final long serialVersionUID = -1463916390L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPriceEntity priceEntity = new QPriceEntity("priceEntity");

    public final com.example.springcloudproduct.core.common.domain.QBaseEntity _super = new com.example.springcloudproduct.core.common.domain.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDt = _super.createDt;

    //inherited
    public final NumberPath<Long> createNo = _super.createNo;

    public final NumberPath<Long> mrgnRt = createNumber("mrgnRt", Long.class);

    public final NumberPath<Long> normPrc = createNumber("normPrc", Long.class);

    public final NumberPath<Long> prdNo = createNumber("prdNo", Long.class);

    public final NumberPath<Long> prdPrcNo = createNumber("prdPrcNo", Long.class);

    public final QProductEntity productEntity;

    public final NumberPath<Long> selPrc = createNumber("selPrc", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDt = _super.updateDt;

    //inherited
    public final NumberPath<Long> updateNo = _super.updateNo;

    public QPriceEntity(String variable) {
        this(PriceEntity.class, forVariable(variable), INITS);
    }

    public QPriceEntity(Path<? extends PriceEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPriceEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPriceEntity(PathMetadata metadata, PathInits inits) {
        this(PriceEntity.class, metadata, inits);
    }

    public QPriceEntity(Class<? extends PriceEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.productEntity = inits.isInitialized("productEntity") ? new QProductEntity(forProperty("productEntity"), inits.get("productEntity")) : null;
    }

}

