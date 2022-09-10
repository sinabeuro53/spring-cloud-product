package com.example.springcloudproduct.core.product.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPrdDescEntity is a Querydsl query type for PrdDescEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPrdDescEntity extends EntityPathBase<PrdDescEntity> {

    private static final long serialVersionUID = 168722596L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPrdDescEntity prdDescEntity = new QPrdDescEntity("prdDescEntity");

    public final com.example.springcloudproduct.core.common.domain.QBaseEntity _super = new com.example.springcloudproduct.core.common.domain.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDt = _super.createDt;

    //inherited
    public final NumberPath<Long> createNo = _super.createNo;

    public final StringPath orgnCd = createString("orgnCd");

    public final StringPath orgnTypCd = createString("orgnTypCd");

    public final StringPath prdDescContClob = createString("prdDescContClob");

    public final StringPath prdDescTypCd = createString("prdDescTypCd");

    public final NumberPath<Long> prdNo = createNumber("prdNo", Long.class);

    public final QProductEntity productEntity;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDt = _super.updateDt;

    //inherited
    public final NumberPath<Long> updateNo = _super.updateNo;

    public QPrdDescEntity(String variable) {
        this(PrdDescEntity.class, forVariable(variable), INITS);
    }

    public QPrdDescEntity(Path<? extends PrdDescEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPrdDescEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPrdDescEntity(PathMetadata metadata, PathInits inits) {
        this(PrdDescEntity.class, metadata, inits);
    }

    public QPrdDescEntity(Class<? extends PrdDescEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.productEntity = inits.isInitialized("productEntity") ? new QProductEntity(forProperty("productEntity"), inits.get("productEntity")) : null;
    }

}

