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
        <link href="/FlashCards/functions/showAnswer.js"/>
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
    </body>
</html>
