package com.example.springcloudproduct.core.option.repository;

import com.example.springcloudproduct.core.option.domain.OptionValueCompositeKey;
import com.example.springcloudproduct.core.option.domain.OptionValueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * packageName  :   com.example.backend.core.option.repository
 * fileName     :   OptionValueRepository
 * author       :   sinabeuro53
 * date         :   2022-03-15
 * description  :
 */
public interface OptionValueRepository extends JpaRepository<OptionValueEntity, OptionValueCompositeKey> {

    List<OptionValueEntity> findByPrdNo(Long prdNo);

    List<OptionValueEntity> findByStockNo(Long stockNo);

    List<OptionValueEntity> findByPrdNoAndStockNo(Long prdNo, Long stockNo);

    OptionValueEntity findByPrdNoAndStockNoAndAndOptItemNo(Long prdNo, Long stockNo, Long optItemNo);

}
