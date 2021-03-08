package com.commerce.inventory.controller;

import com.commerce.inventory.domain.Product;
import com.commerce.inventory.repository.CategoryRepository;
import com.commerce.inventory.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "products")
public class ProductController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public ProductController(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    protected ProductController() {
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    @ExceptionHandler(DuplicateKeyException.class)
    public Product create(@RequestBody Product newProduct) {
        logger.info("Saving sku:" + newProduct.getSku());
        /**
         *  this function is not functional yet
         return productRepository.findProductBySku(product.getSku())
         .map( newProduct -> {
         return productRepository.save(newProduct);
         }).orElseThrow(() -> new DuplicateKeyException("Product Already Exist: " + product.getSku()));
         */
        //return productRepository.save(product);
        productRepository.findProductBySku(newProduct.getSku()).ifPresent(s -> {
            throw new DuplicateKeyException("already in the database");
        });
        return productRepository.save(newProduct);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Product update(@RequestBody Product newProduct) {
        logger.info("updating Product" + newProduct);
        return productRepository.findProductBySku(newProduct.getSku())
                .map((product) -> {
                    product.setName(newProduct.getName());
                    product.setShortDescription(newProduct.getShortDescription());
                    product.setLongDescription(newProduct.getLongDescription());
                    product.setDownload(newProduct.isDownload());
                    product.setPublished(newProduct.isPublished());
                    product.setActiveStartDate(newProduct.getActiveStartDate());
                    product.setActiveEndDate(newProduct.getActiveEndDate());
                    product.setManufacturer(newProduct.getManufacturer());
                    product.setWidth(newProduct.getWidth());
                    product.setHeight(newProduct.getHeight());
                    product.setDepth(newProduct.getDepth());
                    product.setMetaTitle(newProduct.getMetaTitle());
                    product.setMetaDescription(newProduct.getMetaDescription());
                    product.setCanonicalUrl(newProduct.getCanonicalUrl());
                    return productRepository.save(product);
                }).orElseThrow(() -> new NoSuchElementException("Product not found: " + newProduct.getSku()));
    }

    @GetMapping("/{sku}/sku")
    @ResponseStatus(HttpStatus.FOUND)
    public Product view(@PathVariable(value = "sku") String sku) throws NoSuchElementException {
        return productRepository.findProductBySku(sku).orElseThrow(() -> new NoSuchElementException("Product Does not Exist: " + sku));
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    private String return400(NoSuchElementException ex) {
        return ex.getMessage();
    }

    private Product verifyProductExist(String sku) throws NoSuchElementException {
        return productRepository.findProductBySku(sku).orElseThrow(() -> new NoSuchElementException("Product Does not exist: " + sku));
    }
}
