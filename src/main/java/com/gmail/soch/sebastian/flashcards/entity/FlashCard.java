/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.soch.sebastian.flashcards.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ssoch
 */
@Entity
@Table(name = "flash_card")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FlashCard.findAll", query = "SELECT f FROM FlashCard f"),
    @NamedQuery(name = "FlashCard.findById", query = "SELECT f FROM FlashCard f WHERE f.id = :id"),
    @NamedQuery(name = "FlashCard.findByQuestion", query = "SELECT f FROM FlashCard f WHERE f.question = :question"),
    @NamedQuery(name = "FlashCard.findByAnswer", query = "SELECT f FROM FlashCard f WHERE f.answer = :answer"),
    @NamedQuery(name = "FlashCard.findByNbCorrect", query = "SELECT f FROM FlashCard f WHERE f.nbCorrect = :nbCorrect"),
    @NamedQuery(name = "FlashCard.findByNbIncorrect", query = "SELECT f FROM FlashCard f WHERE f.nbIncorrect = :nbIncorrect")
})
public class FlashCard implements Serializable {

    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne
    private Category category;
    @JoinColumn(name = "part_of_speech_id", referencedColumnName = "id")
    @ManyToOne
    private PartOfSpeech partOfSpeech;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "question")
    private String question;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "answer")
    private String answer;
    @Column(name = "nb_correct")
    private Integer nbCorrect;
    @Column(name = "nb_incorrect")
    private Integer nbIncorrect;

    public FlashCard() {
    }

    public FlashCard(Integer id) {
        this.id = id;
    }

    public FlashCard(Integer id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getNbCorrect() {
        return nbCorrect;
    }

    public void setNbCorrect(Integer nbCorrect) {
        this.nbCorrect = nbCorrect;
    }

    public Integer getNbIncorrect() {
        return nbIncorrect;
    }

    public void setNbIncorrect(Integer nbIncorrect) {
        this.nbIncorrect = nbIncorrect;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public PartOfSpeech getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(PartOfSpeech partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.category);
        hash = 13 * hash + Objects.hashCode(this.partOfSpeech);
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + Objects.hashCode(this.question);
        hash = 13 * hash + Objects.hashCode(this.answer);
        hash = 13 * hash + Objects.hashCode(this.nbCorrect);
        hash = 13 * hash + Objects.hashCode(this.nbIncorrect);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FlashCard other = (FlashCard) obj;
        if (!Objects.equals(this.question, other.question)) {
            return false;
        }
        if (!Objects.equals(this.answer, other.answer)) {
            return false;
        }
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        if (!Objects.equals(this.partOfSpeech, other.partOfSpeech)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nbCorrect, other.nbCorrect)) {
            return false;
        }
        if (!Objects.equals(this.nbIncorrect, other.nbIncorrect)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FlashCard{" + "category=" + category + ", partOfSpeech=" + partOfSpeech + ", id=" + id + ", question=" + question + ", answer=" + answer + ", nbCorrect=" + nbCorrect + ", nbIncorrect=" + nbIncorrect + '}';
    }
   
}
