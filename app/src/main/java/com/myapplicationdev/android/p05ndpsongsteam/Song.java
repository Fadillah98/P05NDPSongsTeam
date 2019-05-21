package com.myapplicationdev.android.p05ndpsongsteam;

<<<<<<< Updated upstream
import java.io.Serializable;

public class Song implements Serializable {

    private int id;
    private String title;
    private String singers;
    private int year;
    private int stars;

    public Song(int id, String title, String singers, int year, int stars) {
        this.id = id;
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }

=======
public class Song {
>>>>>>> Stashed changes
    public int getId() {
        return id;
    }

<<<<<<< Updated upstream
=======
    public void setId(int id) {
        this.id = id;
    }

>>>>>>> Stashed changes
    public String getTitle() {
        return title;
    }

<<<<<<< Updated upstream
=======
    public void setTitle(String title) {
        this.title = title;
    }

>>>>>>> Stashed changes
    public String getSingers() {
        return singers;
    }

<<<<<<< Updated upstream
    public int getYear() {
        return year;
    }

    public int getStars() {
        return stars;
    }
}
=======
    public void setSingers(String singers) {
        this.singers = singers;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Song(int id, String title, String singers, Integer year, Integer stars) {
        this.id = id;
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }

    private int id;
    private String title;
    private String singers;
    private Integer year;
    private Integer stars;
}

>>>>>>> Stashed changes
