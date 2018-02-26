/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curious.controller;

import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody; PARA EL TEST
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;

/**
 * @author pavulzavala
 */
@Controller
public class LoginController 
{
     
     @RequestMapping(value = "/curious", method = RequestMethod.GET )
    public String home( ) 
    {
        
       return "curious/curious.html"; 
    }//
    
     @RequestMapping(value = "/curious", method = RequestMethod.POST,
             consumes = "text/plain", headers = "Content-Type=application/x-www-form-urlencoded" )
//    public String home( @RequestBody String postData ) de TEST regresa toda la cadena de parametros enviada por post
    public String home( HttpServletRequest req ) 
    {
        
        System.err.println("entrando datos: "+req.getParameter( "name" ) );
        System.err.println("entrando datos: "+req.getParameter( "pass" ) );
        
       return "curious/curious.html"; 
    }//
    
    
    
}//
