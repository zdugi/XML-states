package model;

public class Data {
	//public java.util.Collection<Tranzicija> tranzicija;
	//public java.util.Collection<Stanje> stanje;
	public Dokument dokument;
	
	public Data()
	{
		dokument = new Dokument();
	}

	public Dokument getDokument() {
		return dokument;
	}

	public void setDokument(Dokument dokument) {
		this.dokument = dokument;
	}
	
	
}
