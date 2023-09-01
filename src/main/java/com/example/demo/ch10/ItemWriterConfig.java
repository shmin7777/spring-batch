package com.example.demo.ch10;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableBatchProcessing
public class ItemWriterConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    @StepScope
    public FlatFileItemWriter<LongTextTest> customerItemWriter(
            @Value("#{jobParameters['outputFile']}") Resource resource) {
        return new FlatFileItemWriterBuilder<LongTextTest>()
                .name("customerFileWriter")
                .resource(resource)
                .formatted()
                .format("%s name :: %s test at %s %s in age:: %s. ")
                .names(new String[] {
                        "content", "name", "desc1", "desc2", "age"
                })
                .build();
    }
//    @Bean
//    @StepScope
//    public FlatFileItemWriter<Customer> customerItemWriter(
//            @Value("#{jobParameters['outputFile']}") Resource resource) {
//        return new FlatFileItemWriterBuilder<Customer>()
//                .name("customerFileWriter")
//                .resource(resource)
//                .formatted()
//                .format("%s %s lives at %s %s in %s, %s. ")
//                .names(new String[] {
//                        "firstName", "lastName", "address", "city", "state",
//                        "zipCode"
//                })
//                .build();
//    }

//    @Bean
//    @StepScope
//    public FlatFileItemReader<Customer> customerFileReader(
//            @Value("#{jobParameters['customerFile']}") Resource resource) {
//        return new FlatFileItemReaderBuilder<Customer>()
//                .name("customerFileReader")
//                .resource(resource)
//                .delimited()
////                .
//                .names(new String[] {
//                        "firstName", "middleInitial", "lastName", "address", "city", "state",
//                        "zipCode"
//                })
//                .targetType(Customer.class)
//                .build();
//    }
    
  @Bean
  @StepScope
  public FlatFileItemReader<LongTextTest> customerFileReader(
          @Value("#{jobParameters['customerFile']}") Resource resource) {
      return new FlatFileItemReaderBuilder<LongTextTest>()
              .name("customerFileReader")
              .resource(resource)
              .lineTokenizer(new LongTextTestLineTokenizer())
//              .lineMapper(null)
              .targetType(LongTextTest.class)
              .build();
  }

    @Bean
    public Step step() {
        return stepBuilderFactory.get("writerStep")
                .<LongTextTest, LongTextTest>chunk(10)
                .reader(customerFileReader(null))
                // .processor(null)
                .writer(customerItemWriter(null))
                .build();
    }

    @Bean
    public Job job() {
        return jobBuilderFactory.get("writerJob")
                .incrementer(new RunIdIncrementer())
                .start(step())
                .build();
    }
}
