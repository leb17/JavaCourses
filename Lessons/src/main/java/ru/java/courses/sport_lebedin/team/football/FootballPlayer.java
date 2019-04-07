package ru.java.courses.sport_lebedin.team.football;

import ru.java.courses.sport_lebedin.team.Athlete;
import ru.java.courses.sport_lebedin.team.ScoringPlayer;

public class FootballPlayer extends Athlete implements ScoringPlayer {

    private PlayerRole role;

    //private boolean active;

    public FootballPlayer(String name, PlayerRole role) {
        super(name);
        setRole(role);
        this.active = true;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FootballPlayer that = (FootballPlayer) o;

        return role == that.role;

    }

    @Override
    public int hashCode() {
        return role != null ? role.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "FootballPlayer{" +
                "role=" + role +
                ", goals=" + goals +
                ", active=" + active +
                '}';
    }
}
