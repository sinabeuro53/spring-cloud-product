package com.example.springcloudproduct.core.product.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPrdGroupEntity is a Querydsl query type for PrdGroupEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPrdGroupEntity extends EntityPathBase<PrdGroupEntity> {

    private static final long serialVersionUID = -145530254L;

    public static final QPrdGroupEntity prdGroupEntity = new QPrdGroupEntity("prdGroupEntity");

    public final com.example.springcloudproduct.core.common.domain.QBaseEntity _super = new com.example.springcloudproduct.core.common.domain.QBaseEntity(this);

    public final StringPath bigo = createString("bigo");

    public final StringPath bizTypCd = createString("bizTypCd");

    public final NumberPath<Long> brandNo = createNumber("brandNo", Long.class);

    public final StringPath brdCd = createString("brdCd");

    public final StringPath centerGubun = createString("centerGubun");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDt = _super.createDt;

    //inherited
    public final NumberPath<Long> createNo = _super.createNo;

    public final NumberPath<Long> defaultMdNo = createNumber("defaultMdNo", Long.class);

    public final StringPath dlvTypCd = createString("dlvTypCd");

    public final NumberPath<Long> mrgnRt = createNumber("mrgnRt", Long.class);

    public final StringPath pchsTypCd = createString("pchsTypCd");

    public final StringPath prdGroupCd = createString("prdGroupCd");

    public final StringPath prdGroupNm = createString("prdGroupNm");

    public final NumberPath<Long> prdGroupNo = createNumber("prdGroupNo", Long.class);

    public final NumberPath<Long> registNo = createNumber("registNo", Long.class);

    public final NumberPath<Long> selAcntNo = createNumber("selAcntNo", Long.class);

    public final StringPath siteCd = createString("siteCd");

    public final StringPath sttlTypCd = createString("sttlTypCd");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDt = _super.updateDt;

    //inherited
    public final NumberPath<Long> updateNo = _super.updateNo;

    public final StringPath useYn = createString("useYn");

    public final StringPath wmsYn = createString("wmsYn");

    public QPrdGroupEntity(String variable) {
        super(PrdGroupEntity.class, forVariable(variable));
    }

    public QPrdGroupEntity(Path<? extends PrdGroupEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPrdGroupEntity(PathMetadata metadata) {
        super(PrdGroupEntity.class, metadata);
    }

}

