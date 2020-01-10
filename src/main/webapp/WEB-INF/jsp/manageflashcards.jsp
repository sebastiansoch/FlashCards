<%-- 
    Document   : manageflashcards
    Created on : 2019-12-20, 12:09:40
    Author     : ssoch
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Flash Card Manager</h1>
        
        <form action="*">
            Question: <input name="question"></textarea>
            <br />
            Answer: <input name="answer"></textarea>
            <br />
            <select name="category">
                <c:forEach items="${categories}" var="cat">
                    <option>${cat.name}</option>    
                </c:forEach>
            </select>
            <br />
            <select name="category">
                <c:forEach items="${part_of_speech}" var="pos">
                    <option>${pos.name}</option>    
                </c:forEach>
            </select>
            <br />
            <input type="submit" value="Add flash card" />
        </form>
        
    </body>
</html>
