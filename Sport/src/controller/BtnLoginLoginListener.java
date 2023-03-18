package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.GestioneDB;
import model.UsernamePasswordNonValido;
import view.ErroreVincoli;
import view.Login;
import view.Magazziniere;
import view.ResponsabileNegozio;
import view.SegreteriaAmministrativa;

public class BtnLoginLoginListener implements ActionListener {
	
	Login parent;
	
	public BtnLoginLoginListener(Login parent) {
		this.parent = parent;
	}
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		try {
			switch (GestioneDB.getInstance().cercaRuolo(parent.username.getText(), parent.password.getText())) {
				case Magazziniere:
					Magazziniere frame = new Magazziniere();
					frame.setVisible(true);
					
					break;
				case ReponsabileNegozio:
					int tmp = GestioneDB.getInstance().numeroNegozio(parent.username.getText(), parent.password.getText());
					ResponsabileNegozio frame2 = new ResponsabileNegozio(tmp);
					frame2.setVisible(true);
					
					break;
				case SegreteriaAmministrativo:
					SegreteriaAmministrativa frame3 = new SegreteriaAmministrativa();
					frame3.setVisible(true);
					
					break;
				default:
					break;
			}
			
			Pulisci();
			parent.dispose();
		} catch (UsernamePasswordNonValido e1) {
			Pulisci();
			
			ErroreVincoli frame = new ErroreVincoli();
			frame.label.setText("Username o password errato");
			frame.setVisible(true);
		}
	}
	
	private void Pulisci()
	{
		parent.username.setText("");
		parent.password.setText("");
		
		parent.username.grabFocus();
	}
}
