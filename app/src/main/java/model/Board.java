package model;

import java.util.ArrayList;

public class Board {

    public String name;
    public String title;

    public Board(String name, String title) {
        this.name = name;
        this.title = title;
    }

    public static ArrayList<Board> createBoardList() {
        ArrayList<Board> contacts = new ArrayList<Board>();

        contacts.add(new Board("Simon", "HeadacheHeadacheHeadacheHeadacheHeadacheHeadacheHeadacheHeadacheHeadacheHeadacheHeadacheHeadacheHeadacheHeadacheHeadacheHeadacheHeadache"));
        contacts.add(new Board("Simon2", "Headache"));
        contacts.add(new Board("Simon3", "Headache"));
        contacts.add(new Board("Simon4", "Headache"));
        contacts.add(new Board("Simon5", "Headache"));

        return contacts;

    }

}

