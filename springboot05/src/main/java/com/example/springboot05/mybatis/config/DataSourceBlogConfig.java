package com.example.springboot05.mybatis.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.example.springboot05.mybatis.mapper.blog", sqlSessionTemplateRef = "blogSqlSessionTemplate")
public class DataSourceBlogConfig {

    @Bean(name = "blogDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.blog")
    public DataSource blogDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 配置事务管理器，不然事务不起作用
     *
     * @return
     */
    @Bean(name = "blogTransactionManager")
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(this.blogDataSource());
    }

    @Bean(name = "blogSqlSessionFactory")
    public SqlSessionFactory blogSqlSessionFactory(@Qualifier("blogDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/blog/*.xml"));
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "blogSqlSessionTemplate")
    public SqlSessionTemplate blogSqlSessionTemplate(@Qualifier("blogSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
