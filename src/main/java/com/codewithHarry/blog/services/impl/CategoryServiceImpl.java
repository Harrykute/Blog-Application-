package com.codewithHarry.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithHarry.blog.entities.Category;
import com.codewithHarry.blog.exception.ResourceNotFoundException;
import com.codewithHarry.blog.payloads.CategoryDto;
import com.codewithHarry.blog.repositories.CategoryRepo;
import com.codewithHarry.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category cat = this.modelMapper.map(categoryDto,Category.class);
		Category addedCat =this.categoryRepo.save(cat);
		return this.modelMapper.map(addedCat,CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategoryDto(CategoryDto categoryDto,Integer categoryId) {
		Category cat =this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","Category Id",categoryId));
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category updatedCat = this.categoryRepo.save(cat);
		return this.modelMapper.map(updatedCat, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","Category Id", categoryId));	
		this.categoryRepo.delete(cat);

	}

	@Override
	public CategoryDto getcategory(Integer categoryId) {
		
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","Category Id",categoryId));
		
		return this.modelMapper.map(cat,CategoryDto.class); //   whatever data will get it will convert into category DTO 
	}

	@Override
	public List<CategoryDto> getCategories() {
	
		List<Category> catogories = this.categoryRepo.findAll();
		List<CategoryDto> catDtos = catogories.stream().map((cat)-> this.modelMapper.map(cat,CategoryDto.class)).collect(Collectors.toList());
		return catDtos;
	}

}
