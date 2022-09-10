package com.example.springcloudproduct.core.product.domain;

import com.example.springcloudproduct.core.common.domain.BaseEntity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;

/**
 * packageName  :   com.example.springcloudproduct.core.product.domain
 * fileName     :   PrdDescEntity
 * author       :   sinabeuro53
 * date         :   2022-03-17
 * description  :
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tpd_prd_desc")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@DynamicInsert
@DynamicUpdate
public class PrdDescEntity extends BaseEntity {

    @Id
    @Column(name = "prd_no", nullable = false)
    private Long prdNo;

    @OneToOne
    @MapsId
    @JoinColumn(name = "prd_no")
    private ProductEntity productEntity;

    private String prdDescTypCd;    // 상품설명유형코드

    private String prdDescContClob; // 상품설명내용

    private String orgnTypCd;   // 원산지유형코드 PD003

    @Transient
    private String orgnTypNm;

    private String orgnCd;  //원산지코드 MB047

    @Transient
    private String orgnNm;

}
