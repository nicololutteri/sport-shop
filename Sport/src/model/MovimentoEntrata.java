package model;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MovimentoEntrata {
	public int codOperazione; //1
	public String dataOperazione; //2
	public int articoloCodice; //3
	public String nomeArticolo; //4
	public double prezzo; //5
	public String dataproduzione; //6
	public int tipologiaCodice; //7
	public String nomeTipologia; //8
	public int sportCodice; //9
	public String nomeSport; //10
	public int posizioneCodice; //11
	public String posizione; //12

	public MovimentoEntrata(int codOperazione, String dataOperazione, int articoloCodice, String nomeArticolo,
			double prezzo, String dataproduzione, int tipologiaCodice, String nomeTipologia, int sportCodice,
			String nomeSport, int posizioneCodice, String posizione) {
		super();
		this.codOperazione = codOperazione;
		this.dataOperazione = dataOperazione;
		this.articoloCodice = articoloCodice;
		this.nomeArticolo = nomeArticolo;
		this.prezzo = prezzo;
		this.dataproduzione = dataproduzione;
		this.tipologiaCodice = tipologiaCodice;
		this.nomeTipologia = nomeTipologia;
		this.sportCodice = sportCodice;
		this.nomeSport = nomeSport;
		this.posizioneCodice = posizioneCodice;
		this.posizione = posizione;
	}

	public void Aggiungi(JTable tabella)
	{
		DefaultTableModel model = (DefaultTableModel) tabella.getModel();
		model.addRow(new Object[]{codOperazione, dataOperazione, articoloCodice, nomeArticolo, prezzo, dataproduzione, nomeTipologia, nomeSport, posizione});
	}
}
