package view;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.BtnMagazziniereMovimentoEntrataListener;
import controller.BtnMagazziniereMovimentoUscitaListener;
import controller.BtnMagazziniereSpostaArticoloListener;
import controller.BtnChiudiApplicazioneListener;
import controller.BtnLogoutListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class Magazziniere extends JFrame {

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
					Magazziniere frame = new Magazziniere();
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
	public Magazziniere() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Magazziniere.class.getResource("/view/Sport-bowling-icon.png")));
		setTitle("Magazziniere");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 373, 329);
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
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(Opzioni, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(Programma, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
							.addGap(51))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(Opzioni, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addComponent(Programma, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		Programma.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblChiudiApplicazione = new JLabel("Chiudi applicazione");
		BtnChiudiApplicazioneListener list = new BtnChiudiApplicazioneListener();
		lblChiudiApplicazione.addMouseListener(list);
		lblChiudiApplicazione.setHorizontalTextPosition(SwingConstants.CENTER);
		lblChiudiApplicazione.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblChiudiApplicazione.setIcon(new ImageIcon(Magazziniere.class.getResource("/view/application-delete-icon.png")));
		Programma.add(lblChiudiApplicazione);
		
		JLabel lbllogout = new JLabel("Log out");
		BtnLogoutListener listout = new BtnLogoutListener(this);
		lbllogout.addMouseListener(listout);
		lbllogout.setIcon(new ImageIcon(Magazziniere.class.getResource("/view/logout-icon.png")));
		lbllogout.setHorizontalTextPosition(SwingConstants.CENTER);
		lbllogout.setVerticalTextPosition(SwingConstants.BOTTOM);
		Programma.add(lbllogout);
		Opzioni.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblMovimentoEntrata = new JLabel("Movimento Entrata");
		BtnMagazziniereMovimentoEntrataListener list1 = new BtnMagazziniereMovimentoEntrataListener(this);
		lblMovimentoEntrata.addMouseListener(list1);
		lblMovimentoEntrata.setIcon(new ImageIcon(Magazziniere.class.getResource("/view/Package-add-icon.png")));
		lblMovimentoEntrata.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMovimentoEntrata.setVerticalTextPosition(SwingConstants.BOTTOM);
		Opzioni.add(lblMovimentoEntrata);
		
		JLabel lblMovimentoUscita = new JLabel("Movimento Uscita");
		BtnMagazziniereMovimentoUscitaListener list2 = new BtnMagazziniereMovimentoUscitaListener(this);
		lblMovimentoUscita.addMouseListener(list2);
		lblMovimentoUscita.setIcon(new ImageIcon(Magazziniere.class.getResource("/view/Package-delete-icon.png")));
		lblMovimentoUscita.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMovimentoUscita.setVerticalTextPosition(SwingConstants.BOTTOM);
		Opzioni.add(lblMovimentoUscita);
		
		JLabel lblSposta = new JLabel("Sposta articolo");
		BtnMagazziniereSpostaArticoloListener list3 = new BtnMagazziniereSpostaArticoloListener(this);
		lblSposta.addMouseListener(list3);
		lblSposta.setIcon(new ImageIcon(Magazziniere.class.getResource("/view/Package-upload-icon.png")));
		lblSposta.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSposta.setVerticalTextPosition(SwingConstants.BOTTOM);
		Opzioni.add(lblSposta);
		contentPane.setLayout(gl_contentPane);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
}
