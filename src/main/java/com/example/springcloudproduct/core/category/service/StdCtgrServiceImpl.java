package com.example.springcloudproduct.core.category.service;

import com.example.springcloudproduct.core.category.domain.*;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.sql.JPASQLQuery;
import com.querydsl.sql.SQLTemplates;
import lombok.RequiredArgsConstructor;
import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import static com.querydsl.sql.SQLExpressions.select;
import static com.querydsl.sql.SQLExpressions.union;

@Service
@RequiredArgsConstructor
public class StdCtgrServiceImpl implements StdCtgrService {

    private final JPAQueryFactory queryFactory;

    @PersistenceContext
    private EntityManager entityManager;


    private QStdCtgrEntity qStdCtgr = QStdCtgrEntity.stdCtgrEntity;

    // map to dto
    // https://www.tabnine.com/code/java/methods/com.fasterxml.jackson.databind.ObjectMapper/getTypeFactory
    // ObjectMapper mapper = new ObjectMapper();
    // List<Map<String, Object>> map = stdCtgrRepository.selectStdCtgrListByRecursiveNative(stdCtgrNo, depth);
    // List<StdCtgrRecursiveDTO> result = mapper.convertValue(map, mapper.getTypeFactory().constructCollectionType(List.class, StdCtgrRecursiveDTO.class));

    @Override
    public StdCtgrTreeDTO selectStdCtgrListTreeFromC(Long stdCtgrNo) {

        QStdCtgrEntity qStdCtgr1 = new QStdCtgrEntity("qStdCtgr1");
        QStdCtgrEntity qStdCtgr2 = new QStdCtgrEntity("qStdCtgr2");
        QStdCtgrEntity qStdCtgr3 = new QStdCtgrEntity("qStdCtgr3");

        StdCtgrTreeDTO result = queryFactory
                .select(Projections.fields(StdCtgrTreeDTO.class
                        , qStdCtgr1.stdCtgrNo.as("stdCtgrNo1"), qStdCtgr1.stdCtgrNm.as("stdCtgrNm1")
                        , qStdCtgr2.stdCtgrNo.as("stdCtgrNo2"), qStdCtgr2.stdCtgrNm.as("stdCtgrNm2")
                        , qStdCtgr3.stdCtgrNo.as("stdCtgrNo3"), qStdCtgr3.stdCtgrNm.as("stdCtgrNm3")
                        , qStdCtgr1.siteCd.as("siteCd")
                        , Expressions.as(qStdCtgr1.stdCtgrNm.concat(" > ").concat(qStdCtgr2.stdCtgrNm).concat(" > ").concat(qStdCtgr3.stdCtgrNm), "stdCtgrPath")
                ))
                .from(qStdCtgr3)
                .leftJoin(qStdCtgr2).on(qStdCtgr3.hgrnkCtgrNo.eq(qStdCtgr2.stdCtgrNo))
                .leftJoin(qStdCtgr1).on(qStdCtgr2.hgrnkCtgrNo.eq(qStdCtgr1.stdCtgrNo))
                .where(qStdCtgr3.stdCtgrNo.eq(stdCtgrNo))
                .fetchOne();

        return result;
    }

    @Override
    public List<StdCtgrRecursiveDTO> selectStdCtgrListAll(String siteCd) {

        List<StdCtgrRecursiveDTO> result = queryFactory
                .select(Projections.fields(StdCtgrRecursiveDTO.class,
                        qStdCtgr.stdCtgrNo, qStdCtgr.hgrnkCtgrNo, qStdCtgr.stdCtgrNm, qStdCtgr.siteCd
                ))
                .from(qStdCtgr)
                .where(
                        qStdCtgr.siteCd.eq(siteCd)
                )
                .fetch();

        return result;
    }


    @Override
    public List<StdCtgrEntity> selectStdCtgrListRecursive(Long stdCtgrNo, int depth) {

//        QStdCtgrEntity qStdCtgr = QStdCtgrEntity.stdCtgrEntity;
        QStdCtgrEntity tempTable = new QStdCtgrEntity("tempTable");

        JPASQLQuery<QStdCtgrEntity> query = new JPASQLQuery<>(entityManager, SQLTemplates.DEFAULT);

        int setDepth = 1;
        List<Tuple> tupleList = query.withRecursive(tempTable, tempTable.stdCtgrNo, tempTable.stdCtgrNm, tempTable.hgrnkCtgrNo)
                .as(union(
                    select(qStdCtgr.stdCtgrNo, qStdCtgr.stdCtgrNm, qStdCtgr.hgrnkCtgrNo, Expressions.as(Expressions.constant(setDepth), "depth"))
                            .from(qStdCtgr)
                            .where(qStdCtgr.stdCtgrNo.eq(stdCtgrNo)),
                    select(qStdCtgr.stdCtgrNo, qStdCtgr.stdCtgrNm, qStdCtgr.hgrnkCtgrNo, Expressions.as(Expressions.constant(setDepth++), "depth"))
                            .from(tempTable)
                            .innerJoin(qStdCtgr).on(tempTable.stdCtgrNo.eq(qStdCtgr.hgrnkCtgrNo))
//                            .where(tempTable.depth.lt(3))
                        )
                ).select(tempTable.stdCtgrNo, tempTable.stdCtgrNm, tempTable.hgrnkCtgrNo).from(tempTable).fetch();


        List<StdCtgrEntity> result = new ArrayList<StdCtgrEntity>();
        tupleList.forEach(tuple -> {

            StdCtgrEntity stdCtgrEntity = new StdCtgrEntity();
            stdCtgrEntity.setStdCtgrNo(tuple.get(0, Long.class));  // stdCtgrNo
            stdCtgrEntity.setStdCtgrNm(tuple.get(1, String.class));  // stdCtgrNm
            stdCtgrEntity.setHgrnkCtgrNo(tuple.get(2, Long.class));  // hgrnkCtgrNo
            result.add(stdCtgrEntity);
        });


        return result;
    }

    public List<StdCtgrResponseDTO> selectStdCtgrListRecursive2(Long stdCtgrNo, int depth) {
        JpaResultMapper jpaResultMapper = new JpaResultMapper();
        String sb = "with recursive self_std_ctgr(std_ctgr_nm, std_ctgr_no, hgrnk_ctgr_no, create_dt, depth) " +
                "as ( " +
                "select\n" +
                "std.std_ctgr_nm , " +
                "std.std_ctgr_no , " +
                "std.hgrnk_ctgr_no , " +
                "std.create_dt , " +
                "1 as depth " +
                "from " +
                "tpd_std_ctgr std " +
                "where std.std_ctgr_no = :stdCtgrNo " +
                "union all\n" +
                "select\n" +
                "std.std_ctgr_nm ,\n" +
                "std.std_ctgr_no ,\n" +
                "std.hgrnk_ctgr_no ,\n" +
                "std.create_dt ,\n" +
                "sef.depth + 1 as depth\n" +
                "from\n" +
                "tpd_std_ctgr std\n" +
                "inner join self_std_ctgr sef on\n" +
                "std.hgrnk_ctgr_no = sef.std_ctgr_no\n" +
                "where sef.depth < :depth " +
                ")\n" +
                "select\n" +
                "tmp.std_ctgr_no, tmp.hgrnk_ctgr_no, tmp.std_ctgr_nm, tmp.create_dt " +
                "from\n" +
                "self_std_ctgr tmp";
        Query query = entityManager.createNativeQuery(sb);
        query.setParameter("stdCtgrNo", stdCtgrNo);
        query.setParameter("depth", depth);
        List<StdCtgrResponseDTO> list = jpaResultMapper.list(query, StdCtgrResponseDTO.class);

        return list;

    }
}
