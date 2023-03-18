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

import controller.BtnSegreteriaAmministrativaInserimentoArticoloListener;
import controller.BtnSegreteriaAmministrativaInserimentoTipologiaListener;
import controller.BtnSegreteriaAmministrativaVisualizzaMovimentiEntrataListener;
import controller.BtnSegreteriaAmministrativaVisualizzaMovimentiUscita;
import controller.BtnSegreteriaAmministrativaVisualizzaOrdiniListener;
import controller.BtnChiudiApplicazioneListener;
import controller.BtnLogoutListener;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class SegreteriaAmministrativa extends JFrame {

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
					SegreteriaAmministrativa frame = new SegreteriaAmministrativa();
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
	public SegreteriaAmministrativa() {
		setResizable(false);
		setTitle("Segreteria amministrativa");
		setIconImage(Toolkit.getDefaultToolkit().getImage(SegreteriaAmministrativa.class.getResource("/view/Sport-bowling-icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 339);
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
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(Programma, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
							.addGap(265))
						.addComponent(Opzioni, GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(Opzioni, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(Programma, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		Opzioni.setLayout(new GridLayout(0, 5, 0, 0));
		
		JLabel lblVisualizzaOrdini = new JLabel("Visualizza ordini");
		BtnSegreteriaAmministrativaVisualizzaOrdiniListener list1 = new BtnSegreteriaAmministrativaVisualizzaOrdiniListener(this);
		lblVisualizzaOrdini.addMouseListener(list1);
		lblVisualizzaOrdini.setIcon(new ImageIcon(SegreteriaAmministrativa.class.getResource("/view/receipt-icon.png")));
		lblVisualizzaOrdini.setHorizontalTextPosition(SwingConstants.CENTER);
		lblVisualizzaOrdini.setVerticalTextPosition(SwingConstants.BOTTOM);
		Opzioni.add(lblVisualizzaOrdini);
		
		JLabel lblVisualizzaMovimenti = new JLabel("Visualizza movimenti entrata");
		BtnSegreteriaAmministrativaVisualizzaMovimentiEntrataListener list2 = new BtnSegreteriaAmministrativaVisualizzaMovimentiEntrataListener(this);
		lblVisualizzaMovimenti.addMouseListener(list2);
		lblVisualizzaMovimenti.setIcon(new ImageIcon(SegreteriaAmministrativa.class.getResource("/view/Package-upload-icon.png")));
		lblVisualizzaMovimenti.setHorizontalTextPosition(SwingConstants.CENTER);
		lblVisualizzaMovimenti.setVerticalTextPosition(SwingConstants.BOTTOM);
		Opzioni.add(lblVisualizzaMovimenti);
		
		JLabel lblInserimentoArticolo = new JLabel("Inserimento articolo");
		BtnSegreteriaAmministrativaInserimentoArticoloListener list3 = new BtnSegreteriaAmministrativaInserimentoArticoloListener(this);
		lblInserimentoArticolo.addMouseListener(list3);
		
		JLabel lblVisualizzaMovimentiUscita = new JLabel("Visualizza movimenti uscita");
		BtnSegreteriaAmministrativaVisualizzaMovimentiUscita list6 = new BtnSegreteriaAmministrativaVisualizzaMovimentiUscita(this);
		lblVisualizzaMovimentiUscita.addMouseListener(list6);
		lblVisualizzaMovimentiUscita.setIcon(new ImageIcon(SegreteriaAmministrativa.class.getResource("/view/Package-upload-icon.png")));
		lblVisualizzaMovimentiUscita.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblVisualizzaMovimentiUscita.setHorizontalTextPosition(SwingConstants.CENTER);
		Opzioni.add(lblVisualizzaMovimentiUscita);
		lblInserimentoArticolo.setIcon(new ImageIcon(SegreteriaAmministrativa.class.getResource("/view/add-item-icon.png")));
		lblInserimentoArticolo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblInserimentoArticolo.setVerticalTextPosition(SwingConstants.BOTTOM);
		Opzioni.add(lblInserimentoArticolo);
		
		JLabel lblInserimentoTipologiaArticolo = new JLabel("Inserimento tipologia");
		BtnSegreteriaAmministrativaInserimentoTipologiaListener list4 = new BtnSegreteriaAmministrativaInserimentoTipologiaListener(this);
		lblInserimentoTipologiaArticolo.addMouseListener(list4);
		lblInserimentoTipologiaArticolo.setIcon(new ImageIcon(SegreteriaAmministrativa.class.getResource("/view/add-item-icon.png")));
		lblInserimentoTipologiaArticolo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblInserimentoTipologiaArticolo.setVerticalTextPosition(SwingConstants.BOTTOM);
		Opzioni.add(lblInserimentoTipologiaArticolo);
		Programma.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblChiudiApplicazione = new JLabel("Chiudi applicazione");
		BtnChiudiApplicazioneListener list = new BtnChiudiApplicazioneListener();
		lblChiudiApplicazione.addMouseListener(list);
		lblChiudiApplicazione.setIcon(new ImageIcon(SegreteriaAmministrativa.class.getResource("/view/application-delete-icon.png")));
		lblChiudiApplicazione.setHorizontalTextPosition(SwingConstants.CENTER);
		lblChiudiApplicazione.setVerticalTextPosition(SwingConstants.BOTTOM);
		Programma.add(lblChiudiApplicazione);
		
		JLabel lblLogout = new JLabel("Log out");
		BtnLogoutListener logut = new BtnLogoutListener(this);
		lblLogout.addMouseListener(logut);
		lblLogout.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLogout.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblLogout.setIcon(new ImageIcon(SegreteriaAmministrativa.class.getResource("/view/logout-icon.png")));
		Programma.add(lblLogout);
		contentPane.setLayout(gl_contentPane);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}

}
