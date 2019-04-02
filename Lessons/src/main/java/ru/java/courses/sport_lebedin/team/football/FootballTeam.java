package ru.java.courses.sport_lebedin.team.football;

import java.util.ArrayList;
import java.util.Collections;

public class FootballTeam {

    private ArrayList<FootballPlayer> players = new ArrayList<>();

    private String name;

    private Coach coach;

    private static final int MAX_PLAYERS_COUNT = 20;


    public FootballTeam(String name) {
        if (name == null || name.isEmpty() ) {
            throw new IllegalArgumentException("Нужно задать имя");
        } else
        this.name = name;
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

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public ArrayList<FootballPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<FootballPlayer> players) {
        this.players = players;
    }

    public int getPlayersCount() {
        return players.size();
    }

    public static int getMaxPlayersCount() {
        return MAX_PLAYERS_COUNT;
    }

    public void addPlayer(FootballPlayer player) {
        if (players.size() >= getMaxPlayersCount()) {
            throw new IllegalArgumentException("Команда уже укомплектована");
        } else
            players.add(player);
    }

    public void addPlayers(FootballPlayer...newplayers) {
        if (this.players.size() + newplayers.length > getMaxPlayersCount()) {
            throw new IllegalArgumentException("Команда уже укомплектована");
        } else
            /*for (FootballPlayer player : newplayers) {
                this.players.add(player);
            }*/
            Collections.addAll(this.players, newplayers);
    }

    public void removePlayer(FootballPlayer player) {
        players.remove(player);
    }

    public int getScore() {
        int sum = 0;
        for (FootballPlayer player : players) {
            sum += player.getScore();
        }
        return sum;
    }

}
