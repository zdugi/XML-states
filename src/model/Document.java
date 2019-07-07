package model;

import java.util.ArrayList;

public class Document {
    private String title;
    private State currentState;
    private ArrayList<Field> fields;
    private ArrayList<Action> actions;

    public Document(String title, State currentState, ArrayList<Field> fields, ArrayList<Action> actions) {
        this.title = title;
        this.currentState = currentState;
        this.fields = fields;
        this.actions = actions;
    }

    public void changeState(State state) {
        currentState = state;
        currentState.entry();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public void addField(Field f) {
        fields.add(f);
    }

    public void removeField(Field f) {
        fields.remove(f);
    }

    public void addAction(Action a) {
        actions.add(a);
    }
}
