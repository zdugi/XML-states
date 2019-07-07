package model;

public class ArchivedState extends State {

    public ArchivedState(int stateID, Document document) {
        super(stateID, document);
    }

    @Override
    public void entry() {

    }

    @Override
    public String doJob() {
        return "Archived.";
    }
}
