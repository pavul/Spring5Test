/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springtest.controller.dao;

import springtest.model.Book;


/**
 *
 * @author MiriamMarina
 */
public interface BookDao {
    
    public Book getBook(String name);   
    
}
