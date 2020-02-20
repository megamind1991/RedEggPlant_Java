package com.rep.oop;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class NotShallowCloneMain {

    public static void main(String[] args) {
        Team team1 = new Team();
        Team team2 = new Team();

        team1.setCity("Boston");
        team1.setName("Flag");

        team2.setCity("Chicago");
        team2.setName("Fire");

        Team team3 = team1;/*from w  w  w.  j a va  2s  .  c om*/
        Team team4 = team2.clone();

        Team team5 = team1.shallowCopyClone();

        System.out.println("Team 3:");
        System.out.println(team3.getCity());
        System.out.println(team3.getName());

        System.out.println("Team 4:");
        System.out.println(team4.getCity());
        System.out.println(team4.getName());

        // Teams move to different cities
        team1.setCity("St. Louis");
        team2.setCity("Orlando");

        System.out.println("Team 3:");
        System.out.println(team3.getCity());
        System.out.println(team3.getName());

        System.out.println("Team 4:");
        System.out.println(team4.getCity());
        System.out.println(team4.getName());

        System.out.println("Team 5:");
        System.out.println(team5.getCity());
        System.out.println(team5.getName());

        if (team1 == team3) {
            System.out.println("team1 and team3 are equal");
        } else {
            System.out.println("team1 and team3 are NOT equal");
        }

        if (team1 == team5) {
            System.out.println("team1 and team5 are equal");
        } else {
            System.out.println("team1 and team5 are NOT equal");
        }

    }

}

class Team implements Cloneable, Serializable {

    private String name;
    private String city;

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

    /**
     * Overrides Object's clone method to create a deep copy
     *
     * @return
     */
    @Override
    public Team clone() {

        Team obj = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);
            oos.close();

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            obj = (Team) ois.readObject();
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
        return obj;
    }

    /**
     * Overrides Object's clone method to create a shallow copy
     *
     * @return
     */
    public Team shallowCopyClone() {

        try {
            return (Team) super.clone();
        } catch (CloneNotSupportedException ex) {
            return null;
        }
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj instanceof Team) {
            Team other = (Team) obj;
            return other.getName().equals(this.getName())
                    && other.getCity().equals(this.getCity());
        } else {
            return false;
        }

    }
}