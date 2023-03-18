package model;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DettaglioOrdine {
	public int codice;
	public int quantita;
	public double prezzoTotale;
	public int articoloCodice;
	
	public DettaglioOrdine(int codice, int quantita, double prezzoTotale, int articoloCodice) {
		super();		
		this.codice = codice;
		this.quantita = quantita;
		this.prezzoTotale = prezzoTotale;
		this.articoloCodice = articoloCodice;
	}
	
	public void Aggiungi(JTable tabella)
	{
		DefaultTableModel model = (DefaultTableModel) tabella.getModel();
		Articolo articolo = null;
		try {
			articolo = GestioneDB.getInstance().cercaArticoli(articoloCodice);
		} catch (ErroreNelDB e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addRow(new Object[]{codice, quantita, prezzoTotale, articolo.codice, articolo.nome, articolo.prezzo, articolo.data, articolo.nomeTipologia, articolo.nomeSport});;
	}
	
}
