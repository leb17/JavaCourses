package ru.java.courses.sport_lebedin.team.football;

import ru.java.courses.sport_lebedin.team.Team;

public class FootballTeam extends Team<FootballPlayer> {

    private static final int MAX_PLAYERS_COUNT = 20;

    public FootballTeam(String name) {
        super(name);
    }

    public int getMaxPlayersCount() {
        return MAX_PLAYERS_COUNT;
    }

    @Override
    public String toString() {
        return "FootballTeam{}";
    }

}
