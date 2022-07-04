package com.ajiw.Controllers; 

import java.util.List;

import com.ajiw.entities.Declaration;
import com.ajiw.entities.User; 



public interface ServiceU {

	public User Login(String username, String password);
	public Declaration saveDec(Declaration dec);
	public Declaration getDec(int id);
	public List<Declaration> getAllDec();
	 
    
	
}
