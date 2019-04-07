package ru.java.courses.sport_lebedin.team.football;

import ru.java.courses.sport_lebedin.team.Athlete;
import ru.java.courses.sport_lebedin.team.ScoringPlayer;

public class ProxyPlayer extends Athlete implements ScoringPlayer {

    private FootballPlayer player; //объект, который хочу подменить

    private PlayerRole role;

    public ProxyPlayer(String name, PlayerRole role) {
        super(name);
        this.role = role;
        this.active = true;
    }

    @Override
    public void score() {
        if (player == null) {
            player = new FootballPlayer("proxy", role);
        }
            goals++;
    }
}
