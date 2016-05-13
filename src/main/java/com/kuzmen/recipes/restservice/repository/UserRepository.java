package com.kuzmen.recipes.restservice.repository;

import com.kuzmen.recipes.restservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

}
