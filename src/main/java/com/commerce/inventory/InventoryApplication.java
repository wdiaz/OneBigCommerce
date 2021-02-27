package com.commerce.inventory;

import com.commerce.inventory.service.ProductService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;

@SpringBootApplication
public class InventoryApplication implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private ProductService productService;

    public static void main(String[] args) {
        SpringApplication.run(InventoryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // createProducts("products.json");
    }

    /*private void createProducts(String fileToImport) throws IOException {
        this.logger.info("Creating products");

        ProductFromFile.read(fileToImport).forEach(importedProduct ->
                productService.createProduct(
                        importedProduct.getSku(),
                        importedProduct.getName(),
                        importedProduct.getShortDescription(),
                        importedProduct.getLongDescription(),
                        importedProduct.isDownload(),
                        importedProduct.isPublished(),
                        importedProduct.getActiveStartDate(),
                        importedProduct.getActiveEndDate()
                        ));
    }*/

    private static class ProductFromFile {
        private String sku, name, shortDescription, longDescription;
        private boolean isDownload, isPublished;
        private Date activeStartDate, activeEndDate;

        static List<ProductFromFile> read(String fileToImport) throws IOException {
            return new ObjectMapper().setVisibility(FIELD, ANY)
                    .readValue(new FileInputStream(fileToImport), new TypeReference<List<ProductFromFile>>() {
                    });
        }


        String getSku() {
            return sku;
        }


        String getName() {
            return name;
        }


        String getShortDescription() {
            return shortDescription;
        }

        String getLongDescription() {
            return longDescription;
        }

        boolean isDownload() {
            return isDownload;
        }

        boolean isPublished() {
            return isPublished;
        }

        Date getActiveStartDate() {
            return activeStartDate;
        }

        Date getActiveEndDate() {
            return activeEndDate;
        }
    }
}
