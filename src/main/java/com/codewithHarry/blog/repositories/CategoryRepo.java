package com.codewithHarry.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithHarry.blog.entities.Category;
import com.codewithHarry.blog.payloads.CategoryDto;

public interface CategoryRepo extends JpaRepository<Category,Integer>{
            
}
