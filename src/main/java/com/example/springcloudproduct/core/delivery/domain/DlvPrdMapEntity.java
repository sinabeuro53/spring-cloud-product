package com.example.springcloudproduct.core.delivery.domain;

import com.example.springcloudproduct.core.common.domain.BaseEntity;
import com.example.springcloudproduct.core.product.domain.ProductEntity;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tpd_prd_lgst_info", schema = "ecomms")
@IdClass(DlvPrdMapCompositeKey.class)
//@EqualsAndHashCode(of = {"prdNo", "dlvTmpltSeq"})
public class DlvPrdMapEntity extends BaseEntity {

    @Id
    @Column(name = "prd_no")
    private Long prdNo;

    @Id
    @Column(name = "dlv_tmplt_seq")
    private Long dlvTmpltSeq;

    private String dlvTypCd;    // (자사)배송구분 PD126
    private String wrhsTypCd;   // 창고구분 PD134(삭제)
    private String bizTypCd;    // (자사)매입구분 PD127
    private String pchsTypCd;   // (자사)사입유형 PD128
    private String sttlTypCd;   // (자사)정산구분 PD129
    private String buyAgntYn;

//    @OneToOne(mappedBy = "dlvPrdMapEntity")
//    private DeliveryEntity deliveryEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dlv_tmplt_seq", insertable = false, updatable = false)
    private DeliveryEntity deliveryEntity;


    @OneToOne
    @JoinColumn(name = "prd_no", insertable = false, updatable = false)
    private ProductEntity productEntity;


}
