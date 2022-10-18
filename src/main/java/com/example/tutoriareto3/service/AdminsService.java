package com.example.tutoriareto3.service;

import com.example.tutoriareto3.entities.Admins;
import com.example.tutoriareto3.repository.AdminsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminsService {

    @Autowired
    private AdminsRepository adminsRepository;

    public List<Admins> getAll(){ return adminsRepository.getAll(); }

    public Optional<Admins> getAdmin(int id){ return adminsRepository.getAdmin(id); }

    public Admins save(Admins a){
        if(a.getIdAdmin()==null){
            return adminsRepository.save(a);
        }else {
            Optional<Admins> e = adminsRepository.getAdmin(a.getIdAdmin());
            if(e.isPresent()){
                return a;
            }else {
                return adminsRepository.save(a);
            }
        }
    }

    public Admins update(Admins admins){
        if(admins.getIdAdmin()!=null){
            Optional<Admins> e = adminsRepository.getAdmin(admins.getIdAdmin());
            if (e.isPresent()){
                if (admins.getName()!=null){
                    e.get().setName(admins.getName());
                }
                if (admins.getPassword()!=null){
                    e.get().setPassword(admins.getPassword());
                }
                if (admins.getEmail()!=null){
                    e.get().setEmail(admins.getEmail());
                }
                adminsRepository.save(e.get());
                return e.get();
            }else {
                return admins;
            }
        }else {
            return admins;
        }
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Admins> e = adminsRepository.getAdmin(id);
        if(e.isPresent()){
            adminsRepository.delete(e.get());
            flag = true;
        }
        return flag;
    }


}
