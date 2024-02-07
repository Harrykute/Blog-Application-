package com.codewithHarry.blog.services.impl;

import java.util.Date;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithHarry.blog.entities.Category;
import com.codewithHarry.blog.entities.Post;
import com.codewithHarry.blog.entities.User;
import com.codewithHarry.blog.exception.ResourceNotFoundException;
import com.codewithHarry.blog.payloads.PostDto;
import com.codewithHarry.blog.repositories.CategoryRepo;
import com.codewithHarry.blog.repositories.PostRepo;
import com.codewithHarry.blog.repositories.UserRepo;
import com.codewithHarry.blog.services.PostService;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	private PostRepo postRepo;
	
	
	@Autowired
	private ModelMapper modelmapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryrepo; 
	
	
	@Override
	public PostDto createPost(PostDto postDto,Integer userId , Integer categoryId) {
		
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "User id",userId));
		
		Category category = this.categoryrepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category ", "Category Id",categoryId));
		
		
		Post post = this.modelmapper.map(postDto,Post.class);
		post.setImagename("defualt.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		
		Post newPost = this.postRepo.save(post);
		return this.modelmapper.map(newPost,PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto) {
		
		return null;
	}

	@Override
	public void deletepost(Integer postId) {
		
		
	}

	@Override
	public List<PostDto> getAllPost() {
	
		return null;
	}

	@Override
	public Post getPostById(Integer postId) {
		
		return null;
	}

	@Override
	public List<PostDto> getPostsByCategory(Integer categoryId) {
		
		return null;
	}

	@Override
	public List<PostDto> getPostsByuser(Integer userId) {
		
		return null;
	}

	@Override
	public List<PostDto> searchPosts(String keyword) {
		
		return null;
	}

	
}
