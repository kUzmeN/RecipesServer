package com.kuzmen.recipes.restservice.repository;


import com.kuzmen.recipes.restservice.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository  extends JpaRepository<Comment,Integer>{
}
