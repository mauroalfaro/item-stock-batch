package com.alfarosoft.itemstockbatch.listener;

import com.alfarosoft.itemstockbatch.service.ItemRetrieveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemJobListener extends JobExecutionListenerSupport {

    private final ItemRetrieveService itemRetrieveService;
    private static final Logger log = LoggerFactory.getLogger(ItemJobListener.class);

    @Autowired
    public ItemJobListener(ItemRetrieveService itemRetrieveService) {
        this.itemRetrieveService = itemRetrieveService;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("Items import job finished successfully");
            log.info("Items imported: {}",itemRetrieveService.retrieveItems());
        }
        else {
            log.error("Items import incomplete with status: " + jobExecution.getStatus().name());
        }
    }

}
