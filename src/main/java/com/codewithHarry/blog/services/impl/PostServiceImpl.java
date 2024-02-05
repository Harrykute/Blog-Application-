package com.codewithHarry.blog.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithHarry.blog.entities.Post;
import com.codewithHarry.blog.payloads.PostDto;
import com.codewithHarry.blog.repositories.PostRepo;
import com.codewithHarry.blog.services.PostService;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelmapper;
	
	@Override
	public Post createPost(PostDto postDto) {
		
		Post post = this.modelmapper.map(postDto,Post.class);
		
		
		return null;
	}

	@Override
	public Post updatePost(PostDto postDto) {
		
		return null;
	}

	@Override
	public void deletepost(Integer postId) {
		
		
	}

	@Override
	public List<Post> getAllPost() {
	
		return null;
	}

	@Override
	public Post getPostById(Integer postId) {
		
		return null;
	}

	@Override
	public List<Post> getPostsByCategory(Integer categoryId) {
		
		return null;
	}

	@Override
	public List<Post> getPostsByuser(Integer userId) {
		
		return null;
	}

	@Override
	public List<Post> searchPosts(String keyword) {
		
		return null;
	}

	
}
