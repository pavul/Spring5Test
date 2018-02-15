/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springtest.controller.bss;

import java.util.List;
import java.util.Map;
import org.neo4j.driver.v1.Record;
import springtest.controller.dao.PersonDao;
import springtest.model.Person;

/**
 *
 * @author pavulzavala
 */
//public class PersonServiceImpl 
public class PersonBssImpl implements PersonBss
{

    private PersonDao personDao;
    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }
    
    
    @Override
    public Person getPerson() 
    {
        
        String nombre = "Manuel";
        
    return personDao.getPerson( nombre );
    
    }

    @Override
    public List<Person> getPersons() 
    {
        return personDao.getPersons();
    }

    @Override
    public List<Map<String, Object>> getPersonsMap() 
    {
        return personDao.getPersonsMap();
    }
    
}
