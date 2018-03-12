/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curious.controller;

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
     
        
        return "[{\"element\":\"input\",\"type\":\"text\",\"inner\":\"\",\"id\":\"username\",\"prop\":[{\"name\":\"name\"},{\"placeholder\":\"name\"}],\"restricts\":[{\"required\":true,\"msg\":\"this field is required\"},{\"minlength\":1,\"msg\":\"minimum length 1\"},{\"maxlength\":50,\"msg\":\"maximum length 50\"}]},{\"element\":\"input\",\"type\":\"password\",\"inner\":\"\",\"id\":\"pass\",\"prop\":[{\"name\":\"password\"},{\"placeholder\":\"\"}],\"restricts\":[{\"required\":true,\"msg\":\"this field is required\"},{\"minlength\":1,\"msg\":\"minimum length 1\"},{\"maxlength\":25,\"msg\":\"maximum length 25\"}]},{\"element\":\"input\",\"type\":\"radio\",\"inner\":\"\",\"id\":\"radio1\",\"prop\":[{\"name\":\"topic\"},{\"value\":\"birds\"},{\"placeholder\":\"\"}],\"restricts\":[{\"required\":true,\"msg\":\"this field is required\"},{\"minlength\":1,\"msg\":\"minimum length 1\"},{\"maxlength\":25,\"msg\":\"maximum length 25\"}]},{\"element\":\"input\",\"type\":\"radio\",\"inner\":\"\",\"id\":\"radio2\",\"prop\":[{\"name\":\"topic\"},{\"value\":\"fishes\"},{\"checked\":\"true\"}],\"restricts\":[{\"required\":true,\"msg\":\"this field is required\"},{\"minlength\":1,\"msg\":\"minimum length 1\"},{\"maxlength\":25,\"msg\":\"maximum length 25\"}]},{\"element\":\"input\",\"type\":\"radio\",\"inner\":\"\",\"id\":\"radio3\",\"prop\":[{\"name\":\"topic\"},{\"value\":\"mamals\"},{\"checked\":\"false\"}],\"restricts\":[{\"required\":true,\"msg\":\"this field is required\"},{\"minlength\":1,\"msg\":\"minimum length 1\"},{\"maxlength\":25,\"msg\":\"maximum length 25\"}]},{\"element\":\"input\",\"type\":\"submit\",\"id\":\"submitBtn\",\"inner\":\"\",\"prop\":[{\"name\":\"submit\"},{\"value\":\"push\"},{\"onclick\":\" validate(testCallback); return false;\"}]}]";
                
                }
        
     
    
}//
