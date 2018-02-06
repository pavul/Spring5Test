<%-- 
    Document   : newjsp
    Created on : Apr 1, 2016, 4:21:17 AM
    Author     : pavulzavala
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" >
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>this is home JSP!</h1>
        
        <h2 th:text="${name} ></h2>
        
        <ul th:each="r:${recordList}" >
            <li th:text="${r.book.title}"> </li>
        </ul>
        
        
    </body>
</html>
