/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.soch.sebastian.flashcards;

import org.springframework.stereotype.Component;
/**
 *
 * @author ssoch
 */
@Component
public class LessonManagerTest implements LessonManagerIntf {

    @Override
    public FlashCard getFlashCard() {
        return new FlashCard("Okno", "Window");
    }


}