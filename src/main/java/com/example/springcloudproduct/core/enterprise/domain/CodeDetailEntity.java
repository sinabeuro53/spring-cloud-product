package com.example.springcloudproduct.core.enterprise.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Table(name = "tsy_co_detail", schema = "enterprise")
@EqualsAndHashCode(of = {"grpCd", "dtlsCd"})
@IdClass(CodeDetailCompositeKey.class)
public class CodeDetailEntity implements Serializable {

    @Id
    @Column(name = "grp_cd")
    private String grpCd;
    @Id
    @Column(name = "dtls_cd")
    private String dtlsCd;

    private String dtlsComNm;
    private String cdVal1;
    private String cdVal2;
    private String cdVal3;
    private int prrtRnk;
    private String useYn;
    private String dtlsCdDesc;

    public CodeDetailEntity(String grpCd, String dtlsCd) {
        this.grpCd = grpCd;
        this.dtlsCd = dtlsCd;
    }

}
