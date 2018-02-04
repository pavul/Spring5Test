/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neo4jdriver;

import java.net.URI;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;

/**
 *
 * @author pavulzavala
 */
public class Neo4jDriver 
{
   
    
    public static Driver neoDriver;
    
    private Neo4jDriver(){};
    
    
    public static Driver getInstance( URI uri, String user, String pass)
    {
        if( neoDriver == null )
        {
        neoDriver = GraphDatabase.driver(uri, AuthTokens.basic( user, pass ) );  
        }
    
        return neoDriver;
    }
   
    public static void close()
    {
        neoDriver.close();
    }
    
    
    
}//
