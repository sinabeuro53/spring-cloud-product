package com.example.springcloudproduct.core.enterprise.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QEmpEntity is a Querydsl query type for EmpEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEmpEntity extends EntityPathBase<EmpEntity> {

    private static final long serialVersionUID = 1145435925L;

    public static final QEmpEntity empEntity = new QEmpEntity("empEntity");

    public final StringPath clssClf = createString("clssClf");

    public final StringPath deptCd = createString("deptCd");

    public final StringPath empClf = createString("empClf");

    public final StringPath empId = createString("empId");

    public final StringPath empNm = createString("empNm");

    public final NumberPath<Long> empNo = createNumber("empNo", Long.class);

    public QEmpEntity(String variable) {
        super(EmpEntity.class, forVariable(variable));
    }

    public QEmpEntity(Path<? extends EmpEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEmpEntity(PathMetadata metadata) {
        super(EmpEntity.class, metadata);
    }

}

