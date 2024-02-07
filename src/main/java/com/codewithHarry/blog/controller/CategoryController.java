package com.codewithHarry.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithHarry.blog.payloads.ApiResponse;
import com.codewithHarry.blog.payloads.CategoryDto;
import com.codewithHarry.blog.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	//create 
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto cateogoryDto){
		
		CategoryDto createCategory = this.categoryService.createCategory(cateogoryDto);
		return new ResponseEntity<CategoryDto>(createCategory,HttpStatus.CREATED);
	}
	
	//update
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto cateogDto , @PathVariable Integer catId){
		CategoryDto updateCategory = this.categoryService.updateCategoryDto(cateogDto,catId);
		return new ResponseEntity<CategoryDto>(updateCategory,HttpStatus.OK);
	}
	
	// delete 
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@RequestBody CategoryDto cateogDto , @PathVariable Integer catId){
		 this.categoryService.deleteCategory(catId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted succesfully" , false),HttpStatus.OK);
	}
	
	//get 
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer catId){
		 CategoryDto categoryDto = this.categoryService.getcategory(catId);
		return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);
	}
	
	//getAll 
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getCategoryAll(){
		List<CategoryDto> categoryDto = this.categoryService.getCategories();
		return new ResponseEntity<List<CategoryDto>>(categoryDto,HttpStatus.OK);
	}
}
