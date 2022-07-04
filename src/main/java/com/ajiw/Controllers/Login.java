package com.ajiw.Controllers; 

import com.ajiw.entities.* ;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Login {

	
	String username; 
	String password; 
	User user;
	String token;
	String role;
	
	
}
