package com.ipi.championshipmanagement.pojos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Day {

    @Id
    @GeneratedValue
    private long id;

    private int number;

    @ManyToOne
    private Championship championship;

    @OneToMany(mappedBy = "day")
    private List<Game> games;

    public Day() {
    }

    public Day(int number, Championship championship) {
        this.number = number;
        this.championship = championship;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Championship getChampionship() {
        return championship;
    }

    public void setChampionship(Championship championship) {
        this.championship = championship;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
