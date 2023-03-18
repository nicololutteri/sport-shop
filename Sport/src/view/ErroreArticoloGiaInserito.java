package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.BtnChiudiFinestraListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class ErroreArticoloGiaInserito extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ErroreArticoloGiaInserito dialog = new ErroreArticoloGiaInserito();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ErroreArticoloGiaInserito() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ErroreArticoloGiaInserito.class.getResource("/view/Sport-bowling-icon.png")));
		setResizable(false);
		setModal(true);
		
		setBounds(100, 100, 362, 187);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblLarticoloSelezionato = new JLabel("L'articolo selezionato \u00E8 gia stato inserito");
		lblLarticoloSelezionato.setIcon(new ImageIcon(ErroreArticoloGiaInserito.class.getResource("/view/Actions-edit-delete-icon.png")));
		lblLarticoloSelezionato.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblLarticoloSelezionato.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLarticoloSelezionato.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(lblLarticoloSelezionato, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(lblLarticoloSelezionato, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				
				okButton.setActionCommand("OK");
				BtnChiudiFinestraListener ok = new BtnChiudiFinestraListener(this);
				okButton.addActionListener(ok);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
}
