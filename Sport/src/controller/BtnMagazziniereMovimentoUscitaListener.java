package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import model.ErroreNelDB;
import model.GestioneDB;
import model.MovimentoEntrata;
import model.Riepilogo;
import model.Utilita;
import model.VincoliSbagliati;
import view.InserisciMovimentoUscita;
import view.RiepilogoUscita;

public class BtnMagazziniereMovimentoUscitaListener extends MouseAdapter {
	
	JFrame parent;
	
	public BtnMagazziniereMovimentoUscitaListener(JFrame parent)
	{
		this.parent = parent;
	}
	
	public void mouseClicked(MouseEvent e)	
    {   
		InserisciMovimentoUscita frame = new InserisciMovimentoUscita();
		
		if (frame.getValue().equals("Ok"))
		{
			Riepilogo p = null;
			try {
				p = GestioneDB.getInstance().evadiOrdine(GestioneDB.getInstance().prendiMovimentoMagazzino(frame.numeroOrdine), frame.numeroSpedizioniere);
			} catch (ErroreNelDB e1) {
				Utilita.MostraErroreDB(e1.getMessage());
			} catch (VincoliSbagliati e1) {
				Utilita.MostraErroreVincoli(e1.getMessage());
			}
			
			RiepilogoUscita r = new RiepilogoUscita();
			
			r.ordinecodice.setText(new Integer(p.ordine.codice).toString());
			r.ordinedata.setText(p.ordine.data);
			r.ordinenomenegozio.setText(p.ordine.nome);
			
			r.bollacodice.setText(new Integer(p.bolla.codBolla).toString());
			r.bolladata.setText(p.bolla.data);
			r.bollaora.setText(p.bolla.ora);
			r.bollanomespedizioniere.setText(p.bolla.nomespedizioniere);
			
			for (MovimentoEntrata x: p.lista)
			{
				x.Aggiungi(r.table);
			}
			
			r.setVisible(true);
		}
		
		frame.dispose();
    }
	
}
