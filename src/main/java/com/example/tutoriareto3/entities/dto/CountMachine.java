package com.example.tutoriareto3.entities.dto;

import com.example.tutoriareto3.entities.Machine;

public class CountMachine {

    private Long total;
    private Machine skate;

    public CountMachine(Long total, Machine costume) {
        this.total = total;
        this.skate = costume;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Machine getCar() {
        return skate;
    }

    public void setCar(Machine room) {
        this.skate = room;
    }
}
