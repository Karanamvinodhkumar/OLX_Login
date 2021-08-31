package com.user.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.user.entity.UserMongoEntity;

public interface UserMongoRepo extends MongoRepository<UserMongoEntity, Integer> {

}
