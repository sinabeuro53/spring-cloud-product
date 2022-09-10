package com.example.springcloudproduct.core.delivery.domain;

import com.example.springcloudproduct.core.common.domain.BaseEntity;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@Table(name = "tpd_dlv_tmplt_info", schema = "ecomms")
public class DeliveryEntity extends BaseEntity {

    @Id
    @Column(name = "dlv_tmplt_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dlvTmpltSeq;       // 배송템플릿 번호
    private String dlvTmpltNm;      // 템플릿 이름
    private int rtrnAmt;            // 반품비(편도)
    private int exchngAmt;          // 교환비용
    private int outskrtsAmtIslnd;   // 도서/산간 비용
    private Long selAcntNo;         // 협력사 번호
    private String dlvCmpnyCd;      // 배송택배사 코드
    @Transient
    private String dlvCmpnyNm;      // 배송택배사명
    private int dlvAmt;             // 배송비(편도)
    private int freeDlvMinAmt;      // 무료배송 하한금액
    private String dlvCmpnyCrctCd;  // 배송택배사 계약코드
    private String rtrnCmpnyCd;     // 반품택배사 코드
    @Transient
    private String rtrnCmpnyNm;     // 반품택배사명
    private String rtrnCmpnyCrctCd; // 반품택배사 계약코드
    private String dlvCmpnyAcctCd;  // 택배사 거래처코드
    private String rtrnBalnTypCd;   // 반품 정산구분
    private String rtripDlvFeeYn;   // 왕복배송료 부과여부(완전무료배송 상품 케이스에서 'Y' 인경우 고객귀책으로 전체반품시 2배 부과)
    private String rtrnBoxSpecCd;   // 반품배송 박스규격
    private int rtrnBoxUnitCost;    // 반품배송 박스규격 계약단가
    private String telNo;           // 전화번호
    private String dlvTmpltType;    // 배송비 유형(1:조건부 무료배송, 2:완전무료배송, 3:고정배송비)
    private int outskrtsAmtJeju;    // 제주 배송비
    private String jejuYn;          // 제주 도서 여부
    private String rtrnBizRegNo;    // 반품택배사 계약주체 사업자번호

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "dlv_tmplt_seq", referencedColumnName = "dlv_tmplt_seq")
    @Fetch(FetchMode.SUBSELECT)
    private List<DeliveryAddrEntity> deliveryAddrEntityList;

}
