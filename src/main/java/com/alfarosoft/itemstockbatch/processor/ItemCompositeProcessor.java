package com.alfarosoft.itemstockbatch.processor;

import com.alfarosoft.itemstockbatch.model.Item;
import com.alfarosoft.itemstockbatch.model.composites.ItemComposite;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class ItemCompositeProcessor implements ItemProcessor<Item, ItemComposite> {
    private static final Logger log = LoggerFactory.getLogger(ItemCompositeProcessor.class);

    @Override
    public ItemComposite process(Item item) throws Exception {
        Integer sku = item.getSku();
        String name = item.getName();
        String description = item.getDescription();
        String longDescription = item.getLongDescription();
        String category = item.getCategory();
        Integer price = item.getPrice();
        String authorizedForSale = item.getAuthorizedForSale();

        ItemComposite itemComposite = new ItemComposite(sku, name, description, longDescription, category, price, authorizedForSale, java.time.LocalDate.now());

        return itemComposite;
    }
}
