//package com.example.demo.config;
//
//import javax.sql.DataSource;
//import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
//import org.springframework.batch.core.repository.JobRepository;
//import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
//import org.springframework.batch.support.DatabaseType;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.PlatformTransactionManager;
//import lombok.RequiredArgsConstructor;
//
//@Component
//@RequiredArgsConstructor
//public class CustomBatchConfigurer extends DefaultBatchConfigurer {
//
//    private final DataSource dataSource;
//    private final PlatformTransactionManager transactionManager;
//
//    @Override
//    protected JobRepository createJobRepository() throws Exception {
//        JobRepositoryFactoryBean factoryBean = new JobRepositoryFactoryBean();
//
//        factoryBean.setDataSource(dataSource);
//        factoryBean.setTransactionManager(transactionManager);
//        factoryBean.setDatabaseType(DatabaseType.MYSQL.getProductName());
////        factoryBean.setTablePrefix("FOO_");
//        factoryBean.afterPropertiesSet();
//        JobRepository jobRepository = factoryBean.getObject();
//        return jobRepository;
//    }
//
//}
