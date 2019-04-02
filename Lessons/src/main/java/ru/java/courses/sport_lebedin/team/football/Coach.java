package ru.java.courses.sport_lebedin.team.football;

public class Coach {

    private String name;

    private int experience;

    public Coach(String name) {
        setName(name);
    }

    public Coach(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty() ) {
            throw new IllegalArgumentException("Нужно задать имя");
        } else
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
