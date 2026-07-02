package com.rohit.blogmanagementapi_v2.repository;

import com.rohit.blogmanagementapi_v2.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}