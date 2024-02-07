package com.codewithHarry.blog.payloads;

import java.util.Date;

import com.codewithHarry.blog.entities.Category;
import com.codewithHarry.blog.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {

	
	private String title;
	
	private String content;
	
	private String imageName ; 
	
	private Date addedDate;
	
	private Category category;
	
	private User user;
}
