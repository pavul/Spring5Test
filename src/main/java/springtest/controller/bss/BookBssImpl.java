/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springtest.controller.bss;

import springtest.model.Book;
import springtest.controller.dao.BookDao;

/**
 *
 * @author MiriamMarina
 */
public class BookBssImpl implements BookBss 
{
    private BookDao bookDao;
        
    public void setBookDao(BookDao bookDao) 
    {
        this.bookDao = bookDao;
    }
    
        @Override
    public Book getBook() 
    {       
        String nombre = "La isla bajo el mar";        
        return bookDao.getBook( nombre );
    }
    
}
