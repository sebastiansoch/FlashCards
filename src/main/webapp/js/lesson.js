/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function () {
    $("#Answer").hide();
    $("#thumbs").hide();
});
$(document).ready(
        function () {
            $("#answerBtn").click(function () {
                $("#Answer").toggle();
                $("#thumbs").show();
            });
        }
);