//package com.example.demo.ch07;
//
//import java.util.HashMap;
//import java.util.Map;
//import javax.sql.DataSource;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.database.JdbcCursorItemReader;
//import org.springframework.batch.item.database.JdbcPagingItemReader;
//import org.springframework.batch.item.database.Order;
//import org.springframework.batch.item.database.PagingQueryProvider;
//import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
//import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
//import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.ArgumentPreparedStatementSetter;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Configuration
//public class JDBCCustomerItemReader {
//
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
////    @Bean
////    @StepScope
////    public JdbcCursorItemReader<Customer> cursorItemReader(DataSource dataSource) {
////        return new JdbcCursorItemReaderBuilder<Customer>()
////                .name("customerItemReader1")
////                .dataSource(dataSource)
////                .sql("select * from customer where city = ?")
////                .rowMapper(new CustomerRowMapper())
////                .preparedStatementSetter(citySetter(null))
////                .build();
////    }
//    
//    @Bean
//    @StepScope
//    public JdbcPagingItemReader<Customer> pagingItemReader(DataSource dataSource, @Value("#{jobParameters['city']}") String city, PagingQueryProvider pagingQueryProvider){
//        Map<String, Object> parameterValues = new HashMap<>(2);
//        parameterValues.put("city", city);
//        
//        return new JdbcPagingItemReaderBuilder<Customer>()
//                .dataSource(dataSource)
//                .name("customerItemReader2")
//                .rowMapper(new CustomerRowMapper())
//                .parameterValues(parameterValues)
//                .pageSize(10)
//                .queryProvider(pagingQueryProvider)
//                .build();
//    }
//    
//    @Bean
//    public SqlPagingQueryProviderFactoryBean pagingQueryProvider(DataSource dataSource) {
//        Map<String, Order> sortedMap = new HashMap<>();
//        sortedMap.put("lastName", Order.DESCENDING);
//        
//        SqlPagingQueryProviderFactoryBean factoryBean = new SqlPagingQueryProviderFactoryBean();
//        factoryBean.setDataSource(dataSource);
//        factoryBean.setSelectClause("select *");
//        factoryBean.setFromClause("from customer");
//        factoryBean.setWhereClause("where city= :city");
//        factoryBean.setSortKeys(sortedMap);
//        
//        return factoryBean;
//    }
//    
//     
//
//    
//    @Bean
//    @StepScope
//    public ArgumentPreparedStatementSetter citySetter(
//           @Value("#{jobParameters['city']}") String city) {
//        log.info("실행되나~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//        return new ArgumentPreparedStatementSetter(new Object[] {city});
//    }
//
//    @Bean
//    public ItemWriter<Customer> itemWriter() {
//        return items -> items.forEach(System.out::println);
//    }
//
//    @Bean
//    public Step copyFileStep() {
//        return this.stepBuilderFactory.get("copyDBStep").<Customer, Customer>chunk(10)
//                .reader(pagingItemReader(null, null, null)).writer(itemWriter()).build();
//    }
//
//    @Bean
//    public Job copyFileJob() {
//        return this.jobBuilderFactory.get("copyDBJob").incrementer(new RunIdIncrementer())
//                .start(copyFileStep()).build();
//    }
//}
