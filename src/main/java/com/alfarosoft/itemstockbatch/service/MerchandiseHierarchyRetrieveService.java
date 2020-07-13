package com.alfarosoft.itemstockbatch.service;

import com.alfarosoft.itemstockbatch.database.HibernateSessionFactory;
import com.alfarosoft.itemstockbatch.model.MerchandiseHierarchy;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MerchandiseHierarchyRetrieveService {
    private HibernateSessionFactory hibernateSessionFactory;
    private Session merchandiseSession;
    private static final Logger LOG = LoggerFactory.getLogger(MerchandiseHierarchyRetrieveService.class);

    public MerchandiseHierarchyRetrieveService(HibernateSessionFactory hibernateSessionFactory) throws Exception {
        this.hibernateSessionFactory = hibernateSessionFactory;
        this.merchandiseSession = hibernateSessionFactory.buildSession();
    }

    public List<MerchandiseHierarchy> retrieveMerchandiseHierarchy(){
        merchandiseSession.beginTransaction();
        List<MerchandiseHierarchy> merchandiseHierarchies = merchandiseSession.createQuery("from MerchandiseHierarchy", MerchandiseHierarchy.class).list();
        merchandiseSession.getTransaction().commit();
        LOG.info("Merchandise Hierarchies imported returned");
        return merchandiseHierarchies;
    }
}
