package com.codewithHarry.blog.exception;

import lombok.Getter;
import lombok.Setter;

// creating Exception for resource not found means user or any resource not Found 

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{

	String resourceName;
	String fieldName;
	long fieldvalue;
	
	
	public ResourceNotFoundException(String resourceName, String fieldName, long fieldvalue) {
		super(String.format("%s not found with %s : %s",resourceName,fieldName,fieldvalue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldvalue = fieldvalue;
	}
}
