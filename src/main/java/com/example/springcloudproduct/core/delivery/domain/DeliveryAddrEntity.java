package com.example.springcloudproduct.core.delivery.domain;


import com.example.springcloudproduct.core.common.domain.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@Table(name = "tpd_dlv_tmplt_addr", schema = "ecomms")
public class DeliveryAddrEntity extends BaseEntity {

    @Id @Column(name = "dlv_tmplt_addr_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dlvTmpltAddrNo;

    @Column(name = "dlv_tmplt_seq", updatable = false)
    private Long dlvTmpltSeq;       // 배송템플릿 번호

    @Column(name = "dlv_tmplt_addr_type", updatable = false)
    private int dlvTmpltAddrType;   // 배송 주소록 유형(0:출고지, 1:반품처)

    private String zipCd;           // 우편번호
    private String addrMain;        // 주소 기본
    private String addrDtl;         // 주소 상세

}
