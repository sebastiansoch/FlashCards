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
import org.springframework.stereotype.Repository;
/**
 *
 * @author ssoch
 */

@Qualifier("database")
@Repository
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