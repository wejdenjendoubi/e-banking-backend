package com.example.ebankig.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users") 
public class User {

    @Id
    private String login;   // clé primaire

    @Column(nullable = false)
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    // Un user peut avoir plusieurs comptes
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Compte> comptes;


    public User() {
    }

    public User(String login, String password, String firstName, String lastName, String email, List<Compte> comptes) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.comptes = comptes;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    public List<Compte> getComptes() {
        return comptes;
    }
    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }
}
