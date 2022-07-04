package com.ajiw.Controllers;

import java.sql.Date; 
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RestController;

import com.ajiw.Repositories.DeclarationRepository;
import com.ajiw.Repositories.TypeReactionRepository;
import com.ajiw.Repositories.UserRespository; 
import com.ajiw.entities.Declaration;  
import com.ajiw.entities.User; 
 
@CrossOrigin(origins = "http://localhost:4200")

@RestController

public class Controller {
	
	@Autowired
	TypeReactionRepository typeReactionRepository;

	@Autowired
	UserRespository userrepo;


	@Autowired
	DeclarationRepository declrepo;

	@Autowired
	ServiceU s;

	@PostMapping(value="/add_declaration")
	 public Declaration declaration(@RequestBody Declaration dec) throws Exception { 
		User u = new User();
		u = dec.getUser();
		dec.setUser(u);
		LocalDateTime date = LocalDateTime.now();
		int day = date.getDayOfMonth(); 
		int mois = date.getMonthValue();  
		int ans = date.getYear(); 
		String datee0 = ans+"-"+mois+"-"+day; 
		Date date1=Date.valueOf(datee0);  
		dec.setDateDecl(date1); 
		if(dec.getContent()!=null) {
			return s.saveDec(dec);
		  }
		else 
			return null;
	 } 
	 
	 @GetMapping(value="/detail_declaration/{id}")
	 public Declaration getDeclaration(@PathVariable("id") int id) { 
		Declaration dec = s.getDec(id);
		if(dec!=null) {   
		    return dec; 
		}
		else 
		   return null;
	  }
	  
	@GetMapping(value="/list_declarations")
	public List<Declaration> declarationslist() { 
		List<Declaration> dec = new ArrayList<>();
		dec = s.getAllDec();
		return dec;
	}
	
	 // Login  
	 @PostMapping(value="/login")
	 public Login Login(@RequestBody Login log, HttpServletRequest req) { 
		User user = s.Login(log.getUsername(), log.getPassword() ); 
	    if(user!=null){
			HttpSession session = req.getSession();  
		    session.setAttribute("username", log.getUsername());
		    log.setRole(user.getRole());
		    log.setUser(user);
		    log.setToken("Auth"+user.getRole()+user.getEmail()); 
		    session.setAttribute("tok", log.getToken());
			return log;
	     } 
		else
		   return null;
	 }

	 
	 
	 // inscription  
	 @PostMapping(value="/inscription")
	 public User inscription(@RequestBody User u) { 
		User user = new User(); 
		user.setNom(u.getNom());
		user.setPrenom(u.getPrenom());
		user.setEmail(u.getEmail());
		user.setPassword(u.getPassword());
		user.setRole(u.getRole());
		return userrepo.save(user); 
	 }
	 
	 
	 //====================================
	   
	 
	 /*
	 
		
		@GetMapping(value="/users")
		public Login logins4(){
			 
		}*/
	 
	/*@PostMapping(value="/categories")
	public void cat(){
   
    }
    */
	 
	 /*
	@PostMapping("/addtyperection.php")
	public ResponseEntity<TypeReaction> addTypeReaction(@RequestBody TypeReaction typeReaction){
		try { 
			TypeReaction tr = new TypeReaction();
			tr = typeReactionRepository.findByLibelle(typeReaction.getLibelle());
			if (tr == null) {
				if (typeReaction == null) {
						tr = typeReactionRepository.save(typeReaction);
				}else {
					tr = typeReactionRepository.getOne(typeReaction.getId());
				}
			} 
			return new ResponseEntity<>(tr,HttpStatus.OK);
			
		}catch(Exception e){
			return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
		}
	}*/
	
	/*
	@GetMapping("/typereaction")
	public ResponseEntity<List<TypeReaction>> getAllTypeReaction(){ 
		try {
			return new ResponseEntity<>(typeReactionRepository.findAll(),HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
		}
	}*/
	 

}
