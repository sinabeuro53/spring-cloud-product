package com.example.springcloudproduct.core.product.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPrdImgEntity is a Querydsl query type for PrdImgEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPrdImgEntity extends EntityPathBase<PrdImgEntity> {

    private static final long serialVersionUID = -1711076170L;

    public static final QPrdImgEntity prdImgEntity = new QPrdImgEntity("prdImgEntity");

    public final com.example.springcloudproduct.core.common.domain.QBaseEntity _super = new com.example.springcloudproduct.core.common.domain.QBaseEntity(this);

    public final StringPath basicExtNm = createString("basicExtNm");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDt = _super.createDt;

    //inherited
    public final NumberPath<Long> createNo = _super.createNo;

    public final StringPath filePath = createString("filePath");

    public final NumberPath<Long> prdNo = createNumber("prdNo", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDt = _super.updateDt;

    //inherited
    public final NumberPath<Long> updateNo = _super.updateNo;

    public QPrdImgEntity(String variable) {
        super(PrdImgEntity.class, forVariable(variable));
    }

    public QPrdImgEntity(Path<? extends PrdImgEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPrdImgEntity(PathMetadata metadata) {
        super(PrdImgEntity.class, metadata);
    }

}

