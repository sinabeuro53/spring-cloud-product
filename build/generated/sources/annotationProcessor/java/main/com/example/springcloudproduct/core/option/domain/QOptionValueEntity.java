package com.example.springcloudproduct.core.option.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QOptionValueEntity is a Querydsl query type for OptionValueEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOptionValueEntity extends EntityPathBase<OptionValueEntity> {

    private static final long serialVersionUID = 2092522549L;

    public static final QOptionValueEntity optionValueEntity = new QOptionValueEntity("optionValueEntity");

    public final com.example.springcloudproduct.core.common.domain.QBaseEntity _super = new com.example.springcloudproduct.core.common.domain.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDt = _super.createDt;

    //inherited
    public final NumberPath<Long> createNo = _super.createNo;

    public final NumberPath<Integer> optItemNo = createNumber("optItemNo", Integer.class);

    public final StringPath optValueNm = createString("optValueNm");

    public final NumberPath<Long> prdNo = createNumber("prdNo", Long.class);

    public final NumberPath<Long> stockNo = createNumber("stockNo", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDt = _super.updateDt;

    //inherited
    public final NumberPath<Long> updateNo = _super.updateNo;

    public QOptionValueEntity(String variable) {
        super(OptionValueEntity.class, forVariable(variable));
    }

    public QOptionValueEntity(Path<? extends OptionValueEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOptionValueEntity(PathMetadata metadata) {
        super(OptionValueEntity.class, metadata);
    }

}

