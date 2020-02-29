/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.soch.sebastian.flashcards;

import com.gmail.soch.sebastian.flashcards.entity.UserAuth;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ssoch
 */
@Component
@Transactional
public class AuthenticationManagerImpl implements AuthenticationManager {

    @PersistenceUnit
    private EntityManagerFactory emf;
    
    
    @Override
    public UserAuth getUserAuthData(String username) {
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createNamedQuery("UserAuth.findByUsername");
        query.setParameter("username", username);
        return (UserAuth) query.getResultList().get(0);
    }
   
}
