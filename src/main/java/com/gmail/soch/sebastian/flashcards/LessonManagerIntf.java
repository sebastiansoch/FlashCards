/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.soch.sebastian.flashcards;

import com.gmail.soch.sebastian.flashcards.entity.FlashCard;
/**
 *
 * @author ssoch
 */

public interface LessonManagerIntf {

    public FlashCard getFlashCard();
    default public void setCorrectAnswer() {}
    default public void setIncorrectAnswer() {}
    

}
