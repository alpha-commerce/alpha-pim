package com.alpha.pim.mongo.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import com.alpha.pim.rest.entity.Product;

import lombok.Getter;
import lombok.Setter;

public class ProductMongoEntity {

  public ProductMongoEntity() {
    super();
  }

  public ProductMongoEntity(Product product) {
    this.name = product.getName();
    this.description = product.getDescription();
    this.maxRetailPrice = product.getMaxRetailPrice();
  }

  @Id
  @Getter
  private ObjectId id;

  @Getter
  @Setter
  private String name;

  @Getter
  @Setter
  private String description;

  @Getter
  @Setter
  private Long maxRetailPrice;
}
