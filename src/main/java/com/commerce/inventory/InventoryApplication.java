package com.commerce.inventory;

import com.commerce.inventory.service.ProductService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ProductService productService;

    public static void main(String[] args) {
        SpringApplication.run(InventoryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        createProducts("products.json");
    }

    private void createProducts(String fileToImport) throws IOException {
        this.logger.info("Creating products");

        ProductFromFile.read(fileToImport).forEach(importedProduct ->
                //logger.info(importedProduct.toString())
                productService.createProduct(
                        importedProduct.getSku(),
                        importedProduct.getName(),
                        importedProduct.getShortDescription(),
                        importedProduct.getLongDescription(),
                        importedProduct.isDownload(),
                        importedProduct.isPublished(),
                        importedProduct.getActiveStartDate(),
                        importedProduct.getActiveEndDate(),
                        importedProduct.getManufacturer(),
                        importedProduct.getWidth(),
                        importedProduct.getHeight(),
                        importedProduct.getDepth(),
                        importedProduct.getMetaTitle(),
                        importedProduct.getMetaDescription(),
                        importedProduct.getCanonicalUrl()
                        ));
    }

    private static class ProductFromFile {
        private String sku, name, shortDescription, longDescription, manufacturer, metaTitle, metaDescription, canonicalUrl;
        private boolean isDownload, isPublished;
        private Date activeStartDate, activeEndDate;
        private Long width, height, depth;

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

        private String getManufacturer() {
            return manufacturer;

        }
        private Long getWidth() {
            return width;
        }
        private Long getHeight() {
            return height;
        }
        private Long getDepth() {
            return depth;
        }
        private String getMetaTitle() {
            return metaTitle;
        }
        private String getMetaDescription() {
            return metaDescription;
        }
        private String getCanonicalUrl() {
            return canonicalUrl;
        }

        @Override
        public String toString() {
            return "ProductFromFile{" +
                    "sku='" + sku + '\'' +
                    ", name='" + name + '\'' +
                    ", shortDescription='" + shortDescription + '\'' +
                    ", longDescription='" + longDescription + '\'' +
                    ", manufacturer='" + manufacturer + '\'' +
                    ", metaTitle='" + metaTitle + '\'' +
                    ", metaDescription='" + metaDescription + '\'' +
                    ", canonicalUrl='" + canonicalUrl + '\'' +
                    ", isDownload=" + isDownload +
                    ", isPublished=" + isPublished +
                    ", activeStartDate=" + activeStartDate +
                    ", activeEndDate=" + activeEndDate +
                    ", width=" + width +
                    ", height=" + height +
                    ", depth=" + depth +
                    '}';
        }
    }
}
