package model;

public class Transition {
    private int transitionID;
    private State failed;
    private State success;

    public Transition(int transitionID, State failed, State success) {
        this.transitionID = transitionID;
        this.failed = failed;
        this.success = success;
    }

    public State getSuccess() {
        return success;
    }

    public void setSuccess(State success) {
        this.success = success;
    }

    public int getTransitionID() {
        return transitionID;
    }

    public void setTransitionID(int transitionID) {
        this.transitionID = transitionID;
    }

    public State getFailed() {
        return failed;
    }

    public void setFailed(State failed) {
        this.failed = failed;
    }
}
