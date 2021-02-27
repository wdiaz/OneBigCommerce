package com.commerce.inventory.service;

import com.commerce.inventory.domain.Product;
import com.commerce.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Product createProduct(String sku, String name, String shortDescription, String longDescription, boolean isDownload, boolean isPublished) {
        return productRepository.findById(1L).orElse(
                productRepository.save(new Product(sku, name, shortDescription, longDescription, isDownload, isPublished))
        );
        //new Product(sku, name, shortDescription, longDescription, isDownload, isPublished)
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
}
