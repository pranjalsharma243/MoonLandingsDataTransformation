package com.moonlandings.data;
import com.moonlandings.model.MoonLandingsInput;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;


import com.moonlandings.model.moonlandings;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfig {

    @Bean
    public Job jobBean(JobRepository jobRepository,
                       JobCompletionNotificationImpl listener,
                       Step steps
    ) {
        return new JobBuilder("job", jobRepository)
                .listener(listener)
                .start(steps)
                .build();
    }

    @Bean
    public Step steps(
            JobRepository jobRepository,
            PlatformTransactionManager transactionManager,
            ItemReader<MoonLandingsInput> reader,
            ItemProcessor<MoonLandingsInput, moonlandings> processor,
            ItemWriter<moonlandings> writer
    ) {
        return new StepBuilder("jobStep", jobRepository)
                .<MoonLandingsInput,moonlandings>chunk(8, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .allowStartIfComplete(true)
                .build();

    }

    //    reader
    @Bean
    public FlatFileItemReader<MoonLandingsInput> reader() {
        return new FlatFileItemReaderBuilder<MoonLandingsInput>()
                .name("itemReader")
                .resource(new ClassPathResource("moon-landings.csv"))
                .delimited()
                .names("mission", "spacecraft", "launch_date", "carrier_rocket","operator", "mission_type", "outcome", "additional_information")
                .targetType(MoonLandingsInput.class)
                .build();
    }

//    processor

    @Bean
    public ItemProcessor<MoonLandingsInput,moonlandings > itemProcessor() {
        return new MoonLandingsProcessor();
    }

//    writer

    @Bean
    public ItemWriter<moonlandings> itemWriter(EntityManagerFactory entityManagerFactory) {

        return new JpaItemWriterBuilder<moonlandings>()
                .entityManagerFactory(entityManagerFactory)
                .usePersist(true)
                .build();

    }


}