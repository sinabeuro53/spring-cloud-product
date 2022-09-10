package com.example.springcloudproduct.core.option.domain;

import javax.persistence.Column;
import java.io.Serializable;

public class OptionValueCompositeKey implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "prd_no")
    private Long prdNo;	//상품번호"
    @Column(name = "stock_no")
    private Long stockNo;	//상품-옵션항목별 sequence"
    @Column(name = "opt_item_no")
    private int optItemNo;	//옵션아이템번호"

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
