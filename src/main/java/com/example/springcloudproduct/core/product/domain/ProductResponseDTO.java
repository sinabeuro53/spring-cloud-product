package com.example.springcloudproduct.core.product.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {

    private Long prdNo;

    private String prdNm;

    private String prdCd;

    private String prdStatCd;   // 상품상태

    private String prdStatNm;

    private String prdSelCd;    // 판매상태

    private String prdSelNm;

    private String refundYn;    // 환불여부

    private String vtaxTypCd;   // 과세구분

    private Long selAcntNo;

    private String selAcntNm;

    private Long brandNo;

    private String brandNm;

    private Long normPrc;   // 정상가

    private Long selPrc;    // 판매가

    private Long mrgnRt;    // 마진율


    private Long empNo;

    private String empNm;

    private String createNm;


    /************* 전시 카테고리 *************/
    private Long dispCtgrNo;

    private Long hgrnkCtgrNo;

    private String dispCtgrNm;

    private String dispCtgrTypCd;

    private Long dispPrrtRnk;

    /************* 표준 카테고리 *************/
    private Long stdCtgrNo1;
    private Long stdCtgrNo2;
    private Long stdCtgrNo3;
    private String stdCtgrNm1;
    private String stdCtgrNm2;
    private String stdCtgrNm3;
    private String stdCtgrPath;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createDt;

    private Long createNo;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime updateDt;

    private Long updateNo;

}
