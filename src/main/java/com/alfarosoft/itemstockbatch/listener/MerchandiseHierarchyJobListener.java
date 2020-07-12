package com.alfarosoft.itemstockbatch.listener;

import com.alfarosoft.itemstockbatch.service.MerchandiseHierarchyRetrieveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MerchandiseHierarchyJobListener extends JobExecutionListenerSupport {
    private final MerchandiseHierarchyRetrieveService merchandiseHierarchyRetrieveService;
    private static final Logger log = LoggerFactory.getLogger(MerchandiseHierarchyJobListener.class);

    @Autowired
    public MerchandiseHierarchyJobListener(MerchandiseHierarchyRetrieveService merchandiseHierarchyRetrieveService) {
        this.merchandiseHierarchyRetrieveService = merchandiseHierarchyRetrieveService;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("Merchandise hierarchy import job finished successfully");
            log.info("Merchandise hierarchies imported: ",merchandiseHierarchyRetrieveService.retrieveMerchandiseHierarchy());
        }
        else {
            log.error("Merchandise hierarchy import incomplete with status: " + jobExecution.getStatus().name());
        }
    }

}
