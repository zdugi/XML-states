package paneli;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import model.komponente.Komponenta;

public class CheckBox extends Panel {

	//private Komponenta komponenta;
	private JCheckBox checkBox;
	
	public CheckBox(Komponenta komponenta, JCheckBox checkBox) {
		super(komponenta);
		//this.komponenta = komponenta;
		this.checkBox = checkBox;
		//this.checkBox.setText(komponenta.getNaziv());
		add(checkBox);
	}

	public Komponenta getKomponenta() {
		return komponenta;
	}

	public void setKomponenta(Komponenta komponenta) {
		this.komponenta = komponenta;
	}

	public JCheckBox getCheckBox() {
		return checkBox;
	}

	public void setCheckBox(JCheckBox checkBox) {
		this.checkBox = checkBox;
	}
}
