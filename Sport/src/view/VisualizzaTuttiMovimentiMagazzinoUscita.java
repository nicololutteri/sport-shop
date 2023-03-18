package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.BtnCancellaDialogListener;
import controller.BtnOkDialogListener;
import controller.IResult;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import java.awt.Toolkit;
import javax.swing.table.DefaultTableModel;

public class VisualizzaTuttiMovimentiMagazzinoUscita extends JDialog implements IResult {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPanel panel_1;
	public JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VisualizzaTuttiMovimentiMagazzinoUscita dialog = new VisualizzaTuttiMovimentiMagazzinoUscita();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VisualizzaTuttiMovimentiMagazzinoUscita() {
		setModal(true);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(VisualizzaTuttiMovimentiMagazzinoUscita.class.getResource("/view/Sport-bowling-icon.png")));
		setBounds(100, 100, 687, 447);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblVisualizzaMovimentiUscita = new JLabel("Visualizza movimenti uscita");
				panel.add(lblVisualizzaMovimentiUscita);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			{
				panel_1 = new JPanel();
			}
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(5)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE))
			);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Codice operazione", "Data operazione", "Ora bolla", "Data bolla", "Nome spedizioniere", "Ordine evaso", "Ordine data", "Nome negozio"
				}
			));
			panel_1.add(table.getTableHeader(), BorderLayout.NORTH);	
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setViewportView(table);
			panel_1.add(scrollPane);		
			panel.setLayout(gl_panel);
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
				JButton cancelButton = new JButton("Cancel");
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
