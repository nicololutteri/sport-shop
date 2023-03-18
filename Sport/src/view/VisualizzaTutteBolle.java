package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.BtnCancellaDialogListener;
import controller.BtnOkDialogListener;
import controller.IResult;

import javax.swing.JLabel;
import java.awt.Toolkit;

public class VisualizzaTutteBolle extends JDialog implements IResult {

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
			VisualizzaTutteBolle dialog = new VisualizzaTutteBolle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VisualizzaTutteBolle() {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VisualizzaTutteBolle.class.getResource("/view/Sport-bowling-icon.png")));
		setBounds(100, 100, 450, 426);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"Codice", "Data", "Ora", "Nome spedizioniere"
				}) {
					
				/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int rowIndex, int columnIndex) {
					    return false;
				}
			});
			contentPanel.add(table.getTableHeader(), BorderLayout.NORTH);
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setViewportView(table);
			contentPanel.add(scrollPane, BorderLayout.CENTER);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				BtnOkDialogListener list1 = new BtnOkDialogListener(this, this);
				okButton.addActionListener(list1);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancella");
				BtnCancellaDialogListener list2 = new BtnCancellaDialogListener(this, this);
				cancelButton.addActionListener(list2);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.NORTH);
			{
				JLabel lblNewLabel = new JLabel("Lista bolle");
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
