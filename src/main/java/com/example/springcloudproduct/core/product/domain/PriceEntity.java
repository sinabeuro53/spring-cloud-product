package com.example.springcloudproduct.core.product.domain;

import com.example.springcloudproduct.core.common.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
@ToString(callSuper = true)     // 상속 받는 클래스의 프로퍼티를 정상적으로 등록하기 위한 추가 처리
@Table(name = "tpd_prd_prc")
@EqualsAndHashCode(callSuper=false, exclude = {"prdNo"})
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class PriceEntity extends BaseEntity implements Serializable {

    @Id
    @Column(name = "prd_prc_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prdPrcNo;

    @Column(name = "prd_no", updatable = false)     // insertable = false, updatable = false 에서 변경
    private Long prdNo;

    @OneToOne
    @JoinColumn(name = "prd_no", insertable = false, updatable = false) // insertable = false, updatable = false 추가함으로써 prdNo 에 insert 가능
    @ToString.Exclude
    private ProductEntity productEntity;

    private Long normPrc;

    private Long selPrc;

    private Long mrgnRt;

//    public PriceEntity() {}
//
//    public PriceEntity(Long prdPrcNo, Long prdNo) {
//        this.prdPrcNo = prdPrcNo;
//        this.prdNo = prdNo;
//    }

}
