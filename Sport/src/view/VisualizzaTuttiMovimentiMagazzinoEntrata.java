package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.BtnCancellaDialogListener;
import controller.BtnOkDialogListener;
import controller.IResult;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTable;
import java.awt.Toolkit;

public class VisualizzaTuttiMovimentiMagazzinoEntrata extends JDialog implements IResult {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VisualizzaTuttiMovimentiMagazzinoEntrata dialog = new VisualizzaTuttiMovimentiMagazzinoEntrata();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VisualizzaTuttiMovimentiMagazzinoEntrata() {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VisualizzaTuttiMovimentiMagazzinoEntrata.class.getResource("/view/Sport-bowling-icon.png")));
		setBounds(100, 100, 846, 494);
		getContentPane().setLayout(new BorderLayout(0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		contentPanel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(1, 2, 20, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
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
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		panel_3.add(scrollPane, BorderLayout.CENTER);
		
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
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.NORTH);
			{
				JLabel lblNewLabel = new JLabel("Visualizza movimenti entrata");
				panel.add(lblNewLabel);
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
