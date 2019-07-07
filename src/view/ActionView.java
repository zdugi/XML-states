package view;

import javax.swing.*;

public class ActionView extends JButton {
    private Action action;
    public ActionView(String text) {
        super(text);
    }

    public Action getAction()
    {
        return action;
    }

    public void setAction(Action action)
    {
        this.action = action;
    }
}
