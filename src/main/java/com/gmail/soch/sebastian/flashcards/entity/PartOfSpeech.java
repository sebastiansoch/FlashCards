/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.soch.sebastian.flashcards.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ssoch
 */
@Entity
@Table(name = "part_of_speech")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PartOfSpeech.findAll", query = "SELECT p FROM PartOfSpeech p"),
    @NamedQuery(name = "PartOfSpeech.findById", query = "SELECT p FROM PartOfSpeech p WHERE p.id = :id"),
    @NamedQuery(name = "PartOfSpeech.findByName", query = "SELECT p FROM PartOfSpeech p WHERE p.name = :name")})
public class PartOfSpeech implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "partOfSpeech")
    private Collection<FlashCard> flashCardCollection;

    public PartOfSpeech() {
    }

    public PartOfSpeech(Integer id) {
        this.id = id;
    }

    public PartOfSpeech(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<FlashCard> getFlashCardCollection() {
        return flashCardCollection;
    }

    public void setFlashCardCollection(Collection<FlashCard> flashCardCollection) {
        this.flashCardCollection = flashCardCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PartOfSpeech)) {
            return false;
        }
        PartOfSpeech other = (PartOfSpeech) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gmail.soch.sebastian.flashcards.entity.PartOfSpeech[ id=" + id + " ]";
    }
    
}
