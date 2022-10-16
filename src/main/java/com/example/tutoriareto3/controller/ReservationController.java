package com.example.tutoriareto3.controller;

import com.example.tutoriareto3.entities.Reservation;
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
    /*@GetMapping("/report-dates/{dateA}/{dateB}")
    public List<Reservation> getByDates(@PathVariable("dateA")String da,@PathVariable("dateB")String db ){ return reservationService.getReservationsByPeriod(da,db);}
    @GetMapping("/report-status")
    public StatusAccount getByStatus(){
        return reservationService.getReportByStatus();
    }
    @GetMapping("/report-clients")
    public List<TopClients> getTopClients(){
        return reservationService.getTopclients();
    }
*/

}

