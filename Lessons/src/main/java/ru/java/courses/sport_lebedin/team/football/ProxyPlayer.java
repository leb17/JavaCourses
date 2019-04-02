package ru.java.courses.sport_lebedin.team.football;

import ru.java.courses.sport_lebedin.team.Athlete;

public class ProxyPlayer extends Athlete implements ScoringPlayer{

    private FootballPlayer player;

    private PlayerRole role;

    private boolean active;

    public ProxyPlayer(String name, PlayerRole role) {
        super(name);
        this.role = role;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public void score() { //в случае если прокси-игрок окажется запасным, то создаётся обычный активный
        if (isActive()) {
            goals++;
        } else {
            player = new FootballPlayer("",role);
            goals++;
        }
    }
}
