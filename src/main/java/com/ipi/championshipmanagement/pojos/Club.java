package com.ipi.championshipmanagement.pojos;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Club {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String dateCreation;
    private String logo;
    private String nameTrainer;
    private String president;
    private String status;
    private String headquarters;
    private String phone;
    private String webSite;

    @ManyToOne
    private Championship championship;

    @OneToOne
    private Stadium stadium;

    @OneToMany(mappedBy = "club1")
    private List<Match> homeMatches;

    @OneToMany(mappedBy = "club2")
    private List<Match> awayMatches;

    public Club() {
    }

    public Club(String name, String dateCreation, String logo, String nameTrainer, String president,
                String status, String headquarters, String phone, String webSite) {
        this.name = name;
        this.dateCreation = dateCreation;
        this.logo = logo;
        this.nameTrainer = nameTrainer;
        this.president = president;
        this.status = status;
        this.headquarters = headquarters;
        this.phone = phone;
        this.webSite = webSite;
    }

    // Getters et Setters
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

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getNameTrainer() {
        return nameTrainer;
    }

    public void setNameTrainer(String nameTrainer) {
        this.nameTrainer = nameTrainer;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHeadquarters() {
        return headquarters;
    }

    public void setHeadquarters(String headquarters) {
        this.headquarters = headquarters;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Championship getChampionship() {
        return championship;
    }

    public void setChampionship(Championship championship) {
        this.championship = championship;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public List<Match> getHomeMatches() {
        return homeMatches;
    }

    public void setHomeMatches(List<Match> homeMatches) {
        this.homeMatches = homeMatches;
    }

    public List<Match> getAwayMatches() {
        return awayMatches;
    }

    public void setAwayMatches(List<Match> awayMatches) {
        this.awayMatches = awayMatches;
    }
}
