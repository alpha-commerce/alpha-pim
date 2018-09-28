package com.alpha.pim.mongo.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

  public Product() {
    super();
  }

  public Product(ObjectId id, String name, String species, String breed) {
    this.id = id;
    this.name = name;
    this.description = species;
    this.maxRetailPrice = breed;
  }

  @Id
  private ObjectId id;
  private String name;
  private String description;
  private String maxRetailPrice;

}
