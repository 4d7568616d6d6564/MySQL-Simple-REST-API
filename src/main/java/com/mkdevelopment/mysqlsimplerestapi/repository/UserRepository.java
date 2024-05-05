package com.mkdevelopment.mysqlsimplerestapi.repository;


import com.mkdevelopment.mysqlsimplerestapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}