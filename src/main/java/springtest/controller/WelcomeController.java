/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springtest.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springtest.controller.bss.PersonBss;

@Controller
public class WelcomeController
{
    
    private PersonBss personBss;
    public void setPersonBss(PersonBss personBss) {
        this.personBss = personBss;
    }
    
    
    
    
    @RequestMapping(value = "/home", method = RequestMethod.GET )
    public String home( Model model ) 
    {
        
//        Driver driver = null;
//        
//        try( Session session = GraphDatabase.driver( URI.create( "bolt://10.0.0.17:7687" ) 
//                        , AuthTokens.basic( "neo4j","pass" ) ).session() )
//        {
//        
//            List<Record> recordList =
//                    session.run( "match(b:Book) return properties(b) as book" ).list();
//            
//            
////            model.addAttribute("recordList", recordList );
//            model.addAttribute("name", "JOHN" );
//            
//
//            
////            recordList.stream().forEach( r ->
////            {
////                System.err.println(" Elem: "+r.get( "book" ).get( "title" )  );
////            });
//            
//            
//        }//
        
//          List<String> nameList = new ArrayList<>();
//  
//            nameList.add( "name1" );
//            nameList.add( "name2" );
//            nameList.add( "name3" );
//            
//            model.addAttribute( "nameList" ,nameList );
//            
//        
//        System.err.println("entrando a welcome cotroller HOMe");
        
        
        model.addAttribute( "nombredeBSS" , personBss.getPerson().getName() );
        
        return "home.html";
    }
    
    
}//c;ass
