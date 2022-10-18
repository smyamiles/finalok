package com.example.tutoriareto3.repository;

import com.example.tutoriareto3.entities.Client;
import com.example.tutoriareto3.entities.Machine;
import com.example.tutoriareto3.entities.Reservation;
import com.example.tutoriareto3.entities.dto.CountMachine;
import com.example.tutoriareto3.entities.dto.TopClients;
import com.example.tutoriareto3.repository.crudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository

public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservaCrudRepository;

    public List<Reservation> getAll(){ return (List<Reservation>) reservaCrudRepository.findAll(); }

    public Reservation save(Reservation r){ return reservaCrudRepository.save(r); }

    public void delete(Reservation r){ reservaCrudRepository.delete(r); }

    public Optional<Reservation> getReserva(int id){ return reservaCrudRepository.findById(id); }


    public List<CountMachine> getTopMachine(){
        List<CountMachine>res=new ArrayList<>();
        List<Object[]>report=reservaCrudRepository.countTotalReservationsByMachine();
        for(int i=0;i<report.size();i++){
            res.add(new CountMachine((Long)report.get(i)[1],(Machine) report.get(i)[0]));
        }
        return res;
    }


    public  List<TopClients> getTopClients(){
        List<TopClients>res=new ArrayList<>();
        List<Object[]>report=reservaCrudRepository.countTotalReservationsByClient();
        for(int i=0;i<report.size();i++){
            res.add(new TopClients((Long)report.get(i)[1],(Client) report.get(i)[0]));
        }
        return res;
    }

    public List<Reservation> getReservationPeriod(Date a, Date b){
        return reservaCrudRepository.findAllByStartDateAfterAndStartDateBefore(a,b);
    }

    public List<Reservation> getReservationsByStatus(String status){
        return reservaCrudRepository.findAllByStatus(status);
    }



}

