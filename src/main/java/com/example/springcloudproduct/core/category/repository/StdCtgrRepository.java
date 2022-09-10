package com.example.springcloudproduct.core.category.repository;

import com.example.springcloudproduct.core.category.domain.StdCtgrEntity;
import com.example.springcloudproduct.core.category.service.StdCtgrService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface StdCtgrRepository extends JpaRepository<StdCtgrEntity, Long>, StdCtgrService {

    @Query(value = "with recursive self_std_ctgr(std_ctgr_nm, std_ctgr_no, hgrnk_ctgr_no, depth, use_yn) " +
            "as (" +
            "select\n" +
            "std.std_ctgr_nm , " +
            "std.std_ctgr_no , " +
            "std.hgrnk_ctgr_no , " +
            "1 as depth, " +
            "std.use_yn\n" +
            "from " +
            "tpd_std_ctgr std " +
            "where " +
            "std.std_ctgr_no = :stdCtgrNo " +
            "union all\n" +
            "select\n" +
            "std.std_ctgr_nm ,\n" +
            "std.std_ctgr_no ,\n" +
            "std.hgrnk_ctgr_no ,\n" +
            "sef.depth + 1 as depth, \n" +
            "sef.use_yn\n" +
            "from\n" +
            "tpd_std_ctgr std\n" +
            "inner join self_std_ctgr sef on\n" +
            "std.hgrnk_ctgr_no = sef.std_ctgr_no\n" +
            "where sef.depth < :depth\n" +
            ")\n" +
            "select\n" +
            "tmp.std_ctgr_no as \"stdCtgrNo\"" +
            ", tmp.hgrnk_ctgr_no as \"hgrnkCtgrNo\"" +
            ", tmp.std_ctgr_nm as \"stdCtgrNm\"" +
            ", tmp.depth as \"depth\" \n" +
            ", tmp.use_yn as \"useYn\" \n" +
            "from\n" +
            "self_std_ctgr tmp", nativeQuery = true)
    List<Map<String, Object>> selectStdCtgrListByRecursiveNative(
            @Param("stdCtgrNo") Long stdCtgrNo
            , @Param("depth") int depth
    );

    StdCtgrEntity findByStdCtgrNoOrderByStdCtgrNoAsc(Long stdCtgrNo);

    StdCtgrEntity findByStdCtgrNoAndUseYnOrderByStdCtgrNoAsc(Long stdCtgrNo, String useYn);

    List<StdCtgrEntity> findByHgrnkCtgrNoAndSiteCdAndUseYnOrderByStdCtgrNoAsc(Long hgrnkCtgrNo, String siteCd, String useYn);

}
