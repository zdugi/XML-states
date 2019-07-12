package paneli;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.komponente.Komponenta;

public class Group extends Panel {

	private Komponenta komponenta;
	private ButtonGroup buttonGroup;
	
	public Group(Komponenta komponenta, ButtonGroup buttonGroup) {
		super(komponenta);
		this.komponenta = komponenta;
		this.buttonGroup = buttonGroup;
		//add(new JLabel(komponenta.getNaziv()));
	}

	public Komponenta getKomponenta() {
		return komponenta;
	}

	public void setKomponenta(Komponenta komponenta) {
		this.komponenta = komponenta;
	}

	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}

	public void setButtonGroup(ButtonGroup buttonGroup) {
		this.buttonGroup = buttonGroup;
	}
}
