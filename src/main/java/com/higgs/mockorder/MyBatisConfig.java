/**
 * BrandBigData.com Inc.
 * Copyright (c) 2016 All Rights Reserved.
 */
package com.higgs.mockorder;

import org.apache.commons.dbcp2.BasicDataSource;
import org.bytesoft.bytejta.supports.jdbc.LocalXADataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * @author chenshiwei
 * @version $Id: MyBatisConfig.java, v 0.1 2017/11/23 16:15 chenshiwei Exp $
 */
@Configuration
@MapperScan("com.higgs.mockorder.dao")
public class MyBatisConfig {

    @Autowired
    private Environment env;

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        LocalXADataSource dataSource = new LocalXADataSource();
        dataSource.setDataSource(this.invokeGetDataSource());
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
