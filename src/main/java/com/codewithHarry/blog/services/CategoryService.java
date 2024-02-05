package com.codewithHarry.blog.services;

import java.util.List;

import com.codewithHarry.blog.payloads.CategoryDto;

public interface CategoryService {

	 //create Category 
		public CategoryDto createCategory(CategoryDto caCategoryDto);
		
		//update
		CategoryDto updateCategoryDto(CategoryDto CategoryDto,Integer categoryId);
		
		//delete 
		void deleteCategory(Integer categoryId);
		
		//getBy Id 
		CategoryDto getcategory(Integer CategoryId);
		
		//getAll
		List<CategoryDto> getCategories();
}
