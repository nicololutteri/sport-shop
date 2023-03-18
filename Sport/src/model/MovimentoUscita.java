package model;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MovimentoUscita {
	public int codOperazione; //1
	public String dataOperazione; //2
	public int bollaCodBolla; //3
	public String data; //4
	public String ora; //5
	public int spedizioniereIdSpedizioniere; //6
	public String nomeSpedizioniere; //7
	public int idOrdine; //8
	public String OrdineData; //9
	public int idNegozio; //10
	public String NomeNegozio; //11
	
	public boolean evaso;
	
	public MovimentoUscita(int codOperazione, String dataOperazione, int bollaCodBolla, String data, String ora,
			int spedizioniereIdSpedizioniere, String nomeSpedizioniere, int idOrdine,
			String ordineData, int idNegozio, String nomeNegozio) {
		super();
		this.codOperazione = codOperazione;
		this.dataOperazione = dataOperazione;
		this.bollaCodBolla = bollaCodBolla;
		this.data = data;
		this.ora = ora;
		this.spedizioniereIdSpedizioniere = spedizioniereIdSpedizioniere;
		this.nomeSpedizioniere = nomeSpedizioniere;
		this.idOrdine = idOrdine;
		OrdineData = ordineData;
		this.idNegozio = idNegozio;
		NomeNegozio = nomeNegozio;
		
		this.evaso = true;
	}
	
	public MovimentoUscita(int codOperazione, String dataOperazione, int idOrdine, String ordineData, int idNegozio,
			String nomeNegozio) {
		super();
		this.codOperazione = codOperazione;
		this.dataOperazione = dataOperazione;
		this.idOrdine = idOrdine;
		OrdineData = ordineData;
		this.idNegozio = idNegozio;
		NomeNegozio = nomeNegozio;
		
		this.evaso = false;
	}

	public void Aggiungi(JTable tabella)
	{
		DefaultTableModel model = (DefaultTableModel) tabella.getModel();

		String ordine = "";
		if (evaso)
		{
			ordine = "Evaso";
		}
		else
		{
			ordine = "Non evaso";
		}
		
		model.addRow(new Object[]{codOperazione, dataOperazione, data, ora, nomeSpedizioniere, ordine, OrdineData, NomeNegozio});
	}
}
