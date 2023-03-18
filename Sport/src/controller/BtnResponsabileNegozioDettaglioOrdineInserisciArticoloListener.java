package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Articolo;
import model.ErroreNelDB;
import model.GestioneDB;
import view.InserisciDettaglioOrdine;
import view.VisualizzaTuttiArticoli;

public class BtnResponsabileNegozioDettaglioOrdineInserisciArticoloListener implements ActionListener {
	
	InserisciDettaglioOrdine parent;
	
	public BtnResponsabileNegozioDettaglioOrdineInserisciArticoloListener(InserisciDettaglioOrdine parent)
	{
		this.parent = parent;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {		
		VisualizzaTuttiArticoli frame = new VisualizzaTuttiArticoli();
		
		try {
			for (Articolo x: GestioneDB.getInstance().tuttiArticoli())
			{
				x.Aggiungi(frame.table);
			}
		} catch (ErroreNelDB e) {
			model.Utilita.MostraErroreDB(e.getMessage());
		}
		
		if (frame.getValue().equals("Ok"))
		{
			parent.numeroarticolo = Utilita.prendiIdDaTabella(frame.table);
		}
		
		frame.dispose();
	}

}