package model;

import java.util.ArrayList;

public class Document {
    private String title;
    private State currentState;
    private ArrayList<Field> fields;
    private ArrayList<Action> actions;

    public boolean changeState(State state) {
        return false;
    }
}
