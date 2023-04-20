package igdxserv.TechLabo4SpringBoot.springbatch.samplebatch.config;

import igdxserv.TechLabo4SpringBoot.springbatch.samplebatch.tasklet.SampleTaskLet;
import jakarta.annotation.PostConstruct;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.support.DefaultBatchConfiguration;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.job.builder.SimpleJobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;

@Configuration
@EnableBatchProcessing
public class SampleBatchConfig {
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Bean
//    public SampleTaskLet tasklet() {
//        return new SampleTaskLet();
//    }
//
//    @Bean
//    public Job myJob() {
//        return jobBuilderFactory.get("myJob")
//                .start(step1())
//                .build();
//    }
//
//    @Bean
//    public Step step1() {
//        return stepBuilderFactory.get("step1")
//                .tasklet(tasklet())
//                .build();
//    }
}
//
//    @Autowired
//    private JobBuilder jobBuilder;
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Autowired
//    private SampleTaskLet sampleTaskLet;
//
////    public SampleBatchConfig(JobBuilderFactory jobBuilderFactory,
////                       StepBuilderFactory stepBuilderFactory,
////                       SampleTaskLet sampleTaskLet) {
////        this.jobBuilderFactory = jobBuilderFactory;
////        this.stepBuilderFactory = stepBuilderFactory;
////        this.sampleTaskLet = sampleTaskLet;
////    }
//
//    @Bean
//    public Job helloWorldJob(Step helloWorldStep) {
//        System.out.println("start job");
//        return jobBuilderFactory.get("helloWorldJob") //Job名を指定
//                .flow(helloWorldStep) //実行するStepを指定
//                .end()
//                .build();
//    }
//
//    @Bean
//    public Step helloWorldStep() {
//        System.out.println("start step");
//        return stepBuilderFactory.get("helloWorldStep") //Step名を指定
//                .tasklet(sampleTaskLet) //実行するTaskletを指定
//                .build();
//    }
//
////
////    private JobBuilder jobBuilder;
////    private JobExplorer jobExplorer;
////    private JobLauncher  jobLauncher;
////    private StepBuilder stepBuilder;
////
////    private SampleTaskLet sampleTaskLet;
////    private PlatformTransactionManager transactionManager ;
////
////    public SampleBatchConfig(JobBuilder jobBuilder,JobExplorer jobExplorer,JobLauncher  jobLauncher,StepBuilder stepBuilder,SampleTaskLet sampleTaskLet) {
////        this.jobBuilder = jobBuilder;
////        this.jobExplorer = jobExplorer;
////        this.jobLauncher = jobLauncher;
////        this.stepBuilder = stepBuilder;
////        this.sampleTaskLet = sampleTaskLet;
////    }
////
////    @Bean
////    public Job helloworldJob(Step step) {
////        SimpleJobBuilder job = jobBuilder.start(step);
////        return job.build();
////    }
////
////    @Bean
////    public TaskletStep helloworldStep() {
////        return stepBuilder.tasklet(sampleTaskLet,transactionManager).build();
////    }
//
////    @Bean
////    DefaultBatchConfiguration batchConfigurer() {
////        return new DefaultBatchConfiguration(){
////            @PostConstruct
////            private void init() throws Exception {
////                MapJobRepositoryFactoryBean jobRepositoryFactory = new MapJobRepositoryFactoryBean();
////                jobRepository = jobRepositoryFactory.getObject();
////                MapJobExplorerFactoryBean jobExplorerFactory = new MapJobExplorerFactoryBean(jobRepositoryFactory);
////                jobExplorer = jobExplorerFactory.getObject();
////                SimpleJobLauncher simpleJobLauncher = new SimpleJobLauncher();
////                simpleJobLauncher.setJobRepository(jobRepository);
////                simpleJobLauncher.afterPropertiesSet();
////                jobLauncher = simpleJobLauncher;
////            }
////            @Override
////            public JobRepository getJobRepository() {
////                return jobRepository;
////            }
////            @Override
////            public JobExplorer getJobExplorer() {
////                return jobExplorer;
////            }
////            @Override
////            public JobLauncher getJobLauncher() {
////                return jobLauncher;
////            }
////        };
////    }
//
////
////    @Autowired
////    private JobBuilderFactory jobBuilderFactory;
////
////    @Autowired
////    private StepBuilderFactory stepBuilderFactory;
////
////    @Value("${hoge.chunk:1}")
////    private int chunk;
////
////    @Bean
////    public Job job() throws IOException {
////        log.debug("called.");
////        return jobBuilderFactory.get("job1")
////                .incrementer(new RunIdIncrementer())
////                .listener(listener())
////                .start(step())
////                .build();
////    }
////
////    @Bean
////    public JobExecutionListener listener() {
////        return new JobListener();
////    }
////
////    @Bean
////    public Step step() throws IOException {
////        log.debug("called.");
////        return stepBuilderFactory.get("step")
////                .<HogeLine, HogeInfo> chunk(chunk)
////                .reader(reader(null))
////                .processor(processor())
////                .writer(writer(null))
////                .faultTolerant()
////                .skip(Exception.class)
////                .skipLimit(Integer.MAX_VALUE)
////                .build();
////    }
////
////    @Bean
////    @StepScope
////    public HogeReader reader(@Value("#{jobParameters[in]}") String fileName) throws IOException {
////        return new HogeReader(fileName);
////    }
////
////    @Bean
////    @StepScope
////    public HogeProcessor processor()  {
////        return new HogeProcessor();
////    }
////
////    @Bean
////    @StepScope
////    public FlatFileItemWriter<HogeInfo> writer(@Value("#{jobParameters[out]}") String filename) {
////        FlatFileItemWriter<HogeInfo> writer = new FlatFileItemWriter<>();
////        writer.setResource(new FileSystemResource(filename));
////        writer.setLineAggregator(item -> {
////            StringBuilder sb = new StringBuilder();
////            sb.append(item.getName());
////            sb.append("-");
////            sb.append(item.getHoge());
////            sb.append(item.getHoge());
////            return sb.toString();
////        });
////        return writer;
////    }
//}
