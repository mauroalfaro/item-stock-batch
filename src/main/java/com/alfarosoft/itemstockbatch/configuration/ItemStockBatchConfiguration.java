package com.alfarosoft.itemstockbatch.configuration;

import com.alfarosoft.itemstockbatch.database.HibernateSessionFactory;
import com.alfarosoft.itemstockbatch.listener.ItemJobListener;
import com.alfarosoft.itemstockbatch.listener.MerchandiseHierarchyJobListener;
import com.alfarosoft.itemstockbatch.model.Item;
import com.alfarosoft.itemstockbatch.model.MerchandiseHierarchy;
import com.alfarosoft.itemstockbatch.model.composites.ItemComposite;
import com.alfarosoft.itemstockbatch.model.composites.MerchandiseHierarchyComposite;
import com.alfarosoft.itemstockbatch.processor.ItemCompositeProcessor;
import com.alfarosoft.itemstockbatch.processor.MerchandiseHierarchyCompositeProcessor;
import com.alfarosoft.itemstockbatch.service.ItemRetrieveService;
import com.alfarosoft.itemstockbatch.service.MerchandiseHierarchyRetrieveService;
import com.alfarosoft.itemstockbatch.writer.ItemCompositeWriter;
import com.alfarosoft.itemstockbatch.writer.MerchandiseHierarchyCompositeWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.annotation.RequestScope;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class ItemStockBatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public ItemRetrieveService itemRetrieveService() throws Exception {
        return new ItemRetrieveService(hibernateSessionFactory());
    }

    @Bean
    public MerchandiseHierarchyRetrieveService merchandiseHierarchyRetrieveService() throws Exception {
        return new MerchandiseHierarchyRetrieveService(hibernateSessionFactory());
    }

    @Bean
    public HibernateSessionFactory hibernateSessionFactory(){
        return new HibernateSessionFactory();
    }

    @Bean
    public FlatFileItemReader<Item> itemReader() {
        return new FlatFileItemReaderBuilder<Item>()
                .name("itemItemReader")
                .resource(new ClassPathResource("item.csv"))
                .delimited()
                .names(new String[]{"sku", "name", "description", "longDescription", "category", "price", "authorizedForSale"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Item>() {{
                    setTargetType(Item.class);
                }})
                .build();
    }

    @Bean
    public FlatFileItemReader<MerchandiseHierarchy> merchandiseHierarchyReader() {
        return new FlatFileItemReaderBuilder<MerchandiseHierarchy>()
                .name("merchandiseHierarchyItemReader")
                .resource(new ClassPathResource("merchandiseHierarchy.csv"))
                .delimited()
                .names(new String[]{"division", "merchandiseGroup", "department", "merchandiseClass", "category"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<MerchandiseHierarchy>() {{
                    setTargetType(MerchandiseHierarchy.class);
                }})
                .build();
    }

    @Bean
    public ItemCompositeProcessor itemCompositeProcessor() {
        return new ItemCompositeProcessor();
    }

    @Bean
    public MerchandiseHierarchyCompositeProcessor merchandiseHierarchyCompositeProcessor() {
        return new MerchandiseHierarchyCompositeProcessor();
    }

    @Bean
    public Job importItemJob(ItemJobListener itemJobListener, Step itemCompositeStep) {
        return jobBuilderFactory.get("importItemJob")
                .incrementer(new RunIdIncrementer())
                .listener(itemJobListener)
                .flow(itemCompositeStep)
                .end()
                .build();
    }

    @Bean
    public Job importMerchandiseJob(MerchandiseHierarchyJobListener merchandiseHierarchyJobListener, Step merchandiseHierarchyCompositeStep) {
        return jobBuilderFactory.get("importMerchandiseJob")
                .incrementer(new RunIdIncrementer())
                .listener(merchandiseHierarchyJobListener)
                .flow(merchandiseHierarchyCompositeStep)
                .end()
                .build();
    }

    @Bean
    public ItemCompositeWriter itemCompositeWriter() throws Exception {
        return new ItemCompositeWriter(hibernateSessionFactory());
    }

    @Bean
    public MerchandiseHierarchyCompositeWriter merchandiseHierarchyCompositeWriter() throws Exception {
        return new MerchandiseHierarchyCompositeWriter(hibernateSessionFactory());
    }

    @Bean
    public Step itemCompositeStep(ItemCompositeWriter writer) {
        return stepBuilderFactory.get("itemCompositeStep")
                .<Item, ItemComposite> chunk(10)
                .reader(itemReader())
                .processor(itemCompositeProcessor())
                .writer(writer)
                .build();
    }

    @Bean
    public Step merchandiseHierarchyCompositeStep(MerchandiseHierarchyCompositeWriter writer) {
        return stepBuilderFactory.get("merchandiseHierarchyCompositeStep")
                .<MerchandiseHierarchy, MerchandiseHierarchyComposite> chunk(10)
                .reader(merchandiseHierarchyReader())
                .processor(merchandiseHierarchyCompositeProcessor())
                .writer(writer)
                .build();
    }
}
