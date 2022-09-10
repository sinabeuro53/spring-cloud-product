package com.example.springcloudproduct.core.option.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QOptionItemEntity is a Querydsl query type for OptionItemEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOptionItemEntity extends EntityPathBase<OptionItemEntity> {

    private static final long serialVersionUID = 196536629L;

    public static final QOptionItemEntity optionItemEntity = new QOptionItemEntity("optionItemEntity");

    public final com.example.springcloudproduct.core.common.domain.QBaseEntity _super = new com.example.springcloudproduct.core.common.domain.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDt = _super.createDt;

    //inherited
    public final NumberPath<Long> createNo = _super.createNo;

    public final StringPath optItemNm = createString("optItemNm");

    public final NumberPath<Integer> optItemNo = createNumber("optItemNo", Integer.class);

    public final NumberPath<Long> optItemSeq = createNumber("optItemSeq", Long.class);

    public final NumberPath<Integer> optPrrtRnk = createNumber("optPrrtRnk", Integer.class);

    public final NumberPath<Long> prdNo = createNumber("prdNo", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDt = _super.updateDt;

    //inherited
    public final NumberPath<Long> updateNo = _super.updateNo;

    public QOptionItemEntity(String variable) {
        super(OptionItemEntity.class, forVariable(variable));
    }

    public QOptionItemEntity(Path<? extends OptionItemEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOptionItemEntity(PathMetadata metadata) {
        super(OptionItemEntity.class, metadata);
    }

}

