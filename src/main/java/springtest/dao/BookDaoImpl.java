/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springtest.dao;

import springtest.model.Book;

/**
 *
 * @author MiriamMarina
 */
public class BookDaoImpl implements BookDao
{

    @Override
    public Book getBook(String name) {
        
        Book b = new Book();
        b.setName(name);
        return b;
    }
    
}
