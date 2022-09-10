package com.example.springcloudproduct.core.product.domain;

import com.example.springcloudproduct.core.brand.domain.BrandEntity;
import com.example.springcloudproduct.core.category.domain.StdCtgrTreeDTO;
import com.example.springcloudproduct.core.delivery.domain.DeliveryEntity;
import com.example.springcloudproduct.core.enterprise.domain.SelAcntEntity;
import com.example.springcloudproduct.core.option.domain.StockEntity;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailDTO {

    private ProductEntity productEntity;

    // 협력사(판매업체) 정보
    private SelAcntEntity selAcntEntity;

    // 브랜드 정보
    private BrandEntity brandEntity;

    // 상품그룹 정보
    private PrdGroupEntity prdGroupEntity;

    // 표준 카테고리 정보
    private StdCtgrTreeDTO stdCtgrTreeDTO;

    // 가격정보
    private PriceEntity priceEntity;

    // 배송정보
    private DeliveryEntity deliveryEntity;

    // 옵션정보
    private List<StockEntity> stockEntityList;

    // 상품이미지
    private PrdImgEntity prdImgEntity;

    // 상품상세
    private PrdDescEntity prdDescEntity;

    // 상품속성 - 성별
    private List<PrdAttrMapEntity> genderList;

    // 상품속성 - 시즌
    private List<PrdAttrMapEntity> seasonList;

    private List<String> selectedGenderList;

    private List<String> selectedSeasonList;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createDt;

    private Long createNo;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime updateDt;

    private Long updateNo;

}
