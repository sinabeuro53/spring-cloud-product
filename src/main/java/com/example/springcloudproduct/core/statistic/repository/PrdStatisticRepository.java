package com.example.springcloudproduct.core.statistic.repository;

import com.example.springcloudproduct.core.statistic.domain.PrdStatisticEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName  :   com.example.springcloudproduct.core.statistic.repository
 * fileName     :   PrdStatisticRepository
 * author       :   sinabeuro53
 * date         :   2022-03-22
 * description  :
 */
public interface PrdStatisticRepository extends JpaRepository<PrdStatisticEntity, Long> {

    PrdStatisticEntity findByStatisticNo(Long statisticNo);

    PrdStatisticEntity findBySelAcntNo(Long selAcntNo);
}
