/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.soch.sebastian.flashcards.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ssoch
 */
@Controller
public class ManageFlashCardsController {

    @RequestMapping
    public String manageFlashCards() {
        return "manageflashcards";
    }
}
