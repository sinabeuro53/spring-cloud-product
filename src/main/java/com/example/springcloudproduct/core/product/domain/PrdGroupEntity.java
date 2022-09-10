package com.example.springcloudproduct.core.product.domain;

import com.example.springcloudproduct.core.common.domain.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "tpd_prd_group", schema = "ecomms")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class PrdGroupEntity extends BaseEntity {

    @Id @Column(name = "prd_group_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prdGroupNo;
    private String prdGroupCd;
    private String prdGroupNm;
    private Long selAcntNo;
    private String siteCd;
    private Long brandNo;
    private String brdCd;
    private Long mrgnRt;
    private Long defaultMdNo;
    private String bigo;
    private String useYn;

    private String dlvTypCd;    // 배송구분 PD126

    @Transient
    private String dlvTypNm;

    private String bizTypCd;    // 매입구분 PD127

    @Transient
    private String bizTypNm;

    private String pchsTypCd;   // 사입유형 PD128

    @Transient
    private String pchsTypNm;

    private String sttlTypCd;   // 정산구분 PD129

    @Transient
    private String sttlTypNm;

    private String centerGubun; // (자사)센터구분 (E1:안성, E2:여주)
    private String wmsYn;
    private Long registNo;
    @Transient
    private String registNm;

}
