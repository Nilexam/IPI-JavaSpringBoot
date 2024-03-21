package com.ipi.championshipmanagement.pojos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
public class Championship {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String logo;
    private Date dateBeginning;
    private Date dateEnd;
    private int pointGagne;
    private int pointPerdu;
    private int pointNul;
    private String classementType;

    @ManyToOne
    private Country country;

    @ManyToOne
    private Club club;

    @ManyToOne
    private Day day;

    @OneToMany(mappedBy = "championship")
    private List<Game> games;

    public Championship() {
    }

    public Championship(String name, String logo, Date dateBeginning, Date dateEnd, int pointGagne,
                        int pointPerdu, int pointNul, String classementType, Country country, Club club, Day day) {
        this.name = name;
        this.logo = logo;
        this.dateBeginning = dateBeginning;
        this.dateEnd = dateEnd;
        this.pointGagne = pointGagne;
        this.pointPerdu = pointPerdu;
        this.pointNul = pointNul;
        this.classementType = classementType;
        this.country = country;
        this.club = club;
        this.day = day;
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

    public int getPointGagne() {
        return pointGagne;
    }

    public void setPointGagne(int pointGagne) {
        this.pointGagne = pointGagne;
    }

    public int getPointPerdu() {
        return pointPerdu;
    }

    public void setPointPerdu(int pointPerdu) {
        this.pointPerdu = pointPerdu;
    }

    public int getPointNul() {
        return pointNul;
    }

    public void setPointNul(int pointNul) {
        this.pointNul = pointNul;
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

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
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
}
