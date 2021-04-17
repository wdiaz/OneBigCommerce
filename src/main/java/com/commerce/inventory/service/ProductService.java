package com.commerce.inventory.service;

import com.commerce.inventory.domain.Product;
import com.commerce.inventory.domain.ProductCategory;
import com.commerce.inventory.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * The type Product service.
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(String sku, String name, String shortDescription, String longDescription, boolean isDownload, boolean isPublished, Date activeStartDate, Date activeEndDate,
                                 String manufacturer, Long width, Long height, Long depth, String metaTitle, String metaDescription, String canonicalUrl) {
        logger.info("Loading product: " + sku);
        return productRepository.findProductBySku(sku).orElse(
                productRepository.save(new Product(sku, name, shortDescription, longDescription, isDownload, isPublished, activeStartDate, activeEndDate, manufacturer,
                        width,
                        height,
                        depth,
                        metaTitle,
                        metaDescription,
                        canonicalUrl
                ))
        );
    }

    /**
     * Lookup for product
     *
     * @return all products
     */
    public Iterable<Product> lookup() {
        return productRepository.findAll();
    }

    public Long total() {
        return productRepository.count();
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }
}
