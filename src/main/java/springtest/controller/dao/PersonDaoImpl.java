/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springtest.controller.dao;

import java.util.ArrayList;
import java.util.List;
import neo4jdriver.Neo4jDriver;
import org.neo4j.driver.v1.Record;
import springtest.model.Person;

/**
 *
 * @author pavulzavala
 */
public class PersonDaoImpl implements PersonDao 
{

    
    Neo4jDriver neo4jDriver;
    public void setNeo4jDriver(Neo4jDriver neo4jDriver) {
        this.neo4jDriver = neo4jDriver;
    }
    
   
    
    
    
    
    @Override
    public Person getPerson(String name) 
    {
        
        Person p = new Person();
        p.setName(name);
        
        return p;
    }

    @Override
    public List<Person> getPersons() 
    {
        List<Record> recordList =
                neo4jDriver.getInstance()
                        .run( "match( p:Person) return properties(p) as person" ).list();
        
        List<Person> personList = new ArrayList<>();
        
//        Person p = null;
        recordList.stream().forEach( rec -> {
        Person p = new Person();
        
        p.setName( rec.get( "person" ).get( "name" ).asString() );
        p.setLastname(rec.get( "person" ).get( "lastName" ).asString() );
            
        personList.add(p);
        });
        
        return personList;
    }
    
}
