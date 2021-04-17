package com.commerce.inventory;

import com.commerce.inventory.service.CategoryService;
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

    @Autowired
    private CategoryService categoryService;

    public static void main(String[] args) {
        SpringApplication.run(InventoryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*createCategories("categories.json");
        createProducts("products.json");
        Optional<Product> p  = productService.getProductRepository().findProductBySku("B07NZYP9K5");
        Optional<Category> c = categoryService.getCategoryRepository().findCategoryById(1L);
        Product product =  new Product();
        if(p.isPresent()) {
            product = p.get();
        }
        productService.getProductRepository().save(product);*/
    }

    private void createCategories(String fileToImport) throws IOException {
        logger.info("Loading Categories");
        CategoryFromFile.read(fileToImport).forEach(importedCategory ->
            categoryService.createCategory(
                    importedCategory.getName(),
                    importedCategory.getShortDescription(),
                    importedCategory.getLongDescription(),
                    importedCategory.getActiveStartDate(),
                    importedCategory.getActiveEndDate(),
                    importedCategory.getMetaTitle(),
                    importedCategory.getLongDescription(),
                    importedCategory.getCanonicalUrl()
           ));
    }

    private void createProducts(String fileToImport) throws IOException {
        logger.info("Loading Products");
        ProductFromFile.read(fileToImport).forEach(importedProduct ->
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


    private static class CategoryFromFile {
        private String name, shortDescription, longDescription, metaTitle, metaDescription, canonicalUrl;
        private Date activeStartDate, activeEndDate, createdAt, updatedAt;

        static List<CategoryFromFile> read(String fileToImport) throws IOException {
            return new ObjectMapper().setVisibility(FIELD, ANY)
                    .readValue(new FileInputStream(fileToImport), new TypeReference<List<CategoryFromFile>>() {
                    });
        }

        private String getName() {
            return name;
        }

        private String getShortDescription() {
            return shortDescription;
        }

        private String getLongDescription() {
            return longDescription;
        }

        public String getMetaTitle() {
            return metaTitle;
        }

        public String getMetaDescription() {
            return metaDescription;
        }

        public String getCanonicalUrl() {
            return canonicalUrl;
        }

        public Date getActiveStartDate() {
            return activeStartDate;
        }

        public Date getActiveEndDate() {
            return activeEndDate;
        }

        public Date getCreatedAt() {
            return createdAt;
        }

        public Date getUpdatedAt() {
            return updatedAt;
        }
    }


}
