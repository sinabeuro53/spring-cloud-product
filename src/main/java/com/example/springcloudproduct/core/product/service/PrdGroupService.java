package com.example.springcloudproduct.core.product.service;

import com.example.springcloudproduct.core.product.domain.PrdGroupEntity;

public interface PrdGroupService {

    PrdGroupEntity selectPrdGroupInfo(Long prdGroupNo);
}
