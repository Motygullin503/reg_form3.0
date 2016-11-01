package ru.itis.entities;

/**
 * Created by UseR7 on 14.10.2016.
 */
public class Themes {
    private String name;
    private String sport;
    private String music;
    private String city;
    private String category;

    public Themes(String name, String sport, String music, String city, String category) {
        this.name = name;
        this.sport = sport;
        this.music = music;
        this.city = city;
        this.category = category;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
