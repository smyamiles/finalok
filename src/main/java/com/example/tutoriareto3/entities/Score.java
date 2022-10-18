package com.example.tutoriareto3.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "score")
public class Score implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idScore;
    private Integer score;

    private Integer calification;

    private String messages;

    @OneToOne
    @JsonIgnoreProperties("score")
    private Reservation reservation;

    public Integer getIdScore() {
        return idScore;
    }

    public void setIdScore(Integer idScore) {
        this.idScore = idScore;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getCalification() {
        return calification;
    }

    public void setCalification(Integer calification) {
        this.calification = calification;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}

