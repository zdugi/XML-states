package model;

public class Tranzicija {
	
	private State fail;
	private State succes;
	private String naziv;
	public Tranzicija(State fail, State succes, String naziv)
	{
		this.fail = fail;
		this.succes = succes;
		this.naziv = naziv;
	}
	public State getFail() {
		return fail;
	}
	public void setFail(State fail) {
		this.fail = fail;
	}
	public State getSucces() {
		return succes;
	}
	public void setSucces(State succes) {
		this.succes = succes;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

}
