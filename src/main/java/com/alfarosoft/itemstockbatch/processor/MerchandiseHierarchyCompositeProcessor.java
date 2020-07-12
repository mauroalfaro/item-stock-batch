package com.alfarosoft.itemstockbatch.processor;

import com.alfarosoft.itemstockbatch.model.MerchandiseHierarchy;
import com.alfarosoft.itemstockbatch.model.composites.MerchandiseHierarchyComposite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;


public class MerchandiseHierarchyCompositeProcessor implements ItemProcessor<MerchandiseHierarchy, MerchandiseHierarchyComposite> {
    private static final Logger log = LoggerFactory.getLogger(MerchandiseHierarchyCompositeProcessor.class);

    @Override
    public MerchandiseHierarchyComposite process(MerchandiseHierarchy merchandiseHierarchy) throws Exception {
        String division = merchandiseHierarchy.getDivision();
        String group = merchandiseHierarchy.getGroup();
        String department = merchandiseHierarchy.getDepartment();
        String merchandiseClass = merchandiseHierarchy.getMerchandiseClass();
        String category = merchandiseHierarchy.getCategory();

        MerchandiseHierarchyComposite merchandiseHierarchyComposite = new MerchandiseHierarchyComposite(division, group, department, merchandiseClass, category, java.time.LocalDate.now());

        return merchandiseHierarchyComposite;
    }
}
