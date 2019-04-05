package ru.java.courses.sport_lebedin.team.football;

import ru.java.courses.sport_lebedin.team.Team;
import java.util.ArrayList;
import java.util.Collections;

public class FootballTeam extends Team {

    private ArrayList<FootballPlayer> players = new ArrayList<>();

    private static final int MAX_PLAYERS_COUNT = 20;


    public FootballTeam(String name) {
        super(name);
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
        if (player == null) {
            throw new IllegalArgumentException("Игрок не выбран");
        } else if (players.size() >= getMaxPlayersCount()) {
            throw new IllegalArgumentException("Команда уже укомплектована");
        } else
            players.add(player);
    }

    public void addPlayers(FootballPlayer...newplayers) {
        for (FootballPlayer f: newplayers) {
            if (f == null) {
                throw new IllegalArgumentException("Один из игроков не выбран");
            }
        }
        if (players.size() + newplayers.length > getMaxPlayersCount()) {
            throw new IllegalArgumentException("Команда уже укомплектована");
        } else
            /*for (FootballPlayer player : newplayers) {
                this.players.add(player);
            }*/
            Collections.addAll(this.players, newplayers);
    }

    public void removePlayer(FootballPlayer player) {
        if (player == null) {
            throw new IllegalArgumentException("Игрок не выбран");
        } else
            players.remove(player);
    }

    public int getScore() {
        int sum = 0;
        for (ScoringPlayer player : players) {
            sum += player.getScore();
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FootballTeam that = (FootballTeam) o;

        return players != null ? players.equals(that.players) : that.players == null;

    }

    @Override
    public int hashCode() {
        return players != null ? players.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "FootballTeam{" +
                "players=" + players +
                '}';
    }
}
