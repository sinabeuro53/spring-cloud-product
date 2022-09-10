package com.example.springcloudproduct.core.enterprise.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@Table(name = "tsy_sel_acnt", schema = "enterprise")
@EqualsAndHashCode
public class SelAcntEntity {


//    private Long selAcntNo;
    @Id @Column(name = "sel_acnt_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long selAcntNo;

    private String selAcntNm;       // 업체명

//    private String selAcntNknm;

    private Long mrgnRt;   // 마진율

    private String bizRegNo;

    private Long empNo;

    private String zipCd;

    private String addrDtl;

    private String ceoNm;

    private String bizCtgrNm;

    private String bizTypNm;

    private Long dlvTmpltSeq;       // 배송 템플릿 번호
}
