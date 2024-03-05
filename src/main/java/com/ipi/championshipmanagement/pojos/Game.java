package com.ipi.championshipmanagement.pojos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Game {

    @Id
    @GeneratedValue
    private long id;

    private int goalClub1;
    private int goalClub2;

    @ManyToOne
    private Stadium stadium;

    @ManyToOne
    private Club club1;

    @ManyToOne
    private Club club2;

    @ManyToOne
    private Day day;

    public Game() {
    }

    public Game(int goalClub1, int goalClub2, Stadium stadium, Club club1, Club club2, Day day) {
        this.goalClub1 = goalClub1;
        this.goalClub2 = goalClub2;
        this.stadium = stadium;
        this.club1 = club1;
        this.club2 = club2;
        this.day = day;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getGoalClub1() {
        return goalClub1;
    }

    public void setGoalClub1(int goalClub1) {
        this.goalClub1 = goalClub1;
    }

    public int getGoalClub2() {
        return goalClub2;
    }

    public void setGoalClub2(int goalClub2) {
        this.goalClub2 = goalClub2;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public Club getClub1() {
        return club1;
    }

    public void setClub1(Club club1) {
        this.club1 = club1;
    }

    public Club getClub2() {
        return club2;
    }

    public void setClub2(Club club2) {
        this.club2 = club2;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

}
