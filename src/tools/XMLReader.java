package tools;

import java.io.File;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import model.*;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public abstract class XMLReader {
    private static State createState(String strType, int id, model.Document doc)
    {
        State state;
        switch (strType)
        {
            case "INIT_STATE":
                state = new InitState(id, doc);
                break;
            case "SAVED_STATE":
                state = new SavedState(id, doc);
                break;
            case "SUBMITED_STATE":
                state = new SubmitedState(id, doc);
                break;
            case "REJECTED_STATE":
                state = new RejectedState(id, doc);
                break;
            case "ARCHIVED_STATE":
                state = new ArchivedState(id, doc);
                break;
            default:
                state = null;
        }

        return state;
    }

    public static model.Document readXML(String pathName) {
        model.Document document = new model.Document();
        HashMap<Integer, State> states = new HashMap<Integer, State>();
        HashMap<Integer, Transition> transitions = new HashMap<Integer, Transition>();
        HashMap<Integer, Field> fields = new HashMap<Integer, Field>();
        HashMap<Integer, Action> actions = new HashMap<Integer, Action>();

        try {
            File inputFile = new File(pathName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Document");

            Element eElement = (Element) nList.item(0);

            document.setTitle(eElement.getElementsByTagName("Title")
                    .item(0).getTextContent());
            NodeList allFields = eElement.getElementsByTagName("Field");
            for(int i = 0; i < allFields.getLength(); i++)
            {
                Element field = (Element)allFields.item(i);
                int id = Integer.parseInt(field.getAttribute("fieldId"));
                FieldTypes type = FieldTypes.valueOf(field.getAttribute("type"));
                String name = field.getElementsByTagName("Name").item(0).getTextContent();

                Field f = new Field(type, name, id);
                fields.put(id, f);
                document.addField(f);
            }

            NodeList allActions = eElement.getElementsByTagName("Action");
            for(int i = 0; i < allActions.getLength(); i++)
            {
                Element action = (Element)allActions.item(i);
                int id = Integer.parseInt(action.getAttribute("actionId"));
                String name = action.getElementsByTagName("Name").item(0).getTextContent();

                Action a = new Action(id, name);
                actions.put(id, a);
                document.addAction(a);
            }

            NodeList nStates = doc.getElementsByTagName("State");

            for(int i = 0; i < nStates.getLength(); i++)
            {
                Element state = (Element)nStates.item(i);
                int id = Integer.parseInt(state.getAttribute("stateId"));
                String type = state.getElementsByTagName("StateType").item(0).getTextContent();

                State s = createState(type, id, document);
                if(type.equals("INIT_STATE"))
                {
                    document.setCurrentState(s);
                    System.out.println("aa");
                }

                NodeList sFields = state.getElementsByTagName("Mandatory");

                for(int m = 0; m < sFields.getLength(); m++)
                {
                    int sFieldId = Integer.parseInt(((Element)sFields.item(m))
                            .getAttribute("fieldId"));
                    s.addMandatory(fields.get(sFieldId));
                }

                sFields = state.getElementsByTagName("Delete");

                for(int m = 0; m < sFields.getLength(); m++)
                {
                    int sFieldId = Integer.parseInt(((Element)sFields.item(m))
                            .getAttribute("fieldId"));
                    s.addDeleted(fields.get(sFieldId));
                }

                sFields = state.getElementsByTagName("Hide");

                for(int m = 0; m < sFields.getLength(); m++)
                {
                    int sFieldId = Integer.parseInt(((Element)sFields.item(m))
                            .getAttribute("fieldId"));
                    s.addHidden(fields.get(sFieldId));
                }

                NodeList sTransitions = state.getElementsByTagName("Transition");

                for(int m = 0; m < sTransitions.getLength(); m++)
                {
                    int tId = Integer.parseInt(((Element)sTransitions.item(m))
                            .getAttribute("transitionId"));
                    int aId = Integer.parseInt(((Element)sTransitions.item(m))
                            .getAttribute("triggerAction"));

                    Transition t = new Transition();
                    t.setTransitionID(tId);
                    transitions.put(tId, t);
                    s.addTransition(aId, t);
                }

                states.put(id, s);
            }

            NodeList nTransitions = doc.getElementsByTagName("Transitions");
            for(int i = 0; i < nTransitions.getLength(); i++)
            {
                if(nTransitions.item(i).getParentNode().getNodeName() == "Data")
                {
                    Node nTransition = nTransitions.item(i);
                    nTransitions = ((Element)nTransitions.item(i)).
                            getElementsByTagName("Transition");

                    for(int j = 0; j < nTransitions.getLength(); j++)
                    {
                        Element transition = (Element)nTransitions.item(j);
                        int tId = Integer.parseInt(transition.getAttribute("transitionId"));
                        int succId = Integer.parseInt(((Element)transition.getElementsByTagName("Success")
                                .item(0)).getAttribute("stateId"));
                        int failId = Integer.parseInt(((Element)transition.getElementsByTagName("Fail")
                                .item(0)).getAttribute("stateId"));

                        transitions.get(tId).setSuccess(states.get(succId));
                        transitions.get(tId).setFailed(states.get(failId));
                    }
                }
            }

        } catch (Exception e) {
            //e.printStackTrace();
            document = null;
        }

        return document;
    }

    public static void main(String[] args) {
        String path = "testInputs\\example.xml";
        readXML(path);
    }
}
