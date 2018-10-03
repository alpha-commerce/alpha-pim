package com.alpha.pim.service.mongo.impl;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.alpha.pim.mongo.entity.ProductMongoEntity;
import com.alpha.pim.mongo.repository.ProductRepository;
import com.alpha.pim.rest.entity.Product;
import com.alpha.pim.service.ProductService;

@ConditionalOnProperty(prefix = "product", name = "database.impl", havingValue = "MONGO")
@Service
public class ProductMongoServiceImpl implements ProductService {

  @Autowired
  private ProductRepository repository;

  public ProductMongoServiceImpl() {
    super();
  }

  @Override
  public Product createProduct(Product product) {
    return new Product(repository.save(new ProductMongoEntity(product)));
  }

  @Override
  public List<Product> findAllProduct() {
    return makeResponseList(repository.findAll());
  }

  @Override
  public Product findProduct(String id) {
    return new Product(repository.findById(new ObjectId(id)));
  }

  @Override
  public Product updateProduct(String id, Product product) {
    ProductMongoEntity productEntity = repository.findById(new ObjectId(id));
    if (product != null && product.getId() != null) {
      return new Product(repository.save(productEntity));
    } else {
      return null;
    }
  }

  @Override
  public Product updateProductDetails(String id, Product product) {
    ProductMongoEntity productEntity = repository.findById(new ObjectId(id));
    if (productEntity != null && productEntity.getId() != null) {
      String name = product.getName();
      if (name != null && !name.isEmpty()) {
        productEntity.setName(name);
      }
      String description = product.getDescription();
      if (description != null && !description.isEmpty()) {
        productEntity.setDescription(description);
      }
      Long maxRetailPrice = product.getMaxRetailPrice();
      if (maxRetailPrice != null && maxRetailPrice > 0L) {
        productEntity.setMaxRetailPrice(maxRetailPrice);
      }
      return new Product(repository.save(productEntity));
    } else {
      return null;
    }
  }

  @Override
  public Product deleteProduct(String id) {
    ProductMongoEntity product = repository.findById(new ObjectId(id));
    if (product != null && product.getId() != null) {
      repository.delete(product);
      return new Product(product);
    } else {
      return null;
    }
  }

  private static List<Product> makeResponseList(List<ProductMongoEntity> products) {
    List<Product> response = new ArrayList<>();
    products.forEach(product -> response.add(new Product(product)));
    return response;
  }

}
