/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.soch.sebastian.flashcards;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import com.gmail.soch.sebastian.flashcards.entity.FlashCard;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
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

    @PersistenceUnit
    private EntityManagerFactory emf;
        
    @Override
    public FlashCard getFlashCard() {
        return emf.createEntityManager().find(FlashCard.class, 2);
    }

    @Override
    @Transactional
    public void setIncorrectAnswer() {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        FlashCard flashCard = entityManager.find(FlashCard.class, 2);
        flashCard.setNbIncorrect(flashCard.getNbIncorrect() + 1);
        entityManager.getTransaction().commit();
    }

    @Override
    public void setCorrectAnswer() {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        FlashCard flashCard = entityManager.find(FlashCard.class, 2);
        flashCard.setNbCorrect(flashCard.getNbCorrect() + 1);
        entityManager.getTransaction().commit();
    }
}