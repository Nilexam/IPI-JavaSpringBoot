package com.ipi.championshipmanagement.pojos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.List;

@Entity
public class Stadium {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String address;
    private int capacity;
    private String phone;

    @OneToOne(mappedBy = "stadium")
    private Club club;

    @OneToMany(mappedBy = "stadium")
    private List<Match> matches;

    public Stadium() {
    }

    public Stadium(String name, String address, int capacity, String phone) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
}
