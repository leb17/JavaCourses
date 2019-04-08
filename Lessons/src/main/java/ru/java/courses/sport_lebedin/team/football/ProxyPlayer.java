package ru.java.courses.sport_lebedin.team.football;

import ru.java.courses.sport_lebedin.team.Athlete;
import ru.java.courses.sport_lebedin.team.ScoringPlayer;

public class ProxyPlayer extends Athlete implements ScoringPlayer {

    //private FootballPlayer player;

    private PlayerRole role;

    public ProxyPlayer(String name, PlayerRole role) {
        super(name);
        this.role = role;
        this.active = true;
    }

    @Override
    public void score() {
        FootballPlayer player = new FootballPlayer(getName(), role);
        player.score();
    }
}
