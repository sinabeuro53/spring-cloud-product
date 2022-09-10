package com.example.springcloudproduct.core.product.service;

import com.example.springcloudproduct.core.enterprise.repository.CodeDetailRepository;
import com.example.springcloudproduct.core.product.domain.PrdAttrMapEntity;
import com.example.springcloudproduct.core.product.repository.PrdAttrMapRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName  :   com.example.springcloudproduct.core.product.service
 * fileName     :   PrdAttrServiceImplTest
 * author       :   sinabeuro53
 * date         :   2022-03-17
 * description  :
 */
@SpringBootTest
class PrdAttrServiceImplTest {

    @Autowired
    private CodeDetailRepository codeDetailRepository;

    @Autowired
    private PrdAttrMapRepository prdAttrMapRepository;

    @Test
    void getGenderList() {
    }

    @Test
    void getSeasonList() {
    }

    @Test
    void getPrdAttrList() {
        List<PrdAttrMapEntity> prdAttrList = prdAttrMapRepository.getPrdAttrList(314837688L);
        System.out.println(prdAttrList);

//        prdNo=314837688, attrGrpCd=AC001, attrGrpNm=성별, attrCd=01, attrNm=남성
        Map<String, Long> result = prdAttrList.stream().filter(a -> a.getAttrGrpCd().equals("AC002")).collect(groupingBy(PrdAttrMapEntity::getAttrCd, Collectors.counting()));
        System.out.println(result);

//        .filter(a -> a.getAttrGrpCd().equals("AC002"))
        Map<String, List<PrdAttrMapEntity>> result2 = prdAttrList.stream().collect(groupingBy(PrdAttrMapEntity::getAttrGrpCd));
        System.out.println(result2);
        // AC003=[...], AC002=[PrdAttrMapEntity, PrdAttrMapEntity...], AC001=[...]

        List<PrdAttrMapEntity> result21 = prdAttrList.stream().collect(groupingBy(PrdAttrMapEntity::getAttrGrpCd)).get("AC002");
        System.out.println(result21);

        List<PrdAttrMapEntity> result3 = prdAttrList.stream().collect(Collectors.toList());
        System.out.println(result3);

        List<PrdAttrMapEntity> result4 = prdAttrList.stream().filter(item -> item.getAttrGrpCd().equals("AC002")).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(result4);
    }
}