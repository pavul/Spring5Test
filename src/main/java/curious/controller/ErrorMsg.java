/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curious.controller;

import lombok.Data;

/**
 * this class is used to store name and message of
 * the element validate with errors
 * @author pavul
 */
@Data
public class ErrorMsg 
{
    private String name;
    private String message;
    
    
//    public ErrorMsg( String name, String message)
//    {
//    this.name = name;
//    this.message = message;
//    }
    
    
}
