package com.example.tutoriareto3.service;

import com.example.tutoriareto3.entities.Client;
import com.example.tutoriareto3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int clientId) {
        return clientRepository.getClient(clientId);
    }

    public Client save(Client client) {
        if (client.getIdClient() == null) {
            return clientRepository.save(client);
        } else {
            Optional<Client> e = clientRepository.getClient(client.getIdClient());
            if (!e.isPresent()) {
                return clientRepository.save(client);
            } else {
                return client;
            }
        }
    }
        public boolean delete(int id){
            Optional<Client> e= clientRepository.getClient(id);
            if(e.isPresent()){
                clientRepository.delete(e.get());
                return true;
            }
            return false;
        }
        public Client update(Client client){
            if (client.getIdClient() != null) {
                Optional<Client> old = clientRepository.getClient(client.getIdClient());
                if (old.isPresent()) {
                    Client k = old.get();

                    if (client.getAge() != null) {
                        k.setAge(client.getAge());
                    }
                    if (client.getPassword() != null) {
                        k.setPassword(client.getPassword());
                    }
                    if (client.getEmail() != null) {
                        k.setEmail(client.getEmail());
                    }
                    if (client.getName() != null) {
                        k.setName(client.getName());
                    }

                    return clientRepository.save(k);
                }
            }
            return client;

        }
}

