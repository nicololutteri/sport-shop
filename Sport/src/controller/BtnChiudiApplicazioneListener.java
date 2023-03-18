package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BtnChiudiApplicazioneListener extends MouseAdapter implements ActionListener {

	public void mouseClicked(MouseEvent e)   
    {   
		System.exit(0);
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		mouseClicked(null);
	}

}
