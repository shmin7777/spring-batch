package com.example.demo;

import java.util.Arrays;
import javax.sql.DataSource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersValidator;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.CompositeJobParametersValidator;
import org.springframework.batch.core.job.DefaultJobParametersValidator;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import com.example.demo.incrementer.DailyJobTimestamper;
import com.example.demo.listener.JobLoggerListener;
import com.example.demo.validator.ParameterValidator;

@SpringBootApplication
@EnableBatchProcessing
public class SpringBatchApplication {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    public static void main(String[] args) {
        SpringApplication.run(SpringBatchApplication.class, args);
    }


    @Bean
    public Step step() {
        return this.stepBuilderFactory.get("step1")
                .tasklet(helloTasklet(null)).build();
    }

    @Bean
    public Job job() {
        return this.jobBuilderFactory
                .get("job")
                .start(step())
                .validator(validator())
//                .incrementer(new RunIdIncrementer())
                .incrementer(new DailyJobTimestamper())
                .listener(new JobLoggerListener())
                .build();
    }

    @Bean
    @StepScope
    public Tasklet helloTasklet(@Value("#{jobParameters['name']}") String name) {
        return (contribution, chunkContext) -> {

            System.out.println(String.format("Hello, %s!", name));

            return RepeatStatus.FINISHED;
        };
    }

    @Bean
    public DefaultJobParametersValidator defaultValidator() {
        // requiredKeys, OptionalKeys외의 다른 파라미터가 오면 에러
        // requredKeys만 있고 OptionalKeys는 없을땐, requiredKeys만 만족하면 optional은 무엇이 와도 상관 없다.
        // run.id : job parameter 증가 시키는 id
        DefaultJobParametersValidator validator = new DefaultJobParametersValidator();
        validator.setRequiredKeys(new String[] {"fileName"});
//        validator.setOptionalKeys(new String[] {"name", "run.id"}); 
        validator.setOptionalKeys(new String[] {"name", "currentDate"}); 
        return validator;
    }

    /**
     * ParameterValidator와 DefaultJobParametersValidator 두개 이상을 jobBuilder에 등록하고 싶을 때
     * 
     * @return
     */
    @Bean
    public CompositeJobParametersValidator validator() {
        CompositeJobParametersValidator validator = new CompositeJobParametersValidator();
        DefaultJobParametersValidator defaultValidator = defaultValidator();

        defaultValidator.afterPropertiesSet();

        validator.setValidators(Arrays.asList(new ParameterValidator(), defaultValidator));

        return validator;
    }
    
}
