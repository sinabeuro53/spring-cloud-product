package com.example.springcloudproduct.core.product.service;

import com.example.springcloudproduct.core.common.domain.UploadFile;
import com.example.springcloudproduct.core.common.utils.FileUploadUtils;
import com.example.springcloudproduct.core.product.domain.*;
import com.example.springcloudproduct.core.product.repository.*;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * packageName  :   com.example.backend.core.product.service
 * fileName     :   PrdContentsServiceImpl
 * author       :   sinabeuro53
 * date         :   2022-03-17
 * description  :
 */
@Service
@RequiredArgsConstructor
public class PrdContentsServiceImpl implements PrdContentsService {

    private final ProductRepository productRepository;
    private final ProductSimpleRepository productSimpleRepository;
    private final PrdAttrMapRepository prdAttrMapRepository;
    private final PrdDescRepository prdDescRepository;
    private final PrdImgRepository prdImgRepository;
    private final FileUploadUtils fileUploadUtils;

    @Value("${upload.web.url}")
    private String webUrl;

    @Value("${upload.dirs.images}")
    private String images;

    @Override
    public ProductDetailDTO getPrdContentsInfo(Long prdNo) {
        ProductDetailDTO productDetailDTO = new ProductDetailDTO();
        ModelMapper modelMapper = new ModelMapper();
//        ProductEntity productEntity = new ProductEntity();
        ProductSimpleEntity productSimpleEntity = productSimpleRepository.findByPrdNo(prdNo);

        ProductEntity productEntity = modelMapper.map(productSimpleEntity, ProductEntity.class);
        productDetailDTO.setProductEntity(productEntity);

        PrdImgEntity prdImgEntity = prdImgRepository.findByPrdNo(prdNo);
        if(prdImgEntity == null) {
            prdImgEntity = new PrdImgEntity();
        } else {
            prdImgEntity.setMainMode("C");
        }
        productDetailDTO.setPrdImgEntity(prdImgEntity);

        PrdDescEntity prdDescEntity = prdDescRepository.getPrdDescInfo(prdNo);
        if(prdDescEntity == null) {
            prdDescEntity = new PrdDescEntity();
        }
        productDetailDTO.setPrdDescEntity(prdDescEntity);


        List<PrdAttrMapEntity> prdAttrList = prdAttrMapRepository.getPrdAttrList(prdNo);
        if(prdAttrList == null) {
            prdAttrList = new ArrayList<>();
        }
        List<PrdAttrMapEntity> genderList = prdAttrList.stream().filter(item -> item.getAttrGrpCd().equals("AC001")).collect(Collectors.toList());
        List<PrdAttrMapEntity> seasonList = prdAttrList.stream().filter(item -> item.getAttrGrpCd().equals("AC002")).collect(Collectors.toList());
        productDetailDTO.setGenderList(genderList);
        productDetailDTO.setSeasonList(seasonList);

        // 선택된 성별/시즌 데이터 넣기
        List<String> selectedGenderList = genderList.stream().map(item -> item.getAttrCd()).collect(Collectors.toList());
        List<String> selectedSeasonList = seasonList.stream().map(item -> item.getAttrCd()).collect(Collectors.toList());
        productDetailDTO.setSelectedGenderList(selectedGenderList);
        productDetailDTO.setSelectedSeasonList(selectedSeasonList);

        return productDetailDTO;
    }

    @Override
    @Transactional
    public ProductEntity savePrdDetailContents(ProductDetailDTO productDetailDTO, PrdImgMultipartFileDTO prdImgMultipartFileDTO) throws Exception {
        Long prdNo = productDetailDTO.getProductEntity().getPrdNo();
        ProductEntity productEntity = productRepository.findByPrdNo(prdNo);
        boolean isReg = true;

        if(Objects.isNull(productEntity.getCntsCrDt())) {
            productEntity.setCntsCrDt(LocalDateTime.now());
            productEntity.setCntsCrNo(1001L);
            productEntity.setCreateNo(1001L);
            productEntity.setPrdStatCd("05");       // 승인완료
            productEntity.setPrdSelCd("02");        // 판매중
        } else {
            isReg = false;
        }

        if(Objects.isNull(productEntity.getAprvReqDt())) {
            productEntity.setAprvReqDt(LocalDateTime.now());
            productEntity.setAprvReqNo(1001L);
        }

        if(Objects.isNull(productEntity.getAprvCpltDt())) {
            productEntity.setAprvCpltDt(LocalDateTime.now());
            productEntity.setAprvCpltNo(1001L);
        }
        productEntity.setUpdateDt(LocalDateTime.now());
        productEntity.setUpdateNo(1001L);
        productRepository.save(productEntity);




        /******** 상품 이미지 등록 ********/
        PrdImgEntity prdImgEntity = new PrdImgEntity();
        if(isReg) {
            prdImgEntity.setCreateNo(1001L);
        } else {
            prdImgEntity = productDetailDTO.getPrdImgEntity();
            prdImgEntity.setUpdateNo(1001L);
        }

        if(Objects.isNull(webUrl) || StringUtils.isBlank(webUrl)) {     // todo: 클라우드를 사용하면 저장경로를 바꿔야함
            webUrl = System.getProperty("user.dir");
        }
        // 이미지 업로드 분기 1. 단순 삭제, 2. 삭제 후 재업로드, 3. 단순 업로드
        // 1. 단순 삭제
        if(prdImgEntity.getMainMode() != null && prdImgEntity.getMainMode().equals("D")) {
            if(StringUtils.isNotBlank(prdImgEntity.getBasicExtNm()) && StringUtils.isNotBlank(prdImgEntity.getFilePath())) {
                fileUploadUtils.deleteLocalFile(prdImgEntity.getBasicExtNm(), webUrl + prdImgEntity.getBasicExtNm());
                prdImgEntity.setPrdNo(prdNo);
                prdImgEntity.setBasicExtNm(null);
                prdImgEntity.setFilePath(null);
                prdImgRepository.save(prdImgEntity);
            }
        } else {
            if(prdImgMultipartFileDTO.getFileMainImg() != null) {
                // 2. 삭제 후 재업로드
                if(StringUtils.isNotBlank(prdImgEntity.getBasicExtNm()) && StringUtils.isNotBlank(prdImgEntity.getFilePath())) {
                    fileUploadUtils.deleteLocalFile(prdImgEntity.getBasicExtNm(), webUrl + prdImgEntity.getBasicExtNm());
                    prdImgEntity.setPrdNo(prdNo);
                    prdImgEntity.setBasicExtNm(null);
                    prdImgEntity.setFilePath(null);
                }

                // 3. 단순 업로드
                MultipartFile multipartFile  = prdImgMultipartFileDTO.getFileMainImg();
                try {
                    UploadFile uploadFileResult = fileUploadUtils.store(multipartFile, null, null, images);
                    prdImgEntity.setPrdNo(prdNo);
                    prdImgEntity.setBasicExtNm(uploadFileResult.getFileUrl());
                    prdImgEntity.setFilePath(uploadFileResult.getFullPath());
                } catch (IOException e) {
                    throw new Exception(e);
                }

                prdImgRepository.save(prdImgEntity);
            }
        }




        /******** 상품 상세, 원산지 등록 ********/
        PrdDescEntity prdDescEntity = productDetailDTO.getPrdDescEntity();
//        prdDescEntity.setPrdNo(prdNo);
        prdDescEntity.setProductEntity(productEntity);
        if(isReg) {
            prdDescEntity.setCreateNo(1001L);
        } else {
            prdDescEntity.setUpdateNo(1001L);
        }
        prdDescRepository.save(prdDescEntity);


        /******** 상품 속성 등록 ********/
        // 상품속성 - 성별
        List<PrdAttrMapEntity> genderList = new ArrayList<>();
        // 상품속성 - 시즌
        List<PrdAttrMapEntity> seasonList = new ArrayList<>();

        prdAttrMapRepository.deleteByPrdNo(prdNo);

        List<String> selectedGenderList = productDetailDTO.getSelectedGenderList();
        selectedGenderList.forEach(item -> {
            PrdAttrMapEntity prdAttrMapEntity = new PrdAttrMapEntity();
            prdAttrMapEntity.setPrdNo(prdNo);
            prdAttrMapEntity.setAttrGrpCd("AC001");
            prdAttrMapEntity.setAttrCd(item);
            prdAttrMapEntity.setAttrTypCd("001");
            prdAttrMapEntity.setCreateNo(1001L);
            prdAttrMapEntity.setCreateDt(LocalDateTime.now());
            prdAttrMapEntity.setUpdateNo(1001L);
            prdAttrMapEntity.setUpdateDt(LocalDateTime.now());
            prdAttrMapRepository.save(prdAttrMapEntity);
        });

        List<String> selectedSeasonList = productDetailDTO.getSelectedSeasonList();
        selectedSeasonList.forEach(item -> {
            PrdAttrMapEntity prdAttrMapEntity = new PrdAttrMapEntity();
            prdAttrMapEntity.setPrdNo(prdNo);
            prdAttrMapEntity.setAttrGrpCd("AC002");
            prdAttrMapEntity.setAttrCd(item);
            prdAttrMapEntity.setAttrTypCd("001");
            prdAttrMapEntity.setCreateNo(1001L);
            prdAttrMapEntity.setCreateDt(LocalDateTime.now());
            prdAttrMapEntity.setUpdateNo(1001L);
            prdAttrMapEntity.setUpdateDt(LocalDateTime.now());
//            seasonList.add(prdAttrMapEntity);
            prdAttrMapRepository.save(prdAttrMapEntity);
        });

        return productEntity;
    }
}
