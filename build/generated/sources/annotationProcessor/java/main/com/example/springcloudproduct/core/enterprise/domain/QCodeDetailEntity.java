package com.example.springcloudproduct.core.enterprise.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCodeDetailEntity is a Querydsl query type for CodeDetailEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCodeDetailEntity extends EntityPathBase<CodeDetailEntity> {

    private static final long serialVersionUID = 386290327L;

    public static final QCodeDetailEntity codeDetailEntity = new QCodeDetailEntity("codeDetailEntity");

    public final StringPath cdVal1 = createString("cdVal1");

    public final StringPath cdVal2 = createString("cdVal2");

    public final StringPath cdVal3 = createString("cdVal3");

    public final StringPath dtlsCd = createString("dtlsCd");

    public final StringPath dtlsCdDesc = createString("dtlsCdDesc");

    public final StringPath dtlsComNm = createString("dtlsComNm");

    public final StringPath grpCd = createString("grpCd");

    public final NumberPath<Integer> prrtRnk = createNumber("prrtRnk", Integer.class);

    public final StringPath useYn = createString("useYn");

    public QCodeDetailEntity(String variable) {
        super(CodeDetailEntity.class, forVariable(variable));
    }

    public QCodeDetailEntity(Path<? extends CodeDetailEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCodeDetailEntity(PathMetadata metadata) {
        super(CodeDetailEntity.class, metadata);
    }

}

