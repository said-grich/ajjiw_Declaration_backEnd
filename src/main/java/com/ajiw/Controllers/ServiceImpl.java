package com.ajiw.Controllers;   
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.ajiw.Repositories.DeclarationRepository;
import com.ajiw.Repositories.UserRespository;
import com.ajiw.entities.Declaration;
import com.ajiw.entities.User;
   

 
@Service
public class ServiceImpl implements ServiceU {
	@Autowired
	UserRespository ur;
	@Autowired
	DeclarationRepository dr;
	public ServiceImpl( DeclarationRepository dr,UserRespository ur ) {
	      this.ur = ur; 
	      this.dr = dr; 
	   } 
	public Declaration saveDec(Declaration dec) { 
		return dr.save(dec);
	} 
	public Declaration getDec(int id) { 
		return dr.getById(id);
	}
	public List<Declaration> getAllDec(){
	    return dr.findAll();
	} 
	public User Login(String username, String password) { 
		System.out.println("login by:"+username+"/"+password); 
        User user2 = ur.findByEmail(username); 
        if(user2==null) {
        	return null; 
        }else {
	        String username2 = user2.getEmail();
	        String password2 = user2.getPassword();
	        if(username.equals(username2) && password.equals(password2)){ 
	        		System.out.println("succes"); 
	        		return user2;
			}else 
				return null;
        } 
	}
 
	 
	
	    
	    /*************************************/

	 
	 
}


