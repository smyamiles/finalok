package com.example.tutoriareto3.repository;

import com.example.tutoriareto3.entities.Admins;
import com.example.tutoriareto3.repository.crudRepository.AdminsCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminsRepository {

    @Autowired
    private AdminsCrudRepository adminsCrudRepository;

    public List<Admins> getAll(){ return (List<Admins>) adminsCrudRepository.findAll(); }

    public Admins save(Admins a){ return adminsCrudRepository.save(a); }

    public void delete(Admins a){ adminsCrudRepository.delete(a); }

    public Optional<Admins> getAdmin(int id){
        return adminsCrudRepository.findById(id);
    }

}
