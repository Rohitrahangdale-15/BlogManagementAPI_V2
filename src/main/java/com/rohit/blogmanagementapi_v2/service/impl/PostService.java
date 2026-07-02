package com.rohit.blogmanagementapi_v2.service.impl;

import com.rohit.blogmanagementapi_v2.dto.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);

    PostDto getPostById(Long id);

    List<PostDto> getAllPosts();

    PostDto updatePost(PostDto postDto, Long id);

    void deletePost(Long id);
}