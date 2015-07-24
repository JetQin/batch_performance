package com.usee.performance.config;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.HibernateCursorItemReader;
import org.springframework.batch.item.database.HibernateItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;

import com.usee.performance.domain.EUProd;
import com.usee.performance.domain.EUProdTemp;
import com.usee.performance.domain.Person;
import com.usee.performance.service.EntityItemProcessor;

@Configuration
@EnableBatchProcessing
@Order(100)
public class BatchConfiguration {

	private final String querySql = "from EUProdTemp";
	
	private final int CHUNCK_SIZE  = 10000;
	
	@Autowired
	private SessionFactory sessionFactory;
	
    @Bean
    public ItemProcessor<EUProdTemp, EUProd> processor() {
        return new EntityItemProcessor();
    }

    @Bean
    public ItemReader<EUProdTemp> reader(DataSource dataSource) {
    	HibernateCursorItemReader<EUProdTemp> reader = new HibernateCursorItemReader<EUProdTemp>();
    	reader.setSessionFactory(sessionFactory);
        reader.setQueryString(querySql);
    	return  reader;
    }

    @Bean
    public ItemWriter<EUProd> writer(DataSource dataSource) {
    	HibernateItemWriter<EUProd> writer = new HibernateItemWriter<EUProd>();
    	writer.setSessionFactory(sessionFactory);
    	return writer;
    }
    // end::readerwriterprocessor[]

    // tag::jobstep[]
    @Bean
    public Job importEntityJob(JobBuilderFactory jobs, Step s1, JobExecutionListener listener) {
        return jobs.get("importEntityJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(s1)
                .end()
                .build();
    }

    @Bean
    public Step step1(StepBuilderFactory stepBuilderFactory, ItemReader<EUProdTemp> reader,
            ItemWriter<EUProd> writer) {
        return stepBuilderFactory.get("step1")
                .<EUProdTemp, EUProd> chunk(CHUNCK_SIZE)
                .reader(reader)
                .processor( processor())
                .writer(writer)
                .build();
    }
    // end::jobstep[]

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

//	/**
//	 * @return the sessionFactory
//	 */
//	public SessionFactory getSessionFactory() {
//		return sessionFactory;
//	}
//
//	/**
//	 * @param sessionFactory the sessionFactory to set
//	 */
//	@Resource(name="sessionFactory")
//	public void setSessionFactory(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}
//    
    
    

}
