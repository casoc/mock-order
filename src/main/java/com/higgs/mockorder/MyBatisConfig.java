/**
 * BrandBigData.com Inc.
 * Copyright (c) 2016 All Rights Reserved.
 */
package com.higgs.mockorder;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.bytesoft.bytejta.supports.jdbc.LocalXADataSource;
import org.bytesoft.bytetcc.TransactionManagerImpl;
import org.bytesoft.bytetcc.supports.springcloud.config.SpringCloudConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

/**
 * @author chenshiwei
 * @version $Id: MyBatisConfig.java, v 0.1 2017/11/23 16:15 chenshiwei Exp $
 */
@Import(SpringCloudConfiguration.class)
@Configuration
@MapperScan(basePackages = "com.higgs.mockorder.dao")
public class MyBatisConfig {

    @Autowired
    private Environment env;

    @Bean(name = "mybatisDataSource")
    public DataSource getDataSource(@Autowired TransactionManagerImpl transactionManager) {
        LocalXADataSource dataSource = new LocalXADataSource();
        dataSource.setDataSource(this.invokeGetDataSource());
        dataSource.setTransactionManager(transactionManager);
        return dataSource;
    }

    public DataSource invokeGetDataSource() {
        BasicDataSource bds = new BasicDataSource();
        bds.setDriverClassName("com.mysql.jdbc.Driver");
        bds.setUrl(env.getProperty("spring.datasource.url"));
        bds.setUsername(env.getProperty("spring.datasource.username"));
        bds.setPassword(env.getProperty("spring.datasource.password"));
        return bds;
    }

}
