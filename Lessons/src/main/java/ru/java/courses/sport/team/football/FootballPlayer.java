package ru.java.courses.sport.team.football;

public class FootballPlayer {

    private String name;

    private PlayerRole role;

    private boolean active;

    private int goals;


    public FootballPlayer(String name, PlayerRole role) {
        if (name == null || name.isEmpty() ) {
            throw new IllegalArgumentException("Нужно задать имя");
        }
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return goals;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void score() {
        if (isActive()) {
            goals++;
        } else
            throw new IllegalArgumentException("Запасной не может забить со скамейки");
    }
}
