package com.alfarosoft.itemstockbatch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

public class ItemJobListener extends JobExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(ItemJobListener.class);

    @Override
    public void afterJob(JobExecution jobExecution) {
        //TODO check job completion
    }
}
