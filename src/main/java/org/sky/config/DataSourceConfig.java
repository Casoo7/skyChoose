package org.sky.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.getmoney.mapper", sqlSessionTemplateRef = "dsSqlSessionTemplate" )
public class DataSourceConfig {

    // 主数据源
    // 获取配置文件
    @Bean("dsDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.database")
    public DataSource getDataSource1(){
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean("dsSqlSessionFactory")
    public SqlSessionFactory ds1SqlSessionFactory(@Qualifier("dsDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(
                // 设置mybatis的xml所在位置
                new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return bean.getObject();
    }

    @Bean("dsSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testsqlsessiontemplate(
            @Qualifier("dsSqlSessionFactory") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }
}
