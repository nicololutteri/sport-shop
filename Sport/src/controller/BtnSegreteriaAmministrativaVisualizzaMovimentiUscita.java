package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import model.ErroreNelDB;
import model.GestioneDB;
import model.MovimentoUscita;
import view.VisualizzaTuttiMovimentiMagazzinoUscita;

public class BtnSegreteriaAmministrativaVisualizzaMovimentiUscita extends MouseAdapter {
	
	JFrame parent;
	
	public BtnSegreteriaAmministrativaVisualizzaMovimentiUscita(JFrame parent)
	{
		this.parent = parent;
	}
	
	public void mouseClicked(MouseEvent e)   
    {   
		VisualizzaTuttiMovimentiMagazzinoUscita frame = new VisualizzaTuttiMovimentiMagazzinoUscita();
		
		try {
			for (MovimentoUscita x: GestioneDB.getInstance().tuttiMovimentiUscita())
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
