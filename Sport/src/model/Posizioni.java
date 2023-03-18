package model;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Posizioni {
	int codice;
	String nome;
	String area;
	int maxGiacenza;
	
	public Posizioni(int codice, String nome, String area, int maxGiacenza) {
		super();
		this.codice = codice;
		this.nome = nome;
		this.area = area;
		this.maxGiacenza = maxGiacenza;
	}
	
	public void Aggiungi(JTable tabella)
	{
		DefaultTableModel model = (DefaultTableModel) tabella.getModel();
		model.addRow(new Object[]{codice, nome, area, maxGiacenza});
	}
}
