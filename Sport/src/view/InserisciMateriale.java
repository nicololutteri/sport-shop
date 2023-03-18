package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.BtnCancellaDialogListener;
import controller.BtnOkDialogListener;
import controller.IResult;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.JTextField;

public class InserisciMateriale extends JDialog implements IResult {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField descrizione;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InserisciMateriale dialog = new InserisciMateriale();
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
	public InserisciMateriale() {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(InserisciMateriale.class.getResource("/view/Sport-bowling-icon.png")));
		setBounds(100, 100, 404, 186);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Inserisci materiale");
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
		panel_2.setLayout(new GridLayout(1, 2, -200, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Descrizione");
		panel_2.add(lblNewLabel_1);
		
		descrizione = new JTextField();
		panel_2.add(descrizione);
		descrizione.setColumns(10);
		
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
