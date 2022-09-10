package com.example.springcloudproduct.core.product.domain;

import com.example.springcloudproduct.core.common.domain.BaseEntity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * packageName  :   com.example.springcloudproduct.core.product.domain
 * fileName     :   PrdAttrMapEntity
 * author       :   sinabeuro53
 * date         :   2022-03-17
 * description  :
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tpd_prd_attr_map")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true, of = {"prdNo", "attrGrpCd", "attrCd"})
@DynamicInsert
@DynamicUpdate
@IdClass(PrdAttrMapCompositeKey.class)
public class PrdAttrMapEntity extends BaseEntity {

    @Id
    @Column(name = "prd_no", updatable = false)
    private Long prdNo;         // 상품코드

    @Id
    @Column(name = "attr_grp_cd")
    private String attrGrpCd;   // 속성그룹코드 AC001 성별, AC002 시즌

    @Transient
    private String attrGrpNm;   // 속성그룹코드 AC001 성별, AC002 시즌

    @Id
    @Column(name = "attr_cd")
    // AC001 : 01 남성, 02 여성, 03 남녀공용
    // AC002 : 01 봄, 02 여름, 03 가을, 04 겨울, 05 사계절
    private String attrCd;      // 속성코드

    @Transient
    private String attrNm;      // 속성코드

    private String attrTypCd;      // 속성코드 구분코드(안씀 하드 코딩 001)


//    private String attrTypCd;   // 속성구분코드


}
