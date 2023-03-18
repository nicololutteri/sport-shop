package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.BtnCancellaDialogListener;
import controller.BtnMagazziniereMovimentoUscitaInserisciOrdine;
import controller.BtnMagazziniereMovimentoUscitaInserisciSpedizionere;
import controller.BtnOkDialogListener;
import controller.IResult;

import java.awt.Toolkit;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class InserisciMovimentoUscita extends JDialog implements IResult {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public int numeroOrdine;
	public int numeroSpedizioniere;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InserisciMovimentoUscita dialog = new InserisciMovimentoUscita();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InserisciMovimentoUscita() {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(InserisciMovimentoUscita.class.getResource("/view/Sport-bowling-icon.png")));
		setBounds(100, 100, 480, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Inserisci movimento uscita");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton btnNewButton_1 = new JButton("Ok");
		BtnOkDialogListener ok = new BtnOkDialogListener(this, this);
		btnNewButton_1.addActionListener(ok);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Cancella");
		BtnCancellaDialogListener cancella = new BtnCancellaDialogListener(this, this);
		btnNewButton.addActionListener(cancella);
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(2, 2, -200, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Ordine");
		panel_2.add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("Seleziona ordine");
		BtnMagazziniereMovimentoUscitaInserisciOrdine list2 = new BtnMagazziniereMovimentoUscitaInserisciOrdine(this);
		btnNewButton_2.addActionListener(list2);
		panel_2.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("Spedizioniere");
		panel_2.add(lblNewLabel_3);
		
		JButton btnNewButton_4 = new JButton("Seleziona spedizioniere");
		BtnMagazziniereMovimentoUscitaInserisciSpedizionere list3 = new BtnMagazziniereMovimentoUscitaInserisciSpedizionere(this);
		btnNewButton_4.addActionListener(list3);
		panel_2.add(btnNewButton_4);
		
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
