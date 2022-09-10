package com.example.springcloudproduct.core.enterprise.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@Table(name = "tsy_emp", schema = "enterprise")
@EqualsAndHashCode
public class EmpEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empNo;

    private String empId;

    private String empNm;

    private String clssClf; // 직책구분(공통코드:SY014)

    private String deptCd;  // 부서코드

    private String empClf;  // 사원구분(공통코드:SY015)

}
