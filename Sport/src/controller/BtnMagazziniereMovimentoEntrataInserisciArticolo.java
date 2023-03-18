package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Articolo;
import model.ErroreNelDB;
import model.GestioneDB;
import view.InserisciMovimentoEntrata;
import view.VisualizzaTuttiArticoli;

public class BtnMagazziniereMovimentoEntrataInserisciArticolo implements ActionListener {

	InserisciMovimentoEntrata parent;
	
	public BtnMagazziniereMovimentoEntrataInserisciArticolo(InserisciMovimentoEntrata parent)
	{
		this.parent = parent;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		VisualizzaTuttiArticoli frame = new VisualizzaTuttiArticoli();
		
		try {
			for (Articolo x: GestioneDB.getInstance().tuttiArticoli())
			{
				x.Aggiungi(frame.table);
			}
		} catch (ErroreNelDB e1) {
			model.Utilita.MostraErroreDB(e1.getMessage());
		}
		
		if (frame.getValue().equals("Ok"))
		{
			parent.numeroarticolo = Utilita.prendiIdDaTabella(frame.table);
		}
	}

}
