package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.BtnChiudiFinestraListener;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import javax.swing.JTable;
import java.awt.Toolkit;

public class RiepilogoUscita extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public JTable table;
	
	public JLabel ordinedata;
	public JLabel bollanomespedizioniere;
	public JLabel ordinenomenegozio;
	public JLabel ordinecodice;
	public JLabel bollaora;
	public JLabel bollacodice;
	public JLabel bolladata;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RiepilogoUscita dialog = new RiepilogoUscita();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RiepilogoUscita() {
		setModal(true);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(RiepilogoUscita.class.getResource("/view/Sport-bowling-icon.png")));
		setBounds(100, 100, 741, 609);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblNewLabel = new JLabel("Riepilogo uscita");
				panel.add(lblNewLabel);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			
			JLabel lblNewLabel_1 = new JLabel("Ordine");
			
			JPanel panel_1 = new JPanel();
			
			JLabel lblNewLabel_2 = new JLabel("Bolla");
			
			JPanel panel_2 = new JPanel();
			
			JLabel lblNewLabel_3 = new JLabel("Lista articoli");
			
			JPanel panel_3 = new JPanel();
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addComponent(panel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
							.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
							.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1, Alignment.LEADING)
							.addComponent(lblNewLabel_2, Alignment.LEADING)
							.addComponent(lblNewLabel_3, Alignment.LEADING))
						.addContainerGap())
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblNewLabel_1)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblNewLabel_2)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblNewLabel_3)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
						.addContainerGap())
			);
			panel_1.setLayout(new GridLayout(3, 2, 0, 0));
			
			JLabel lblNewLabel_4 = new JLabel("Codice");
			panel_1.add(lblNewLabel_4);
			
			ordinecodice = new JLabel("New label");
			panel_1.add(ordinecodice);
			
			JLabel lblNewLabel_5 = new JLabel("Data");
			panel_1.add(lblNewLabel_5);
			
			ordinedata = new JLabel("New label");
			panel_1.add(ordinedata);
			
			JLabel lblNomeNegozio = new JLabel("Nome negozio");
			panel_1.add(lblNomeNegozio);
			
			ordinenomenegozio = new JLabel("New label");
			panel_1.add(ordinenomenegozio);
			panel_2.setLayout(new GridLayout(0, 2, 0, 0));
			
			JLabel lblNewLabel_6 = new JLabel("Cod bolla");
			panel_2.add(lblNewLabel_6);
			
			bollacodice = new JLabel("New label");
			panel_2.add(bollacodice);
			
			JLabel lblNewLabel_8 = new JLabel("Data");
			panel_2.add(lblNewLabel_8);
			
			bolladata = new JLabel("New label");
			panel_2.add(bolladata);
			
			JLabel lblNewLabel_10 = new JLabel("Ora");
			panel_2.add(lblNewLabel_10);
			
			bollaora = new JLabel("New label");
			panel_2.add(bollaora);
			
			JLabel lblNomeSpedizioniere = new JLabel("Nome spedizioniere");
			panel_2.add(lblNomeSpedizioniere);
			
			bollanomespedizioniere = new JLabel("New label");
			panel_2.add(bollanomespedizioniere);
			panel_3.setLayout(new BorderLayout(0, 0));
			
			table = new JTable();
			table.setModel(new DefaultTableModel(
					new Object[][] {},
					new String[] {
							"Codice", "Data", "Id articolo", "Nome articolo", "Prezzo", "Data produzione", "Nome tipologia", "Nome sport", "Posizione"
					}) {
					
					/**
						 * 
						 */
						private static final long serialVersionUID = 1L;

					public boolean isCellEditable(int rowIndex, int columnIndex) {
						    return false;
					}
				});
			panel_3.add(table.getTableHeader(), BorderLayout.NORTH);
			panel_3.add(table, BorderLayout.CENTER);
			panel.setLayout(gl_panel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				BtnChiudiFinestraListener ok = new BtnChiudiFinestraListener(this);
				okButton.addActionListener(ok);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
}
