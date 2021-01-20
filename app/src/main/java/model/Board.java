package model;

import java.util.ArrayList;

public class Board {

    public String name;
    public String title;

    public Board(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    /*public static ArrayList<Board> createBoardList() {
        ArrayList<Board> contacts = new ArrayList<Board>();

        contacts.add(new Board("Simon", "Headache"));
        contacts.add(new Board("Simon2", "Headache"));
        contacts.add(new Board("Simon3", "Headache"));
        contacts.add(new Board("Simon4", "Headache"));
        contacts.add(new Board("Simon5", "Headache"));

        return contacts;

    }*/

}

