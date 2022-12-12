package org.frakin.Application.Repository;

import org.frakin.Application.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
