package com.alpha.pim.mongo.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import com.alpha.pim.rest.entity.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductMongoEntity {

  public ProductMongoEntity() {
    super();
  }

  public ProductMongoEntity(ObjectId id, Product product) {
    this.id = id;
    this.name = product.getName();
    this.description = product.getDescription();
    this.maxRetailPrice = product.getMaxRetailPrice();
  }

  public ProductMongoEntity(Product product) {
    this.name = product.getName();
    this.description = product.getDescription();
    this.maxRetailPrice = product.getMaxRetailPrice();
  }

  @Id
  private ObjectId id;
  private String name;
  private String description;
  private String maxRetailPrice;
}
