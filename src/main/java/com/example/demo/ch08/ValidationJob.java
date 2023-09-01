//package com.example.demo.ch08;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
//import org.springframework.batch.item.validator.BeanValidatingItemProcessor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.Resource;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
////@SpringBootApplication
//@Configuration
//public class ValidationJob {
//
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @StepScope
//    @Bean
//    public FlatFileItemReader<Customer> customerItemReader(@Value("#{jobParameters['customerFile']}") Resource inputFile) {
//        return new FlatFileItemReaderBuilder<Customer>()
//                .name("customerItemReader")
//                .delimited()
//                .names(new String[] {
//                        "firstName", "middleInitial", "lastName", "address", "city", "state",
//                        "zipCode"
//                })
//                .targetType(Customer.class)
//                .resource(inputFile)
//                .build();
//    }
//
//    @Bean
//    public ItemWriter<Customer> itemWriter() {
//        return (items) -> items.forEach(System.out::println);
//    }
//
//    @Bean
//    public BeanValidatingItemProcessor<Customer> customerValidatingItemProcessor() {
//        return new BeanValidatingItemProcessor<>();
//    }
//
//    @Bean
//    public Step copyFileStep() {
//        return stepBuilderFactory.get("copyFileStep")
//                .<Customer, Customer>chunk(5)
//                .reader(customerItemReader(null))
//                .processor(customerValidatingItemProcessor())
//                .writer(itemWriter())
//                .build();
//    }
//
//    @Bean
//    public Job validationJob22() {
//        return this.jobBuilderFactory.get("validationJob3")
//                .start(copyFileStep())
//                .incrementer(new RunIdIncrementer())
//                .build();
//    }
//
////    public static void main(String[] args) {
////        SpringApplication.run(ValidationJob.class, "customerFile=customer.csv");
////    }
//
//}
