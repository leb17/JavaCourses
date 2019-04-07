package ru.java.courses.sport_lebedin.team;

import ru.java.courses.sport_lebedin.team.football.Coach;

public abstract class Team<T extends Athlete> {

    private String name;

    private Coach coach;

    public Team(String name) {
        setName(name);
    }

    public abstract int getMaxPlayersCount();

    public String getName() {
        return name;
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
}
