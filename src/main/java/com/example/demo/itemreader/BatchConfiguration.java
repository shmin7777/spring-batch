//package com.example.demo.itemreader;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
//import org.springframework.batch.item.file.transform.LineTokenizer;
//import org.springframework.batch.item.file.transform.Range;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.core.io.Resource;
//
//@Configuration
//public class BatchConfiguration {
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;

//    @Bean
//    @StepScope
//    public FlatFileItemReader<Customer> customerItemReader(
//            @Value("#{jobParameters['customFile']}") Resource inputFile) {
//        return new FlatFileItemReaderBuilder<Customer>().name("customerItemReader")
//                // .resource(inputFile)
//                .resource(new FileSystemResource(
//                        "C:\\Users\\shmin\\Downloads\\customerFixedWidth.txt"))
//                .fixedLength()
//                .columns(new Range[] {new Range(1, 11), new Range(12, 12), new Range(13, 22),
//                        new Range(23, 26),
//                        new Range(27, 46), new Range(47, 62), new Range(63, 64), new Range(65, 69)})
//                .names(new String[] {"firstName", "middleInitial", "lastName", "addressNumber",
//                        "street", "city",
//                        "state", "zipCode"})
//                .targetType(Customer.class).build();
//    }
//
//    @Bean
//    @StepScope
//    public FlatFileItemReader<Customer> customerItemReader2(
//            @Value("#{jobParameters['customFile']}") Resource inputFile) {
//        return new FlatFileItemReaderBuilder<Customer>().name("customerItemReader2")
//                // .resource(inputFile)
//                .resource(new FileSystemResource(
//                        "C:\\Users\\shmin\\Downloads\\customDelimited.txt"))
//                .lineTokenizer(new CustomerLineTokenizer())
//                .targetType(Customer.class)
//                .build();
//    }
//    
////    @Bean
////    @StepScope
////    public FlatFileItemReader customItemReader() {
////        
////    }
//
//    @Bean
//    @StepScope
//    public FlatFileItemReader<Customer> customerItemReader3(
//            @Value("#{jobParameters['customFile']}") Resource inputFile) {
//        return new FlatFileItemReaderBuilder<Customer>().name("customerItemReader3")
//                // .resource(inputFile)
//                .resource(new FileSystemResource(
//                        "C:\\Users\\shmin\\Downloads\\customDelimited.txt"))
//                .delimited()
//                .names(new String[] {"firstName", "middleInitial", "lastName", "address",
//                        "city",
//                        "state", "zipCode"})
//                .fieldSetMapper(new CustomFieldSetMapper())
//                // .targetType(Customer.class)
//                .build();
//    }
//
//
//
//    @Bean
//    public ItemWriter<Customer> itemWriter() {
//        return items -> items.forEach(System.out::println);
//    }
//
//    @Bean
//    public Step copyFileStep() {
//        return this.stepBuilderFactory.get("copyFileStep").<Customer, Customer>chunk(10)
//                .reader(customerItemReader2(null)).writer(itemWriter()).build();
//    }
//
//    @Bean
//    public Job copyFileJob() {
//        return this.jobBuilderFactory.get("copyFileJob").incrementer(new RunIdIncrementer()).start(copyFileStep()).build();
//    }
//}
