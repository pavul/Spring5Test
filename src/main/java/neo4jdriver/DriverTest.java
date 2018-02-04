/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neo4jdriver;

import java.io.File;
import java.net.URI;
import java.util.List;
import java.util.Map;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

/**
 *
 * @author pavulzavala
 */
public class DriverTest 
{
   
    
    
    
    
      public static void main( String ...args)
      {
         DriverTest d = new DriverTest();
//         d.queryTest();
         d.createTest();
      }//
    
    
    
    
    
    
    public void queryTest()
    {
    
       
        
        try ( Session session = Neo4jDriver.getInstance( URI.create( "bolt://10.0.0.17:7687" ),
                "neo4j", "pass" ).session() )
        {
            
            
            List<Record> recordList = session.run( "match(b:Book) return properties(b) as book" ).list();
            
            //this is used if we want to call raw node, we have to call r.get(0) instead r.get("book")
            //List<Record> recordList = session.run( "match(b:Book) return properties(b)" ).list();
      
//            System.err.println("list size: "+recordList.size());
//            System.err.println("list : "+recordList.toString());
            
            
            recordList.stream().forEach( r->
            {
                System.err.println("->"+r.get( "book" ).get("title") );
            });
            
            
//     while ( result.hasNext() )
//    {
//        Record res = result.next();
//        
//        System.err.println(" --> "+res.get(0)+" - "+res.get("title")+" - "+res.get("author") ); 
//    }
           
//            
        }//
        finally
        {
           
        Neo4jDriver.close();
        }
        
    }//
    
    
    
    /**
     * example to create new node
     */
    public void createTest()
    {
    
        
         try ( Session session = Neo4jDriver.getInstance( URI.create( "bolt://10.0.0.17:7687" ),
                "neo4j", "pass" ).session() )
        {
            
          
//            session.run("CREATE (a:Person {name: $name})", parameters( "name", name ) );
           List<Record> recordList = session.run( "create(b5:Book{title:\"book5\",author:\"author6\"}),(b6:Book{title:\"book6\",author:\"author6\"})" ).list();
            
//            List<Record> recordList = session.run( "match(b:Book) return properties(b) as book" ).list();
          
            recordList.stream().forEach( r->
            {
                System.err.println("creado->"+r.get( "book" ) );
            });
          
            
        }//
        finally
        {
           
        Neo4jDriver.close();
        }
        
        
    }//
    
    
    
    
    
}//
