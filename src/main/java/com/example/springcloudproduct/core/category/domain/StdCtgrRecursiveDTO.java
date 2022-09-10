package com.example.springcloudproduct.core.category.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StdCtgrRecursiveDTO {

    private Long stdCtgrNo;
    private Long hgrnkCtgrNo;
    private String stdCtgrNm;
    private int depth;
    private String useYn;
    private String siteCd;

}
