package com.example.springcloudproduct.core.common.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@MappedSuperclass   // 해당 클래스의 필드를 상속받는 Entity의 컬럼으로 추가시키겠다는 뜻
//, BaseEntityListener.class
@EntityListeners(value = { AuditingEntityListener.class })
public class BaseEntity implements Auditable {
//    여러 객체에서 공통 Entity Listener 쓰는 법
    @CreatedDate
    @Column(columnDefinition = "timestamp default now()", nullable = false, updatable = false)      //  postgres 는 comment 를 바로 달수없다. comment '생성시간'
    // columnDefinition 은 auto ddl 시 디폴트로 생성되는 값이다.
    // columnDefinition에 sqlType 넣어주어야 디폴트 값이 저장된다.
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createDt;

    @LastModifiedDate
    @Column(columnDefinition = "timestamp default now()", nullable = true)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime updateDt;

    private Long createNo;

    @Transient
    private String createNm;

    private Long updateNo;

    @Transient
    private String updateNm;

}
