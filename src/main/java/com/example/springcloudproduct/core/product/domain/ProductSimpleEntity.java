package com.example.springcloudproduct.core.product.domain;

import com.example.springcloudproduct.core.common.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * packageName  :   com.example.springcloudproduct.core.product.domain
 * fileName     :   ProductSimpleEntity
 * author       :   sinabeuro53
 * date         :   2022-03-17
 * description  :
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tpd_prd")
@Where(clause = "site_cd='1' and prd_typ_cd='01' and use_yn='Y'")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@DynamicInsert
@DynamicUpdate
public class ProductSimpleEntity extends BaseEntity {

    @Id
    @Column(name = "prd_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prdNo;

    private String prdNm;

    private String prdCd;

    private String prdStatCd;   // 상품상태

    private String prdSelCd;    // 판매상태

    private String prdTypCd;    // 타입

    private String selYr;       // 판매년도

    private String dispYn;       // 전시여부

    private String refundYn;    // 환불여부

    private String vtaxTypCd;   // 과세구분

    private Long stdCtgrNo;   // 카테고리 번호(전시카테고리)

    private Long mdNo;          // md 번호

    private Long prdGroupNo;   // 상품그룹 번호

    private String certiTypCd;   // 인증 타입

    private String pcode;   // p코드

    private String prdRegCd;   // 등록 코드

    private String useYn;   // 사용여부

    private String siteCd;   // 사이트

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime codeCrDt;    // 코드생성일
    private Long codeCrNo;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime plcyCrDt;    // 정책등록일
    private Long plcyCrNo;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime cntsCrDt;    // 컨탠츠등록일
    private Long cntsCrNo;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime aprvReqDt;   // 승인신청일
    private Long aprvReqNo;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime aprvCpltDt;  // 승인완료일
    private Long aprvCpltNo;

}
