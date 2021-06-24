package com.commerce.inventory.controller;

import com.commerce.inventory.domain.Product;
import com.commerce.inventory.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.reactive.WebFluxLinkBuilder.methodOn;

@CrossOrigin(origins = "https://127.0.0.1:8000", maxAge = 3600)
@RestController
public class ProductController {
    private final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    CollectionModel<EntityModel<Product>> all() {
        List<EntityModel<Product>> employees = productRepository.findAll().stream()
                .map(employee -> {
                    try {
                        return EntityModel.of(employee,
                                linkTo(methodOn(ProductController.class).one(employee.getId())).withSelfRel(),
                                linkTo(methodOn(ProductController.class).all()).withRel("products"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .collect(Collectors.toList());

        return CollectionModel.of(employees, linkTo(methodOn(ProductController.class).all()).withSelfRel());
    }

    @GetMapping("/product/{id}")
    EntityModel<Product> one(@PathVariable Integer id) throws Exception {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new Exception("invalid"));
        return EntityModel.of(product,
                linkTo(methodOn(ProductController.class).one(id)).withSelfRel(),
                linkTo(methodOn(ProductController.class).all()).withRel("products"));
    }

    @GetMapping("/product/{sku}")
    EntityModel<Product> view(@PathVariable String sku) throws Exception {
        Product product = productRepository.findProductBySku(sku);
        if(product == null) {
            throw new Exception("Product Not Found");
        }
        return EntityModel.of(product,
                linkTo(methodOn(ProductController.class).one(product.getId())).withSelfRel(),
                linkTo(methodOn(ProductController.class).all()).withSelfRel());

    }

}
