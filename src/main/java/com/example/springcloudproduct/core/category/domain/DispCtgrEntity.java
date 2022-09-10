package com.example.springcloudproduct.core.category.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString(callSuper = true)
@Table(name = "tdp_disp_ctgr")
@EqualsAndHashCode
public class DispCtgrEntity {

    // 전시카테고리 테이블
    // productEntity 와 조인테이블 관계에 있음
    @Id
    @Column(name = "disp_ctgr_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dispCtgrNo;

    private Long hgrnkCtgrNo;

    private String dispCtgrNm;

    private String dispCtgrTypCd;

    private Long dispPrrtRnk;

    private String useYn;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createDt;

    private Long createNo;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime updateDt;

    private Long updateNo;

}
