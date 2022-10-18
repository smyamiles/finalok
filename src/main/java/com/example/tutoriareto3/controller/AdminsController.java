package com.example.tutoriareto3.controller;

import com.example.tutoriareto3.entities.Admins;
import com.example.tutoriareto3.service.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Admin")
public class AdminsController {

    @Autowired
    private AdminsService adminsService;

    @GetMapping("/all")
    public List<Admins> getAll(){return adminsService.getAll();}

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admins save(@RequestBody Admins a){ return adminsService.save(a); }

    @GetMapping("/{id}")
    public Optional<Admins> getCostume(@PathVariable("id") int id){ return adminsService.getAdmin(id); }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admins update(@RequestBody Admins a){
        return adminsService.update(a);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return adminsService.delete(id);
    }

}
