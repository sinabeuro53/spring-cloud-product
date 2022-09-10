package com.example.springcloudproduct.core.option.domain;

import com.example.springcloudproduct.core.common.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
//@EqualsAndHashCode(of = {"prdNo", "optItemNo"})
@EqualsAndHashCode(callSuper=false)
@Table(name = "tpd_opt_item")
//@IdClass(OptionItemCompositeKey.class)
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class OptionItemEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id @Column(name = "opt_item_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long optItemSeq;
    // 옵션 아이템 테이블에 옵션명이 저장됨.

    @Column(name = "prd_no", updatable = false)
    private Long prdNo;	//상품번호"

    @Column(name = "opt_item_no", updatable = false)
    private int optItemNo;	//상품-옵션항목별 sequence"

    private String optItemNm;	//옵션항목명"

    private int optPrrtRnk;	//옵션우선순위"

//    @ManyToOne
//    @JoinColumn(name = "prd_no", referencedColumnName = "prd_no", insertable = false, updatable = false)
//    @ToString.Exclude
//    private StockEntity stockEntity;


//    @ManyToOne
//    @JoinColumn(name = "prd_no", referencedColumnName = "prd_no")
//    @ToString.Exclude
//    private StockEntity stockEntity;

}
