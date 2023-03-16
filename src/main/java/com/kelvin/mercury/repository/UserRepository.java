package com.kelvin.mercury.repository;

import com.kelvin.mercury.model.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends ListCrudRepository<User, Long> {
    Optional<User> findByMobileNumber(String mobileNumber);
}
