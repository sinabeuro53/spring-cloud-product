package com.example.springcloudproduct.core.delivery.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDeliveryAddrEntity is a Querydsl query type for DeliveryAddrEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDeliveryAddrEntity extends EntityPathBase<DeliveryAddrEntity> {

    private static final long serialVersionUID = -71628207L;

    public static final QDeliveryAddrEntity deliveryAddrEntity = new QDeliveryAddrEntity("deliveryAddrEntity");

    public final com.example.springcloudproduct.core.common.domain.QBaseEntity _super = new com.example.springcloudproduct.core.common.domain.QBaseEntity(this);

    public final StringPath addrDtl = createString("addrDtl");

    public final StringPath addrMain = createString("addrMain");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDt = _super.createDt;

    //inherited
    public final NumberPath<Long> createNo = _super.createNo;

    public final NumberPath<Long> dlvTmpltAddrNo = createNumber("dlvTmpltAddrNo", Long.class);

    public final NumberPath<Integer> dlvTmpltAddrType = createNumber("dlvTmpltAddrType", Integer.class);

    public final NumberPath<Long> dlvTmpltSeq = createNumber("dlvTmpltSeq", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDt = _super.updateDt;

    //inherited
    public final NumberPath<Long> updateNo = _super.updateNo;

    public final StringPath zipCd = createString("zipCd");

    public QDeliveryAddrEntity(String variable) {
        super(DeliveryAddrEntity.class, forVariable(variable));
    }

    public QDeliveryAddrEntity(Path<? extends DeliveryAddrEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDeliveryAddrEntity(PathMetadata metadata) {
        super(DeliveryAddrEntity.class, metadata);
    }

}

