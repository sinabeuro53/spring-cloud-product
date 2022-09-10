package com.example.springcloudproduct.core.product.domain;

import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/****** 해당 클래스 사용하지 않음 *******/
@Embeddable
@EqualsAndHashCode
public class PrdNoEmbed implements Serializable {

    @Column(name = "prd_no")
    private Long prdNo;

    @Column(name = "prd_prc_no")
    private Long prdPrcNo;

}
