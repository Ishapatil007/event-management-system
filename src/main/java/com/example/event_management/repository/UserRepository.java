package com.example.event_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.event_management.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByEmail(String email);
}