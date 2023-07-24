package com.example.demo;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableBatchProcessing
@EnableScheduling
@Slf4j
public class SpringBatchApplication  implements CommandLineRunner {

    @Autowired
    private ApplicationContext applicationContext;


    public static void main(String[] args) {
        SpringApplication.run(SpringBatchApplication.class, args);
    }
    

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        String[] beans = applicationContext.getBeanDefinitionNames();
//
//        for (String bean : beans) {
//            System.out.println("bean : " + bean);
//        }
    }
    //
    // @Autowired
    // private JobBuilderFactory jobBuilderFactory;
    //
    // @Autowired
    // private StepBuilderFactory stepBuilderFactory;
    //
    // @Autowired
    // CustomService customService;
    //
    //
    //
    // @Bean
    // public Step step1() {
    // return this.stepBuilderFactory.get("step1")
    // // .tasklet(new HelloTasklet())
    // // .tasklet(callableTasklet())
    //// .tasklet(methodInvokingTaskletAdapter())
    // .tasklet(systemCommandTasklet())
    // // .listener(promotionListener())
    // .build();
    // }
    //
    // @Bean
    // public Step step2() {
    // return this.stepBuilderFactory.get("step2")
    // .tasklet(new GoodByeTasklet())
    // .build();
    // }
    //
    // @Bean
    // public Job job() {
    // return this.jobBuilderFactory
    // .get("job")
    // .start(step1())
    // .next(step2())
    // .validator(validator())
    // // .incrementer(new RunIdIncrementer())
    // .incrementer(new DailyJobTimestamper())
    // .listener(new JobLoggerListener())
    // .build();
    // }
    //
    // // @Bean
    // // @StepScope
    // // public Tasklet helloTasklet(@Value("#{jobParameters['name']}") String name) {
    // // return (contribution, chunkContext) -> {
    // //
    // // System.out.println(String.format("Hello, %s!", name));
    // //
    // // return RepeatStatus.FINISHED;
    // // };
    // // }
    //
    // @Bean
    // public DefaultJobParametersValidator defaultValidator() {
    // // requiredKeys, OptionalKeys외의 다른 파라미터가 오면 에러
    // // requredKeys만 있고 OptionalKeys는 없을땐, requiredKeys만 만족하면 optional은 무엇이 와도 상관 없다.
    // // run.id : job parameter 증가 시키는 id
    // DefaultJobParametersValidator validator = new DefaultJobParametersValidator();
    // validator.setRequiredKeys(new String[] {"fileName"});
    // // validator.setOptionalKeys(new String[] {"name", "run.id"});
    // validator.setOptionalKeys(new String[] {"name", "currentDate"});
    // return validator;
    // }
    //
    // /**
    // * ParameterValidator와 DefaultJobParametersValidator 두개 이상을 jobBuilder에 등록하고 싶을 때
    // *
    // * @return
    // */
    // @Bean
    // public CompositeJobParametersValidator validator() {
    // CompositeJobParametersValidator validator = new CompositeJobParametersValidator();
    // DefaultJobParametersValidator defaultValidator = defaultValidator();
    //
    // defaultValidator.afterPropertiesSet();
    //
    // validator.setValidators(Arrays.asList(new ParameterValidator(), defaultValidator));
    //
    // return validator;
    // }
    //
    //
    // /**
    // * step이 완료된 후에 step의 executionContext를 job executionContext로 승격
    // *
    // * @return
    // */
    // @Bean
    // public StepExecutionListener promotionListener() {
    // ExecutionContextPromotionListener promotionListener =
    // new ExecutionContextPromotionListener();
    // promotionListener.setKeys(new String[] {"user.name2"});
    //
    // return promotionListener;
    // }
    //
    // /**
    // * Callable객체가 유효한 RepeatStatus 객체를 반환하기 전까지는 완료된것으로 간주하지 않아, 다른 스텝은 실행되지 않음. 따라서 별개의 스레드에서
    // * 실행되지만 병렬로 실행되는 것은 아님
    // *
    // * @return
    // */
    //// @Bean
    //// public CallableTaskletAdapter callableTasklet() {
    //// CallableTaskletAdapter callableTaskletAdapter = new CallableTaskletAdapter();
    //// log.info("call 전" + Thread.currentThread().getId());
    //// callableTaskletAdapter.setCallable(() -> {
    //// log.info("This was executed in another thread" + Thread.currentThread().getId());
    //// return RepeatStatus.FINISHED;
    //// });
    //// log.info("call 후" + Thread.currentThread().getId());
    //// return callableTaskletAdapter;
    //// }
    //
    // /**
    // * 기존에 존재하던 다른 클래스 내의 메서드를 잡 내의 태스크릿처럼 실행 가능
    // *
    // * @return
    // */
    // @Bean
    // public MethodInvokingTaskletAdapter methodInvokingTaskletAdapter() {
    // MethodInvokingTaskletAdapter methodInvokingTaskletAdapter =
    // new MethodInvokingTaskletAdapter();
    //
    // methodInvokingTaskletAdapter.setTargetMethod("serviceMethod");
    // methodInvokingTaskletAdapter.setTargetObject(customService);
    //
    // return methodInvokingTaskletAdapter;
    // }
    //
    //
    // /**
    // * 시스템 명령을 실행할 때 사용 비동기로 실행
    // *
    // * @return
    // */
    // @Bean
    // public SystemCommandTasklet systemCommandTasklet() {
    // log.info("system command tasklet");
    // SystemCommandTasklet systemCommandTasklet = new SystemCommandTasklet();
    //
    // systemCommandTasklet.setCommand("fsutil file createnew 1.txt 0");
    // systemCommandTasklet.setTimeout(5000);
    // systemCommandTasklet.setInterruptOnCancel(true); // job이 비정상 적으로 종료될 때 시스템 프로세스와 관련된 스레드 강제
    // 종료 여부
    //
    // // change this directory to something appropriate for your environment
    // systemCommandTasklet.setWorkingDirectory("C:\\Temp"); // 명령을 실행할 디렉터리 . cd ~/로 들어가는것과 같음
    //
    // systemCommandTasklet.setSystemProcessExitCodeMapper(new SimpleSystemProcessExitCodeMapper());
    // // 시스템 반환 코드 -> Finished or Failed
    // systemCommandTasklet.setTerminationCheckInterval(5000); // 시스템 명령은 비동기 방식으로 실행되는데, 명령이후에
    // 테스크릿은 해당 명령의 완료 여부를 주기적으로 확인. default는 1초
    // systemCommandTasklet.setTaskExecutor(new SimpleAsyncTaskExecutor()); // 시스템 명령을 실행하는 custom
    // task executor를 구성 할 수 있다. 시스템 명령에 문제가 발생한다면 job에 lock이 걸릴 수 있으므로 동기식 task executor를 구성하지 않는것이
    // 좋다.
    // systemCommandTasklet.setEnvironmentParams(new String[] { // 명령 실행 전 설정하는 환경 파라미터 목록
    // "JAVA_HOME=/java",
    // "BATCH_HOME=/User/batch"
    // });
    //
    // return systemCommandTasklet;
    // }
    //

}
