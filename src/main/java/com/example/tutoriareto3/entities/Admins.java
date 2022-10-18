package com.example.tutoriareto3.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "admins")
public class Admins implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idAdmin;
    private String name;
    private String email;
    private String password;

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
