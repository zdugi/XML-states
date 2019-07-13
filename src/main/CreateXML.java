package main;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import enums.VrstaAkcije;
import enums.VrstaKomponente;
import model.Akcija;
import model.Tranzicija;
import model.komponente.GroupKomponenta;
import model.komponente.SpinnerKomponenta;

public class CreateXML {
	public static void writeToXML()
	{
		try {
	         DocumentBuilderFactory dbFactory =
	         DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.newDocument();
	         
	         // root element
	         Element rootElement = doc.createElement("data");
	         doc.appendChild(rootElement);

	         // supercars element
	         Element dokument = doc.createElement("Document");
	         rootElement.appendChild(dokument);
	         
	         Element title = doc.createElement("Title");
	         dokument.appendChild(title);
	         
	         Element fields = doc.createElement("Fields");
	         dokument.appendChild(fields);
	         
	         for(int i = 0; i < MainTest.data.getDokument().getKomponente().size(); i++)
	         {
	        	 Element field = doc.createElement("Field");
	        	 Attr attr = doc.createAttribute("fieldId");
	        	 attr.setValue(MainTest.data.getDokument().getKomponente().get(i).getKomponentaId());
	        	 Attr attr1 = doc.createAttribute("type");
	        	 attr1.setValue(MainTest.data.getDokument().getKomponente().get(i).getTip()+"");
	        	 field.setAttributeNode(attr);
	        	 field.setAttributeNode(attr1);
	        	 Element name = doc.createElement("Name");
	        	 name.appendChild(doc.createTextNode(MainTest.data.getDokument().getKomponente().get(i).getNaziv()));
	        	 field.appendChild(name);
	        	 if(MainTest.data.getDokument().getKomponente().get(i).getTip() == VrstaKomponente.SPINNER)
	        	 {
	        		 Element donjaGranica = doc.createElement("DonjaGranica");
	        		 donjaGranica.appendChild(doc.createTextNode(((SpinnerKomponenta)MainTest.data.getDokument().getKomponente().get(i)).getDonjaGranica()+""));
	        		 Element gornjaGranica = doc.createElement("GornjaGranica");
	        		 gornjaGranica.appendChild(doc.createTextNode(((SpinnerKomponenta)MainTest.data.getDokument().getKomponente().get(i)).getGornjaGranica()+""));
	        		 field.appendChild(donjaGranica);
	        		 field.appendChild(gornjaGranica);
	        	 }
	        	 if(MainTest.data.getDokument().getKomponente().get(i).getTip() == VrstaKomponente.CHECKGROUP || MainTest.data.getDokument().getKomponente().get(i).getTip() == VrstaKomponente.RADIOGROUP)
	        	 {
	        		 for(int j = 0; j < ((GroupKomponenta)MainTest.data.getDokument().getKomponente().get(i)).getDugmici().size(); j++)
	        		 {
	        			 Element value = doc.createElement("Value");
	        			 value.appendChild(doc.createTextNode(((GroupKomponenta)MainTest.data.getDokument().getKomponente().get(i)).getDugmici().get(j)+""));
	        			 field.appendChild(value);
	        		 }
	        	 }
	        	 fields.appendChild(field);
	         }
	         
	         Element actions = doc.createElement("Actions");
	         
	         for(int i = 0; i < 4; i++)
	         {
	        	 Element action = doc.createElement("Action");
	        	 Attr attr = doc.createAttribute("actionId");
	        	 attr.setValue(i+"");
	        	 Element name = doc.createElement("Name");
	        	 name.appendChild(doc.createTextNode(VrstaAkcije.values()[i]+""));
	        	 action.setAttributeNode(attr);
	        	 action.appendChild(name);
	        	 actions.appendChild(action);
	         }
	         
	         dokument.appendChild(actions);
	         
	         Element states = doc.createElement("States");
	         rootElement.appendChild(states);
	         
	         for(int i = 0; i < MainTest.data.getStanje().size(); i++)
	         {
	        	 Element state = doc.createElement("State");
	        	 Attr attr = doc.createAttribute("stateId");
	        	 attr.setValue(MainTest.data.getStanje().get(i).getStanjeId());
	        	 state.setAttributeNode(attr);
	        	 Element stateType = doc.createElement("Statetype");
	        	 stateType.appendChild(doc.createTextNode(MainTest.data.getStanje().get(i).getTipStanja()+""));
	        	 state.appendChild(stateType);
	        	 for(int j = 0;  j < MainTest.data.getStanje().get(i).getMandatory_list().size(); j++)
	        	 {
	        		 Element mandatory = doc.createElement("Mandatory");
	        		 mandatory.appendChild(doc.createTextNode(MainTest.data.getStanje().get(i).getMandatory_list().get(j).getKomponentaId()));
	        		 state.appendChild(mandatory);
	        	 }
	        	 for(int j = 0;  j < MainTest.data.getStanje().get(i).getHide_list().size(); j++)
	        	 {
	        		 Element mandatory = doc.createElement("Hide");
	        		 mandatory.appendChild(doc.createTextNode(MainTest.data.getStanje().get(i).getHide_list().get(j).getKomponentaId()));
	        		 state.appendChild(mandatory);
	        	 }
	        	 for(int j = 0;  j < MainTest.data.getStanje().get(i).getDelete_list().size(); j++)
	        	 {
	        		 Element mandatory = doc.createElement("Delete");
	        		 mandatory.appendChild(doc.createTextNode(MainTest.data.getStanje().get(i).getDelete_list().get(j).getKomponentaId()));
	        		 state.appendChild(mandatory);
	        	 }
	        	 states.appendChild(state);
	        	 
	        	 Element transitions = doc.createElement("Transitions");
	        	 
	        	 
	        	 ArrayList<Tranzicija> listTr = new ArrayList<Tranzicija>();
	 			 for (Map.Entry<Akcija, Tranzicija> mapEntry : MainTest.data.getStanje().get(i).getTranzicija().entrySet()) 
	 			 {
	 				Element transition = doc.createElement("Transition");
	 				Attr attrh = doc.createAttribute("triggerAction");
		        	attrh.setValue(mapEntry.getKey().getId()+"");
		        	transition.setAttributeNode(attrh);
		        	Attr attrh1 = doc.createAttribute("transitionID");
		        	attrh1.setValue(mapEntry.getValue().getNaziv()+"");
		        	transition.setAttributeNode(attrh1);
		        	transitions.appendChild(transition);
	 			 }
	 			 
	 			state.appendChild(transitions);
	 			
	         }
	         
	         Element transitions = doc.createElement("Transitions");
	         for(int k = 0;  k < MainTest.data.getTranzicija().size(); k++)
	         {
	        	 Element transition = doc.createElement("Transition");
	        	 Attr attrh = doc.createAttribute("transitionID");
		         attrh.setValue(MainTest.data.getTranzicija().get(k).getNaziv()+"");
		         transition.setAttributeNode(attrh);
		         
		         Element success = doc.createElement("Success");
		         Attr attrh1 = doc.createAttribute("stateID");
		         attrh1.setValue(MainTest.data.getTranzicija().get(k).getSucces().getStanjeId()+"");
		         success.setAttributeNode(attrh1);
		         
		         Element fail = doc.createElement("Fail");
		         Attr attrh2 = doc.createAttribute("stateID");
		         attrh2.setValue(MainTest.data.getTranzicija().get(k).getFail().getStanjeId()+"");
		         fail.setAttributeNode(attrh2);
		         
		         transition.appendChild(success);
		         transition.appendChild(fail);
		         transitions.appendChild(transition);
	         }
	         rootElement.appendChild(transitions);
	         
	         /*TransformerFactory transformerFactory = TransformerFactory.newInstance();
	         Transformer transformer = transformerFactory.newTransformer();*/
	         Transformer tf = TransformerFactory.newInstance().newTransformer();
	         tf.setOutputProperty(OutputKeys.INDENT, "yes");
	         tf.setOutputProperty(OutputKeys.METHOD, "xml");
	         tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
	         DOMSource source = new DOMSource(doc);
	         StreamResult result = new StreamResult(new File("test.xml"));
	         tf.transform(source, result);
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	}
}
