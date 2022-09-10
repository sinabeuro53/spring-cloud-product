package com.example.springcloudproduct.core.option.service;

import com.example.springcloudproduct.core.option.domain.StockEntity;
import com.example.springcloudproduct.core.option.repository.StockRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StockServiceImplTest {

    @Autowired
    private StockRepository stockRepository;

    @Test
    void stockSelect() {

        List<StockEntity> stockEntityList = stockRepository.findByStockNo(3000141618149L);
        System.out.println(stockEntityList);


    }


}
