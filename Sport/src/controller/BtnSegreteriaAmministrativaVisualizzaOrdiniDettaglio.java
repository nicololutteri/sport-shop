package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.DettaglioOrdine;
import model.ErroreNelDB;
import model.GestioneDB;
import view.OrdiniPrecedentiInfo;
import view.VisualizzaTuttiOrdini;

public class BtnSegreteriaAmministrativaVisualizzaOrdiniDettaglio implements ActionListener {

	VisualizzaTuttiOrdini parent;
	
	public BtnSegreteriaAmministrativaVisualizzaOrdiniDettaglio(VisualizzaTuttiOrdini parent)
	{
		this.parent = parent;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (Utilita.prendiIdDaTabella(parent.table) == -1)
		{
			return;
		}
		
		OrdiniPrecedentiInfo frame = new OrdiniPrecedentiInfo();
		
		try {
			for (DettaglioOrdine x: GestioneDB.getInstance().tuttiDettagliOrdine(Utilita.prendiIdDaTabella(parent.table)))
			{
				x.Aggiungi(frame.table);
			}
		} catch (ErroreNelDB e1) {
			model.Utilita.MostraErroreDB(e1.getMessage());
		}
		
		if (frame.getValue().equals("Ok"))
		{
			
		}
		
		frame.dispose();
	}

}
