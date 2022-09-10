package com.example.springcloudproduct.core.statistic.domain;

import com.example.springcloudproduct.core.common.domain.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * packageName  :   com.example.springcloudproduct.core.statistic.domain
 * fileName     :   PrdStatisticEntity
 * author       :   sinabeuro53
 * date         :   2022-03-22
 * description  :
 */
@Entity
@Getter
@Setter
@Table(name = "tpd_prd_statistic", schema = "statistic")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class PrdStatisticEntity extends BaseEntity {

    @Id @Column(name = "statistic_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long statisticNo;

    private Long selAcntNo;

    private Long totalCnt;

    @Column(name = "sel_cd_01_cnt")
    private Long selCd01Cnt;
    @Column(name = "sel_cd_02_cnt")
    private Long selCd02Cnt;
    @Column(name = "sel_cd_03_cnt")
    private Long selCd03Cnt;
    @Column(name = "sel_cd_04_cnt")
    private Long selCd04Cnt;
    @Column(name = "sel_cd_05_cnt")
    private Long selCd05Cnt;

    private String siteCd;

    @Transient
    private Long prdRegedCnt;   // 등록된 상품수

    @Transient
    private Long prdOnRegCnt;   // 미등록 상품수
}
