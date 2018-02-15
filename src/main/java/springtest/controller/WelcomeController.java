/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springtest.controller;

import java.net.URI;
import java.util.List;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springtest.controller.bss.PersonBss;
import springtest.controller.bss.BookMBss;

@Controller
public class WelcomeController
{
    
    private PersonBss personBss;
    public void setPersonBss(PersonBss personBss) {
        this.personBss = personBss;
    }

    private BookMBss bookMBss;
    public void setBookMBss(BookMBss bookMBss) {
        this.bookMBss = bookMBss;
    }
    
    
    
    @RequestMapping(value = "/home", method = RequestMethod.GET )
    public String home( Model model ) 
    {
        
        
        //for LINUX NIGHTMARE
//        try( Session session = GraphDatabase.driver( UGraphDatabaseRI.create( "bolt://10.0.0.17:7687" ) 
//        try( Session session = GraphDatabase.driver( URI.create( "bolt://127.0.0.1:7687" ),
//                                                     AuthTokens.basic( "neo4j","pass" ) ).session() )
//        {
//        
//            List<Record> recordList =
//                    session.run( "match(b:BookM) return properties(b) as book" ).list();
//            model.addAttribute("recordList", recordList );
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
        
        System.err.println("mostrando MAP: "+personBss.getPersonsMap().toString() );
        
        model.addAttribute("recordList", personBss.getPersons() );
        
        model.addAttribute("recordMap", personBss.getPersonsMap() );
        
        
        System.err.println("getName" + personBss.getPersonByName( "paul" ).toString());
        model.addAttribute("getName", personBss.getPersonByName( "paul" ) );
        
        
        model.addAttribute( "nombredeBSS" , personBss.getPerson().getName() );
        model.addAttribute( "libroMdeBSS" , bookMBss.getBookM().getBookName() );
        
        
        
        
        
        return "home.html";
    }
    
    
}//c;ass
