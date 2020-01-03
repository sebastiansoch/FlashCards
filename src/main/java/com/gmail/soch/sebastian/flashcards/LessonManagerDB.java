/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.soch.sebastian.flashcards;

import com.gmail.soch.sebastian.flashcards.entity.Category;
import javax.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;
import com.gmail.soch.sebastian.flashcards.entity.FlashCard;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author ssoch
 */

@Qualifier("database")
@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.INTERFACES)
@Transactional
public class LessonManagerDB implements LessonManagerIntf {

    private int flashCardNb = -1;
    private Collection<FlashCard> flashCards;
    private Iterator<FlashCard> iterator;
    
    @PersistenceUnit
    private EntityManagerFactory emf;
        
    @Override
    public FlashCard getFlashCard() {
        if (flashCards == null) {
            flashCards = emf.createEntityManager().find(Category.class, 2).getFlashCardCollection();
            iterator = flashCards.iterator();
        }
        
        if (iterator.hasNext()) {
            FlashCard flashCard = iterator.next();
            flashCardNb = flashCard.getId();
            return flashCard;
        }
        
        return null;
    }

    @Override
    @Transactional
    public void setIncorrectAnswer() {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        FlashCard flashCard = entityManager.find(FlashCard.class, flashCardNb);
        flashCard.setNbIncorrect(flashCard.getNbIncorrect() + 1);
        entityManager.getTransaction().commit();
    }

    @Override
    public void setCorrectAnswer() {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        FlashCard flashCard = entityManager.find(FlashCard.class, flashCardNb);
        flashCard.setNbCorrect(flashCard.getNbCorrect() + 1);
        entityManager.getTransaction().commit();
    }
}