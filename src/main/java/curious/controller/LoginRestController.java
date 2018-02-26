/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curious.controller;

import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pavulzavala
 */
@RestController
public class LoginRestController 
{
   
        //if this is inside restcontroller, its not necesary to put
    //ResponseBody
    @RequestMapping(value = "/loadLogin", 
            method = RequestMethod.GET,
            headers = "Accept=application/json" ,
            produces = MediaType.APPLICATION_JSON_VALUE )
    public String loadForm()
    {
//        Map<String, String> mapList = new HashMap<>();
//        
//        mapList.put("name", "paul");
//        mapList.put("lastname", "zavala");
        
//        JSONObject jsonobj = new JSONObject( mapList );
     
        //return jsonobj .toJSONString();
        return "[{\"html\":\"input\",\"type\":\"text\",\"inner\":\"\",\"prop\":[{\"name\":\"name\"},{\"id\":\"namefield\"},{\"placeholder\":\"name\"}]},{\"html\":\"input\",\"type\":\"password\",\"inner\":\"\",\"prop\":[{\"name\":\"pass\"},{\"id\":\"pass\"},{\"placeholder\":\"\"}]}]";
        
    }
        
     
    
}//
