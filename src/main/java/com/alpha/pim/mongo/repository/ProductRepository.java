package com.alpha.pim.mongo.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.alpha.pim.mongo.entity.ProductMongoEntity;

public interface ProductRepository extends MongoRepository<ProductMongoEntity, String> {
  ProductMongoEntity findById(ObjectId id);
}
