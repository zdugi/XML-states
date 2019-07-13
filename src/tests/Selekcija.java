package tests;

import gui.mainWindows.ComponentsWindow;
import model.Data;
import model.komponente.Komponenta;
import model.komponente.SpinnerKomponenta;
import paneli.TextField;

public class Selekcija {

	public static void main(String[] args) {

		Data data = new Data();
		
		ComponentsWindow window = new ComponentsWindow(data);

		TextField txt = window.postaviTextField(new Komponenta("sad", null));
		window.postaviSpinner(new SpinnerKomponenta("sad", null, 1, 0));
		
		window.setSeleckija(null);
		
		if (!window.btnEditComponent.isEnabled() && !window.btnDeleteComponent.isEnabled())
		{
			System.out.println("Test je prosao");
		}
		else
		{
			System.out.println("Test nije prosao");
		}
		
		window.setSeleckija(txt);
		
		if (window.btnEditComponent.isEnabled() && window.btnDeleteComponent.isEnabled())
		{
			System.out.println("Test je prosao");
		}
		else
		{
			System.out.println("Test nije prosao");
		}
		
		window.setSeleckija(null);
		
		if (txt.getBorder() == null)
		{
			System.out.println("Test je prosao");
		}
		else
		{
			System.out.println("Test nije prosao");
		}
	}

}
