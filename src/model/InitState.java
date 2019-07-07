package model;

public class InitState extends State {
    public InitState(int stateID, Document document) {
        super(stateID, document);
    }

    @Override
    public void entry() {

    }

    @Override
    public String doJob() {
        return "Init.";
    }
}
