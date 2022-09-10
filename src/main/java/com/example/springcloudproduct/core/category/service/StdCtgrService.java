package com.example.springcloudproduct.core.category.service;

import com.example.springcloudproduct.core.category.domain.StdCtgrEntity;
import com.example.springcloudproduct.core.category.domain.StdCtgrRecursiveDTO;
import com.example.springcloudproduct.core.category.domain.StdCtgrTreeDTO;

import java.util.List;

public interface StdCtgrService {

    List<StdCtgrEntity> selectStdCtgrListRecursive(Long stdCtgrNo, int depth);

    StdCtgrTreeDTO selectStdCtgrListTreeFromC(Long stdCtgrNo);

    List<StdCtgrRecursiveDTO> selectStdCtgrListAll(String siteCd);

}
