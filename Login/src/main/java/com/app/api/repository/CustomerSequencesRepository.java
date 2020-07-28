package com.app.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.api.model.CustomSequences;

@Repository
public interface CustomerSequencesRepository extends MongoRepository<CustomSequences, String>{
}
