package com.rep.innerclass;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建拥有功能的内部类
 */
public class FunctionalityInnerClassMain {

    private Player player;

    private List<Player> playerList;

    private int size = 4;

    /**
     * from w w w.j a v a 2 s . c o m Inner class representing a Player object
     */
    class Player {

        private String firstName = null;

        private String lastName = null;

        private String position = null;

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

        @Override
        public String toString() {
            return this.firstName + " " + this.lastName + " - " + this.position;
        }
    }

    /**
     * Inner class that constructs the Player objects and adds them to an array that was declared in the outer class;
     */
    public FunctionalityInnerClassMain() {

        final int ACTIVE = 0;

        // In reality, this would probably read records from a database using
        // a loop...but for this example we will manually enter the player data.
        playerList = new ArrayList();
        playerList.add(constructPlayer("A", "Z", "Right Wing", ACTIVE));
        playerList.add(constructPlayer("B", "X", "Left Wing", ACTIVE));
        playerList.add(constructPlayer("C", "Y", "Center", ACTIVE));
        playerList.add(constructPlayer("D", "W", "Defense", ACTIVE));
        playerList.add(constructPlayer("E", "G", "Goalie", ACTIVE));
    }

    public Player constructPlayer(String first, String last, String position, int status) {
        Player player = new Player();
        player.firstName = first;
        player.lastName = last;
        player.position = position;
        player.status = status;
        return player;
    }

    public List<Player> getPlayerList() {
        return this.playerList;
    }

    public static void main(String[] args) {
        FunctionalityInnerClassMain inner = new FunctionalityInnerClassMain();
        for (Player player : inner.getPlayerList()) {
            System.out.println(player.playerString());
        }

        FunctionalityInnerClassMain outerClass = new FunctionalityInnerClassMain();
        outerClass.player = outerClass.new Player();
        outerClass.player.setFirstName("Test");
        System.out.println(outerClass.player.firstName);

    }
}