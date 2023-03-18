package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import model.ErroreNelDB;
import model.GestioneDB;
import model.MovimentoEntrata;
import view.VisualizzaTuttiMovimentiMagazzinoEntrata;

public class BtnSegreteriaAmministrativaVisualizzaMovimentiEntrataListener extends MouseAdapter {
	
	JFrame parent;
	
	public BtnSegreteriaAmministrativaVisualizzaMovimentiEntrataListener(JFrame parent)
	{
		this.parent = parent;
	}
	
	public void mouseClicked(MouseEvent e)   
    {   
		VisualizzaTuttiMovimentiMagazzinoEntrata frame = new VisualizzaTuttiMovimentiMagazzinoEntrata();
		
		try {
			for (MovimentoEntrata x: GestioneDB.getInstance().tuttiMovimentiEntrata())
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
