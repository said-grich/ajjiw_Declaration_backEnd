package com.ajiw.Controllers;   
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException; 

 
@Component
public class Filter extends OncePerRequestFilter {
 

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse response, FilterChain filterChain) 
    		throws ServletException, IOException { 
		response.addHeader("Access-Control-Allow-Origin", "*"); 
		response.addHeader("Access-Control-Allow-Headers", "*");
		if (req.getMethod().equals("OPTIONS")) {
			response.setStatus(HttpServletResponse.SC_OK);
		} else { 
		    String jwt = getToken(req); 
	        if (jwt != null) {
             try {   
                filterChain.doFilter(req, response);
              } catch (Exception e) { 
				response.setHeader("Error", e.getMessage()); 
                logger.error("failed");
               }
           }else
            {  
        	response.sendError(403);
        	logger.error("Vous etez pas authentifie!");
         }
       } 
        
    }

    private String getToken(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization"); 
        if (authHeader != null) {
            return authHeader;
        }
        else
          return null;
    }
}
