package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;

import model.GestioneDB;
import model.ErroreNelDB;
import model.Utilita;
import model.VincoliSbagliati;
import view.InserisciArticolo;

public class BtnSegreteriaAmministrativaInserimentoArticoloListener extends MouseAdapter {
	
	JFrame parent;
	
	public BtnSegreteriaAmministrativaInserimentoArticoloListener(JFrame parent)
	{
		this.parent = parent;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void mouseClicked(MouseEvent e)   
    {
		InserisciArticolo frame = new InserisciArticolo();
		
		try {
			frame.tipologia.setModel(new AbstractListModel() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
				ArrayList<String> values = GestioneDB.getInstance().tutteTipologie();
				public int getSize() {
					return values.size();
				}
				public Object getElementAt(int index) {
					return values.get(index);
				}
			});
			
			frame.tipologia.setSelectedIndex(0);
		} catch (ErroreNelDB e1) {
			Utilita.MostraErroreDB(e1.getMessage());
		}
		
		if (frame.getValue().equals("Ok")) {
			try {
				GestioneDB.getInstance().inserisciArticolo(frame.nome.getText(), (double) frame.prezzo.getValue(), (Date) frame.dataproduzione.getValue(), frame.tipologia.getSelectedIndex() + 1);
			} catch (ErroreNelDB e1) {
				Utilita.MostraErroreDB(e1.getMessage());
			} catch (VincoliSbagliati e1) {
				Utilita.MostraErroreVincoli(e1.getMessage());
			}
		}
		else
		{
			
		}
		
		frame.dispose();
	}
	
}
