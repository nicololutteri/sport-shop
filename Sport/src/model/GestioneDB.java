package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class GestioneDB {
	
	//region Singleton
	private static GestioneDB instance = null;
	Connection con;
	
	protected GestioneDB()	{
		try {
			crea("127.0.0.1", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static GestioneDB getInstance() {
	      if(instance == null) {
	    	  instance = new GestioneDB();
	      }
	      return instance;
	}
	//endregion
	
	//region Preparazione
	public void crea(String ip, String username, String password) throws SQLException
	{
		con = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/Sport?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", username, password);
	}
	//endregion
	
	//region Login
	public Ruoli cercaRuolo(String username, String password) throws UsernamePasswordNonValido
	{
		try {
			//Query
			PreparedStatement s = con.prepareStatement("SELECT sport.ruolonome.idRuoloNome "
					+ "FROM (sport.informazioni_utente INNER JOIN sport.ruolonome ON sport.ruolonome.idRuoloNome = sport.informazioni_utente.RuoloNome_idRuoloNome) "
					+ "WHERE sport.informazioni_utente.username = ? AND sport.informazioni_utente.password = ?;");
			s.setString(1, username);
			s.setString(2, password);
			//Risultato
			ResultSet result = s.executeQuery();
			
			result.next();
		    return Ruoli.values()[result.getInt(1) - 1];
		}
		catch (SQLException ex) {
			throw new UsernamePasswordNonValido();
		}
	}
	public int numeroNegozio(String username, String password) throws UsernamePasswordNonValido
	{
		try {
			//Query
			PreparedStatement s = con.prepareStatement("SELECT sport.informazioni_utente.Negozio_Id_Negozio "
					+ "FROM (sport.informazioni_utente INNER JOIN sport.ruolonome ON sport.ruolonome.idRuoloNome = sport.informazioni_utente.RuoloNome_idRuoloNome) "
					+ "WHERE sport.informazioni_utente.username = ? AND sport.informazioni_utente.password = ?;");
			s.setString(1, username);
			s.setString(2, password);
			//Risultato
			ResultSet result = s.executeQuery();
			
			result.next();
		    return result.getInt(1);
		}
		catch (SQLException ex) {
			throw new UsernamePasswordNonValido();
		}
	}
	//endregion
	
	//region Ordini
	public ArrayList<Ordine> tuttiOrdini() throws ErroreNelDB
	{
		try {
			//Query
			PreparedStatement s = con.prepareStatement("SELECT sport.ordine.Cod_Ordine, sport.ordine.Data, sport.negozio.Id_Negozio, sport.negozio.Nome FROM (sport.ordine INNER JOIN sport.negozio ON sport.ordine.Negozio_Id_Negozio = sport.negozio.Id_Negozio);");
		    //Risultato
			ResultSet result = s.executeQuery();
			
			ArrayList<Ordine> tmp = new ArrayList<Ordine>();
			while(result.next())
	    	{
				tmp.add(new Ordine(result.getInt(1), result.getString(2), result.getInt(3), result.getString(4)));
	    	}
			return tmp;
		}
		catch (SQLException ex) {
			throw new ErroreNelDB();
		} 		
	}
	public ArrayList<Ordine> cercaOrdiniNegozio(int numero) throws ErroreNelDB
	{
		try {
			//Query
			PreparedStatement s = con.prepareStatement("SELECT sport.ordine.Cod_Ordine, sport.ordine.Data, sport.negozio.Id_Negozio, sport.negozio.Nome FROM (sport.ordine JOIN sport.negozio ON sport.ordine.Negozio_Id_Negozio = sport.negozio.Id_Negozio) WHERE sport.negozio.Id_Negozio = ?;");
		    s.setLong(1, numero);
			
		    //Risultato
			ResultSet result = s.executeQuery();
			
			ArrayList<Ordine> tmp = new ArrayList<Ordine>();
			while(result.next())
	    	{
				tmp.add(new Ordine(result.getInt(1), result.getString(2), result.getInt(3), result.getString(4)));
	    	}
			return tmp;
		}
		catch (SQLException ex) {
			throw new ErroreNelDB();
		}
	}
	public ArrayList<Ordine> tuttiOrdiniNonEvasi() throws ErroreNelDB {
		// TODO Problemi prestazioni
		ArrayList<Ordine> list = new ArrayList<Ordine>();
		
		for (Ordine x: GestioneDB.getInstance().tuttiOrdini())
		{
			if (!x.getEvaso())
			{
				list.add(x);
			}
		}
		
		return list;
	}
	public boolean ordineEvaso(int idordine) throws ErroreNelDB {
		try {
			//Query
			PreparedStatement s = con.prepareStatement("SELECT sport.movimenti_scarico.Bolla_Cod_Bolla "
					+ "FROM sport.movimenti_scarico "
					+ "WHERE sport.movimenti_scarico.Ordine_Cod_Ordine = ?;");
		    s.setLong(1, idordine);
			//Risultato
			ResultSet result = s.executeQuery();
			
			if (result.next())
			{
				return result.getInt(1) != 0;
			}
			else
			{
				return false;
			}
		}
		catch (SQLException ex) {
			throw new ErroreNelDB();
		}
	}
	//endregion
	
	//region Articoli
	public ArrayList<DettaglioOrdine> listaArticoli(int idordine) throws ErroreNelDB
	{
		try {
			//Query
			PreparedStatement s = con.prepareStatement("SELECT * FROM sport.dettaglio_ordine WHERE sport.dettaglio_ordine.Ordine_Cod_Ordine = ?;");
		    s.setString(1, new Integer(idordine).toString());
			//Risultato
			ResultSet result = s.executeQuery();
			
			ArrayList<DettaglioOrdine> tmp = new ArrayList<DettaglioOrdine>();
			while(result.next())
	    	{
				tmp.add(new DettaglioOrdine(result.getInt(1), result.getInt(2), result.getInt(3), result.getInt(4)));
	    	}
			return tmp;
		}
		catch (SQLException ex) {
			throw new ErroreNelDB();
		}
	}
	public ArrayList<Articolo> tuttiArticoli() throws ErroreNelDB
	{
		try {
			//Query
			PreparedStatement s = con.prepareStatement("SELECT sport.articolo.codice, sport.articolo.nome, sport.articolo.prezzo, sport.articolo.Data_Produzione, sport.articolo.Tipologia_Id_Tipologia, sport.tipologia.nome, sport.sport.Codice, sport.sport.Disciplina\r\n" + 
					" FROM ((sport.articolo INNER JOIN sport.tipologia ON sport.articolo.Tipologia_Id_Tipologia = sport.tipologia.Id_Tipologia) INNER JOIN sport.sport ON sport.sport.Codice = sport.tipologia.Sport_Codice);");
		    //Risultato
			ResultSet result = s.executeQuery();
			
			ArrayList<Articolo> tmp = new ArrayList<Articolo>();
			while(result.next())
	    	{
				tmp.add(new Articolo(result.getInt(1), result.getString(2), result.getDouble(3), result.getString(4), result.getInt(5), result.getString(6), result.getInt(7), result.getString(8)));
	    	}
			return tmp;
		}
		catch (SQLException ex) {
			throw new ErroreNelDB();
		}
	}	
	public Articolo cercaArticoli(int id) throws ErroreNelDB
	{
		try {
			//Query
			PreparedStatement s = con.prepareStatement("SELECT sport.articolo.codice, sport.articolo.nome, sport.articolo.prezzo, sport.articolo.Data_Produzione, sport.articolo.Tipologia_Id_Tipologia, sport.tipologia.nome, sport.sport.Codice, sport.sport.Disciplina\r\n" + 
					" FROM ((sport.articolo INNER JOIN sport.tipologia ON sport.articolo.Tipologia_Id_Tipologia = sport.tipologia.Id_Tipologia) INNER JOIN sport.sport ON sport.sport.Codice = sport.tipologia.Sport_Codice) WHERE sport.articolo.codice = ?;");
			s.setLong(1, id);
			
		    //Risultato
			ResultSet result = s.executeQuery();
			
			result.next();
			return (new Articolo(result.getInt(1), result.getString(2), result.getDouble(3), result.getString(4), result.getInt(5), result.getString(6), result.getInt(7), result.getString(8)));
		}
		catch (SQLException ex) {
			throw new ErroreNelDB();
		} 		
	}
	public int articoloPosizioneInMagazzino(int idarticolo) throws ErroreNelDB
	{
		try {
			//Query
			PreparedStatement s = con.prepareStatement("SELECT sport.movimenti_carico.Cod_Operazione FROM sport.movimenti_carico WHERE sport.movimenti_carico.Movimenti_Scarico_Cod_Operazione IS NULL AND sport.movimenti_carico.Articolo_Codice = ?;");
			s.setLong(1, idarticolo);
			
		    //Risultato
			ResultSet result = s.executeQuery();
			
			result.next();
			return result.getInt(1);
		}
		catch (SQLException ex) {
			throw new ErroreNelDB();
		}
	}
	//endregion
	
	//region Movimenti
	public ArrayList<MovimentoEntrata> tuttiMovimentiEntrata() throws ErroreNelDB
	{
		try {
			//Query
			PreparedStatement s = con.prepareStatement("SELECT sport.movimenti_carico.Cod_Operazione, sport.movimenti_carico.Data_Operazione, sport.movimenti_carico.Articolo_Codice, sport.articolo.nome, sport.articolo.prezzo, sport.articolo.Data_Produzione, sport.tipologia.Id_Tipologia, sport.tipologia.Nome, sport.sport.Codice, sport.sport.Disciplina, sport.posizione.id_Posizione, sport.posizione.Nome FROM (((((sport.movimenti_carico INNER JOIN sport.articolo ON sport.articolo.Codice = sport.movimenti_carico.Articolo_Codice) INNER JOIN sport.posizione ON sport.movimenti_carico.Posizione_id_Posizione = sport.posizione.id_Posizione) INNER JOIN sport.tipologia ON sport.tipologia.Id_Tipologia = sport.articolo.Tipologia_Id_Tipologia) INNER JOIN sport.sport ON sport.sport.Codice = sport.tipologia.Sport_Codice));");
		    //Risultato
			ResultSet result = s.executeQuery();
			
			ArrayList<MovimentoEntrata> tmp = new ArrayList<MovimentoEntrata>();
			while(result.next())
	    	{
				tmp.add(new MovimentoEntrata(result.getInt(1), result.getString(2), result.getInt(3), result.getString(4), result.getDouble(5), result.getString(6), result.getInt(7), result.getString(8), result.getInt(9), result.getString(10), result.getInt(11), result.getString(12)));
	    	}
			return tmp;
		}
		catch (SQLException ex) {
			throw new ErroreNelDB();
		}
	}
	public ArrayList<MovimentoEntrata> tuttiMovimentiUscitaNonEvasi() throws ErroreNelDB
	{
		try {
			//Query
			PreparedStatement s = con.prepareStatement("SELECT sport.movimenti_carico.Cod_Operazione, sport.movimenti_carico.Data_Operazione, sport.movimenti_carico.Articolo_Codice, sport.articolo.nome, sport.articolo.prezzo, sport.articolo.Data_Produzione, sport.tipologia.Id_Tipologia, sport.tipologia.Nome, sport.sport.Codice, sport.sport.Disciplina, sport.posizione.id_Posizione, sport.posizione.Nome FROM (((((sport.movimenti_carico INNER JOIN sport.articolo ON sport.articolo.Codice = sport.movimenti_carico.Articolo_Codice) INNER JOIN sport.posizione ON sport.movimenti_carico.Posizione_id_Posizione = sport.posizione.id_Posizione) INNER JOIN sport.tipologia ON sport.tipologia.Id_Tipologia = sport.articolo.Tipologia_Id_Tipologia) INNER JOIN sport.sport ON sport.sport.Codice = sport.tipologia.Sport_Codice)) WHERE sport.movimenti_carico.Movimenti_Scarico_Cod_Operazione IS NULL;");
		    //Risultato
			ResultSet result = s.executeQuery();
			
			ArrayList<MovimentoEntrata> tmp = new ArrayList<MovimentoEntrata>();
			while(result.next())
	    	{
				tmp.add(new MovimentoEntrata(result.getInt(1), result.getString(2), result.getInt(3), result.getString(4), result.getDouble(5), result.getString(6), result.getInt(7), result.getString(8), result.getInt(9), result.getString(10), result.getInt(11), result.getString(12)));
	    	}
			return tmp;
		}
		catch (SQLException ex) {
			throw new ErroreNelDB();
		}
	}	
	
	public ArrayList<MovimentoUscita> tuttiMovimentiUscita() throws ErroreNelDB
	{
		try {
			//Query
			PreparedStatement s = con.prepareStatement("SELECT sport.movimenti_scarico.Cod_Operazione, sport.movimenti_scarico.Data_Operazione, sport.bolla.Cod_Bolla, sport.bolla.Ora, sport.bolla.Data, sport.spedizioniere.Id_Spedizioniere, sport.spedizioniere.Nome, sport.ordine.Cod_Ordine, sport.ordine.Data, sport.negozio.Id_Negozio, sport.negozio.Nome\r\n" + 
					"FROM ((((sport.movimenti_scarico INNER JOIN sport.ordine ON sport.ordine.Cod_Ordine = sport.movimenti_scarico.Ordine_Cod_Ordine)\r\n" + 
					"INNER JOIN sport.bolla ON sport.movimenti_scarico.Bolla_Cod_Bolla = sport.bolla.Cod_Bolla)\r\n" + 
					"INNER JOIN sport.spedizioniere ON sport.spedizioniere.Id_Spedizioniere = sport.bolla.Id_Spedizioniere)\r\n" + 
					"INNER JOIN sport.negozio ON sport.ordine.Negozio_Id_Negozio = sport.negozio.Id_Negozio);");
		    //Risultato
			ResultSet result = s.executeQuery();
			
			ArrayList<MovimentoUscita> tmp = new ArrayList<MovimentoUscita>();
			while(result.next())
	    	{
				tmp.add(new MovimentoUscita(result.getInt(1), result.getString(2), result.getInt(3), result.getString(4), result.getString(5), result.getInt(6), result.getString(7), result.getInt(8), result.getString(9), result.getInt(10), result.getString(11)));
	    	}
			
			//Query
			s = con.prepareStatement("SELECT sport.movimenti_scarico.Cod_Operazione, sport.movimenti_scarico.Data_Operazione, sport.ordine.Cod_Ordine, sport.ordine.Data, sport.negozio.Id_Negozio, sport.negozio.Nome \r\n" + 
					"FROM ((sport.movimenti_scarico INNER JOIN sport.ordine ON sport.ordine.Cod_Ordine = sport.movimenti_scarico.Ordine_Cod_Ordine)\r\n" + 
					"INNER JOIN sport.negozio ON sport.ordine.Negozio_Id_Negozio = sport.negozio.Id_Negozio) WHERE sport.movimenti_scarico.Bolla_Cod_Bolla IS NULL;");
		    //Risultato
			result = s.executeQuery();
			
			while(result.next())
	    	{
				tmp.add(new MovimentoUscita(result.getInt(1), result.getString(2), result.getInt(3), result.getString(4), result.getInt(5), result.getString(6)));
	    	}
						
			return tmp;
		}
		catch (SQLException ex) {
			throw new ErroreNelDB();
		}
	}
	
	public void spostaArticolo(int numeromagazzino, int nuovaposizione) throws ErroreNelDB, VincoliSbagliati
	{
		if (numeromagazzino < 1 || nuovaposizione < 1)
		{
			throw new VincoliSbagliati();
		}
		
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("UPDATE sport.movimenti_carico "
					+ "SET sport.movimenti_carico.Posizione_id_Posizione = ? "
					+ "WHERE sport.movimenti_carico.Cod_Operazione = ?;");
			stmt.setInt(1, nuovaposizione);
			stmt.setInt(2, numeromagazzino);
			
			boolean i = stmt.execute();

			if(i)
			{
				throw new ErroreNelDB();
			}
		}
        catch (SQLException e) {
        	throw new ErroreNelDB();
		}
	}
	//endregion
	
	//region Select *
	public ArrayList<String> tutteTipologie() throws ErroreNelDB
	{
		try {
			//Query
			PreparedStatement s = con.prepareStatement("SELECT sport.tipologia.nome FROM sport.tipologia;");
		    //Risultato
			ResultSet result = s.executeQuery();
			
			ArrayList<String> tmp = new ArrayList<String>();
			while(result.next())
	    	{
				tmp.add(result.getString(1));
	    	}
			return tmp;
		}
		catch (SQLException ex) {
			throw new ErroreNelDB();
		}
	}
	public ArrayList<Posizioni> tuttePosizioni() throws ErroreNelDB
	{
		try {
			//Query
			PreparedStatement s = con.prepareStatement("SELECT * FROM sport.posizione;");
		    //Risultato
			ResultSet result = s.executeQuery();
			
			ArrayList<Posizioni> tmp = new ArrayList<Posizioni>();
			while(result.next())
	    	{
				tmp.add(new Posizioni(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4)));
	    	}
			return tmp;
		}
		catch (SQLException ex) {
			throw new ErroreNelDB();
		}
	}
	public ArrayList<String> tuttiSport() throws ErroreNelDB
	{
		try {
			//Query
			PreparedStatement s = con.prepareStatement("SELECT sport.Disciplina FROM sport.sport;");
		    //Risultato
			ResultSet result = s.executeQuery();
			
			ArrayList<String> tmp = new ArrayList<String>();
			while(result.next())
	    	{
				tmp.add(result.getString(1));
	    	}
			return tmp;
		}
		catch (SQLException ex) {
			throw new ErroreNelDB();
		}
	}
	public ArrayList<Bolla> tuttiBolle() throws ErroreNelDB
	{
		try {
			//Query
			PreparedStatement s = con.prepareStatement("SELECT sport.bolla.Cod_Bolla, sport.bolla.Data, sport.bolla.ora, sport.spedizioniere.Id_Spedizioniere, sport.spedizioniere.Nome FROM sport.bolla INNER JOIN sport.spedizioniere ON sport.bolla.Id_Spedizioniere = sport.spedizioniere.Id_Spedizioniere;");
		    //Risultato
			ResultSet result = s.executeQuery();
			
			ArrayList<Bolla> tmp = new ArrayList<Bolla>();
			while(result.next())
	    	{
				tmp.add(new Bolla(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4), result.getString(5)));
	    	}
			return tmp;
		}
		catch (SQLException ex) {
			throw new ErroreNelDB();
		}
	}
	public ArrayList<DettaglioOrdine> tuttiDettagliOrdine(int numeroordine) throws ErroreNelDB
	{
		try {
			//Query
			PreparedStatement s = con.prepareStatement("SELECT sport.dettaglio_ordine.Codice_Dettagio, sport.dettaglio_ordine.Quantita, sport.dettaglio_ordine.Prezzo_Totale, sport.dettaglio_ordine.Articolo_Codice "
					+ "FROM (sport.dettaglio_ordine INNER JOIN sport.ordine ON sport.dettaglio_ordine.Ordine_Cod_Ordine = sport.ordine.Cod_Ordine) "
					+ "WHERE sport.ordine.Cod_Ordine = ?;");
			s.setLong(1, numeroordine);

			//Risultato
			ResultSet result = s.executeQuery();
			
			ArrayList<DettaglioOrdine> tmp = new ArrayList<DettaglioOrdine>();
			while(result.next())
	    	{
				tmp.add(new DettaglioOrdine(result.getInt(1), result.getInt(2), result.getInt(3), result.getInt(4)));
	    	}
			return tmp;
		}
		catch (SQLException ex) {
			throw new ErroreNelDB();
		}
	}
	public ArrayList<Spedizioniere> tuttiSpedizionieri() throws ErroreNelDB
	{
		try {
			//Query
			PreparedStatement s = con.prepareStatement("SELECT * FROM sport.spedizioniere;");
		    //Risultato
			ResultSet result = s.executeQuery();
			
			ArrayList<Spedizioniere> tmp = new ArrayList<Spedizioniere>();
			while(result.next())
	    	{
				tmp.add(new Spedizioniere(result.getInt(1), result.getString(2), result.getString(3)));
	    	}
			return tmp;
		}
		catch (SQLException ex) {
			throw new ErroreNelDB();
		}
	}
	
	public ArrayList<String> cercaPosizione() throws ErroreNelDB
	{
		try {
			//Query
			PreparedStatement s = con.prepareStatement("SELECT sport.posizione.nome FROM sport.posizione;");
		    //Risultato
			ResultSet result = s.executeQuery();
			
			ArrayList<String> tmp = new ArrayList<String>();
			while(result.next())
	    	{
				tmp.add(result.getString(1));
	    	}
			return tmp;
		}
		catch (SQLException ex) {
			throw new ErroreNelDB();
		}
	}
	//endregion
	
 	//region Salva su file
	public int articolientrati(int numeromese) throws ErroreNelDB
 	{
		try {
			//Query
			PreparedStatement s = con.prepareStatement("SELECT count(*) FROM sport.movimenti_carico WHERE Month(sport.movimenti_carico.Data_Operazione) = ?;");
		    s.setInt(1, numeromese);
		    
			//Risultato
			ResultSet result = s.executeQuery();
			
			result.next();
			return result.getInt(1);
		}
		catch (SQLException ex) {
			throw new ErroreNelDB();
		}
 	}
 	public int articoliusciti(int numeromese) throws ErroreNelDB
 	{
		try {
			//Query
			PreparedStatement s = con.prepareStatement("SELECT count(*) FROM sport.movimenti_carico WHERE Month(sport.movimenti_carico.Data_Operazione) = ? AND sport.movimenti_carico.Movimenti_Scarico_Cod_Operazione IS NOT NULL;");
		    s.setInt(1, numeromese);
		    
			//Risultato
			ResultSet result = s.executeQuery();
			
			result.next();
			return result.getInt(1);
		}
		catch (SQLException ex) {
			throw new ErroreNelDB();
		}
 	}
 	//endregion
 	
 	//region Calcolo giacenza
 	public int calcolaGiacenzaZona(int idzona) throws ErroreNelDB
 	{
 		try {
			//Query
			PreparedStatement s = con.prepareStatement("SELECT count(*) FROM sport.movimenti_carico WHERE sport.movimenti_carico.Movimenti_Scarico_Cod_Operazione IS NULL AND sport.movimenti_carico.Posizione_id_Posizione = ?;");
		    s.setInt(1, idzona);
		    
			//Risultato
			ResultSet result = s.executeQuery();
			
			result.next();
		    return result.getInt(1);
		}
		catch (SQLException ex) {
			throw new ErroreNelDB();
		}
 	}
	public int maxGiacenzaZona(int idzona) throws ErroreNelDB {
		try {
			//Query
			PreparedStatement s = con.prepareStatement("SELECT sport.posizione.MaxGiacenza FROM sport.posizione WHERE sport.posizione.id_Posizione = ?;");
		    s.setInt(1, idzona);
		    
			//Risultato
			ResultSet result = s.executeQuery();
			
			result.next();
		    return result.getInt(1);
		}
		catch (SQLException ex) {
			throw new ErroreNelDB();
		}
	}
 	
 	public int calcolaGiacenza(int idarticolo) throws ErroreNelDB
 	{
 		try {
			//Query
			PreparedStatement s = con.prepareStatement("SELECT count(*) FROM sport.movimenti_carico WHERE sport.movimenti_carico.Articolo_Codice = ? AND sport.movimenti_carico.Movimenti_Scarico_Cod_Operazione IS NULL;");
		    s.setInt(1, idarticolo);
		    
			//Risultato
			ResultSet result = s.executeQuery();
			
			result.next();
		    int numeroentrati = result.getInt(1);
		    return numeroentrati;
		}
		catch (SQLException ex) {
			throw new ErroreNelDB();
		}
 	}
 	//endregion
 	
 	public Riepilogo evadiOrdine(int codicemovimentoscarico, int idspedizioniere) throws VincoliSbagliati, ErroreNelDB
 	{
		if (codicemovimentoscarico < 1 || idspedizioniere < 1)
		{
			throw new VincoliSbagliati();
		}
		
 		try {
 			int numerobolla;
 			this.creaNuovaBolla(idspedizioniere);
 			ArrayList<Bolla> list = this.tuttiBolle();
 			Bolla b = list.get(list.size() - 1);
 			numerobolla = b.codBolla;
 			
			//Query
			PreparedStatement stmt = con.prepareStatement("UPDATE sport.movimenti_scarico SET Bolla_Cod_Bolla = ? WHERE Cod_Operazione = ?");
		    stmt.setInt(1, numerobolla);
		    stmt.setInt(2, codicemovimentoscarico);
		    
			boolean i = stmt.execute();
			
			if(i)
			{
				throw new ErroreNelDB();
			}
			else
			{
				int ordine = prendiOrdine(codicemovimentoscarico);
				Riepilogo r = new Riepilogo(prelevaOrdine(ordine), b, prendiArticoliperUscita(codicemovimentoscarico));
				return r;
			}
		}
		catch (SQLException ex) {
			throw new ErroreNelDB();
		}
 	}
 	
 	public Bolla prelevaBolla(int idbolla)
 	{
 		// TODO Prestazioni
 		try {
			for (Bolla x: this.tuttiBolle())
			{
				if (x.codBolla == idbolla)
				{
					return x;
				}
			}
		} catch (ErroreNelDB e) {
			Utilita.MostraErroreDB(e.getMessage());
		}
 		
		return null;
 	}
 	
 	public Ordine prelevaOrdine(int ordine)
 	{
 		// TODO Prestazioni
 		try {
			for (Ordine x: this.tuttiOrdini())
			{
				if (x.codice == ordine)
				{
					return x;
				}
			}
		} catch (ErroreNelDB e) {
			Utilita.MostraErroreDB(e.getMessage());
		}
 		
		return null;
 	}
 	
 	public ArrayList<MovimentoEntrata> prendiArticoliperUscita(int uscita) throws ErroreNelDB
 	{
 		try {
			//Query
			PreparedStatement s = con.prepareStatement("SELECT sport.movimenti_carico.Cod_Operazione, sport.movimenti_carico.Data_Operazione, sport.movimenti_carico.Articolo_Codice, sport.articolo.nome, sport.articolo.prezzo, sport.articolo.Data_Produzione, sport.tipologia.Id_Tipologia, sport.tipologia.Nome, sport.sport.Codice, sport.sport.Disciplina, sport.posizione.id_Posizione, sport.posizione.Nome FROM (((((sport.movimenti_carico INNER JOIN sport.articolo ON sport.articolo.Codice = sport.movimenti_carico.Articolo_Codice) INNER JOIN sport.posizione ON sport.movimenti_carico.Posizione_id_Posizione = sport.posizione.id_Posizione) INNER JOIN sport.tipologia ON sport.tipologia.Id_Tipologia = sport.articolo.Tipologia_Id_Tipologia) INNER JOIN sport.sport ON sport.sport.Codice = sport.tipologia.Sport_Codice)) WHERE sport.movimenti_carico.Movimenti_Scarico_Cod_Operazione = ?;");
		    s.setInt(1, uscita);
		    
			//Risultato
			ResultSet result = s.executeQuery();
			
			ArrayList<MovimentoEntrata> tmp = new ArrayList<MovimentoEntrata>();
			while(result.next())
			{
				tmp.add(new MovimentoEntrata(result.getInt(1), result.getString(2), result.getInt(3), result.getString(4), result.getDouble(5), result.getString(6), result.getInt(7), result.getString(8), result.getInt(9), result.getString(10), result.getInt(11), result.getString(12)));
			}
			return tmp;
		}
		catch (SQLException ex) {
			throw new ErroreNelDB();
		}
 	}
 	
 	public int prendiMovimentoMagazzino(int idordine) throws ErroreNelDB
 	{		
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("SELECT sport.movimenti_scarico.Cod_Operazione FROM sport.movimenti_scarico WHERE sport.movimenti_scarico.Ordine_Cod_Ordine = ?;");
			stmt.setLong(1, idordine);
			
		    //Risultato
			ResultSet result = stmt.executeQuery();
			
			result.next();
			return result.getInt(1);
		}
        catch (SQLException e) {
        	throw new ErroreNelDB();
		}
 	}
 	
 	public int prendiOrdine(int idmagazzino) throws ErroreNelDB
 	{
 		PreparedStatement stmt;
		try {
			// TODO Da finire
			stmt = con.prepareStatement("SELECT sport.movimenti_scarico.Ordine_Cod_Ordine FROM sport.movimenti_scarico WHERE sport.movimenti_scarico.Cod_Operazione = ?;");
			stmt.setLong(1, idmagazzino);
			
		    //Risultato
			ResultSet result = stmt.executeQuery();
			
			result.next();
			return result.getInt(1);
		}
        catch (SQLException e) {
        	throw new ErroreNelDB();
		}
 	}
 	
 	//region Inserisci
 	public void inserisciArticolo(String nome, double prezzo, Date data, int tipologia) throws ErroreNelDB, VincoliSbagliati
	{
		if (nome.trim().equals("") || prezzo < 0 || data.compareTo(new Date()) == 1 || tipologia < 1)
		{
			throw new VincoliSbagliati();
		}
		
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("INSERT INTO sport.articolo VALUES (NULL, ?, ?, ?, ?)");
			stmt.setString(1, nome);
			stmt.setDouble(2, prezzo);
			stmt.setString(3, Utilita.convertData(data));
			stmt.setLong(4, tipologia);
			
			boolean i = stmt.execute();

			if(i)
			{
				throw new ErroreNelDB();
			}
		}
        catch (SQLException e) {
        	throw new ErroreNelDB();
		}
	}
	public void inserisciMateriale(String descrizione) throws ErroreNelDB, VincoliSbagliati
	{
		if (descrizione.trim().equals(""))
		{
			throw new VincoliSbagliati();
		}
		
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("INSERT INTO sport.materiale VALUES (NULL, ?)");
			stmt.setString(1, descrizione);
			
			boolean i = stmt.execute();

			if(i)
			{
				throw new ErroreNelDB();
			}
		}
        catch (SQLException e) {
        	throw new ErroreNelDB();
		}
	}
	public void inserisciNuovoMovimentoEntrata(Date data, int posizione, int articolo) throws ErroreNelDB, VincoliSbagliati
	{
		if (data.compareTo(new Date()) == 1 || posizione < 1 || articolo < 1)
		{
			throw new VincoliSbagliati();
		}
		
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("INSERT INTO sport.Movimenti_Carico VALUES (NULL, ?, NULL, ?, ?)");
			stmt.setString(1, Utilita.convertData(data));
			stmt.setLong(2, articolo);
			stmt.setLong(3, posizione);

			boolean i = stmt.execute();

			if(i)
			{
				throw new ErroreNelDB();
			}
		}
        catch (SQLException e) {
        	throw new ErroreNelDB();
		}
	}
	public void inserisciMovimentoUscita(int ordine) throws ErroreNelDB, VincoliSbagliati
	{
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("INSERT INTO sport.Movimenti_Scarico VALUES (NULL, ?, NULL, ?)");
			stmt.setString(1, Utilita.dataattuale());
			stmt.setInt(2, ordine);
			
			boolean i = stmt.execute();

			if(i)
			{
				throw new ErroreNelDB();
			}
		}
        catch (SQLException e) {
        	throw new ErroreNelDB();
		}
	}
	public void inserisciNegozio(String codicefiscale, String nome, String indirizzo, String citta) throws ErroreNelDB, VincoliSbagliati
	{
		if (codicefiscale.trim().equals("") || nome.trim().equals("") || indirizzo.trim().equals("") || citta.trim().equals(""))
		{
			throw new VincoliSbagliati();
		}
		
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("INSERT INTO sport.negozio VALUES (NULL, ?, ?, ?, ?)");
			stmt.setString(1, codicefiscale);
			stmt.setString(2, nome);
			stmt.setString(3, indirizzo);
			stmt.setString(4, citta);
			
			boolean i = stmt.execute();

			if(i)
			{
				throw new ErroreNelDB();
			}
		}
        catch (SQLException e) {
        	throw new ErroreNelDB();
		}
	}
	public void inserisciTipologia(String nome, String descrizione, int sport) throws ErroreNelDB, VincoliSbagliati
	{
		if (nome.trim().equals("") || descrizione.trim().equals("") || sport < 1)
		{
			throw new VincoliSbagliati();
		}
		
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("INSERT INTO sport.tipologia VALUES (NULL, ?, ?, ?)");
			stmt.setString(1, nome);
			stmt.setString(2, descrizione);
			stmt.setString(3, String.valueOf(sport));
			
			boolean i = stmt.execute();

			if(i)
			{
				throw new ErroreNelDB();
			}
		}
        catch (SQLException e) {
        	throw new ErroreNelDB();
		}		
	}
	
	public int ultimaBolla() throws ErroreNelDB {
		try {
			//Query
			PreparedStatement s = con.prepareStatement("SELECT * FROM sport.bolla order by sport.bolla.Cod_Bolla desc;");
		    //Risultato
			ResultSet result = s.executeQuery();
			
			result.next();
			return result.getInt(1);
		}
		catch (SQLException ex) {
			throw new ErroreNelDB();
		}
	}
	public void creaNuovaBolla(int spedizioniere) throws VincoliSbagliati, ErroreNelDB {
		inserisciBolla(Utilita.dataattuale(), Utilita.oraattuale(), spedizioniere);
	}
	public void inserisciBolla(String data, String ora, int spedizioniere) throws VincoliSbagliati, ErroreNelDB {
		if (data.trim().equals("") || ora.trim().equals("") || spedizioniere < 1)
		{
			throw new VincoliSbagliati();
		}
		
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("INSERT INTO sport.bolla VALUES (NULL, ?, ?, ?)");
			stmt.setString(1, data);
			stmt.setString(2, ora);
			stmt.setLong(3, spedizioniere);
			
			boolean i = stmt.execute();

			if(i)
			{
				throw new ErroreNelDB();
			}
		}
        catch (SQLException e) {
        	throw new ErroreNelDB();
		}
	}
	public void inserisciOrdine(ArrayList<DettaglioOrdine> lista, int numeronegozio) throws VincoliSbagliati, ErroreNelDB 
	{
		if (lista.size() <= 0 || numeronegozio < 1)
		{
			throw new VincoliSbagliati();
		}
		
		// Genera ordine
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("INSERT INTO sport.ordine VALUES (NULL, ?, ?)");
			stmt.setString(1, Utilita.convertData(new Date()));
			stmt.setLong(2, numeronegozio);
			
			boolean i = stmt.execute();
			
			if(i)
			{
				throw new ErroreNelDB();
			}			
		}
        catch (SQLException e) {
        	throw new ErroreNelDB();
		}
		
		// Trovo numero di ordine fatto
		int ordineprima;
		// TODO HACK Prendo l'ultimo della fila
		ArrayList<Ordine> list = tuttiOrdini();
		ordineprima = list.get(list.size() - 1).codice;
		
		// Genera tutti i dettagliordine
		for (DettaglioOrdine x: lista)
		{
			try {
				stmt = con.prepareStatement("INSERT INTO sport.dettaglio_ordine VALUES (NULL, ?, ?, ?, ?)");
				stmt.setLong(1, x.quantita);
				stmt.setDouble(2, x.prezzoTotale);
				stmt.setLong(3, x.articoloCodice);
				stmt.setLong(4, ordineprima);
				
				boolean i = stmt.execute();
				
				if(i)
				{
					throw new ErroreNelDB();
				}			
			}
	        catch (SQLException e) {
	        	throw new ErroreNelDB();
			}
		}
		
		this.inserisciMovimentoUscita(ordineprima);
		ArrayList<MovimentoUscita> list2 = this.tuttiMovimentiUscita();
		int movimentouscita = list2.get(list2.size() - 1).codOperazione;
		
		//Prendi gia articoli per l'ordine
		for (DettaglioOrdine x: lista)
		{
			int j;
			for (j = 1; j <= x.quantita; j++)
			{
					try {
					stmt = con.prepareStatement("UPDATE sport.movimenti_carico SET Movimenti_Scarico_Cod_Operazione = ? WHERE Cod_Operazione = ? and Articolo_Codice = ?");
					stmt.setLong(1, movimentouscita);
					stmt.setLong(2, this.articoloPosizioneInMagazzino(x.articoloCodice));
					stmt.setLong(3, x.articoloCodice);
					
					boolean i = stmt.execute();
					
					if(i)
					{
						throw new ErroreNelDB();
					}			
				}
		        catch (SQLException e) {
		        	throw new ErroreNelDB();
				}
			}		
		}
	}
	//endregion

	
}
