/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springtest.controller.dao;

import java.util.List;
import java.util.Map;
import org.neo4j.driver.v1.Record;
import springtest.model.Person;

/**
 *
 * @author pavulzavala
 */
public interface PersonDao 
{
   
    public Person getPerson(String name);
    
    public List<Person>  getPersons();
    
    
    public List< Map<String, Object>> getPersonsMap();
    
    
}//
