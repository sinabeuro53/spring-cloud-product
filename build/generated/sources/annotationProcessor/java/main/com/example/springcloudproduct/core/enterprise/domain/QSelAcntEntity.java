package com.example.springcloudproduct.core.enterprise.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSelAcntEntity is a Querydsl query type for SelAcntEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSelAcntEntity extends EntityPathBase<SelAcntEntity> {

    private static final long serialVersionUID = 59984559L;

    public static final QSelAcntEntity selAcntEntity = new QSelAcntEntity("selAcntEntity");

    public final StringPath addrDtl = createString("addrDtl");

    public final StringPath bizCtgrNm = createString("bizCtgrNm");

    public final StringPath bizRegNo = createString("bizRegNo");

    public final StringPath bizTypNm = createString("bizTypNm");

    public final StringPath ceoNm = createString("ceoNm");

    public final NumberPath<Long> dlvTmpltSeq = createNumber("dlvTmpltSeq", Long.class);

    public final NumberPath<Long> empNo = createNumber("empNo", Long.class);

    public final NumberPath<Long> mrgnRt = createNumber("mrgnRt", Long.class);

    public final StringPath selAcntNm = createString("selAcntNm");

    public final NumberPath<Long> selAcntNo = createNumber("selAcntNo", Long.class);

    public final StringPath zipCd = createString("zipCd");

    public QSelAcntEntity(String variable) {
        super(SelAcntEntity.class, forVariable(variable));
    }

    public QSelAcntEntity(Path<? extends SelAcntEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSelAcntEntity(PathMetadata metadata) {
        super(SelAcntEntity.class, metadata);
    }

}

