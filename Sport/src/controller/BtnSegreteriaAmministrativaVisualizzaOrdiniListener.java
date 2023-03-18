package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import model.ErroreNelDB;
import model.GestioneDB;
import model.Ordine;
import view.VisualizzaTuttiOrdini;

public class BtnSegreteriaAmministrativaVisualizzaOrdiniListener extends MouseAdapter {
	
	JFrame parent;
	
	public BtnSegreteriaAmministrativaVisualizzaOrdiniListener(JFrame parent)
	{
		this.parent = parent;
	}
		
	public void mouseClicked(MouseEvent e)   
    {   
		VisualizzaTuttiOrdini frame = new VisualizzaTuttiOrdini();
		
		try {
			for (Ordine x: GestioneDB.getInstance().tuttiOrdini())
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
