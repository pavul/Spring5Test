/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springtest.dao;

import springtest.model.BookM;

/**
 *
 * @author Mozart
 */
public interface BookMDao
{

    public BookM getBookM(String bookName);
    
}
