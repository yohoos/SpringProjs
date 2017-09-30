package com.project.repository;

import com.project.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yohoos on 5/12/17.
 */
@Repository()
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
