package com.ajiw.Controllers; 

import java.util.List;

import com.ajiw.entities.Declaration;
import com.ajiw.entities.User;
import org.springframework.stereotype.Service;


@Service
public interface ServiceU {

	public User Login(String username, String password);
	public Declaration saveDec(Declaration dec);
	public Declaration getDec(Long id);
	public List<Declaration> getAllDec();
	 
    
	
}
