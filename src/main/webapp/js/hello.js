/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $("#greetings").click(function () {
        $.ajax({
            url: "http://localhost:8080/FlashCards/logic/restdata"
        }).then(function (data) {
            $('#greeting-id').text(data.id);
            $('#greeting-content').text(data.content);
        });
    });
});