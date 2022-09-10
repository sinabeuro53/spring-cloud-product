package com.example.springcloudproduct.core.option.domain;

import java.io.Serializable;

public class OptionItemCompositeKey implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long prdNo; // 상품번호
    private int optItemNo;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
