package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import model.ErroreNelDB;
import model.GestioneDB;
import model.Ordine;
import view.OrdiniPrecedenti;

public class BtnResponsabileNegozioVisualizzaOrdiniListener extends MouseAdapter {
	
	JFrame parent;
	int numero;
	
	public BtnResponsabileNegozioVisualizzaOrdiniListener(JFrame parent, int numero)
	{
		this.parent = parent;
		this.numero = numero;
	}
	
	public void mouseClicked(MouseEvent e)   
    {   
		OrdiniPrecedenti frame = new OrdiniPrecedenti();
		
		try {
			for (Ordine x: GestioneDB.getInstance().cercaOrdiniNegozio(numero))
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
