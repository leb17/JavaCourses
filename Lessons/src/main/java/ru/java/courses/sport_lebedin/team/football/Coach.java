package ru.java.courses.sport_lebedin.team.football;

public class Coach {

    private String name;

    private int experience;

    public Coach(String name) {
        setName(name);
    }

    public Coach(String name, int experience) {
        setName(name);
        this.experience = experience;
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

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coach coach = (Coach) o;

        if (experience != coach.experience) return false;
        return name != null ? name.equals(coach.name) : coach.name == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + experience;
        return result;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "name='" + name + '\'' +
                ", experience=" + experience +
                '}';
    }
}
