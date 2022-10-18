package com.example.tutoriareto3.service;

import com.example.tutoriareto3.entities.Reservation;
import com.example.tutoriareto3.entities.dto.CountMachine;
import com.example.tutoriareto3.entities.dto.StatusAccount;
import com.example.tutoriareto3.entities.dto.TopClients;
import com.example.tutoriareto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Reservation save(Reservation r){
        if(r.getIdReservation()==null){
            return reservationRepository.save(r);
        }else {
            Optional<Reservation> e = reservationRepository.getReserva(r.getIdReservation());
            if(e.isPresent()){
                return r;
            }else {
                return reservationRepository.save(r);
            }
        }
    }
    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> e = reservationRepository.getReserva(reservation.getIdReservation());
            if (e.isPresent()) {
                if (reservation.getStartDate() != null) {
                    e.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getMachine() != null) {
                    e.get().setMachine(reservation.getMachine());
                }
                if (reservation.getClient() != null) {
                    e.get().setClient(reservation.getClient());
                }
                reservationRepository.save(e.get());
                return e.get();
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }


    }
    public boolean delete ( int id){
        boolean flag = false;
        Optional<Reservation> e = reservationRepository.getReserva(id);
        if (e.isPresent()) {
            reservationRepository.delete(e.get());
            flag = true;
        }
        return flag;
    }
    public List<Reservation> getReservationsByPeriod(String dateA,String dateB){

        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date a= new Date();
        Date b=new Date();
        try {
            a=parser.parse(dateA);
            b=parser.parse(dateB);
        }catch (ParseException e){
            e.printStackTrace();;
        }
        if(a.before(b)){
            return reservationRepository.getReservationPeriod(a,b);
        }else{
            return new ArrayList<Reservation>();
        }
    }
    public StatusAccount getReservationsStatusReport(){
        List<Reservation>completed=reservationRepository.getReservationsByStatus("completed");
        List<Reservation>cancelled=reservationRepository.getReservationsByStatus("cancelled");
        return new StatusAccount(completed.size(),cancelled.size());
    }

    public List<TopClients> getTopClients(){
        return reservationRepository.getTopClients();
    }

    public List<CountMachine> getTopMachine(){
        return reservationRepository.getTopMachine();
    }

}






