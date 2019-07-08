package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public abstract class State {
    protected int stateID;
    protected Collection<Field> deleted;
    protected Collection<Field> hidden;
    protected Collection<Field> mandatory;
    protected HashMap<Integer, Transition> transitions; // Integer stands for ActionID
    protected Document document;

    public State(int stateID, Document document) {
        this.stateID = stateID;
        this.document = document;
        deleted = new ArrayList<Field>();
        hidden = new ArrayList<Field>();
        mandatory = new ArrayList<Field>();
        transitions = new HashMap<Integer, Transition>();
    }

    public State() {
        deleted = new ArrayList<Field>();
        hidden = new ArrayList<Field>();
        mandatory = new ArrayList<Field>();
        transitions = new HashMap<Integer, Transition>();
    }

    public int getStateID() {
        return stateID;
    }

    public void setStateID(int stateID) {
        this.stateID = stateID;
    }

    public Document getDocument() {
        return document;
    }

    public void addDeleted(Field f) {
        deleted.add(f);
    }

    public void addHidden(Field f) {
        hidden.add(f);
    }

    public void addMandatory(Field f) {
        mandatory.add(f);
    }

    public void addTransition(int actionID, Transition t) {
        transitions.put(actionID, t);
    }

    public Collection<Field> getDeleted() { return deleted; }

    public Collection<Field> getHidden() { return hidden; }

    public Collection<Field> getMandatory() { return mandatory; }

    public Transition getTransition(int actionId) { return transitions.get(actionId); }

    public abstract void entry();
    public abstract String doJob();
}
