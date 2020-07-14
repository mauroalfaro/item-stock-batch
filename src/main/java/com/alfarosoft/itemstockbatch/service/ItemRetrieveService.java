package com.alfarosoft.itemstockbatch.service;

import com.alfarosoft.itemstockbatch.database.HibernateSessionFactory;
import com.alfarosoft.itemstockbatch.model.Item;
import com.alfarosoft.itemstockbatch.model.composites.ItemComposite;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ItemRetrieveService {
    private HibernateSessionFactory hibernateSessionFactory;
    private Session itemSession;
    private static final Logger LOG = LoggerFactory.getLogger(ItemRetrieveService.class);

    public ItemRetrieveService(HibernateSessionFactory hibernateSessionFactory) throws Exception {
        this.hibernateSessionFactory = hibernateSessionFactory;
        this.itemSession = hibernateSessionFactory.buildSession();
    }

    public List<ItemComposite> retrieveItems(){
        itemSession.beginTransaction();
        List<ItemComposite> itemComposites = itemSession.createQuery("from ItemComposite", ItemComposite.class).list();
        itemSession.getTransaction().commit();
        LOG.info("Items imported returned");
        return itemComposites;
    }
}
