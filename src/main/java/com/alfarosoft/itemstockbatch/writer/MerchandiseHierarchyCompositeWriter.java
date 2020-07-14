package com.alfarosoft.itemstockbatch.writer;

import com.alfarosoft.itemstockbatch.database.HibernateSessionFactory;
import com.alfarosoft.itemstockbatch.model.composites.MerchandiseHierarchyComposite;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import javax.persistence.Query;
import java.util.List;

public class MerchandiseHierarchyCompositeWriter implements ItemWriter<MerchandiseHierarchyComposite> {
    private HibernateSessionFactory hibernateSessionFactory;
    private Session merchandiseSession;
    private static final Logger LOG = LoggerFactory.getLogger(MerchandiseHierarchyCompositeWriter.class);

    public MerchandiseHierarchyCompositeWriter(HibernateSessionFactory hibernateSessionFactory) throws Exception{
        this.hibernateSessionFactory = hibernateSessionFactory;
        this.merchandiseSession = hibernateSessionFactory.buildSession();
    }

    @Override
    public void write(List<? extends MerchandiseHierarchyComposite> list) throws Exception {
        LOG.info("Cleaning previous Merchandises from db");
        wipeDbData();
        LOG.info("Writing Merchandise hierarchies to database");
        for(MerchandiseHierarchyComposite merchandiseHierarchyComposite : list){
            merchandiseSession.beginTransaction();
            merchandiseSession.save(merchandiseHierarchyComposite);
            merchandiseSession.getTransaction().commit();
        }
    }

    private void wipeDbData(){
        merchandiseSession.beginTransaction();
        String stringQuery = "DELETE FROM MerchandiseHierarchyComposite";
        Query query = merchandiseSession.createQuery(stringQuery);
        query.executeUpdate();
        merchandiseSession.getTransaction().commit();
    }
}
