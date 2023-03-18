package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ErroreNelDB;
import model.GestioneDB;
import model.Ordine;
import view.InserisciMovimentoUscita;
import view.VisualizzaTuttiOrdini;

public class BtnMagazziniereMovimentoUscitaInserisciOrdine implements ActionListener {

	InserisciMovimentoUscita parent;
	
	public BtnMagazziniereMovimentoUscitaInserisciOrdine(InserisciMovimentoUscita parent)
	{
		this.parent = parent;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		VisualizzaTuttiOrdini frame = new VisualizzaTuttiOrdini();
		
		try {
			for (Ordine x: GestioneDB.getInstance().tuttiOrdiniNonEvasi())
			{
				x.Aggiungi(frame.table);
			}
		} catch (ErroreNelDB e1) {
			model.Utilita.MostraErroreDB(e1.getMessage());
		}
		
		if (frame.getValue().equals("Ok"))
		{
			parent.numeroOrdine = Utilita.prendiIdDaTabella(frame.table);
		}
	}

}
