package com.example.tutoriareto3.entities.dto;


import com.example.tutoriareto3.entities.Client;

public class TopClients {
    private long total;
    private Client client;


    public TopClients(long total, Client client){
        this.total=total;
        this.client=client;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
