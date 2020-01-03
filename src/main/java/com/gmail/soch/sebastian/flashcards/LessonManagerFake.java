/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.soch.sebastian.flashcards;

import org.springframework.stereotype.Component;
import com.gmail.soch.sebastian.flashcards.entity.FlashCard;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author ssoch
 */
@Component
@Qualifier("fake")
public class LessonManagerFake implements LessonManagerIntf {

    @Override
    public FlashCard getFlashCard() {
        return new FlashCard(1, "Drzwi", "Door");
    }
}
