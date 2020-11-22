package com.rep.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericListAndMapMain {
    public static void main(String[] args) {
        List<Player> team = new ArrayList<>();
        Player player1 = new Player("A", "AA", 5);
        Player player2 = new Player("B", "BB", 15);
        Player player3 = new Player("C", "CC", 1);
        Player player4 = new Player("D", "DD", 18);
        Player player5 = new Player("E", "EE", 7);

        team.add(player1);// ww w . jav a 2 s . c om
        team.add(player2);
        team.add(player3);
        team.add(player4);
        team.add(player5);

        List objectList = new ArrayList();
        Object obj1 = "none";
        objectList.add(obj1);

        // Create a List that can be of type that is any superclass of Player
        List<? super Player> myTeam = team;
        for (Object p : myTeam) {
            System.out.println("Printing the objects...");
            System.out.println(p.toString());
        }

        Map<String, String> strMap = new HashMap<>();
        strMap.put("first", "Josh");
        strMap.put("last", "Juneau");
        System.out.println(strMap.values());
    }
}

class Player {

    private String firstName = null;

    private String lastName = null;

    private String position = null;

    private int status = -1;

    private int goals;

    public Player() {

    }

    public Player(String position, int status) {
        this.position = position;
        this.status = status;
    }

    public Player(String first, String last, int goals) {
        this.firstName = first;
        this.lastName = last;
        this.goals = goals;
    }

    public Player(String position, int status, String first, String last) {
        this.position = position;
        this.status = status;
        this.firstName = first;
        this.lastName = last;
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

    /**
     * @return the goals
     */
    public int getGoals() {
        return goals;
    }

    /**
     * @param goals the goals to set
     */
    public void setGoals(int goals) {
        this.goals = goals;
    }

}