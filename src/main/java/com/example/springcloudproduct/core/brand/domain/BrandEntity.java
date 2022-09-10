package com.example.springcloudproduct.core.brand.domain;

import com.example.springcloudproduct.core.common.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@Table(name = "tpd_brand_lwrnk")
public class BrandEntity extends BaseEntity {

    @Id @Column(name = "brand_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brandNo;

    private String brandCd;

    private String siteCd;

    private String mainNmKr;

    private String mainNmEn;

    private String hgrnkBrandCd;

}
