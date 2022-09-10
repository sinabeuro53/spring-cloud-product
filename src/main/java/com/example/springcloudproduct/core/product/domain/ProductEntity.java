package com.example.springcloudproduct.core.product.domain;

import com.example.springcloudproduct.core.common.domain.BaseEntity;
import com.example.springcloudproduct.core.enterprise.domain.SelAcntEntity;
import com.example.springcloudproduct.core.option.domain.StockEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.hibernate.Hibernate;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@Table(name = "user_d", indexes = { @Index(columnList = "name") }, uniqueConstraints = { @UniqueConstraint(columnNames = {"email"})})
@Table(name = "tpd_prd")
@Where(clause = "site_cd='1' and prd_typ_cd='01' and use_yn='Y'")        // and hide_yn='N'"
@ToString(callSuper = true)     // 상속 받는 클래스의 프로퍼티를 정상적으로 등록하기 위한 추가 처리
@EqualsAndHashCode(callSuper = true, of = {"prdNo"})
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "prdNo")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@DynamicInsert
@DynamicUpdate
public class ProductEntity extends BaseEntity {

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


    @OneToOne(optional = true)
    @JoinColumn(name = "sel_acnt_no")
    private SelAcntEntity selAcntEntity;

    private Long brandNo;

    @OneToOne(mappedBy = "productEntity")
    private PriceEntity priceEntity;

    @OneToMany(mappedBy = "productEntity", fetch = FetchType.EAGER)         // 중요! could not initialize proxy - no Session 에러 해결.
    @Fetch(FetchMode.SUBSELECT)
    private List<StockEntity> stockEntityList;

//    @OneToMany
//    @JoinTable(name = "tdp_disp_prd_map",
//        joinColumns = @JoinColumn(name = "prd_no"),
//        inverseJoinColumns = @JoinColumn(name = "disp_ctgr_no"))
//    private List<DispCtgrEntity> dispCtgrEntity = new ArrayList<DispCtgrEntity>();


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
