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

    // Un user peut avoir plusieurs comptes
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Compte> comptes;

    public User() {}

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    // getters et setters
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public List<Compte> getComptes() {
        return comptes;
    }
    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }
}
