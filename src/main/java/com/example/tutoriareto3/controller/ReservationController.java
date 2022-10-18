package com.example.tutoriareto3.controller;

import com.example.tutoriareto3.entities.Reservation;
import com.example.tutoriareto3.entities.dto.CountMachine;
import com.example.tutoriareto3.entities.dto.StatusAccount;
import com.example.tutoriareto3.entities.dto.TopClients;
import com.example.tutoriareto3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    @GetMapping("/all")
    public List<Reservation> getAll() {
        return reservationService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation r){
        return reservationService.update(r);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return reservationService.delete(id);
    }

    //RETO 5

    @GetMapping("/report-costue")
    public List<CountMachine> getReservationsReportRoom(){
        return reservationService.getTopMachine();
    }

    @GetMapping("/report-clients")
    public List<TopClients> getReservationsReportClient(){
        return reservationService.getTopClients();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservationsReportDates(@PathVariable("dateOne") String dateOne,@PathVariable("dateTwo") String dateTwo){
        return reservationService.getReservationsByPeriod(dateOne,dateTwo);
    }
    @GetMapping("/report-dates/amount/{dateOne}/{dateTwo}")
    public Integer getReservationsReportDatesAmount(@PathVariable("dateOne") String dateOne,@PathVariable("dateTwo") String dateTwo){
        return reservationService.getReservationsByPeriod(dateOne,dateTwo).size();
    }

    @GetMapping("/report-status")
    public StatusAccount getReservationsStatusReport(){
        return reservationService.getReservationsStatusReport();
    }



}

