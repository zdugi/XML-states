package controller;

import model.Document;
import model.Field;
import model.State;
import model.Transition;
import view.DocumentView;

public class Controller {
    private Document documentModel;
    private DocumentView documentView;

    public Controller(Document documentModel, DocumentView documentView) {
        this.documentModel = documentModel;
        this.documentView = documentView;
    }

    public void performTransition(Transition trans) {
        State nextState = trans.getSuccess();
        for (Field field : documentModel.getFields()) {
            boolean mandatory = documentModel.getCurrentState().getMandatory().contains(field);
            boolean deleted = documentModel.getCurrentState().getDeleted().contains(field);
            boolean hidden = documentModel.getCurrentState().getHidden().contains(field);

            if (deleted || hidden)
                continue;

            if (mandatory && field.isEmpty()) {
                nextState = trans.getFailed();
                break;
            }
        }

        for(Field field : nextState.getDeleted()) {
            documentModel.removeField(field);
        }

        documentModel.changeState(nextState);
        documentView.updateView();
    }

}
