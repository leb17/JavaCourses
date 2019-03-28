package ru.java.courses.sport.team.football;

import java.util.ArrayList;

public class FootballTeam {

    private ArrayList<FootballPlayer> players = new ArrayList<FootballPlayer>();

    private String name;

    private Coach coach;

    private static final int MAX_PLAYERS_COUNT = 20;


    public FootballTeam(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public int getPlayersCount(String[] players) {
        return players.length;
    }

    public static int getMaxPlayersCount() {
        return MAX_PLAYERS_COUNT;
    }

    public void addPlayers(FootballPlayer player) {
        if (players.size() >= MAX_PLAYERS_COUNT) {
            throw new IllegalArgumentException("Команда уже укомплектована");
        } else
            players.add(player);
    }

    public void removePlayers(FootballPlayer player) {
        players.remove(player);
    }

    public int getScore(ArrayList<FootballPlayer> players) {
        int sum = 0;
        for (FootballPlayer player : players) {
            sum += player.getScore();
        }
        return sum;
    }

}
