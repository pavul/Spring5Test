/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springtest.controller;

import java.net.URI;
import java.util.List;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController
{
    
    
    
    
    
    @RequestMapping(value = "/home", method = RequestMethod.GET )
    public String home() 
    {
        
        Driver driver = null;
        
        try( Session session = GraphDatabase.driver( URI.create( "bolt://10.0.0.17:7687" ) 
                        , AuthTokens.basic( "neo4j","pass" ) ).session() )
        {
        
            List<Record> recordList =
                    session.run( "match(b:Book) return properties(b) as book" ).list();
            
            
            recordList.stream().forEach( r ->
            {
                System.err.println(" Elem: "+r.get( "book" ).get( "title" )  );
            });
            
            
        }//
        
        
        System.err.println("entrando a welcome cotroller HOMe");
        return "home";
    }
    
    
}//c;ass
