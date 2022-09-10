package com.example.springcloudproduct.core.category.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StdCtgrTreeDTO {

    private Long stdCtgrNo1;
    private Long stdCtgrNo2;
    private Long stdCtgrNo3;
    private String stdCtgrNm1;
    private String stdCtgrNm2;
    private String stdCtgrNm3;
    private String stdCtgrPath;
    private String siteCd;

}
