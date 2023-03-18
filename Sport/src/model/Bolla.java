package model;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Bolla {
	public int codBolla;
	public String data;
	public String ora;
	public int idSpedizioniere;
	public String nomespedizioniere;
		
	public Bolla(int codBolla, String data, String ora, int idSpedizioniere, String nomespedizioniere) {
		super();
		this.codBolla = codBolla;
		this.data = data;
		this.ora = ora;
		this.idSpedizioniere = idSpedizioniere;
		this.nomespedizioniere = nomespedizioniere;
	}
	
	public void Aggiungi(JTable tabella)
	{
		DefaultTableModel model = (DefaultTableModel) tabella.getModel();
		model.addRow(new Object[]{codBolla, data, ora, nomespedizioniere});
	}
}
