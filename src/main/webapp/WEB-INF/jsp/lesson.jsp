<%-- 
    Document   : show
    Created on : 2019-12-13, 12:05:33
    Author     : ssoch
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function showAnswer() {
                var show = document.getElementById("Answer");
                if (show.style.display === "none") {
                    show.style.display = "block";
                } else {
                    show.style.display = "none";
                }
            }
        </script>
    </head>
    <body>

        <h1>Question: ${flash_card.question}</h1>
        <h1 id="Answer" style="display: none">Answer: ${flash_card.answer}</h1>
        <button onclick="showAnswer()">Show Answer</button>
        <br />
        <table style="padding-top: 30px">
            <tr>
                <td style="padding-left: 30px; padding-right: 30px">
                    <a href="<c:url value='incorrect'/>">
                        <img src="<c:url value='/pictures/thumb-down.png'/>" style="width: auto">
                    </a>
                </td>
                <td style="padding-left: 30px; padding-right: 30px">
                    <a href="<c:url value='correct'/>">
                        <img src="<c:url value='/pictures/thumb-up.png'/>" style="width: auto">
                    </a>
                </td>
            </tr>
        </table>
                      
    </body>
</html>
