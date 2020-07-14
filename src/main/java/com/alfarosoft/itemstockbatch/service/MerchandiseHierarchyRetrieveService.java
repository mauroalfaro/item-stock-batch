package com.alfarosoft.itemstockbatch.service;

import com.alfarosoft.itemstockbatch.database.HibernateSessionFactory;
import com.alfarosoft.itemstockbatch.model.MerchandiseHierarchy;
import com.alfarosoft.itemstockbatch.model.composites.MerchandiseHierarchyComposite;
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

    public List<MerchandiseHierarchyComposite> retrieveMerchandiseHierarchy(){
        merchandiseSession.beginTransaction();
        List<MerchandiseHierarchyComposite> merchandiseHierarchyComposites = merchandiseSession.createQuery("from MerchandiseHierarchyComposite", MerchandiseHierarchyComposite.class).list();
        merchandiseSession.getTransaction().commit();
        LOG.info("Merchandise Hierarchies imported returned");
        return merchandiseHierarchyComposites;
    }
}
