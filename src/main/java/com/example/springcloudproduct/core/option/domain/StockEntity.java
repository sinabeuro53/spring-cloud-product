package com.example.springcloudproduct.core.option.domain;

import com.example.springcloudproduct.core.common.domain.BaseEntity;
import com.example.springcloudproduct.core.product.domain.ProductEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)     // 상속 받는 클래스의 프로퍼티를 정상적으로 등록하기 위한 추가 처리
@EqualsAndHashCode(callSuper=false)
@Table(name = "tpd_stock")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class StockEntity extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_no")
    private Long stockNo;       // 재고번호

    @Column(name = "prd_no", updatable = false)
    private Long prdNo;         // 상품번호

    private Long addPrc;        // 옵션가

    private String useYn;       // 사용여부

    private Long selQty;        // 판매수량
            
    private Long realStckQty;   // 실재고

    private Long tempStckQty;   // 임시재고

    private String optValueArf; // 옵션코드 임의

    @Column(name = "sel_acnt_no")
    private Long selAcntNo;     // 판매자 번호

    private String stockOptCd;  // 옵션코드 채번(p코드_0000)

    private String optStockCd;  // 옵션재고코드(사용안함)

    private int optPrrtRnk;     // 옵션 순위

    @ManyToOne
    @JoinColumn(name = "prd_no", insertable = false, updatable = false)
    @ToString.Exclude
    private ProductEntity productEntity;


//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "prd_no", referencedColumnName = "prd_no", insertable = false, updatable = false)
//    @Fetch(value = FetchMode.SUBSELECT)
//    @OrderBy(value = "optItemNo ASC")
//    @ToString.Exclude
//    private List<OptionItemEntity> optionItemEntityList;
    @Transient
    private List<OptionItemEntity> optionItemEntityList;


    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "stock_no", referencedColumnName = "stock_no")
    @Fetch(value = FetchMode.SUBSELECT)
    @OrderBy(value = "optItemNo ASC")
    @ToString.Exclude
    private List<OptionValueEntity> optionValueEntityList;

}
