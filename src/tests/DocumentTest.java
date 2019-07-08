package tests;

import model.*;
import org.junit.Test;
import tools.FieldTypes;

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

    @Test
    public void addField() {
        Document doc = new Document();
        Field f = new Field(FieldTypes.TEXTFIELD, "Polje", 1);
        doc.addField(f);

        boolean found = false;
        for (Field i:doc.getFields()
             ) {
            if(i == f) {
                found = true;
                break;
            }
        }

        assertTrue(found);
    }

    @Test
    public void removeField() {
        Document doc = new Document();
        Field f = new Field(FieldTypes.TEXTFIELD, "Polje", 1);
        doc.addField(f);
        doc.removeField(f);


        boolean found = false;
        for (Field i:doc.getFields()
        ) {
            if(i == f) {
                found = true;
                break;
            }
        }

        assertFalse(found);
    }
}