/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springtest.dao;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
                        .run( "match( p:Person) return properties(p) as person" ).  list();
        
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

    @Override
    public List<Map<String, Object>> getPersonsMap() 
    {
        
        List<Map<String, Object>> list = new ArrayList<>();
        
         List<Record> recordList =
                neo4jDriver.getInstance()
                        .run( "match( p:Person) return properties(p) as person" ).  list();
         
         recordList.stream().forEach( rec ->
         {
         list.add( rec.asMap() );
             
         });
        
        
         return list;
    }//

    @Override
    public Map<String, Object> getPersonByName(Map<String, Object> statementParameters) 
    {
        
        /**
         * NOTA IMPORTANTE:
         * al ejecutar un quiery co return properties(p), se regresa un map
         * con el nombre de 'properties(p)', cuando thymeleaf intenta llamar a este nombre
         * lo interpreta como si se estuviera llamando a un metodo, 
         * 
         * properties(p).name //es para llamar el query en thymeleaf, sin embargo
         * saltara un error en el servlet puesto que dira que no hay algun metodo
         * llamado properties(p) que acepte un parametro P, por lo que se tiene 
         * que agregar un alias siempre a la consulta para que no haya error alguno
         * 
         * return properties(p) as person indicara al final que a "person" tendra
         * valores, por ende se podra llamar en thymeleaf como:
         * <span th:text="${VARNAME.person.name}" >span value</span>
         * 
         */
        
           return neo4jDriver.getInstance()
                  .run( "match( p:Person)  where p.name = {name} return properties(p) as person", statementParameters ).single().asMap();
        
    }
    
}
