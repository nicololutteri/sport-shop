package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ErroreNelDB;
import model.GestioneDB;
import model.MovimentoEntrata;
import model.Posizioni;
import model.VincoliSbagliati;
import view.SpostamentoArticolo;
import view.VisualizzaTuttePosizioni;

public class BtnMagazziniereSpostaArticoloNuovaPosizioneListener implements ActionListener {

	SpostamentoArticolo parent;
	
	public BtnMagazziniereSpostaArticoloNuovaPosizioneListener(SpostamentoArticolo parent)
	{
		this.parent = parent;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (Utilita.prendiIdDaTabella(parent.table) == -1)
		{
			return;
		}
		
		VisualizzaTuttePosizioni frame = new VisualizzaTuttePosizioni();
		
		try {
			for (Posizioni x: GestioneDB.getInstance().tuttePosizioni())
			{
				x.Aggiungi(frame.table);
			}
		} catch (ErroreNelDB e2) {
			model.Utilita.MostraErroreDB(e2.getMessage());
		}
		
		if (frame.getValue().equals("Ok"))
		{
			try {
				if (GestioneDB.getInstance().calcolaGiacenzaZona(Utilita.prendiIdDaTabella(frame.table)) + 1 <= GestioneDB.getInstance().maxGiacenzaZona(Utilita.prendiIdDaTabella(frame.table)))
				{
					GestioneDB.getInstance().spostaArticolo(Utilita.prendiIdDaTabella(parent.table), Utilita.prendiIdDaTabella(frame.table));
				}
				else
				{
					model.Utilita.MostraErroreGiacenza();
				}
				
				// Aggiorno la tabella
				Utilita.cancellaTabella(parent.table);
				for (MovimentoEntrata x: GestioneDB.getInstance().tuttiMovimentiUscitaNonEvasi())
				{
					x.Aggiungi(parent.table);
				}
			} catch (ErroreNelDB e1) {
				model.Utilita.MostraErroreDB(e1.getMessage());
			} catch (VincoliSbagliati e1) {
				model.Utilita.MostraErroreVincoli(e1.getMessage());
			}
		}
		
		frame.dispose();
	}

}
