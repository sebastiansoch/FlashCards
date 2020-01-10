/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.soch.sebastian.flashcards;

import com.gmail.soch.sebastian.flashcards.entity.Category;
import com.gmail.soch.sebastian.flashcards.entity.FlashCard;
import com.gmail.soch.sebastian.flashcards.entity.PartOfSpeech;
import java.util.List;

/**
 *
 * @author ssoch
 */
public interface LessonManagerIntf {

    public FlashCard getFlashCard();

    default public void setCorrectAnswer() {
    }

    default public void setIncorrectAnswer() {
    }

    default public List<Category> getCategories() {
        return null;
    }

    default public List<PartOfSpeech> getPartOfSpeech() {
        return null;
    }
}
