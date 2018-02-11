/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springtest.controller.bss;

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
    
}
