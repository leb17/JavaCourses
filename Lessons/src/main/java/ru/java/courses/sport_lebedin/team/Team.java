package ru.java.courses.sport_lebedin.team;

import ru.java.courses.sport_lebedin.team.football.Coach;
import java.util.ArrayList;
import java.util.Collections;

public abstract class Team<T extends Athlete & ScoringPlayer> {

    private String name;

    private Coach coach;

    private ArrayList<T> players = new ArrayList<>();

    public Team(String name) {
        setName(name);
    }

    public abstract int getMaxPlayersCount();

    public int getPlayersCount() {
        return players.size();
    }

    public void addPlayer(T player) {
        if (player == null) {
            throw new IllegalArgumentException("Игрок не выбран");
        } else if (players.size() >= getMaxPlayersCount()) {
            throw new IllegalArgumentException("Команда уже укомплектована");
        } else
            players.add(player);
    }

    public void addPlayers(T...newplayers) {
        for (T f: newplayers) {
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

    public void removePlayer(T player) {
        if (player == null) {
            throw new IllegalArgumentException("Игрок не выбран");
        } else
            players.remove(player);
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        int sum = 0;
        for (T player : players) {
            sum += player.getScore();
        }
        return sum;
    }

    public final void setName(String name) {
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

    public ArrayList<T> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<T> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", coach=" + coach +
                ", players=" + players +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team<?> team = (Team<?>) o;

        if (name != null ? !name.equals(team.name) : team.name != null) return false;
        if (coach != null ? !coach.equals(team.coach) : team.coach != null) return false;
        return players != null ? players.equals(team.players) : team.players == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (coach != null ? coach.hashCode() : 0);
        result = 31 * result + (players != null ? players.hashCode() : 0);
        return result;
    }
}
