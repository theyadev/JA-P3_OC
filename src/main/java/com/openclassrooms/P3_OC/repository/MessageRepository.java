package com.openclassrooms.P3_OC.repository;

import com.openclassrooms.P3_OC.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
}