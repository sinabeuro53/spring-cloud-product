package com.example.springcloudproduct.core.option.repository;

import com.example.springcloudproduct.core.option.domain.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<StockEntity, Long> {

    List<StockEntity> findByStockNo(Long stockNo);

}
