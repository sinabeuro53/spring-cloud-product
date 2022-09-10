package com.example.springcloudproduct.core.product.domain;

import com.example.springcloudproduct.core.common.domain.BaseEntity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * packageName  :   com.example.backend.core.product.domain
 * fileName     :   PrdImgEntity
 * author       :   sinabeuro53
 * date         :   2022-03-17
 * description  :
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tpd_prd_image")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@DynamicInsert
@DynamicUpdate
public class PrdImgEntity extends BaseEntity {

    @Id
    @Column(name = "prd_no", updatable = false)
    private Long prdNo;

//    private String urlPath;   // 이미지 경로

    private String filePath;   // 실제로 이미지가 저장되는 경로

    private String basicExtNm;

    @Transient
    private String mainMode;


}
