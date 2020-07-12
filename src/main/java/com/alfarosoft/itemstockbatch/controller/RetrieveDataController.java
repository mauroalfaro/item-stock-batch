package com.alfarosoft.itemstockbatch.controller;

import com.alfarosoft.itemstockbatch.model.Item;
import com.alfarosoft.itemstockbatch.model.MerchandiseHierarchy;
import com.alfarosoft.itemstockbatch.service.ItemRetrieveService;
import com.alfarosoft.itemstockbatch.service.MerchandiseHierarchyRetrieveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/importedData")
public class RetrieveDataController {

    private final ItemRetrieveService itemRetrieveService;
    private final MerchandiseHierarchyRetrieveService merchandiseHierarchyRetrieveService;
    private static final Logger LOG = LoggerFactory.getLogger(RetrieveDataController.class);

    @Autowired
    public RetrieveDataController(ItemRetrieveService itemRetrieveService, MerchandiseHierarchyRetrieveService merchandiseHierarchyRetrieveService) {
        this.itemRetrieveService = itemRetrieveService;
        this.merchandiseHierarchyRetrieveService = merchandiseHierarchyRetrieveService;
    }

    @GetMapping(value = "/items", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Item>> searchItems(){
        LOG.info("Incoming items search request from RetrieveDataController");
        return ResponseEntity.status(HttpStatus.OK).body(itemRetrieveService.retrieveItems());
    }

    @GetMapping(value = "/merchandise", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MerchandiseHierarchy>> searchMerchandiseHierarchy(){
        LOG.info("Incoming merchandise search request from RetrieveDataController");
        return ResponseEntity.status(HttpStatus.OK).body(merchandiseHierarchyRetrieveService.retrieveMerchandiseHierarchy());
    }
}
