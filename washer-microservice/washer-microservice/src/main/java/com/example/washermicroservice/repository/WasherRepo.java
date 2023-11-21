package com.example.washermicroservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.washermicroservice.model.Washer;

@Repository
public interface WasherRepo extends MongoRepository<Washer, Integer>{

}
