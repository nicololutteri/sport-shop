package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.Login;

import javax.swing.JFrame;

public class BtnLogoutListener extends MouseAdapter {
	
	JFrame parent;
	
	public BtnLogoutListener(JFrame parent)
	{
		this.parent = parent;
	}
	
	public void mouseClicked(MouseEvent e)
    {
		parent.dispose();
		
		Login f = new Login();
		f.setVisible(true);
    }
	
}
