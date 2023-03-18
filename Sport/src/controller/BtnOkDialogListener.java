package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

public class BtnOkDialogListener implements ActionListener {
	
	IResult resultdialog;
	JDialog dialog;
	
	public BtnOkDialogListener(IResult result, JDialog parent)
	{
		this.resultdialog = result;
		this.dialog = parent;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		resultdialog.setResult("Ok");
		dialog.setVisible(false);
	}

}
