/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neo4jdriver;

import java.net.URI;
import java.sql.Driver;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;

/**
 *
 * @author pavulzavala
 */
public class Neo4jDriver 
{
   
    private String uri;
    private String user;
    private String pass;
    
    //private static Driver neoDriver;
    private static Session session = null;
    
    
    public Neo4jDriver( String uri, String user, String pass)
    {
    this.uri = uri;
    this.user = user;
    this.pass = pass;
    }
    
    
    public Session getInstance( )
    {
        
        if( session == null )
        {
           session = GraphDatabase.driver( this.uri, AuthTokens.basic( this.user, this.pass ) ).session();  
        }
    
        return session;
    }
   
    
    
//    public static void close()
//    {
//        neoDriver.close();
//    } 
    
    
}//
