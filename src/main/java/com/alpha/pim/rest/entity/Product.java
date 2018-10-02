package com.alpha.pim.rest.entity;

import org.springframework.data.annotation.Id;

import com.alpha.pim.mongo.entity.ProductMongoEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

  public Product() {
    super();
  }

  public Product(ProductMongoEntity product) {
    this.id = product.getId().toHexString();
    this.name = product.getName();
    this.description = product.getDescription();
    this.maxRetailPrice = product.getMaxRetailPrice();
  }

  @Id
  private String id;
  private String name;
  private String description;
  private Long maxRetailPrice;

}
