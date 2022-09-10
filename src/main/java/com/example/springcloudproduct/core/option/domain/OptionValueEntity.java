package com.example.springcloudproduct.core.option.domain;

import com.example.springcloudproduct.core.common.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@Table(name = "tpd_opt_value")
@EqualsAndHashCode(callSuper=false, of = {"prdNo", "stockNo", "optItemNo"})
@IdClass(OptionValueCompositeKey.class)
public class OptionValueEntity extends BaseEntity {

    // 옵션값 테이블에 옵션값이 저장됨.
    // 복합키 사용
    @Id
    @Column(name = "prd_no", updatable = false)
    private Long prdNo;	//상품번호"
    @Id
    @Column(name = "stock_no", updatable = false)
    private Long stockNo;	//상품-옵션항목별 sequence"
    @Id
    @Column(name = "opt_item_no", updatable = false, nullable = false)
    private int optItemNo;	//옵션아이템번호"

    private String optValueNm;	//옵션값명"

}
