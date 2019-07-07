package model;

public class SavedState extends State {
    public SavedState(int stateID, Document document) {
        super(stateID, document);
    }

    @Override
    public void entry() {

    }

    @Override
    public String doJob() {
        return "Saved.";
    }
}
