package com.example.tutoriareto3.repository.crudRepository;

import com.example.tutoriareto3.entities.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {

    @Query("SELECT c.machine, COUNT(c.machine) from Reservation AS c group by c.machine order by COUNT(c.machine) DESC")
    public List<Object[]> countTotalReservationsByMachine();

    //select clientId, count(*) as "total" from reservation group by clientId order by total desc;

    @Query("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client) DESC")

    public List<Object[]> countTotalReservationsByClient();

    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo );

    public List<Reservation>findAllByStatus(String status);


}
