package com.nova.springSecurity.repository;

import com.nova.springSecurity.models.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<ApplicationUser,Integer> {

    Optional<ApplicationUser> findByUsername(String username);
}
