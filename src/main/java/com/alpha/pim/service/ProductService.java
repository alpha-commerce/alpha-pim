package com.alpha.pim.service;

import java.util.List;

import com.alpha.pim.rest.entity.Product;

public interface ProductService {
  Product createProduct(Product product);

  List<Product> findAllProduct();

  Product findProduct(String id);

  Product updateProduct(String id, Product product);

  Product deleteProduct(String id);

  Product updateProductDetails(String id, Product product);
}
