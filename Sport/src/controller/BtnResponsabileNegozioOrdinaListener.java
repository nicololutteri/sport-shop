package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.ErroreNelDB;
import model.GestioneDB;
import model.VincoliSbagliati;
import view.Ordina;

public class BtnResponsabileNegozioOrdinaListener extends MouseAdapter {
	
	int numero;
	
	public BtnResponsabileNegozioOrdinaListener(int numero)
	{
		this.numero = numero;
	}
	
	public void mouseClicked(MouseEvent e)   
    {   
		Ordina frame = new Ordina();
		
		if (frame.getValue().equals("Ok"))
		{
			try {
				GestioneDB.getInstance().inserisciOrdine(frame.lista, numero);
			} catch (VincoliSbagliati e1) {
				model.Utilita.MostraErroreVincoli(e1.getMessage());
			} catch (ErroreNelDB e1) {
				model.Utilita.MostraErroreDB(e1.getMessage());
			}
		}
		
		frame.dispose();
    }

}
