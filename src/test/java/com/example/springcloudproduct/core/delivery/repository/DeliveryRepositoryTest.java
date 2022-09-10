package com.example.springcloudproduct.core.delivery.repository;

import com.example.springcloudproduct.core.delivery.domain.DeliveryEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DeliveryRepositoryTest {

    @Autowired
    private DeliveryRepository deliveryRepository;


    @Test
    public void  deliveryRepositoryTest() {

        Optional<DeliveryEntity> deliveryEntity = deliveryRepository.findById(206922L);

        System.out.println(deliveryEntity.get().getCreateNo());
        System.out.println(deliveryEntity.get().getDeliveryAddrEntityList());
    }

}