/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.soch.sebastian.flashcards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gmail.soch.sebastian.flashcards.LessonManagerIntf;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author ssoch
 */
@Controller
public class LessonController {

    @Autowired
    private LessonManagerIntf lessonManager;

    @RequestMapping("/lesson")
    public String showQuestion(Model model) {
        model.addAttribute("flash_card", lessonManager.getFlashCard());
        return "lesson";
    }
    
    @RequestMapping("/correct")
    public String correctAnswer() {
        lessonManager.setCorrectAnswer();
        return "redirect:/logic/lesson";
    }
         
    @RequestMapping("/incorrect")
    public String incorrectAnswer() {
        lessonManager.setIncorrectAnswer();
        return "redirect:/logic/lesson";
    }
         
}
