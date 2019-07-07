package model;

public class SubmitedState extends State {
    public SubmitedState(int stateID, Document document) {
        super(stateID, document);
    }

    @Override
    public void entry() {

    }

    @Override
    public String doJob() {
        return "Submited.";
    }
}
