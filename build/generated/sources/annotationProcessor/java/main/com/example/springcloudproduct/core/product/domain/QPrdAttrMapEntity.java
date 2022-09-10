package com.example.springcloudproduct.core.product.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPrdAttrMapEntity is a Querydsl query type for PrdAttrMapEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPrdAttrMapEntity extends EntityPathBase<PrdAttrMapEntity> {

    private static final long serialVersionUID = 622170270L;

    public static final QPrdAttrMapEntity prdAttrMapEntity = new QPrdAttrMapEntity("prdAttrMapEntity");

    public final com.example.springcloudproduct.core.common.domain.QBaseEntity _super = new com.example.springcloudproduct.core.common.domain.QBaseEntity(this);

    public final StringPath attrCd = createString("attrCd");

    public final StringPath attrGrpCd = createString("attrGrpCd");

    public final StringPath attrTypCd = createString("attrTypCd");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDt = _super.createDt;

    //inherited
    public final NumberPath<Long> createNo = _super.createNo;

    public final NumberPath<Long> prdNo = createNumber("prdNo", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDt = _super.updateDt;

    //inherited
    public final NumberPath<Long> updateNo = _super.updateNo;

    public QPrdAttrMapEntity(String variable) {
        super(PrdAttrMapEntity.class, forVariable(variable));
    }

    public QPrdAttrMapEntity(Path<? extends PrdAttrMapEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPrdAttrMapEntity(PathMetadata metadata) {
        super(PrdAttrMapEntity.class, metadata);
    }

}

