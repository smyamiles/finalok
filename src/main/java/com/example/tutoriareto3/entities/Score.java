package com.example.tutoriareto3.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "score")
public class Score implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idScore;
    private String messageText;
    private Integer machine;//fala de precio
    private String score;
}

