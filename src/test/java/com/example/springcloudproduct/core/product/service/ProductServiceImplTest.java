package com.example.springcloudproduct.core.product.service;

import com.example.springcloudproduct.core.product.domain.ProductEntity;
import com.example.springcloudproduct.core.product.domain.ProductRequestDTO;
import com.example.springcloudproduct.core.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class ProductServiceImplTest {
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductServiceImpl productServiceImpl;
    
    @Test
    public void productRepository() {
        productRepository.findTop10ByPrdNmContaining("연길_지사 테스트 GR013 구매금지 product20211211024310 02 @");
    }
    @Test
    public void findByPrdNo() {

        System.out.println(productRepository.findByPrdNo(316996735L));

    }

    @Test
    public void findAllByPrdNo() {

        List<Long> paramList = new ArrayList<>();
        paramList.add(316996735L);
        paramList.add(316996733L);
        paramList.add(316996732L);
        paramList.add(316996730L);
        paramList.add(316996725L);


        Set<Long> paramList2 = new HashSet<>();
        paramList2.add(315226057L);
        paramList2.add(315226013L);
        paramList2.add(315025001L);

        List<ProductEntity> result = productRepository.findByPrdNoIn(paramList);

        result.forEach(System.out::println);
    }

    @Test
    public void productServiceTest() {
        ProductRequestDTO productRequestDTO = new ProductRequestDTO();
//        productRequestDTO.setPrdNm("데일리스트");
        productRequestDTO.setPrdCdTyp("01");
        productRequestDTO.setPrdCdArray(new String[]{"316996735", "316996733", "316996732"});
        productServiceImpl.selectProductList(productRequestDTO);
    }




}