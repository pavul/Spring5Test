/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curious.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody; PARA EL TEST
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
       
//        System.err.println("::: request "+req.getParameterMap().toString());
       
        
//        System.err.println("entrando datos: "+req.getParameter( "name" ) );
//        System.err.println("entrando datos: "+req.getParameter( "password" ) );
//        System.err.println("entrando datos: "+req.getParameter( "topic" ) );
//        System.err.println("entrando datos: "+req.getParameter( "submit" ) );
//        System.err.println(" - - - - - -" );
//        "[{\"element\":\"input\",\"type\":\"text\",\"inner\":\"\",\"id\":\"username\",\"prop\":[{\"name\":\"name\"},{\"placeholder\":\"name\"}],\"restricts\":[{\"required\":true,\"msg\":\"this field is required\"},{\"minlength\":1,\"msg\":\"minimum length 1\"},{\"maxlength\":50,\"msg\":\"maximum length 50\"}]},{\"element\":\"input\",\"type\":\"password\",\"inner\":\"\",\"id\":\"pass\",\"prop\":[{\"name\":\"password\"},{\"placeholder\":\"\"}],\"restricts\":[{\"required\":true,\"msg\":\"this field is required\"},{\"minlength\":1,\"msg\":\"minimum length 1\"},{\"maxlength\":25,\"msg\":\"maximum length 25\"}]},{\"element\":\"input\",\"type\":\"radio\",\"inner\":\"\",\"id\":\"radio1\",\"prop\":[{\"name\":\"topic\"},{\"value\":\"birds\"},{\"placeholder\":\"\"}],\"restricts\":[{\"required\":true,\"msg\":\"this field is required\"},{\"minlength\":1,\"msg\":\"minimum length 1\"},{\"maxlength\":25,\"msg\":\"maximum length 25\"}]},{\"element\":\"input\",\"type\":\"radio\",\"inner\":\"\",\"id\":\"radio2\",\"prop\":[{\"name\":\"topic\"},{\"value\":\"fishes\"},{\"checked\":\"true\"}],\"restricts\":[{\"required\":true,\"msg\":\"this field is required\"},{\"minlength\":1,\"msg\":\"minimum length 1\"},{\"maxlength\":25,\"msg\":\"maximum length 25\"}]},{\"element\":\"input\",\"type\":\"radio\",\"inner\":\"\",\"id\":\"radio3\",\"prop\":[{\"name\":\"topic\"},{\"value\":\"mamals\"},{\"checked\":\"false\"}],\"restricts\":[{\"required\":true,\"msg\":\"this field is required\"},{\"minlength\":1,\"msg\":\"minimum length 1\"},{\"maxlength\":25,\"msg\":\"maximum length 25\"}]},{\"element\":\"input\",\"type\":\"submit\",\"id\":\"submitBtn\",\"inner\":\"\",\"prop\":[{\"name\":\"submit\"},{\"value\":\"push\"},{\"onclick\":\" validate(testCallback); return false;\"}]}]";
        
        
        //convertir el codigo de abajo a una clase mas modular donde
        //se pueda usar en cualquier parte que se necesite
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = null;
        List<ErrorMsg> errorMsgList = new ArrayList<>();
        
         try 
         {
             jsonArray = 
                     (JSONArray)parser.parse( "[{\"element\":\"input\",\"type\":\"text\",\"inner\":\"\",\"id\":\"username\",\"name\":\"name\",\"prop\":[{\"placeholder\":\"name\"}],\"restricts\":[{\"required\":true,\"msg\":\"this field is required\"},{\"minlength\":1,\"msg\":\"minimum length 1\"},{\"maxlength\":50,\"msg\":\"maximum length 50\"}]},{\"element\":\"input\",\"type\":\"password\",\"inner\":\"\",\"id\":\"pass\",\"name\":\"password\",\"prop\":[{\"placeholder\":\"\"}],\"restricts\":[{\"required\":true,\"msg\":\"this field is required\"},{\"minlength\":1,\"msg\":\"minimum length 1\"},{\"maxlength\":25,\"msg\":\"maximum length 25\"}]},{\"element\":\"input\",\"type\":\"radio\",\"inner\":\"\",\"id\":\"radio1\",\"name\":\"topic\",\"prop\":[{\"value\":\"birds\"},{\"placeholder\":\"\"}],\"restricts\":[{\"required\":true,\"msg\":\"this field is required\"},{\"minlength\":1,\"msg\":\"minimum length 1\"},{\"maxlength\":25,\"msg\":\"maximum length 25\"}]},{\"element\":\"input\",\"type\":\"radio\",\"inner\":\"\",\"id\":\"radio2\",\"name\":\"topic\",\"prop\":[{\"value\":\"fishes\"},{\"checked\":\"true\"}],\"restricts\":[{\"required\":true,\"msg\":\"this field is required\"},{\"minlength\":1,\"msg\":\"minimum length 1\"},{\"maxlength\":25,\"msg\":\"maximum length 25\"}]},{\"element\":\"input\",\"type\":\"radio\",\"inner\":\"\",\"id\":\"radio3\",\"name\":\"topic\",\"prop\":[{\"value\":\"mamals\"},{\"checked\":\"false\"}],\"restricts\":[{\"required\":true,\"msg\":\"this field is required\"},{\"minlength\":1,\"msg\":\"minimum length 1\"},{\"maxlength\":25,\"msg\":\"maximum length 25\"}]},{\"element\":\"input\",\"type\":\"submit\",\"id\":\"submitBtn\",\"name\":\"submit\",\"inner\":\"\",\"prop\":[{\"value\":\"push\"},{\"onclick\":\"validate(testCallback); return false;\"}]}]" ); 
         }
         catch (ParseException ex) 
         {
             Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
         }
        
         
        //iterate all  
        for( int i = 0; i < jsonArray.size(); i++ )
        {
            JSONObject json = (JSONObject)jsonArray.get( i );
        
            String param = req.getParameter( (String)json.get( "name" ) ); 
            
            
            //if a param exist and there are restrictions, validate it
            if( param != null && json.containsKey( "restricts" ) )//@TODO and if is validable
            {
            
                System.err.println("::: entrando PARAM: "+param);
                
                JSONArray restrictions = ( JSONArray )json.get( "restricts" );
                
                for( int j = 0; j < restrictions.size(); j++ )
                {
                    JSONObject rule = (JSONObject)restrictions.get( j );
                    
                    System.err.println("--> "+rule.toString() ); 
                    
//                    param es el valor a validar o el value
                    
                 //populating list of errors
                 errorMsgList.add( validate( (String)json.get( "name" ), param, rule ) );
                            
                    
                }///
                
                
            }//
            
            
            
        }//
         
        
         
        
        
       return "curious/curious.html"; 
    }//
    
    
    
    @RequestMapping(value = "/splash", method = RequestMethod.GET )
    public String splash( ) 
    {
       return "webtemplate/contact.html"; 
    }//
    
   
    
    
    
    /**
     * funcion para validar el JSON entrante
     */
    private ErrorMsg validate( String name, String value, JSONObject rule )
    {
    
        ErrorMsg msg = new ErrorMsg( );
        
        
        if( rule.containsKey( "required" ) )
        {
        
            if( value == null || value.isEmpty() )
            {
            //add error to message here
                msg.setName(name);
                msg.setMessage( (String)rule.get( "msg" ) );
            }
            
        }
        else if( rule.containsKey( "minlength" ) )
        {
        
        }
        else if( rule.containsKey( "maxlength" ) )
        {
        
        }
        else if( rule.containsKey( "numeric" ) )
        {
        
        }
        else if( rule.containsKey( "sameas" ) )
        {
        
        }
        else if( rule.containsKey( "lessthan" ) )
        {
        
        }
        else if( rule.containsKey( "mayorthan" ) )
        {
        
        }
        else if( rule.containsKey( "email" ) )
        {
        
        }
        else if( rule.containsKey( "regexp" ) )
        {
        
        }
        else if( rule.containsKey( "custom" ) )
        {
        
        }
//        else if( rule.containsKey( "required" ) )
//        {
//        
//        }
        
        /*
        
        */
        return msg;
    }//
    
    
    
}//
