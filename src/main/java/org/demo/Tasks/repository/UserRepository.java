package org.demo.Tasks.repository;

import org.demo.Tasks.model.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("SELECT * FROM user WHERE username = :username AND password = :password")
    public Optional<User> getUserByUsernameAndPassword(String username, String password);

}
