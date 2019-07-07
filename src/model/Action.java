package model;

public class Action {
    private int actionID;
    private String name;
    private Transition transition;

    public Action(int actionID, String name, Transition transition) {
        this.actionID = actionID;
        this.name = name;
        this.transition = transition;
    }

    public Transition getTransition() {
        return transition;
    }

    public void setTransition(Transition transition) {
        this.transition = transition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getActionID() {
        return actionID;
    }

    public void setActionID(int actionID) {
        this.actionID = actionID;
    }
}
