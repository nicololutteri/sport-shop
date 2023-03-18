package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

public class BtnCancellaDialogListener implements ActionListener {

	IResult resultdialog;
	JDialog dialog;
	
	public BtnCancellaDialogListener(IResult result, JDialog parent)
	{
		this.resultdialog = result;
		this.dialog = parent;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		resultdialog.setResult("Cancella");
		dialog.setVisible(false);
	}

}
