package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import model.ErroreNelDB;
import model.GestioneDB;
import model.MovimentoEntrata;
import view.SpostamentoArticolo;

public class BtnMagazziniereSpostaArticoloListener extends MouseAdapter {
	
	JFrame parent;
	
	public BtnMagazziniereSpostaArticoloListener(JFrame parent)
	{
		this.parent = parent;
	}
	
	public void mouseClicked(MouseEvent e)   
    {   
		SpostamentoArticolo frame = new SpostamentoArticolo();
		
		try {
			for (MovimentoEntrata x: GestioneDB.getInstance().tuttiMovimentiUscitaNonEvasi())
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
