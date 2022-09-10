package com.example.springcloudproduct.core.category.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QStdCtgrEntity is a Querydsl query type for StdCtgrEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStdCtgrEntity extends EntityPathBase<StdCtgrEntity> {

    private static final long serialVersionUID = 1773600303L;

    public static final QStdCtgrEntity stdCtgrEntity = new QStdCtgrEntity("stdCtgrEntity");

    public final com.example.springcloudproduct.core.common.domain.QBaseEntity _super = new com.example.springcloudproduct.core.common.domain.QBaseEntity(this);

    public final StringPath autoApprYn = createString("autoApprYn");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDt = _super.createDt;

    //inherited
    public final NumberPath<Long> createNo = _super.createNo;

    public final NumberPath<Integer> dispPrrtRnk = createNumber("dispPrrtRnk", Integer.class);

    public final NumberPath<Long> hgrnkCtgrNo = createNumber("hgrnkCtgrNo", Long.class);

    public final StringPath reviewType = createString("reviewType");

    public final StringPath siteCd = createString("siteCd");

    public final StringPath stdCtgrCd = createString("stdCtgrCd");

    public final StringPath stdCtgrNm = createString("stdCtgrNm");

    public final NumberPath<Long> stdCtgrNo = createNumber("stdCtgrNo", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDt = _super.updateDt;

    //inherited
    public final NumberPath<Long> updateNo = _super.updateNo;

    public final StringPath useYn = createString("useYn");

    public QStdCtgrEntity(String variable) {
        super(StdCtgrEntity.class, forVariable(variable));
    }

    public QStdCtgrEntity(Path<? extends StdCtgrEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStdCtgrEntity(PathMetadata metadata) {
        super(StdCtgrEntity.class, metadata);
    }

}

