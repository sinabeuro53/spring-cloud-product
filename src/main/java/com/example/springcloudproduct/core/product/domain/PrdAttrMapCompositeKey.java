package com.example.springcloudproduct.core.product.domain;

import java.io.Serializable;

/**
 * packageName  :   com.example.springcloudproduct.core.product.domain
 * fileName     :   PrdAttrMapCompositeKey
 * author       :   sinabeuro53
 * date         :   2022-03-20
 * description  :
 */
public class PrdAttrMapCompositeKey implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long prdNo; // 상품번호
    private String attrGrpCd;
    private String attrCd;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}
