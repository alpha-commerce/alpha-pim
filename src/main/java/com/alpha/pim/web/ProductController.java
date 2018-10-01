package com.alpha.pim.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.pim.mongo.entity.ProductMongoEntity;
import com.alpha.pim.mongo.repository.ProductRepository;
import com.alpha.pim.rest.entity.Product;

import io.swagger.annotations.Api;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;

@RestController
@RequestMapping("/products")
@SwaggerDefinition(info = @Info(title = "PIM Microservice", version = "v8.0",
  description = "Using PIM service products api, you can create, get, update, delete and "
    + "list all products"))
@Api(value = "Product", tags = "Product")
public class ProductController {
  @Autowired
  private ProductRepository repository;

  @PostMapping
  public Product createProduct(@RequestBody Product product) {
    return new Product(repository.save(new ProductMongoEntity(product)));
  }
}
