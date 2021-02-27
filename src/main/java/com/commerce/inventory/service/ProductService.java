package com.commerce.inventory.service;

import com.commerce.inventory.domain.Product;
import com.commerce.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * The type Product service.
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /*public Product createProduct(String sku, String name, String shortDescription, String longDescription, boolean isDownload, boolean isPublished, Date activeStartDate, Date activeEndDate,
                                 String manufacturer, Long width, Long height, Long depth, String metaTitle, String metaDescription, String canonicalUrl) {
        return productRepository.findById(1L).orElse(
                productRepository.save(new Product(sku, name, shortDescription, longDescription, isDownload, isPublished, activeStartDate, activeEndDate, manufacturer,
                        width,
                        height,
                        depth,
                        metaTitle,
                        metaDescription,
                        canonicalUrl
                ))
        );
    }*/

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
}
