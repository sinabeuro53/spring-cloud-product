package com.example.springcloudproduct.core.delivery.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDlvPrdMapEntity is a Querydsl query type for DlvPrdMapEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDlvPrdMapEntity extends EntityPathBase<DlvPrdMapEntity> {

    private static final long serialVersionUID = -1979986814L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDlvPrdMapEntity dlvPrdMapEntity = new QDlvPrdMapEntity("dlvPrdMapEntity");

    public final com.example.springcloudproduct.core.common.domain.QBaseEntity _super = new com.example.springcloudproduct.core.common.domain.QBaseEntity(this);

    public final StringPath bizTypCd = createString("bizTypCd");

    public final StringPath buyAgntYn = createString("buyAgntYn");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDt = _super.createDt;

    //inherited
    public final NumberPath<Long> createNo = _super.createNo;

    public final QDeliveryEntity deliveryEntity;

    public final NumberPath<Long> dlvTmpltSeq = createNumber("dlvTmpltSeq", Long.class);

    public final StringPath dlvTypCd = createString("dlvTypCd");

    public final StringPath pchsTypCd = createString("pchsTypCd");

    public final NumberPath<Long> prdNo = createNumber("prdNo", Long.class);

    public final com.example.springcloudproduct.core.product.domain.QProductEntity productEntity;

    public final StringPath sttlTypCd = createString("sttlTypCd");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDt = _super.updateDt;

    //inherited
    public final NumberPath<Long> updateNo = _super.updateNo;

    public final StringPath wrhsTypCd = createString("wrhsTypCd");

    public QDlvPrdMapEntity(String variable) {
        this(DlvPrdMapEntity.class, forVariable(variable), INITS);
    }

    public QDlvPrdMapEntity(Path<? extends DlvPrdMapEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDlvPrdMapEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDlvPrdMapEntity(PathMetadata metadata, PathInits inits) {
        this(DlvPrdMapEntity.class, metadata, inits);
    }

    public QDlvPrdMapEntity(Class<? extends DlvPrdMapEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.deliveryEntity = inits.isInitialized("deliveryEntity") ? new QDeliveryEntity(forProperty("deliveryEntity")) : null;
        this.productEntity = inits.isInitialized("productEntity") ? new com.example.springcloudproduct.core.product.domain.QProductEntity(forProperty("productEntity"), inits.get("productEntity")) : null;
    }

}

