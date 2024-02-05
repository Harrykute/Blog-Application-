package com.codewithHarry.blog.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

	private Integer categoryId;
	
	@NotBlank
	@Size(min=4 , message="Min size of CategoryTitle is 4 ")
	private String categoryTitle;
	 
	@NotBlank
	@Size(min=10 , message="Min size of CategoryDescription is 10 ")
	private String categoryDescription; 
}
