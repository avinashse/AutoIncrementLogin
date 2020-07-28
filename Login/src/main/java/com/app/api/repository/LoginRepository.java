package com.app.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.app.api.model.Login;

@Repository
public interface LoginRepository extends MongoRepository<Login, Long>{

}
