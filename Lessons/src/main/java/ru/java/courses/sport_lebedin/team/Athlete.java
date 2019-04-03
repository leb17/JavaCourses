package ru.java.courses.sport_lebedin.team;

public class Athlete {

    private String name;

    protected int goals;

    protected boolean active;

    public Athlete(String name) {
        setName(name);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Athlete athlete = (Athlete) o;

        if (goals != athlete.goals) return false;
        if (active != athlete.active) return false;
        return name != null ? name.equals(athlete.name) : athlete.name == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + goals;
        result = 31 * result + (active ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "name='" + name + '\'' +
                ", goals=" + goals +
                ", active=" + active +
                '}';
    }
}
