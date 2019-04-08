package ru.java.courses.sport_lebedin.team.football;

public enum PlayerRole {

    GOALKEEPER("Вратарь"),
    DEFENDER("Защитник"),
    WINGER("Нападающий"); //public static final PlayerRole WINGER = new PlayerRole("Нападающий");

    protected String name;

    PlayerRole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /*public void setRole(String role) {
        this.name = role;
    }*/
}
