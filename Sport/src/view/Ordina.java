package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.BtnCancellaDialogListener;
import controller.BtnOkDialogListener;
import controller.BtnResponsabileNegozioOrdinaAggiungiListener;
import controller.IResult;
import model.DettaglioOrdine;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Ordina extends JDialog implements IResult {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTable table;
	
	public ArrayList<DettaglioOrdine> lista = new ArrayList<DettaglioOrdine>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ordina frame = new Ordina();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ordina() {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ordina.class.getResource("/view/Sport-bowling-icon.png")));
		setBounds(100, 100, 753, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Ordina articoli");
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
		
		JPanel panel_4 = new JPanel();
		
		JButton btnNewButton_2 = new JButton("Aggiungi");
		BtnResponsabileNegozioOrdinaAggiungiListener list1 = new BtnResponsabileNegozioOrdinaAggiungiListener(this);
		btnNewButton_2.addActionListener(list1);
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(7))
		);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"Codice", "Quantita", "Prezzo totale", "Id articolo", "Nome", "Prezzo", "Data produzione", "Nome tipologia", "Nome sport"
				}) {
			
			/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				    return false;
			}
		});
		panel_4.add(table.getTableHeader(), BorderLayout.NORTH);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		panel_4.add(scrollPane, BorderLayout.CENTER);
		panel_2.setLayout(gl_panel_2);
		
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
