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

/**
 *
 * @author ssoch
 */
@Controller
public class FlashCardController {

    @Autowired
    private LessonManagerIntf lessonManager;

    @RequestMapping(value = "flashcard")
    public String showQuestion(Model model) {
        model.addAttribute("flash_card", lessonManager.getFlashCard());
        return "flashcard";
    }
         
}
