package model;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Spedizioniere {	
	public int idSpedizione;
	public String nome;
	public String telefono;
	
	public Spedizioniere(int idSpedizione, String nome, String telefono) {
		super();
		this.idSpedizione = idSpedizione;
		this.nome = nome;
		this.telefono = telefono;
	}
		
	public void Aggiungi(JTable tabella)
	{
		DefaultTableModel model = (DefaultTableModel) tabella.getModel();
		model.addRow(new Object[]{idSpedizione, nome, telefono});
	}
}
