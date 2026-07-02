package com.rohit.blogmanagementapi_v2.controller;

import com.rohit.blogmanagementapi_v2.dto.PostDto;
import com.rohit.blogmanagementapi_v2.service.impl.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public PostDto createPost(@Valid @RequestBody PostDto postDto){
        return postService.createPost(postDto);
    }

    @GetMapping("/{id}")
    public PostDto getPostById(@PathVariable Long id){
        return postService.getPostById(id);
    }

    @GetMapping
    public List<PostDto> getAllPosts(){
        return postService.getAllPosts();
    }

    @PutMapping("/{id}")
    public PostDto updatePost(
            @RequestBody PostDto postDto,
            @PathVariable Long id) {

        return postService.updatePost(postDto, id);
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable Long id) {

        postService.deletePost(id);

        return "Post deleted successfully";
    }

}