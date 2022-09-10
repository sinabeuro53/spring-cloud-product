package com.example.springcloudproduct.core.category.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;

// https://github.com/72services/qlrm
// https://charlie-choi.tistory.com/246
@Data
@AllArgsConstructor
@NoArgsConstructor
//QLRM을 사용하기 위한 DTO 부분 보시면 Long이 아닌 BigInteger로 선언한거 보이시나요?
//QLRM 라이브러리의 ClassGenerator.class를 보시면 DB의 Data Type을 가져오는거 같습니다. 그리고 내부 클래스를 통해 Java Primitive Type으로 변환을 시켜주더라고요.
//다만 Mysql Point 타입 같은거는 지원을 안해줘서 이러한 타입들을 이용하신다면 @SqlResultSetMapping를 이용해야 합니다.
public class StdCtgrResponseDTO {

    private BigInteger stdCtgrNo;
    private BigInteger hgrnkCtgrNo;
    private String stdCtgrNm;
    private LocalDateTime createDt;

}
