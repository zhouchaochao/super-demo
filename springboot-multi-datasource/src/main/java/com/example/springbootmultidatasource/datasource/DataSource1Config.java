package com.example.springbootmultidatasource.datasource;

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
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Title:
 * Description:    配置扫描 datasource1 文件夹下的mapper
 * Date:  2018/3/17
 *
 * @author <a href=mailto:zhouzhichao1024@gmail.com>chaochao</a>
 */
@Configuration
@MapperScan(basePackages = "com.example.springbootmultidatasource.mapper.datasource1", sqlSessionTemplateRef  = "sqlSessionTemplate1")
public class DataSource1Config {

    @Bean(name = "dataSource1")
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    @Primary
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "sqlSessionFactory1")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("dataSource1") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "transactionManager1")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("dataSource1") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "sqlSessionTemplate1")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("sqlSessionFactory1") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
