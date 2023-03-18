package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

public class BtnChiudiFinestraListener implements ActionListener {
	
	JDialog parent;
	
	public BtnChiudiFinestraListener(JDialog parent) {
		this.parent = parent;
	}
	
	public void actionPerformed(ActionEvent e) {
		parent.dispose();
	}
	
}
