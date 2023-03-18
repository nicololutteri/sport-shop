package model;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Articolo {
	public int codice;
	public String nome;
	public double prezzo;
	public String data;
	public int idTipologia;
	public String nomeTipologia;
	public int idSport;
	public String nomeSport;
	
	public int getGiacenza()
	{
		try {
			return GestioneDB.getInstance().calcolaGiacenza(codice);
		} catch (ErroreNelDB e) {
			Utilita.MostraErroreDB(e.getMessage());
		}
		return codice;
	}
	
	public Articolo(int codice, String nome, double prezzo, String data, int idTipologia, String nomeTipologia,
			int idSport, String nomeSport) {
		super();
		this.codice = codice;
		this.nome = nome;
		this.prezzo = prezzo;
		this.data = data;
		this.idTipologia = idTipologia;
		this.nomeTipologia = nomeTipologia;
		this.idSport = idSport;
		this.nomeSport = nomeSport;
	}

	public void Aggiungi(JTable tabella)
	{
		DefaultTableModel model = (DefaultTableModel) tabella.getModel();
		model.addRow(new Object[]{codice, nome, prezzo, getGiacenza(), data, nomeTipologia, nomeSport});
	}
}
