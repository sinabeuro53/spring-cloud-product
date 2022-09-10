package com.example.springcloudproduct.core.product.service;

import com.example.springcloudproduct.core.brand.domain.BrandEntity;
import com.example.springcloudproduct.core.brand.domain.QBrandEntity;
import com.example.springcloudproduct.core.brand.repository.BrandRepository;
import com.example.springcloudproduct.core.category.domain.StdCtgrTreeDTO;
import com.example.springcloudproduct.core.category.repository.StdCtgrRepository;
import com.example.springcloudproduct.core.delivery.domain.DeliveryEntity;
import com.example.springcloudproduct.core.delivery.domain.DlvPrdMapEntity;
import com.example.springcloudproduct.core.delivery.repository.DeliveryRepository;
import com.example.springcloudproduct.core.delivery.repository.DlvPrdMapRepository;
import com.example.springcloudproduct.core.enterprise.domain.*;
import com.example.springcloudproduct.core.enterprise.repository.CodeDetailRepository;
import com.example.springcloudproduct.core.enterprise.repository.SelAcntRepository;
import com.example.springcloudproduct.core.option.domain.OptionItemEntity;
import com.example.springcloudproduct.core.option.domain.OptionValueEntity;
import com.example.springcloudproduct.core.option.domain.StockEntity;
import com.example.springcloudproduct.core.option.repository.OptionItemRepository;
import com.example.springcloudproduct.core.option.repository.OptionValueRepository;
import com.example.springcloudproduct.core.option.repository.StockRepository;
import com.example.springcloudproduct.core.product.domain.*;
import com.example.springcloudproduct.core.product.repository.PrdGroupRepository;
import com.example.springcloudproduct.core.product.repository.PriceRepository;
import com.example.springcloudproduct.core.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class ProductDetailServiceImpl implements ProductDetailService {

    private final ProductRepository productRepository;
    private final SelAcntRepository selAcntRepository;
    private final StdCtgrRepository stdCtgrRepository;
    private final DeliveryRepository deliveryRepository;
    private final DlvPrdMapRepository dlvPrdMapRepository;
    private final BrandRepository brandRepository;
    private final PrdGroupRepository prdGroupRepository;
    private final CodeDetailRepository codeDetailRepository;
    private final PriceRepository priceRepository;

    private final StockRepository stockRepository;  // 재고
    private final OptionItemRepository optionItemRepository;    // 옵션 아이템
    private final OptionValueRepository optionValueRepository;  // 옵션값

    @PersistenceContext
    private EntityManager entityManager;

    // 상품
    QProductEntity qProduct = QProductEntity.productEntity;
    // 가격
    QPriceEntity qPrice = QPriceEntity.priceEntity;
    // 판매업체
    QSelAcntEntity qSelAcnt = QSelAcntEntity.selAcntEntity;
    // 직원 및 업체
    QEmpEntity qEmp = QEmpEntity.empEntity;
    // 브랜드
    QBrandEntity qBrand = QBrandEntity.brandEntity;
    // 공통코드
    QCodeDetailEntity qCodeDetail = QCodeDetailEntity.codeDetailEntity;


    /**
     *
     * @param prdNo
     * @return
     */
    @Override
    public ProductDetailDTO selectProductDetail(Long prdNo) {

        ProductDetailDTO productDetailDTO = new ProductDetailDTO();
        ProductEntity productEntity = null;
        SelAcntEntity selAcntEntity = null;
        BrandEntity brandEntity = null;
        PrdGroupEntity prdGroupEntity = null;
        StdCtgrTreeDTO stdCtgrTreeDTO = null;
        PriceEntity priceEntity = null;
        DeliveryEntity deliveryEntity = null;
        List<StockEntity> stockEntityList = new ArrayList<>();

//        entityManager.close();

        productEntity = productRepository.findByPrdNo(prdNo);
        productDetailDTO.setProductEntity(productEntity);

        selAcntEntity = productEntity.getSelAcntEntity();
        productDetailDTO.setSelAcntEntity(selAcntEntity);

        brandEntity = brandRepository.findByBrandNo(productEntity.getBrandNo());
        productDetailDTO.setBrandEntity(brandEntity);

        prdGroupEntity = prdGroupRepository.selectPrdGroupInfo(productEntity.getPrdGroupNo());
        productDetailDTO.setPrdGroupEntity(prdGroupEntity);

        stdCtgrTreeDTO = stdCtgrRepository.selectStdCtgrListTreeFromC(productEntity.getStdCtgrNo());
        productDetailDTO.setStdCtgrTreeDTO(stdCtgrTreeDTO);

        priceEntity = productEntity.getPriceEntity();
        productDetailDTO.setPriceEntity(priceEntity);

        DlvPrdMapEntity dlvPrdMapEntity = dlvPrdMapRepository.findByPrdNo(prdNo);
        deliveryEntity = deliveryRepository.findByDlvTmpltSeq(dlvPrdMapEntity.getDlvTmpltSeq());
        CodeDetailEntity codeDetailEntity1 = codeDetailRepository.findByGrpCdAndDtlsCd("PD117", deliveryEntity.getDlvCmpnyCd());
        deliveryEntity.setDlvCmpnyNm(codeDetailEntity1.getDtlsComNm());
        CodeDetailEntity codeDetailEntity2 = codeDetailRepository.findByGrpCdAndDtlsCd("PD117", deliveryEntity.getRtrnCmpnyCd());
        deliveryEntity.setRtrnCmpnyNm(codeDetailEntity2.getDtlsComNm());
        productDetailDTO.setDeliveryEntity(deliveryEntity);

        stockEntityList = productEntity.getStockEntityList();
        List<OptionItemEntity> optionItem = optionItemRepository.findByPrdNo(productEntity.getPrdNo());
        stockEntityList.forEach(stockEntity -> {
            stockEntity.setOptionItemEntityList(optionItem);
        });
        productDetailDTO.setStockEntityList(stockEntityList);

        return productDetailDTO;
    }


    // 주석설정
    // https://creampuffy.tistory.com/81
    @Override
    @Transactional
    public ProductEntity saveProductDetailPolicy(ProductDetailDTO productDetailDTO) {
        ProductEntity productEntity = productDetailDTO.getProductEntity();
        SelAcntEntity selAcntEntity = productDetailDTO.getSelAcntEntity();
        BrandEntity brandEntity = productDetailDTO.getBrandEntity();
        PrdGroupEntity prdGroupEntity = productDetailDTO.getPrdGroupEntity();
        StdCtgrTreeDTO stdCtgrTreeDTO = productDetailDTO.getStdCtgrTreeDTO();

        PriceEntity priceEntity = productDetailDTO.getPriceEntity();
        DeliveryEntity deliveryEntity = productDetailDTO.getDeliveryEntity();
        List<StockEntity> stockEntityList = productDetailDTO.getStockEntityList();

        Long prdNo = 0L;
        Long selAcntNo = selAcntEntity.getSelAcntNo();
        Long prdGroupNo = prdGroupEntity.getPrdGroupNo();
        boolean isReg = true;

        if(productEntity != null && Objects.nonNull(productEntity.getPrdNo())) {
            isReg = false;
            prdNo = productEntity.getPrdNo();
            productEntity.setStdCtgrNo(stdCtgrTreeDTO.getStdCtgrNo3());
            productEntity.setUpdateNo(1001L);
            productRepository.save(productEntity);

            priceRepository.save(priceEntity);

            DlvPrdMapEntity dlvPrdMap = dlvPrdMapRepository.findByPrdNo(prdNo);
            dlvPrdMap.setDlvTmpltSeq(deliveryEntity.getDlvTmpltSeq());
            dlvPrdMap.setDlvTypCd(prdGroupEntity.getDlvTypCd());
            dlvPrdMap.setBizTypCd(prdGroupEntity.getBizTypCd());
            dlvPrdMap.setPchsTypCd(prdGroupEntity.getPchsTypCd());
            dlvPrdMap.setSttlTypCd(prdGroupEntity.getSttlTypCd());
            dlvPrdMap.setUpdateNo(1001L);
            dlvPrdMapRepository.save(dlvPrdMap);

        } else {    // 등록
            SelAcntEntity selAcnt = selAcntRepository.findBySelAcntNo(selAcntEntity.getSelAcntNo());
            productEntity.setSelAcntEntity(selAcnt);
            productEntity.setBrandNo(brandEntity.getBrandNo());
            productEntity.setStdCtgrNo(stdCtgrTreeDTO.getStdCtgrNo3());
            productEntity.setPrdTypCd("01");
//            productEntity.setRefundYn("Y");
            productEntity.setUseYn("Y");
            productEntity.setSelYr("2022");
            productEntity.setDispYn("Y");
            productEntity.setMdNo(prdGroupEntity.getDefaultMdNo());
            productEntity.setCertiTypCd("01");
            productEntity.setPcode("");
            productEntity.setPrdRegCd("06");
            productEntity.setPrdStatCd("02");   // 컨텐츠 미등록
            productEntity.setPrdSelCd("01");    // 상품등록 중
            productEntity.setPrdGroupNo(prdGroupEntity.getPrdGroupNo());

            productEntity.setCreateNo(selAcnt.getEmpNo());
            productEntity.setCodeCrDt(LocalDateTime.now());
            productEntity.setCodeCrNo(selAcnt.getEmpNo());
            productEntity.setPlcyCrDt(LocalDateTime.now());
            productEntity.setPlcyCrNo(selAcnt.getEmpNo());

            productRepository.saveAndFlush(productEntity);
            prdNo = productEntity.getPrdNo();


            /****** 가격등록 ******/
            priceEntity.setPrdNo(prdNo);
//            priceEntity.setProductEntity(productEntity);
            priceEntity.setMrgnRt(selAcntEntity.getMrgnRt());
            priceEntity.setCreateNo(1001L);
//            priceEntity.setCreateDt(LocalDateTime.now());
            priceRepository.save(priceEntity);


            /****** 상품 배송 매핑 등록 ******/
            // 상품그룹 재조회
            prdGroupEntity = prdGroupRepository.findByPrdGroupNo(prdGroupNo);
            DlvPrdMapEntity dlvPrdMap = new DlvPrdMapEntity();
            dlvPrdMap.setPrdNo(productEntity.getPrdNo());
            dlvPrdMap.setDlvTypCd(prdGroupEntity.getDlvTypCd());
            dlvPrdMap.setBizTypCd(prdGroupEntity.getBizTypCd());
            dlvPrdMap.setPchsTypCd(prdGroupEntity.getPchsTypCd());
            dlvPrdMap.setSttlTypCd(prdGroupEntity.getSttlTypCd());
            dlvPrdMap.setDlvTmpltSeq(deliveryEntity.getDlvTmpltSeq());
            dlvPrdMap.setBuyAgntYn("N");
            dlvPrdMap.setCreateNo(1001L);
            dlvPrdMapRepository.save(dlvPrdMap);

        }

        // 옵션 수정 및 등록
        // step1. 옵션 아이템 등록
        // step2. 옵션재고 등록
        // step3. 옵션값 등록
        if(stockEntityList != null && stockEntityList.size() > 0) {
            List<OptionItemEntity> optionItemEntityList = stockEntityList.get(0).getOptionItemEntityList();
            boolean isDubleOption = optionItemEntityList.size() > 1;

            OptionItemEntity optionItemEntity1 = new OptionItemEntity();
            OptionItemEntity optionItemEntity2 = new OptionItemEntity();

            if(isReg) { // 옵션아이템 등록
                optionItemEntity1.setPrdNo(prdNo);
                optionItemEntity1.setOptItemNo(optionItemEntityList.get(0).getOptItemNo());
                optionItemEntity1.setOptItemNm(optionItemEntityList.get(0).getOptItemNm());
                optionItemEntity1.setOptPrrtRnk(1);
                optionItemEntity1.setCreateNo(1001L);
                optionItemRepository.save(optionItemEntity1);
                if(isDubleOption) {

                    optionItemEntity2.setPrdNo(prdNo);
                    optionItemEntity2.setOptItemNo(optionItemEntityList.get(1).getOptItemNo());
                    optionItemEntity2.setOptItemNm(optionItemEntityList.get(1).getOptItemNm());
                    optionItemEntity2.setOptPrrtRnk(2);
                    optionItemEntity2.setCreateNo(1001L);
                    optionItemRepository.save(optionItemEntity2);
                }
            }

            Long finalPrdNo = prdNo;
            AtomicInteger index = new AtomicInteger(0);
            stockEntityList.forEach(stock -> {
                // 재고등록, 옵션값 등록
                if(stock.getStockNo() == null || stock.getStockNo() == 0L) {
                    StockEntity stockEntity = new StockEntity();

                    stockEntity.setPrdNo(finalPrdNo);
                    stockEntity.setAddPrc(stock.getAddPrc());
                    stockEntity.setUseYn(stock.getUseYn());
                    stockEntity.setSelQty(0L);
                    stockEntity.setRealStckQty(stock.getRealStckQty());
                    stockEntity.setTempStckQty(stock.getRealStckQty());
//                        stockEntity.setOptStockCd(String.valueOf(stock.getStockNo()));
                    stockEntity.setOptPrrtRnk(index.getAndIncrement());
                    stockEntity.setOptValueArf(stock.getOptValueArf());
                    Formatter f = new Formatter();
                    String str = f.format("%04d",stockEntity.getOptPrrtRnk()).toString();
                    stockEntity.setStockOptCd("P"+String.valueOf(finalPrdNo)+"_"+str);

                    stockEntity.setSelAcntNo(selAcntNo);
                    stockEntity.setCreateNo(1001L);
                    stockRepository.save(stockEntity);
                    Long stockNo = stockEntity.getStockNo();

                    OptionValueEntity optionValue1 = new OptionValueEntity();
                    optionValue1.setPrdNo(finalPrdNo);
                    optionValue1.setStockNo(stockNo);
                    optionValue1.setOptItemNo(1);
                    optionValue1.setOptValueNm(stock.getOptionValueEntityList().get(0).getOptValueNm());
                    optionValue1.setCreateNo(1001L);
                    optionValueRepository.save(optionValue1);

                    if(stock.getOptionValueEntityList().size() > 1) {
                        OptionValueEntity optionValue2 = new OptionValueEntity();
                        optionValue2.setPrdNo(finalPrdNo);
                        optionValue2.setStockNo(stockNo);
                        optionValue2.setOptItemNo(2);
                        optionValue2.setOptValueNm(stock.getOptionValueEntityList().get(1).getOptValueNm());
                        optionValue2.setCreateNo(1001L);
                        optionValueRepository.save(optionValue2);
                    }

                } else {        // 업데이트
                    // 아직 기능 없음. 추가할 예정임
//                    StockEntity stockEntity = stock;
//                    stockEntity.setUpdateNo(1001L);
//                    stockRepository.save(stockEntity);
                }
            });
        }

        return productEntity;
    }

}
