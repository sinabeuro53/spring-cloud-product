package com.example.springcloudproduct.core.product.controller;

import com.example.springcloudproduct.core.product.domain.ProductRequestDTO;
import com.example.springcloudproduct.core.product.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

// @AutoConfigureMockMvc
// https://kingds.tistory.com/80
// AutoconfigureWebMvc는 서버를 시작하지 않고 아래 계층만 테스트.
// 실제 HTTP 요청을 처리하는 것과 똑같은 방식으로 호출되지만 서버시작 비용이 없다.

// @WebMvcTest
// WebMvcTest는 MVC쪽만 따로 테스트 할때 사용
// 테스트 범위를 웹레이어쪽으로 스코프를 지정한다는 의미
//@AutoConfigureMockMvc
//@AutoConfigureWebMvc
//@SpringBootTest
@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void selectProductList() throws Exception {


        //productRepository.findTop10ByPrdNmContaining("테스트");
        ProductRequestDTO productRequestDTO = new ProductRequestDTO();
//        List<ProductResponseDTO> resultList = productRepository.selectProductList(productRequestDTO);

//        System.out.println(resultList);


        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(new ProductRequestDTO());
        mockMvc.perform(
            MockMvcRequestBuilders.post("http://localhost:8150/product/selectProductList")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json)
            ).andExpect(
                    MockMvcResultMatchers.status().isOk()
            )
            .andDo(MockMvcResultHandlers.print());

//        .andExpect(
//                MockMvcResultMatchers.jsonPath("$.result").value(0)
//        ).andExpect(
//                MockMvcResultMatchers.jsonPath("$.response.resultCode").value("OK")    // 뎁스가 있는 결과값
//        )
    }


}