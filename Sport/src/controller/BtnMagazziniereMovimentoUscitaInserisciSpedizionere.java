package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ErroreNelDB;
import model.GestioneDB;
import model.Spedizioniere;
import view.InserisciMovimentoUscita;
import view.VisualizzaTuttiSpedizionieri;

public class BtnMagazziniereMovimentoUscitaInserisciSpedizionere implements ActionListener {

	InserisciMovimentoUscita parent;
	
	public BtnMagazziniereMovimentoUscitaInserisciSpedizionere(InserisciMovimentoUscita parent)
	{
		this.parent = parent;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		VisualizzaTuttiSpedizionieri frame = new VisualizzaTuttiSpedizionieri();
		
		try {
			for (Spedizioniere x: GestioneDB.getInstance().tuttiSpedizionieri())
			{
				x.Aggiungi(frame.table);
			}
		} catch (ErroreNelDB e1) {
			model.Utilita.MostraErroreDB(e1.getMessage());
		}
		
		if (frame.getValue().equals("Ok"))
		{
			parent.numeroSpedizioniere = Utilita.prendiIdDaTabella(frame.table);
		}
		
		frame.dispose();
	}

}
