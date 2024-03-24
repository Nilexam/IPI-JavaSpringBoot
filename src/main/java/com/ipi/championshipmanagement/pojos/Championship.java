package com.ipi.championshipmanagement.pojos;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
public class Championship {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String logo;
    private Date dateBeginning;
    private Date dateEnd;
    private String classementType;

    @ManyToOne
    private Country country;

    @ManyToMany
    private List<Club> club;

    @ManyToOne
    private Day day;

    @OneToMany(mappedBy = "championship")
    private List<Game> games;

    @ElementCollection
    @CollectionTable(name = "championship_club_points")
    @MapKeyJoinColumn(name = "club_id")
    @Column(name = "points")
    private Map<Club, Integer> pointsEquipe;

    public Championship() {
    }

    public Championship(String name, String logo, Date dateBeginning, Date dateEnd, String classementType,
                        Country country, List<Club> club, Day day, Map<Club, Integer> pointsEquipe) {
        this.name = name;
        this.logo = logo;
        this.dateBeginning = dateBeginning;
        this.dateEnd = dateEnd;
        this.classementType = classementType;
        this.country = country;
        this.club = club;
        this.day = day;
        this.pointsEquipe = pointsEquipe;
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Date getDateBeginning() {
        return dateBeginning;
    }

    public void setDateBeginning(Date dateBeginning) {
        this.dateBeginning = dateBeginning;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getClassementType() {
        return classementType;
    }

    public void setClassementType(String classementType) {
        this.classementType = classementType;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Club> getClub() {
        return club;
    }

    public void setClub(List<Club> club) {
        this.club = club;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public Map<Club, Integer> getPointsEquipe() {
        return pointsEquipe;
    }

    public void setPointsEquipe(Map<Club, Integer> pointsEquipe) {
        this.pointsEquipe = pointsEquipe;
    }
}
