package com.example.springcloudproduct.core.category.service;

import com.example.springcloudproduct.core.category.domain.StdCtgrRecursiveDTO;
import com.example.springcloudproduct.core.category.repository.StdCtgrRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StdCtgrServiceImplTest {

    @Autowired
    private StdCtgrRepository stdCtgrRepository;

    @Autowired
    private StdCtgrServiceImpl stdCtgrService;

    @Test
    void selectStdCtgrListRecursiveTest() {
        System.out.println(stdCtgrRepository.selectStdCtgrListRecursive(101L, 3));
    }

    @Test
    void findByStdCtgrNoRecursiveTest2() {
        System.out.println(stdCtgrService.selectStdCtgrListRecursive2(101L, 3));
    }

    @Test
    void selectStdCtgrListRecursiveByNativeTest() {
        List<Map<String, Object>> result = stdCtgrRepository.selectStdCtgrListByRecursiveNative(101L, 3);
        ObjectMapper mapper = new ObjectMapper();
        // map to dto
        // https://www.tabnine.com/code/java/methods/com.fasterxml.jackson.databind.ObjectMapper/getTypeFactory
        List<StdCtgrRecursiveDTO> result3 = mapper.convertValue(result, mapper.getTypeFactory().constructCollectionType(List.class, StdCtgrRecursiveDTO.class));
        System.out.println(result3);

//        result.forEach(map -> {
//            ObjectMapper mapper = new ObjectMapper();
//            StdCtgrRecursiveDTO result2 = mapper.convertValue(map,StdCtgrRecursiveDTO.class);
//            System.out.println(result2);
//        });
    }


    @Test
    void selectStdCtgrListAllTest() {
        System.out.println(stdCtgrService.selectStdCtgrListAll("1"));
    }

    @Test
    void findByStdCtgrNoInTest() {
//        System.out.println(stdCtgrRepository.findByStdCtgrNoAndUseYn(101L, "Y"));
        System.out.println(stdCtgrRepository.findByHgrnkCtgrNoAndSiteCdAndUseYnOrderByStdCtgrNoAsc(0L,"1", "Y"));
    }
    @Test
    void selectStdCtgrListTreeFromC() {
        stdCtgrRepository.selectStdCtgrListTreeFromC(101013003L);
    }

}