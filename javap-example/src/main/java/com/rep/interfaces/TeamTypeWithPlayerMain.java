package com.rep.interfaces;

import java.util.List;

interface TeamType {

    void setPlayers(List<Player> players);

    void setName(String name);

    void setCity(String city);

    String getFullName();/* w w w. j av a2 s.c o m */

    List<Player> getPlayers();

    // 在不破坏现有代码的情况下 修改接口
    default void listPlayers() {
        getPlayers().stream().forEach((player) -> {
            System.out.println(player.getFirstName() + " " + player.getLastName());
        });
    }

}

public class TeamTypeWithPlayerMain {

    public static void main(String[] args) {
        TeamType team1 = new Team();
        // 通过接口方法 调用实现类 进行交互 interact交互
        team1.getFullName();
    }
}

class Player {

    private String firstName;

    private String lastName;

    private String position;

    private int status = -1;

    public Player() {

    }

    public Player(String position, int status) {
        this.position = position;
        this.status = status;
    }

    public String playerString() {
        return getFirstName() + " " + getLastName() + " - " + getPosition();
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }
}

class Team implements TeamType {

    private List<Player> players;

    private String name;

    private String city;

    /**
     * @return the players
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * @param players the players to set
     */
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    public String getFullName() {
        return this.name + " - " + this.city;
    }

}