package com.example.springcloudproduct.core.product.repository;

import com.example.springcloudproduct.core.product.domain.ProductEntity;
import com.example.springcloudproduct.core.product.service.ProductService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>, ProductService {

// https://yonguri.tistory.com/122
// 1. LIKE :검색어 findByUsernameLike
// 2. LIKE :검색어% findByUsernameStartingWith
// 3. LIKE %:검색어 findByUsernameEndingWith
// 4. LIKE %:검색어% findByUsernameContaining

    List<ProductEntity> findTop10ByPrdNmContaining(String prdNm);

    ProductEntity findByPrdNo(Long prdNo);

    List<ProductEntity> findByPrdNoIn(List<Long> prdNoList);

}
