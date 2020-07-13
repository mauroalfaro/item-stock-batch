package com.alfarosoft.itemstockbatch.writer;

import com.alfarosoft.itemstockbatch.database.HibernateSessionFactory;
import com.alfarosoft.itemstockbatch.model.composites.ItemComposite;
import com.alfarosoft.itemstockbatch.service.ItemRetrieveService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class ItemCompositeWriter implements ItemWriter<ItemComposite> {
    private HibernateSessionFactory hibernateSessionFactory;
    private Session itemSession;
    private static final Logger LOG = LoggerFactory.getLogger(ItemCompositeWriter.class);

    public ItemCompositeWriter(HibernateSessionFactory hibernateSessionFactory) throws Exception{
        this.hibernateSessionFactory = hibernateSessionFactory;
        this.itemSession = hibernateSessionFactory.buildSession();
    }

    @Override
    public void write(List<? extends ItemComposite> list) throws Exception {
        LOG.info("Writing Items to database");
        for(ItemComposite itemComposite : list){
            itemSession.beginTransaction();
            itemSession.save(itemComposite);
            itemSession.getTransaction().commit();
        }
    }
}
