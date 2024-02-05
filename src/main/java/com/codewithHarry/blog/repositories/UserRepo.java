package com.codewithHarry.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithHarry.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
