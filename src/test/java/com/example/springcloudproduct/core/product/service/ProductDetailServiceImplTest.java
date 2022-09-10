package com.example.springcloudproduct.core.product.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
class ProductDetailServiceImplTest {

    @Autowired
    private ProductDetailService productDetailService;

    @Test
    void selectProductDetailTest() {
        System.out.println(productDetailService.selectProductDetail(316996735L))
        ;
    }

    @Test
    void formatterTest() {

        Timestamp timestamp =  new Timestamp(System.currentTimeMillis());

        String str = String.valueOf(timestamp);

//        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
//        System.out.println(date);

//        2021-10-12T21:54:55.651562


//        System.out.println( LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//        System.out.println( LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))) );

//        BASIC_ISO_DATE
        LocalDateTime localDateTime = LocalDateTime.parse(LocalDateTime.now().format( DateTimeFormatter.ISO_DATE_TIME ));
        LocalDateTime localDateTime2 = LocalDateTime.parse(LocalDateTime.now().format( DateTimeFormatter.ISO_LOCAL_DATE_TIME ));
//        LocalDateTime localDateTime3 = LocalDateTime.parse(LocalDateTime.now().format( DateTimeFormatter.ISO_OFFSET_DATE_TIME ));

        System.out.println(localDateTime);
        System.out.println(localDateTime2);
//        System.out.println(localDateTime3);

        Timestamp timestamp1 = Timestamp.valueOf(LocalDateTime.now()); // 2018-07-26 01:06:55.323
        System.out.println(timestamp1);


    }
}