package com.example.springcloudproduct.core.statistic.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPrdStatisticEntity is a Querydsl query type for PrdStatisticEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPrdStatisticEntity extends EntityPathBase<PrdStatisticEntity> {

    private static final long serialVersionUID = 1059394532L;

    public static final QPrdStatisticEntity prdStatisticEntity = new QPrdStatisticEntity("prdStatisticEntity");

    public final com.example.springcloudproduct.core.common.domain.QBaseEntity _super = new com.example.springcloudproduct.core.common.domain.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDt = _super.createDt;

    //inherited
    public final NumberPath<Long> createNo = _super.createNo;

    public final NumberPath<Long> selAcntNo = createNumber("selAcntNo", Long.class);

    public final NumberPath<Long> selCd01Cnt = createNumber("selCd01Cnt", Long.class);

    public final NumberPath<Long> selCd02Cnt = createNumber("selCd02Cnt", Long.class);

    public final NumberPath<Long> selCd03Cnt = createNumber("selCd03Cnt", Long.class);

    public final NumberPath<Long> selCd04Cnt = createNumber("selCd04Cnt", Long.class);

    public final NumberPath<Long> selCd05Cnt = createNumber("selCd05Cnt", Long.class);

    public final StringPath siteCd = createString("siteCd");

    public final NumberPath<Long> statisticNo = createNumber("statisticNo", Long.class);

    public final NumberPath<Long> totalCnt = createNumber("totalCnt", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDt = _super.updateDt;

    //inherited
    public final NumberPath<Long> updateNo = _super.updateNo;

    public QPrdStatisticEntity(String variable) {
        super(PrdStatisticEntity.class, forVariable(variable));
    }

    public QPrdStatisticEntity(Path<? extends PrdStatisticEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPrdStatisticEntity(PathMetadata metadata) {
        super(PrdStatisticEntity.class, metadata);
    }

}

