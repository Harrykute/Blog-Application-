package com.codewithHarry.blog.services;

import java.util.List;

import com.codewithHarry.blog.entities.Post;
import com.codewithHarry.blog.payloads.PostDto;

public interface PostService {

	//create
	Post createPost(PostDto postDto);
	
	//update
	Post updatePost(PostDto postDto);
	
	//delete
	void deletepost(Integer postId);
	
	//get All Post
	List<Post> getAllPost();

	//get single post
	Post getPostById(Integer postId);
	
	//get All posts by category
	List<Post> getPostsByCategory(Integer categoryId);
	
	//get all posts by user
	List<Post> getPostsByuser(Integer userId);
	
	//search Post
	List<Post> searchPosts(String keyword);
}
