package com.example.tutoriareto3.service;

import com.example.tutoriareto3.entities.Score;
import com.example.tutoriareto3.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository calificacionRepository;

    public List<Score> getAll(){ return calificacionRepository.getAll(); }

    public Optional<Score> getCalificacion(int id){ return calificacionRepository.getCalificacion(id); }

    public Score save(Score c){
        if(c.getIdScore()==null){
            return calificacionRepository.save(c);
        }else {
            Optional<Score> e = calificacionRepository.getCalificacion(c.getIdScore());
            if(e.isPresent()){
                return c;
            }else {
                return calificacionRepository.save(c);
            }
        }
    }

    public Score update(Score score){
        if(score.getIdScore()!=null){
            Optional<Score> e = calificacionRepository.getCalificacion(score.getIdScore());
            if (e.isPresent()){
                if (score.getCalification()!=null){
                    e.get().setCalification(score.getCalification());
                }
                if (score.getMessages()!=null){
                    e.get().setMessages(score.getMessages());
                }
                calificacionRepository.save(e.get());
                return e.get();
            }else {
                return score;
            }
        }else {
            return score;
        }
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Score> e = calificacionRepository.getCalificacion(id);
        if(e.isPresent()){
            calificacionRepository.delete(e.get());
            flag = true;
        }
        return flag;
    }



}
