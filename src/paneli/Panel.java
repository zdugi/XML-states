package paneli;

import javax.swing.JPanel;

import model.komponente.Komponenta;

public class Panel extends JPanel {

	private Komponenta komponenta;
	
	public Panel(Komponenta komponenta) {
		this.komponenta = komponenta;
	}

	public Komponenta getKomponenta() {
		return komponenta;
	}

	public void setKomponenta(Komponenta komponenta) {
		this.komponenta = komponenta;
	}

	@Override
	public String toString() {
		return "Panel [komponenta=" + komponenta + "]";
	}
}
