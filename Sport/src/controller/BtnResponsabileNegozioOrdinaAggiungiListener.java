package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import view.InserisciDettaglioOrdine;
import view.Ordina;

import model.DettaglioOrdine;
import model.ErroreNelDB;
import model.GestioneDB;

public class BtnResponsabileNegozioOrdinaAggiungiListener implements ActionListener {
	
	Ordina parent;
	
	public BtnResponsabileNegozioOrdinaAggiungiListener(Ordina parent)
	{
		this.parent = parent;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {		
		InserisciDettaglioOrdine frame = new InserisciDettaglioOrdine();
		
		if (frame.getValue().equals("Ok"))
		{
			if (frame.numeroarticolo == 0)
			{
				model.Utilita.MostraErroreVincoli("Articolo non selezionato");
			}
			else
			{
				try {
					if (((int) frame.quantita.getValue()) > GestioneDB.getInstance().calcolaGiacenza(frame.numeroarticolo))
					{
						// Supera quantita
						model.Utilita.MostraErroreGiacenza();
					}
					else
					{
						if (!cercaNellaLista(parent.lista, frame.numeroarticolo))
						{
							parent.lista.add(new DettaglioOrdine(0, (int) frame.quantita.getValue(), (((int) frame.quantita.getValue()) * GestioneDB.getInstance().cercaArticoli(frame.numeroarticolo).prezzo), frame.numeroarticolo));			
						}
						else
						{
							model.Utilita.MostraErroreArticoloGiaInserito();
						}
					}
				} catch (ErroreNelDB e) {
					model.Utilita.MostraErroreDB(e.getMessage());
				}
			}

		}
		
		Utilita.cancellaTabella(parent.table);
		for (DettaglioOrdine x: parent.lista)
		{
			x.Aggiungi(parent.table);
		}
		
		frame.dispose();
	}
	
	private boolean cercaNellaLista(ArrayList<DettaglioOrdine> lista, int numeroarticolo)
	{
		for (DettaglioOrdine x: lista)
		{
			if (x.articoloCodice == numeroarticolo)
			{
				return true;
			}
		}
		
		return false;
	}

}