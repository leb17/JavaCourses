package ru.java.courses.sport_lebedin.team;

public class Athlete {
    String name;

    protected int goals;

    public Athlete(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public final void setName(String name) {
        if (name == null || name.isEmpty() ) {
            throw new IllegalArgumentException("Нужно задать имя");
        } else
        this.name = name;
    }

    public int getScore() {
        return goals;
    }

    public int getGoals() {return goals;}

    public void setScore(int goals) {
        this.goals = goals;
    }
}
