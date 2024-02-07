package com.codewithHarry.blog.services;

import java.util.List;

import com.codewithHarry.blog.entities.Post;
import com.codewithHarry.blog.payloads.PostDto;

public interface PostService {

	//create
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	//update
	PostDto updatePost(PostDto postDto);
	
	//delete
	void deletepost(Integer postId);
	
	//get All Post
	List<PostDto> getAllPost();

	//get single post
	Post getPostById(Integer postId);
	
	//get All posts by category
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	//get all posts by user
	List<PostDto> getPostsByuser(Integer userId);
	
	//search Post
	List<PostDto> searchPosts(String keyword);
}
