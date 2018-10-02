package com.alpha.pim.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.pim.rest.entity.Product;
import com.alpha.pim.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;

@RestController
@RequestMapping("/products")
@SwaggerDefinition(info = @Info(title = "PIM Microservice", version = "v0.1",
  description = "Using PIM service products api, you can create, get, update, delete and list all products"))
@Api(value = "Product", tags = "Product")
public class ProductController {
  @Autowired
  private ProductService service;

  @PostMapping
  public Product createProduct(@RequestBody Product product) {
    return service.createProduct(product);
  }

  @GetMapping
  public List<Product> finAllProduct() {
    return service.findAllProduct();
  }

  @GetMapping("/{id}")
  public Product findProduct(@PathVariable("id") String id) {
    return service.findProduct(id);
  }

  @PutMapping("/{id}")
  public Product updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
    return service.updateProduct(id, product);
  }

  @PatchMapping("/{id}")
  public Product updateProductDetails(@PathVariable("id") String id, @RequestBody Product product) {
    return service.updateProductDetails(id, product);
  }

  @DeleteMapping("/{id}")
  public Product deleteProduct(@PathVariable("id") String id) {
    return service.deleteProduct(id);
  }
}
