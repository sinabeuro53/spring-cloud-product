package com.example.springcloudproduct.datasource;


import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

//import org.springframework.boot.jdbc.DataSourceBuilder;

@Configuration
@PostgreConnMapper
@MapperScan(basePackages = "com.example.backend.core", annotationClass = PostgreConnMapper.class, sqlSessionFactoryRef = "postgreSqlSessionFactory")
@EnableTransactionManagement
public class PostgreDatabaseConfig {

    @Bean(name = "postgreDataSource", destroyMethod = "close")
    @Primary
    @ConfigurationProperties(prefix = "spring.postgresqlconnection")
    public DataSource postgreDataSource(){
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "postgreSqlSessionFactory")
    @Primary
    public SqlSessionFactory postgreSqlSessionFactory(@Qualifier("postgreDataSource") DataSource postgreDataSource, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(postgreDataSource);
        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:/config/mybatis-config.xml"));
        sqlSessionFactoryBean.setMapperLocations((new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/**/*.xml")));
        return  sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "postgreSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate postgreSqlSessionTemplate(SqlSessionFactory postgreSqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(postgreSqlSessionFactory);
    }

}
