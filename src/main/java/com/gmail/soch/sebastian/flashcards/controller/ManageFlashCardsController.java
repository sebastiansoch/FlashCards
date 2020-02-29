/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.soch.sebastian.flashcards.controller;

import com.gmail.soch.sebastian.flashcards.LessonManagerIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ssoch
 */
@Controller
public class ManageFlashCardsController {

    @Autowired
    private LessonManagerIntf lessonManageraa;
    
    @RequestMapping("/manageflashcards")
    public String getInitializationData(Model model) {
        model.addAttribute("categories", lessonManageraa.getCategories());
        model.addAttribute("part_of_speech", lessonManageraa.getPartOfSpeech());
              
        return "manageflashcards";
    }
}
