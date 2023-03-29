package com.codeup.codeupspringblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findById(long id);
//    List<Post> findByTitle(String title);
//
//    List<Post> findByBody(String body);


}
