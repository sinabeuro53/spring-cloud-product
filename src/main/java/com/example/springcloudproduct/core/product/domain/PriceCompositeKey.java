package com.example.springcloudproduct.core.product.domain;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

@Data
public class PriceCompositeKey implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long prdPrcNo;

    private Long prdNo;	//상품번호"

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
