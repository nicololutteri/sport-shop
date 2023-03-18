package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;

import model.GestioneDB;
import model.ErroreNelDB;
import model.Utilita;
import model.VincoliSbagliati;
import view.InserisciTipologia;

public class BtnSegreteriaAmministrativaInserimentoTipologiaListener extends MouseAdapter {
	
	JFrame parent;
	
	public BtnSegreteriaAmministrativaInserimentoTipologiaListener(JFrame parent)
	{
		this.parent = parent;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void mouseClicked(MouseEvent e)   
    {   
		InserisciTipologia frame = new InserisciTipologia();
		
		try {
			frame.sport.setModel(new AbstractListModel() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
				ArrayList<String> values = GestioneDB.getInstance().tuttiSport();
				public int getSize() {
					return values.size();
				}
				public Object getElementAt(int index) {
					return values.get(index);
				}
			});
			
			frame.sport.setSelectedIndex(0);
		} catch (ErroreNelDB e1) {
			Utilita.MostraErroreDB(e1.getMessage());
		}
		
		if (frame.getValue().equals("Ok"))
		{
			try {
				GestioneDB.getInstance().inserisciTipologia(frame.nome.getText(), frame.descrizione.getText(), frame.sport.getSelectedIndex() + 1);
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
