/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.soch.sebastian.flashcards;

import com.gmail.soch.sebastian.flashcards.entity.UserAuth;

/**
 *
 * @author ssoch
 */
public interface AuthenticationManager {

    UserAuth getUserAuthData(String username);

}
