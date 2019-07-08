package model;

import static org.junit.Assert.*;

public class DocumentTest {

    @org.junit.Test
    public void changeState() {
        Document doc = new Document();
        State s = new InitState(1, doc);
        doc.setCurrentState(s);
        State s2 = new SubmitedState(2, null);
        doc.changeState(s2);
        assertEquals(s2, doc.getCurrentState());
    }
}