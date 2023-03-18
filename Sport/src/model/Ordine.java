package model;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Ordine {
	public int codice;
	public String data;
	public int idNegozio;
	public String nome;
	
	public boolean getEvaso()
	{
		boolean evaso = false;
		try {
			evaso = GestioneDB.getInstance().ordineEvaso(codice);
		} catch (ErroreNelDB e) {
			Utilita.MostraErroreDB(e.getMessage());
		}
		
		return evaso;
	}
	
	public Ordine(int codice, String data, int idNegozio, String nome) {
		super();
		this.codice = codice;
		this.data = data;
		this.idNegozio = idNegozio;
		this.nome = nome;
	}

	public void Aggiungi(JTable tabella)
	{
		DefaultTableModel model = (DefaultTableModel) tabella.getModel();
		
		String valore;
		if (getEvaso())
		{
			valore = "Si";
		}
		else
		{
			valore = "No";
		}
		
		model.addRow(new Object[]{codice, data, valore, nome});
	}
}
