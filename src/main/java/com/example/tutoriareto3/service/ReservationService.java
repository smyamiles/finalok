package com.example.tutoriareto3.service;

import com.example.tutoriareto3.entities.Reservation;
import com.example.tutoriareto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            Optional<Reservation> e = reservationRepository.getReservation(r.getIdReservation());
            if(e.isPresent()){
                return r;
            }else {
                return reservationRepository.save(r);
            }
        }
    }
    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> e = reservationRepository.getReservation(reservation.getIdReservation());
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
        Optional<Reservation> e = reservationRepository.getReservation(id);
        if (e.isPresent()) {
            reservationRepository.delete(e.get());
            flag = true;
        }
        return flag;
    }
    /*public List<Reservation> getReservationsByPeriod(String dateA,String dateB){

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
            return reservationRepository.getDatesReport(a,b);
        }else{
            return new ArrayList<Reservation>();
        }
    }
    public StatusAccount getReportByStatus(){
        List<Reservation> completes=reservationRepository.getStatusReport("completed");
        List<Reservation> cancelled=reservationRepository.getStatusReport("cancelled");

        StatusAccount resultado=new StatusAccount(completes.size(),cancelled.size());
        return resultado;

    }
    public List<TopClients> getTopclients(){
        List<TopClients> tc=new ArrayList<>();
        List<Object[]> result= reservationRepository.getTopClients();

        for(int i=0;i<result.size();i++){
            int total=Integer.parseInt(result.get(i)[1].toString());
            Client client= (Client) result.get(i)[0];
            TopClients topClient=new TopClients(total,client);
            tc.add(topClient);
        }
        return tc;
    }
*/


}



