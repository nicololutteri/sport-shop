package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;

import model.GestioneDB;
import model.ErroreNelDB;
import model.Utilita;
import model.VincoliSbagliati;
import view.InserisciMovimentoEntrata;

public class BtnMagazziniereMovimentoEntrataListener extends MouseAdapter {
	
	JFrame parent;
	
	public BtnMagazziniereMovimentoEntrataListener(JFrame parent)
	{
		this.parent = parent;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void mouseClicked(MouseEvent e)   
    {   
		InserisciMovimentoEntrata frame = new InserisciMovimentoEntrata();
		try {
			frame.posizione.setModel(new AbstractListModel() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
				ArrayList<String> values = GestioneDB.getInstance().cercaPosizione();
				public int getSize() {
					return values.size();
				}
				public Object getElementAt(int index) {
					return values.get(index);
				}
			});
			
			frame.posizione.setSelectedIndex(0);
		} catch (ErroreNelDB e1) {
			Utilita.MostraErroreDB(e1.getMessage());
		}
		
		if (frame.getValue().equals("Ok"))
		{
			try {
				if (GestioneDB.getInstance().calcolaGiacenzaZona(frame.posizione.getSelectedIndex() + 1) + 1 > GestioneDB.getInstance().maxGiacenzaZona(frame.posizione.getSelectedIndex() + 1))
				{
					Utilita.MostraErroreGiacenza();
				}
				else
				{
					try {
						GestioneDB.getInstance().inserisciNuovoMovimentoEntrata((Date) frame.data.getValue(), frame.posizione.getSelectedIndex() + 1, frame.numeroarticolo);
					} catch (ErroreNelDB e1) {
						Utilita.MostraErroreDB(e1.getMessage());
					} catch (VincoliSbagliati e1) {
						Utilita.MostraErroreVincoli(e1.getMessage());
					}
				}
			} catch (ErroreNelDB e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
				
		frame.dispose();
    }
	
}
