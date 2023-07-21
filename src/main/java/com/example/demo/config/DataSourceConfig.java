package com.example.demo.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class DataSourceConfig {

    @Autowired
    private DataSource dataSource;
    
    @Qualifier("batch-tr")
    @Bean
    public PlatformTransactionManager batchTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
