package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.BtnResponsabileNegozioOrdinaListener;
import controller.BtnResponsabileNegozioVisualizzaOrdiniListener;
import controller.BtnChiudiApplicazioneListener;
import controller.BtnLogoutListener;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class ResponsabileNegozio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResponsabileNegozio frame = new ResponsabileNegozio(1);
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
	public ResponsabileNegozio(int numeronegozio) {
		setResizable(false);
		setTitle("Responsabile negozio");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ResponsabileNegozio.class.getResource("/view/Sport-bowling-icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 331, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel Opzioni = new JPanel();
		
		JPanel Programma = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(Opzioni, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
						.addComponent(Programma, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
					.addGap(20))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(Opzioni, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
					.addComponent(Programma, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		Programma.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblChiudiApplicazione = new JLabel("Chiudi applicazione");
		BtnChiudiApplicazioneListener list = new BtnChiudiApplicazioneListener();
		lblChiudiApplicazione.addMouseListener(list);
		lblChiudiApplicazione.setIcon(new ImageIcon(ResponsabileNegozio.class.getResource("/view/application-delete-icon.png")));
		lblChiudiApplicazione.setHorizontalTextPosition(SwingConstants.CENTER);
		lblChiudiApplicazione.setVerticalTextPosition(SwingConstants.BOTTOM);
		Programma.add(lblChiudiApplicazione);
		
		JLabel lblLogout = new JLabel("Log out");
		BtnLogoutListener list2 = new BtnLogoutListener(this);
		lblLogout.addMouseListener(list2);
		lblLogout.setIcon(new ImageIcon(ResponsabileNegozio.class.getResource("/view/logout-icon.png")));
		lblLogout.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLogout.setVerticalTextPosition(SwingConstants.BOTTOM);
		Programma.add(lblLogout);
		Opzioni.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblOpzioni = new JLabel("Ordina");
		BtnResponsabileNegozioOrdinaListener ordinaListener = new BtnResponsabileNegozioOrdinaListener(numeronegozio);
		lblOpzioni.addMouseListener(ordinaListener);		
		lblOpzioni.setIcon(new ImageIcon(ResponsabileNegozio.class.getResource("/view/Actions-tag-new-icon.png")));
		lblOpzioni.setHorizontalTextPosition(SwingConstants.CENTER);
		lblOpzioni.setVerticalTextPosition(SwingConstants.BOTTOM);
		Opzioni.add(lblOpzioni);
		
		JLabel lblVisualizzaOrdini = new JLabel("Visualizza ordini");
		//HACK
		BtnResponsabileNegozioVisualizzaOrdiniListener visualizzaordini = new BtnResponsabileNegozioVisualizzaOrdiniListener(this, numeronegozio);
		lblVisualizzaOrdini.addMouseListener(visualizzaordini);
		lblVisualizzaOrdini.setIcon(new ImageIcon(ResponsabileNegozio.class.getResource("/view/Checklist-icon.png")));
		lblVisualizzaOrdini.setHorizontalTextPosition(SwingConstants.CENTER);
		lblVisualizzaOrdini.setVerticalTextPosition(SwingConstants.BOTTOM);
		Opzioni.add(lblVisualizzaOrdini);
		contentPane.setLayout(gl_contentPane);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
}
