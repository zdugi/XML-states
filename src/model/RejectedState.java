package model;

public class RejectedState extends State {

    public RejectedState(int stateID, Document document) {
        super(stateID, document);
    }

    @Override
    public void entry() {
        
    }

    @Override
    public String doJob() {
        return "Rejected.";
    }
}
