/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.soch.sebastian.flashcards;

/**
 *
 * @author ssoch
 */
public class FlashCard {
    private String question;
    private String answer;

    FlashCard(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    
    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
    
}
