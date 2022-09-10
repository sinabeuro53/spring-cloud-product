package com.example.springcloudproduct.core.product.controller;

import com.example.springcloudproduct.core.common.domain.ResponseData;
import com.example.springcloudproduct.core.common.utils.JsonUtils;
import com.example.springcloudproduct.core.product.domain.*;
import com.example.springcloudproduct.core.product.repository.ProductRepository;
import com.example.springcloudproduct.core.product.service.PrdContentsService;
import com.example.springcloudproduct.core.product.service.ProductDetailService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

//    private final ProductServiceImpl productService;
    private final ProductRepository productRepository;
    private final ProductDetailService productDetailService;
    private final PrdContentsService prdContentsService;


    @PostMapping("/selectProductList")
    public ResponseEntity selectProductList(@RequestBody ProductRequestDTO parameters) {
        List<ProductResponseDTO> result = productRepository.selectProductList(parameters);
        return ResponseData.builder().body(result).build();
    }

    @GetMapping("/selectProductDetail/{prdNo}")
    public ResponseEntity selectProductDetail(@PathVariable("prdNo") Long prdNo) {
        ProductDetailDTO productDetailDTO = productDetailService.selectProductDetail(prdNo);
        return ResponseData.builder().body(productDetailDTO).build();
    }

    @PostMapping("/savePrdDetailPolicy")
    public ResponseEntity savePrdDetailPolicy(
            @RequestBody ProductDetailDTO productDetailDTO
    ) {
        ProductEntity result = productDetailService.saveProductDetailPolicy(productDetailDTO);
        return ResponseData.builder().body(result).build();
    }

    @GetMapping("/getPrdContentsInfo/{prdNo}")
    public ResponseEntity getPrdContentsInfo(@PathVariable("prdNo") Long prdNo) {
        ProductDetailDTO productDetailDTO = prdContentsService.getPrdContentsInfo(prdNo);
        return ResponseData.builder().body(productDetailDTO).build();
    }

    @PostMapping("/savePrdDetailContents")
    public ResponseEntity savePrdDetailContents(
            @RequestParam(value="metaData", required=true) String metaData,
            @RequestPart(value="fileMainImg", required=false) MultipartFile fileMainImg
    ) throws Exception {

        // 메타 파라미터 - JSON 파싱
        ProductDetailDTO metaParam = JsonUtils.fromJson(metaData, ProductDetailDTO.class);
 
        // multipartFile 이미지 저장
        PrdImgMultipartFileDTO prdImgMultipartFileDTO = new PrdImgMultipartFileDTO();
        prdImgMultipartFileDTO.setFileMainImg(fileMainImg);

        ProductEntity result = prdContentsService.savePrdDetailContents(metaParam, prdImgMultipartFileDTO);
        
        return ResponseData.builder().body(result).build();
    }
}
