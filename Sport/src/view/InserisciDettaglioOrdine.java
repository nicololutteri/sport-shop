package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.BtnCancellaDialogListener;
import controller.BtnOkDialogListener;
import controller.BtnResponsabileNegozioDettaglioOrdineInserisciArticoloListener;
import controller.IResult;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class InserisciDettaglioOrdine extends JDialog implements IResult {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public JSpinner quantita;
	public int numeroarticolo = 0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InserisciDettaglioOrdine dialog = new InserisciDettaglioOrdine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InserisciDettaglioOrdine() {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(InserisciDettaglioOrdine.class.getResource("/view/Sport-bowling-icon.png")));
		setBounds(100, 100, 412, 226);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblNewLabel = new JLabel("Inserisci dettaglio ordine");
				panel.add(lblNewLabel);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new GridLayout(2, 2, -200, 0));
			{
				JLabel lblNewLabel_1 = new JLabel("Quantita");
				panel.add(lblNewLabel_1);
			}
			{
				quantita = new JSpinner();
				quantita.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
				panel.add(quantita);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Articolo");
				panel.add(lblNewLabel_3);
			}
			{
				JButton btnNewButton = new JButton("Inserisci articolo");
				BtnResponsabileNegozioDettaglioOrdineInserisciArticoloListener list1 = new BtnResponsabileNegozioDettaglioOrdineInserisciArticoloListener(this);
				btnNewButton.addActionListener(list1);
				panel.add(btnNewButton);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				BtnOkDialogListener ok = new BtnOkDialogListener(this, this);
				okButton.addActionListener(ok);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancella");
				BtnCancellaDialogListener cancella = new BtnCancellaDialogListener(this, this);
				cancelButton.addActionListener(cancella);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}

	String result = "";
	@Override
	public void setResult(String result) {
		this.result = result;
	}
	
	@Override
	public String getValue() {
		this.setVisible(true);
		return result;
	}


}
