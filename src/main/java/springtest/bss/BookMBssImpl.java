/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springtest.bss;

import springtest.model.BookM;
import springtest.dao.BookMDao;

/**
 *
 * @author Mozart
 */
public class BookMBssImpl implements BookMBss
{

    private BookMDao bookMDao;
    
    public void setBookMDao(BookMDao bookMDao)
    {
        this.bookMDao = bookMDao;
    }
    
    @Override
    public BookM getBookM() 
    {
        String bookName = "Spring in Action";
        return bookMDao.getBookM(bookName);    
    }
    
}