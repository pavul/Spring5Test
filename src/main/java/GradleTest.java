
import java.io.File;
import org.apache.commons.lang3.StringUtils;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.ResourceIterable;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pavulzavala
 */
public class GradleTest 
{
   
    public static void main( String ...args)
    {
        
        
        GraphDatabaseService graphDb;
        graphDb = new GraphDatabaseFactory().newEmbeddedDatabase( new File( "dir/javaNeoDB" ) );
        
        
        try ( Transaction tx = graphDb.beginTx() )
{
    
        Node nod1;
        Node nod2;
        Node nod3;
        nod1 =  graphDb.createNode();
        nod2 =  graphDb.createNode();
        nod3 =  graphDb.createNode();
        System.err.println("::: creado node 1: "+nod1.getId() );
        System.err.println("::: creado node 2: "+nod2.getId() );
        System.err.println("::: creado node 3: "+nod3.getId() );
    
        
        
        
        
      ResourceIterable<Node> nodeList =  graphDb.getAllNodes();
        
              nodeList.stream().forEach( n ->
              {
              
                  System.out.println("node: "+n.getAllProperties().toString() );
                  
              });
              
              
        
        
    tx.success();
}
        catch(Exception e)
        {
            System.out.println("exc: "+e);
        }
        finally
        {
        graphDb.shutdown();
        }
        
        
    }//main
    
    
}//
