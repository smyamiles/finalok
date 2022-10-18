package com.example.tutoriareto3.controller;

import com.example.tutoriareto3.service.ScoreService;
import com.example.tutoriareto3.entities.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Score")
public class ScoreController {

    @Autowired
    private ScoreService ScoreService;

    @GetMapping("/all")
    public List<Score> getAll(){ return ScoreService.getAll(); }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score c){ return ScoreService.save(c);}

    @GetMapping("/{id}")
    public Optional<Score> getCostume(@PathVariable("id") int id){ return ScoreService.getCalificacion(id); }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Score update(@RequestBody Score s){
        return ScoreService.update(s);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return ScoreService.delete(id);
    }
}
