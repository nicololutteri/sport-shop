package model;

import java.util.ArrayList;

public class Riepilogo {
	public Ordine ordine;
	public Bolla bolla;
	public ArrayList<MovimentoEntrata> lista;
	
	public Riepilogo(Ordine ordine, Bolla bolla, ArrayList<MovimentoEntrata> lista) {
		super();
		this.ordine = ordine;
		this.bolla = bolla;
		this.lista = lista;
	}
	
}
