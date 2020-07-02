package com.alfarosoft.itemstockbatch.processor;

import com.alfarosoft.itemstockbatch.model.MerchandiseHierarchy;
import com.alfarosoft.itemstockbatch.model.composites.ItemComposite;
import com.alfarosoft.itemstockbatch.model.composites.MerchandiseHierarchyComposite;
import org.springframework.batch.item.ItemProcessor;

import java.util.Date;

public class MerchandiseHierarchyCompositeProcessor implements ItemProcessor<MerchandiseHierarchy, MerchandiseHierarchyComposite> {
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
