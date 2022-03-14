package com.watabelabs.api.repository;

import com.watabelabs.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** UserRepository */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
