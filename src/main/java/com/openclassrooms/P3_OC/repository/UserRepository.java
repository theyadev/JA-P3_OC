package com.openclassrooms.P3_OC.repository;

import com.openclassrooms.P3_OC.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}