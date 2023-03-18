package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.BtnCancellaDialogListener;
import controller.BtnMagazziniereMovimentoEntrataInserisciArticolo;
import controller.BtnOkDialogListener;
import controller.IResult;

import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SpinnerDateModel;
import javax.swing.JList;
import javax.swing.JSpinner;

public class InserisciMovimentoEntrata extends JDialog implements IResult {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JSpinner data;
	@SuppressWarnings("rawtypes")
	public JList posizione;
	
	public int numeroarticolo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InserisciMovimentoEntrata dialog = new InserisciMovimentoEntrata();
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
	public InserisciMovimentoEntrata() {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(InserisciMovimentoEntrata.class.getResource("/view/Sport-bowling-icon.png")));
		setBounds(100, 100, 505, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Inserisci movimento entrata");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(3, 2, -200, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Data");
		panel_1.add(lblNewLabel_1);
		
		SimpleDateFormat model = new SimpleDateFormat("dd/MM/yyyy");
		data = new JSpinner(new SpinnerDateModel());
		data.setEditor(new JSpinner.DateEditor(data, model.toPattern()));
		panel_1.add(data);
		
		JLabel lblNewLabel_3 = new JLabel("Posizione");
		panel_1.add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		posizione = new JList();
		scrollPane.setViewportView(posizione);
		panel_1.add(scrollPane);
		
		JLabel lblNewLabel_2 = new JLabel("Articolo");
		panel_1.add(lblNewLabel_2);
		
		JButton btnSelezionaArticolo = new JButton("Seleziona articolo");
		BtnMagazziniereMovimentoEntrataInserisciArticolo list1 = new BtnMagazziniereMovimentoEntrataInserisciArticolo(this);
		btnSelezionaArticolo.addActionListener(list1);
		panel_1.add(btnSelezionaArticolo);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton btnNewButton_1 = new JButton("Ok");
		BtnOkDialogListener ok = new BtnOkDialogListener(this, this);
		btnNewButton_1.addActionListener(ok);
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Cancella");
		BtnCancellaDialogListener cancella = new BtnCancellaDialogListener(this, this);
		btnNewButton.addActionListener(cancella);
		panel_2.add(btnNewButton);
		
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
