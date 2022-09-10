package com.example.springcloudproduct.core.category.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDispCtgrEntity is a Querydsl query type for DispCtgrEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDispCtgrEntity extends EntityPathBase<DispCtgrEntity> {

    private static final long serialVersionUID = 1175772532L;

    public static final QDispCtgrEntity dispCtgrEntity = new QDispCtgrEntity("dispCtgrEntity");

    public final DateTimePath<java.time.LocalDateTime> createDt = createDateTime("createDt", java.time.LocalDateTime.class);

    public final NumberPath<Long> createNo = createNumber("createNo", Long.class);

    public final StringPath dispCtgrNm = createString("dispCtgrNm");

    public final NumberPath<Long> dispCtgrNo = createNumber("dispCtgrNo", Long.class);

    public final StringPath dispCtgrTypCd = createString("dispCtgrTypCd");

    public final NumberPath<Long> dispPrrtRnk = createNumber("dispPrrtRnk", Long.class);

    public final NumberPath<Long> hgrnkCtgrNo = createNumber("hgrnkCtgrNo", Long.class);

    public final DateTimePath<java.time.LocalDateTime> updateDt = createDateTime("updateDt", java.time.LocalDateTime.class);

    public final NumberPath<Long> updateNo = createNumber("updateNo", Long.class);

    public final StringPath useYn = createString("useYn");

    public QDispCtgrEntity(String variable) {
        super(DispCtgrEntity.class, forVariable(variable));
    }

    public QDispCtgrEntity(Path<? extends DispCtgrEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDispCtgrEntity(PathMetadata metadata) {
        super(DispCtgrEntity.class, metadata);
    }

}

