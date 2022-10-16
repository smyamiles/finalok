package com.example.tutoriareto3.repository;

import com.example.tutoriareto3.entities.Reservation;
import com.example.tutoriareto3.repository.crudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation reservation) {
        return reservationCrudRepository.save(reservation);
    }

    public void delete(Reservation c){
        reservationCrudRepository.delete(c);
    }

    // public List<Reservation> getDatesReport(Date inicio, Date fin){
    // return reservationCrudRepository.findAllByIdSStartDateAfterAndStartDateBefore(inicio,fin);
    //}
    //public List<Reservation> getStatusReport(String sts){
     //   return reservationCrudRepository.finindAllByStatus(sts);
    //}

    //public List<Object[]> getTopClients(){ return reservationCrudRepository.getTopClients(); }


}

