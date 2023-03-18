package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.BtnCancellaDialogListener;
import controller.BtnOkDialogListener;
import controller.IResult;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JDialog;

import java.awt.Toolkit;
import java.text.SimpleDateFormat;

import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JList;
import javax.swing.JTextField;

public class InserisciArticolo extends JDialog implements IResult {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public JTextField nome;
	public JSpinner prezzo;
	public JSpinner dataproduzione;
	@SuppressWarnings("rawtypes")
	public JList tipologia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InserisciArticolo dialog = new InserisciArticolo();
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
	@SuppressWarnings("rawtypes")
	public InserisciArticolo() {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(InserisciArticolo.class.getResource("/view/Sport-bowling-icon.png")));
		setBounds(100, 100, 458, 388);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Inserisci articolo");
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
		panel_2.setLayout(new GridLayout(0, 2, -200, 0));
		
		JLabel lblNewLabel_4 = new JLabel("Nome");
		panel_2.add(lblNewLabel_4);
		
		nome = new JTextField();
		panel_2.add(nome);
		nome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Prezzo");
		panel_2.add(lblNewLabel_1);
		
		prezzo = new JSpinner();
		prezzo.setModel(new SpinnerNumberModel(new Double(1), new Double(1), null, new Double(1)));
		panel_2.add(prezzo);
		
		JLabel lblNewLabel_2 = new JLabel("Data produzione");
		panel_2.add(lblNewLabel_2);
		
		//Modifca modello JSpinner (tolgo l'ora)
		SimpleDateFormat model = new SimpleDateFormat("dd/MM/yyyy");
		dataproduzione = new JSpinner(new SpinnerDateModel());
		dataproduzione.setEditor(new JSpinner.DateEditor(dataproduzione, model.toPattern()));
		panel_2.add(dataproduzione);
				
		JLabel lblNewLabel_3 = new JLabel("Tipologia");
		panel_2.add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		tipologia = new JList();
		scrollPane.setViewportView(tipologia);
		panel_2.add(scrollPane);
		
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
