package ru.java.courses.sport_lebedin.team.football;

import ru.java.courses.sport_lebedin.team.Athlete;

public class FootballPlayer extends Athlete {

    private PlayerRole role;

    private boolean active;

    public FootballPlayer(String name, PlayerRole role) {
        super(name);
        if (role == null) {
            throw new IllegalArgumentException("");
        }
        this.role = role;
        this.active = true;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public PlayerRole getRole() {
        return role;
    }

    public void setRole(PlayerRole role) {
        if (role == null) {
            throw new IllegalArgumentException("");
        }
        this.role = role;
    }

    public void score() {
        if (isActive()) {
            goals++;
        } else
            throw new IllegalArgumentException("Запасной не может забить гол");
    }
}
