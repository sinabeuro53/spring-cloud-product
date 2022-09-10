package com.example.springcloudproduct.core.category.domain;

import com.example.springcloudproduct.core.common.domain.BaseEntity;
import com.querydsl.core.annotations.QueryProjection;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@Table(name = "tpd_std_ctgr")
public class StdCtgrEntity extends BaseEntity {

    @Id @Column(name = "std_ctgr_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stdCtgrNo;

    @Column(name = "hgrnk_ctgr_no")
    private Long hgrnkCtgrNo;

    @Column(name = "std_ctgr_nm")
    private String stdCtgrNm;

    @Column(name = "disp_prrt_rnk")
    private int dispPrrtRnk;
    private String useYn;
    private String stdCtgrCd;
    private String autoApprYn;
    private String reviewType;
    private String siteCd;

    @Transient      // 영속화 제외
     private int depth;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        StdCtgrEntity that = (StdCtgrEntity) o;
        return stdCtgrNo != null && Objects.equals(stdCtgrNo, that.stdCtgrNo);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

//    @QueryProjection
//    public StdCtgrEntity(Long stdCtgrNo, Long hgrnkCtgrNo, String stdCtgrNm, int dispPrrtRnk, String useYn, String stdCtgrCd, String autoApprYn, String reviewType, String siteCd, int depth) {
//        this.stdCtgrNo = stdCtgrNo;
//        this.hgrnkCtgrNo = hgrnkCtgrNo;
//        this.stdCtgrNm = stdCtgrNm;
//        this.dispPrrtRnk = dispPrrtRnk;
//        this.useYn = useYn;
//        this.stdCtgrCd = stdCtgrCd;
//        this.autoApprYn = autoApprYn;
//        this.reviewType = reviewType;
//        this.siteCd = siteCd;
//        this.depth = depth;
//    }

}
