package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.BtnCancellaDialogListener;
import controller.BtnOkDialogListener;
import controller.BtnSegreteriaAmministrativaVisualizzaOrdiniDettaglio;
import controller.IResult;

import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class VisualizzaTuttiOrdini extends JDialog implements IResult {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizzaTuttiOrdini frame = new VisualizzaTuttiOrdini();
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
	public VisualizzaTuttiOrdini() {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VisualizzaTuttiOrdini.class.getResource("/view/Sport-bowling-icon.png")));
		setBounds(100, 100, 603, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Lista di ordini");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
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
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_2 = new JButton("Dettaglio");
		BtnSegreteriaAmministrativaVisualizzaOrdiniDettaglio list1 = new BtnSegreteriaAmministrativaVisualizzaOrdiniDettaglio(this);
		btnNewButton_2.addActionListener(list1);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(10)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(8))
		);
		
		table = new JTable();;
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codice", "Data", "Evaso", "Nome negozio"
			}
		));
		panel_3.add(table.getTableHeader(), BorderLayout.NORTH);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		panel_3.add(scrollPane, BorderLayout.CENTER);
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
