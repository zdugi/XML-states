package paneli;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import model.komponente.Komponenta;
import model.komponente.SpinnerKomponenta;

public class Spinner extends JPanel {

	private Komponenta komponenta;
	private JSpinner spinner;

	public Spinner(SpinnerKomponenta komponenta, JSpinner spinner) {
		super();
		this.komponenta = komponenta;
		this.spinner = spinner;
		add(new JLabel(komponenta.getNaziv()));
		add(new JLabel("Gornja granica:"));
		add(new JLabel(String.valueOf(komponenta.getGornjaGranica())));
		add(new JLabel("Donja granica:"));
		add(new JLabel(String.valueOf(komponenta.getDonjaGranica())));
		spinner.setValue(komponenta.getDonjaGranica());
		add(spinner);
	}

	public Komponenta getKomponenta() {
		return komponenta;
	}

	public void setKomponenta(Komponenta komponenta) {
		this.komponenta = komponenta;
	}

	public JSpinner getSpinner() {
		return spinner;
	}

	public void setSpinner(JSpinner spinner) {
		this.spinner = spinner;
	}
}
