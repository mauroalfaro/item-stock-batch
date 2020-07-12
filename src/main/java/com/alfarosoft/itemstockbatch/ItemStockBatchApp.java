package com.alfarosoft.itemstockbatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.alfarosoft.itemstockbatch")
public class ItemStockBatchApp {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ItemStockBatchApp.class, args);
    }
}
