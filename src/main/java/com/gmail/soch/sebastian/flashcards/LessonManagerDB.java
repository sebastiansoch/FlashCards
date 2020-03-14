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
import com.gmail.soch.sebastian.flashcards.entity.PartOfSpeech;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author ssoch
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.INTERFACES)
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
            Query query = emf.createEntityManager().createNamedQuery("FlashCard.findAll");
            flashCards = query.getResultList();
            iterator = flashCards.iterator();
        }

        FlashCard flashCard = null;
        if (iterator.hasNext()) {
            flashCard = iterator.next();
            flashCardNb = flashCard.getId();
        } else {
            iterator = flashCards.iterator();
            flashCard = getFlashCard();
        }

        return flashCard;
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

    @Override
    public List<Category> getCategories() {
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createNamedQuery("Category.findAll");
        return query.getResultList();
    }

    @Override
    public List<PartOfSpeech> getPartOfSpeech() {
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createNamedQuery("PartOfSpeech.findAll");
        return query.getResultList();
    }
}
