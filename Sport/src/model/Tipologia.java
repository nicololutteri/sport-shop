package model;

public class Tipologia {
	public int IdTipologia;
	public String Nome;
	public String Cognome;
	public int idSport;
	
	public Tipologia(int idTipologia, String nome, String cognome, int idSport) {
		super();
		IdTipologia = idTipologia;
		Nome = nome;
		Cognome = cognome;
		this.idSport = idSport;
	}
}
