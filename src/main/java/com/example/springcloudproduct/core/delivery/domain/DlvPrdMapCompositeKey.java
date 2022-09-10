package com.example.springcloudproduct.core.delivery.domain;

import javax.persistence.Column;
import java.io.Serializable;

public class DlvPrdMapCompositeKey implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "prd_no")
    private Long prdNo;

    @Column(name = "dlv_tmplt_seq")
    private Long dlvTmpltSeq;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
