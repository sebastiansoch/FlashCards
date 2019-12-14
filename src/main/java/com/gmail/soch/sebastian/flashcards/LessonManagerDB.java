/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.soch.sebastian.flashcards;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.gmail.soch.sebastian.flashcards.entity.FlashCard;
import org.springframework.beans.factory.annotation.Qualifier;
/**
 *
 * @author ssoch
 */

@Component
@Qualifier("database")
@Transactional
public class LessonManagerDB implements LessonManagerIntf {

    @PersistenceContext
    private EntityManager entityManager;
        
    @Override
    public FlashCard getFlashCard() {
        return entityManager.find(FlashCard.class, 1);
    }
}