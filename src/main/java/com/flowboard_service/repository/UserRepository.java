package com.flowboard_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.flowboard_service.models.User;

public interface UserRepository extends MongoRepository<User,String> {
}
