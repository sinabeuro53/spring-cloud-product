package com.example.springcloudproduct.core.delivery.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DeliveryServiceImplTest {

    @Autowired
    private DeliveryServiceImpl deliveryService;

    @Test
    void selectDlvPrdMapBy() {
//        deliveryService.selectDlvPrdMapBy(314055633L, null);

//        deliveryService.selectDlvPrdMapBy(314055633L, 206922L);
        deliveryService.selectDlvPrdMapBy(null, 206922L);
    }
}