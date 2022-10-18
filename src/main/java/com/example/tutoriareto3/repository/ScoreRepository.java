package com.example.tutoriareto3.repository;

import com.example.tutoriareto3.entities.Score;
import com.example.tutoriareto3.repository.crudRepository.ScoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public class ScoreRepository {
    @Autowired
    private ScoreCrudRepository calificacionCrudRepository;

    public List<Score> getAll(){
        return (List<Score>) calificacionCrudRepository.findAll();
    }

    public Score save(Score c){
        return calificacionCrudRepository.save(c);
    }

    public void delete(Score c){
        calificacionCrudRepository.delete(c);
    }

    public Optional<Score> getCalificacion(int id){
        return calificacionCrudRepository.findById(id);
    }


}

