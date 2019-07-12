package paneli;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.komponente.Komponenta;

public class RadioButton extends JPanel {

	private Komponenta komponenta;
	private JRadioButton radioButton;
	
	public RadioButton(Komponenta komponenta, JRadioButton button) {
		super();
		this.komponenta = komponenta;
		this.radioButton = button;
		this.radioButton.setText(komponenta.getNaziv());
		add(radioButton);
	}

	public Komponenta getKomponenta() {
		return komponenta;
	}

	public void setKomponenta(Komponenta komponenta) {
		this.komponenta = komponenta;
	}

	public JRadioButton getRadioButton() {
		return radioButton;
	}

	public void setRadioButton(JRadioButton radioButton) {
		this.radioButton = radioButton;
	}
}
