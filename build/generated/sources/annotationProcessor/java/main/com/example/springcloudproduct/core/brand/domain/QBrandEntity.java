package com.example.springcloudproduct.core.brand.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBrandEntity is a Querydsl query type for BrandEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBrandEntity extends EntityPathBase<BrandEntity> {

    private static final long serialVersionUID = 257347840L;

    public static final QBrandEntity brandEntity = new QBrandEntity("brandEntity");

    public final com.example.springcloudproduct.core.common.domain.QBaseEntity _super = new com.example.springcloudproduct.core.common.domain.QBaseEntity(this);

    public final StringPath brandCd = createString("brandCd");

    public final NumberPath<Long> brandNo = createNumber("brandNo", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDt = _super.createDt;

    //inherited
    public final NumberPath<Long> createNo = _super.createNo;

    public final StringPath hgrnkBrandCd = createString("hgrnkBrandCd");

    public final StringPath mainNmEn = createString("mainNmEn");

    public final StringPath mainNmKr = createString("mainNmKr");

    public final StringPath siteCd = createString("siteCd");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDt = _super.updateDt;

    //inherited
    public final NumberPath<Long> updateNo = _super.updateNo;

    public QBrandEntity(String variable) {
        super(BrandEntity.class, forVariable(variable));
    }

    public QBrandEntity(Path<? extends BrandEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBrandEntity(PathMetadata metadata) {
        super(BrandEntity.class, metadata);
    }

}

