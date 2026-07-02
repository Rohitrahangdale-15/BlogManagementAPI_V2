package com.rohit.blogmanagementapi_v2.service.impl;

import com.rohit.blogmanagementapi_v2.dto.PostDto;
import com.rohit.blogmanagementapi_v2.entity.Post;
import com.rohit.blogmanagementapi_v2.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import com.rohit.blogmanagementapi_v2.exception.ResourceNotFoundException;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public PostDto createPost(PostDto postDto) {

        // Convert DTO to Entity
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());

        // Save in database
        Post savedPost = postRepository.save(post);

        // Convert Entity to DTO
        PostDto postDto1 = new PostDto();
        postDto1.setId(savedPost.getId());
        postDto1.setTitle(savedPost.getTitle());
        postDto1.setContent(savedPost.getContent());

        return postDto1;
    }

    @Override
    public PostDto getPostById(Long id) {

        Post post = postRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Post not found with id : " + id));

        PostDto postDto = new PostDto();

        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());

        return postDto;
    }

    @Override
    public List<PostDto> getAllPosts() {

        List<Post> posts = postRepository.findAll();

        List<PostDto> postDtos = new ArrayList<>();

        for(Post post : posts){

            PostDto dto = new PostDto();

            dto.setId(post.getId());
            dto.setTitle(post.getTitle());
            dto.setContent(post.getContent());

            postDtos.add(dto);
        }

        return postDtos;
    }

    @Override
    public PostDto updatePost(PostDto postDto, Long id) {

        Post post = postRepository.findById(id).get();

        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());

        Post updatedPost = postRepository.save(post);

        PostDto response = new PostDto();

        response.setId(updatedPost.getId());
        response.setTitle(updatedPost.getTitle());
        response.setContent(updatedPost.getContent());

        return response;
    }

    @Override
    public void deletePost(Long id) {

        Post post = postRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Post not found with id : " + id));

        postRepository.delete(post);
    }
}