package ru.java.courses.sport_lebedin.team.football;

import ru.java.courses.sport_lebedin.team.Athlete;

public class FootballPlayer extends Athlete implements ScoringPlayer {

    private PlayerRole role;

    private boolean active;

    public FootballPlayer(String name, PlayerRole role) {
        super(name);
        setRole(role);
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

    @Override
    public void score() {
        if (isActive()) {
            goals++;
        } else
            throw new IllegalArgumentException("Запасной не может забить гол");
    }

    @Override
    public int getScore() {
        return goals;
    }
}
