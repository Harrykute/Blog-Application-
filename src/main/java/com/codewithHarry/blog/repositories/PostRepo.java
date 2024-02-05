package com.codewithHarry.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithHarry.blog.entities.Category;
import com.codewithHarry.blog.entities.Post;
import com.codewithHarry.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{

	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
}
