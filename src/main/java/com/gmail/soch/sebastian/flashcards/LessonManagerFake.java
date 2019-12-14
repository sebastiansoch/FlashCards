/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.soch.sebastian.flashcards;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 *
 * @author ssoch
 */
@Component
@Primary
public class LessonManagerFake implements LessonManagerIntf {

    @Override
    public FlashCard getFlashCard() {
        return new FlashCard("Drzwi", "Door");
    }
}
