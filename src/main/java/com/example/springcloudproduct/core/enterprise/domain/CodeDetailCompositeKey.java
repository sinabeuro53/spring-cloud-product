package com.example.springcloudproduct.core.enterprise.domain;

import javax.persistence.Column;
import java.io.Serializable;

public class CodeDetailCompositeKey implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "grp_cd")
    private String grpCd;

    @Column(name = "dtls_cd")
    private String dtlsCd;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
