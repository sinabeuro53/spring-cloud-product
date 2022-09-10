package com.example.springcloudproduct.core.delivery.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDeliveryEntity is a Querydsl query type for DeliveryEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDeliveryEntity extends EntityPathBase<DeliveryEntity> {

    private static final long serialVersionUID = 503648640L;

    public static final QDeliveryEntity deliveryEntity = new QDeliveryEntity("deliveryEntity");

    public final com.example.springcloudproduct.core.common.domain.QBaseEntity _super = new com.example.springcloudproduct.core.common.domain.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDt = _super.createDt;

    //inherited
    public final NumberPath<Long> createNo = _super.createNo;

    public final ListPath<DeliveryAddrEntity, QDeliveryAddrEntity> deliveryAddrEntityList = this.<DeliveryAddrEntity, QDeliveryAddrEntity>createList("deliveryAddrEntityList", DeliveryAddrEntity.class, QDeliveryAddrEntity.class, PathInits.DIRECT2);

    public final NumberPath<Integer> dlvAmt = createNumber("dlvAmt", Integer.class);

    public final StringPath dlvCmpnyAcctCd = createString("dlvCmpnyAcctCd");

    public final StringPath dlvCmpnyCd = createString("dlvCmpnyCd");

    public final StringPath dlvCmpnyCrctCd = createString("dlvCmpnyCrctCd");

    public final StringPath dlvTmpltNm = createString("dlvTmpltNm");

    public final NumberPath<Long> dlvTmpltSeq = createNumber("dlvTmpltSeq", Long.class);

    public final StringPath dlvTmpltType = createString("dlvTmpltType");

    public final NumberPath<Integer> exchngAmt = createNumber("exchngAmt", Integer.class);

    public final NumberPath<Integer> freeDlvMinAmt = createNumber("freeDlvMinAmt", Integer.class);

    public final StringPath jejuYn = createString("jejuYn");

    public final NumberPath<Integer> outskrtsAmtIslnd = createNumber("outskrtsAmtIslnd", Integer.class);

    public final NumberPath<Integer> outskrtsAmtJeju = createNumber("outskrtsAmtJeju", Integer.class);

    public final StringPath rtripDlvFeeYn = createString("rtripDlvFeeYn");

    public final NumberPath<Integer> rtrnAmt = createNumber("rtrnAmt", Integer.class);

    public final StringPath rtrnBalnTypCd = createString("rtrnBalnTypCd");

    public final StringPath rtrnBizRegNo = createString("rtrnBizRegNo");

    public final StringPath rtrnBoxSpecCd = createString("rtrnBoxSpecCd");

    public final NumberPath<Integer> rtrnBoxUnitCost = createNumber("rtrnBoxUnitCost", Integer.class);

    public final StringPath rtrnCmpnyCd = createString("rtrnCmpnyCd");

    public final StringPath rtrnCmpnyCrctCd = createString("rtrnCmpnyCrctCd");

    public final NumberPath<Long> selAcntNo = createNumber("selAcntNo", Long.class);

    public final StringPath telNo = createString("telNo");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDt = _super.updateDt;

    //inherited
    public final NumberPath<Long> updateNo = _super.updateNo;

    public QDeliveryEntity(String variable) {
        super(DeliveryEntity.class, forVariable(variable));
    }

    public QDeliveryEntity(Path<? extends DeliveryEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDeliveryEntity(PathMetadata metadata) {
        super(DeliveryEntity.class, metadata);
    }

}

