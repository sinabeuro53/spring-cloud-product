package com.example.springcloudproduct.core.product.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 상품등록 목록 요청 도메인
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class ProductRequestDTO  {   // extends BaseParam

    private static final long serialVersionUID = 1L;

    /* 사이트코드 */
    private String siteCd;

    /* 상품판매코드 */
    private String prdSelCd;

    /* 검색일자유형 */
    private String schDtTyp;

    /* 시작일 */
    private String strDt;

    /* 종료일 */
    private String endDt;

    /* 시즌코드 */
    private String attrCd;

    /* 카테고리유형 */
    private String ctgrTyp;

    /* 카테고리depth */
    private Integer ctgrDepth;

    /* 카테고리번호 */
    private Long ctgrNo;

    /* 카테고리번호1 */
    private Long ctgrNo1;

    /* 카테고리번호2 */
    private Long ctgrNo2;

    /* 카테고리번호3 */
    private Long ctgrNo3;

    /* 협력사번호 */
    private Long selAcntNo;

    /* MD번호 */
    private Long mdNo;

    /* 브랜드번호 */
    private Long brandNo;

    /* 상품명유형 */
    private String prdNmTyp;

    /* 상품명 */
    private String prdNm;

    /* 상품상태코드배열 */
    private String[] prdStatCdArray;

    /* 배송구분코드 */
    private String dlvTypCd;

    /* 매입구분코드 */
    private String bizTypCd;

    /* 업체상품코드유형 */
    private String prdCdTyp;

    /* 업체상품코드배열 */
    private String[] prdCdArray;

    /* 앱아이디 */
    private String appId;

    /* 시즌 */
    private String season;

    private String sortCol1;

    private String sortCol2;
    
    private String sortCol3;

    /* 판매상태 코드 배열 */
    private String[] prdSelCdArray;

    /* 전시여부 코드 배열 */
    private String[] dispYnArray;

    /* 시즌 코드 배열 */
    private String[] attrCdArray;

    /* 성별 코드 배열 */
    private String[] gendCdArray;

    /* 협력사 코드 배열 */
    private String[] selAcntNoArray;

    /* MD 코드 배열 */
    private String[] mdNoArray;

    /* 브랜드 코드 배열 */
    private String[] brandNoArray;

    /* 노출채널 코드 배열*/
    private String[] dispChanTypCdArray;

    /* 생산년도 */
    private String prdYr;

    /* 등록자 배열 */
    private String[] createNoArray;

    /* 사이트코드 배열 */
    private String[] siteCdArray;

    /* 상세브랜드번호 */
    private Long prdGroupNo;

    /* 상세브랜드번호 배열 */
    private String[] prdGroupNoArray;

    /* 카테고리번호 배열 */
    private Long[] stdCtgrNoArray;
}
