package com.example.springcloudproduct.core.option.repository;

import com.example.springcloudproduct.core.option.domain.OptionItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * packageName  :   com.example.backend.core.option.repository
 * fileName     :   OptionItemRepository
 * author       :   sinabeuro53
 * date         :   2022-03-15
 * description  :
 */
public interface OptionItemRepository extends JpaRepository<OptionItemEntity, Long> {

    List<OptionItemEntity> findByPrdNo(Long prdNo);

}
