/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springtest.controller.dao;

import springtest.model.BookM;

/**
 *
 * @author Mozart
 */
public class BookMDaoImpl implements BookMDao
{

    @Override
    public BookM getBookM(String bookName)
    {
        BookM bookM = new BookM();
        bookM.setBookName(bookName);
        return bookM;
    }
    
}
