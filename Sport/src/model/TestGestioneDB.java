/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Nicolò
 *
 */
public class TestGestioneDB {

//	/**
//	 * @throws java.lang.Exception
//	 */
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//	}
//
//	/**
//	 * @throws java.lang.Exception
//	 */
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//	}
//
//	/**
//	 * @throws java.lang.Exception
//	 */
//	@Before
//	public void setUp() throws Exception {
//	}
//
//	/**
//	 * @throws java.lang.Exception
//	 */
//	@After
//	public void tearDown() throws Exception {
//	}

	/**
	 * Test method for {@link model.GestioneDB#cercaRuolo(java.lang.String, java.lang.String)}.
	 * @throws UsernamePasswordNonValido 
	 */
	@Test
	public void testCercaRuolo() throws UsernamePasswordNonValido {
		if (GestioneDB.getInstance().cercaRuolo("Paolo.Rossi", "Test") != Ruoli.SegreteriaAmministrativo)
		{
			Assert.fail();
		}
		
		if (GestioneDB.getInstance().cercaRuolo("Paola.Rossi", "Test") != Ruoli.Magazziniere)
		{
			Assert.fail();
		}
		
		if (GestioneDB.getInstance().cercaRuolo("Federica.Rossi", "Test") != Ruoli.ReponsabileNegozio)
		{
			Assert.fail();
		}
	}

	/**
	 * Test method for {@link model.GestioneDB#numeroNegozio(java.lang.String, java.lang.String)}.
	 * @throws UsernamePasswordNonValido 
	 */
	@Test
	public void testNumeroNegozio() throws UsernamePasswordNonValido {
		Assert.assertEquals(GestioneDB.getInstance().numeroNegozio("Federica.Rossi", "Test"), 1);
	}
	
	/**
	 * Test method for {@link model.GestioneDB#tuttiOrdini()}.
	 * @throws ErroreNelDB 
	 */
	@Test
	public void testTuttiOrdini() throws ErroreNelDB {
		Assert.assertNotEquals(GestioneDB.getInstance().tuttiOrdini().size(), 0);
	}

	/**
	 * Test method for {@link model.GestioneDB#cercaOrdiniNegozio(int)}.
	 * @throws ErroreNelDB 
	 */
	@Test
	public void testCercaOrdiniNegozio() throws ErroreNelDB {
		Assert.assertNotEquals(GestioneDB.getInstance().cercaOrdiniNegozio(1).size(), 0);
	}
	
	@Test
	public void testTuttiOrdiniNonEvasi() throws ErroreNelDB
	{
		Assert.assertNotEquals(GestioneDB.getInstance().tuttiOrdiniNonEvasi().size(), 0);
	}

	/**
	 * Test method for {@link model.GestioneDB#listaArticoli(int)}.
	 * @throws ErroreNelDB 
	 */
	@Test
	public void testListaArticoli() throws ErroreNelDB {
		Assert.assertNotEquals(GestioneDB.getInstance().listaArticoli(1).size(), 0);
	}

	/**
	 * Test method for {@link model.GestioneDB#tuttiArticoli()}.
	 * @throws ErroreNelDB 
	 */
	@Test
	public void testTuttiArticoli() throws ErroreNelDB {
		Assert.assertNotEquals(GestioneDB.getInstance().tuttiArticoli().size(), 0);
	}

	/**
	 * Test method for {@link model.GestioneDB#cercaArticoli(int)}.
	 * @throws ErroreNelDB 
	 */
	@Test
	public void testCercaArticoliInt() throws ErroreNelDB {
		Assert.assertFalse(GestioneDB.getInstance().cercaArticoli(1).prezzo < 1);
	}

	/**
	 * Test method for {@link model.GestioneDB#tuttiMovimentiEntrata()}.
	 * @throws ErroreNelDB 
	 */
	@Test
	public void testTuttiMovimentiEntrata() throws ErroreNelDB {
		Assert.assertNotEquals(GestioneDB.getInstance().tuttiMovimentiEntrata().size(), 0);
	}

	/**
	 * Test method for {@link model.GestioneDB#tuttiMovimentiUscita()}.
	 * @throws ErroreNelDB 
	 */
	@Test
	public void testTuttiMovimentiUscita() throws ErroreNelDB {
		Assert.assertNotEquals(GestioneDB.getInstance().tuttiMovimentiUscita().size(), 0);
	}

	/**
	 * Test method for {@link model.GestioneDB#spostaArticolo(int, int)}.
	 * @throws VincoliSbagliati 
	 * @throws ErroreNelDB 
	 */
	@Test
	public void testSpostaArticolo() throws ErroreNelDB, VincoliSbagliati {
		GestioneDB.getInstance().spostaArticolo(1, 1);
		Assert.assertEquals(GestioneDB.getInstance().tuttiMovimentiEntrata().get(0).posizioneCodice, 1);
	}

	/**
	 * Test method for {@link model.GestioneDB#tutteTipologie()}.
	 * @throws ErroreNelDB 
	 */
	@Test
	public void testTutteTipologie() throws ErroreNelDB {
		Assert.assertNotEquals(GestioneDB.getInstance().tutteTipologie().size(), 0);
	}

	/**
	 * Test method for {@link model.GestioneDB#tuttePosizioni()}.
	 * @throws ErroreNelDB 
	 */
	@Test
	public void testTuttePosizioni() throws ErroreNelDB {
		Assert.assertNotEquals(GestioneDB.getInstance().tuttePosizioni().size(), 0);
	}

	/**
	 * Test method for {@link model.GestioneDB#tuttiSport()}.
	 * @throws ErroreNelDB 
	 */
	@Test
	public void testTuttiSport() throws ErroreNelDB {
		Assert.assertNotEquals(GestioneDB.getInstance().tuttiSport().size(), 0);
	}

	/**
	 * Test method for {@link model.GestioneDB#tuttiBolle()}.
	 * @throws ErroreNelDB 
	 */
	@Test
	public void testTuttiBolle() throws ErroreNelDB {
		Assert.assertNotEquals(GestioneDB.getInstance().tuttiBolle().size(), 0);
	}

	/**
	 * Test method for {@link model.GestioneDB#tuttiDettagliOrdine(int)}.
	 * @throws ErroreNelDB 
	 */
	@Test
	public void testTuttiDettagliOrdine() throws ErroreNelDB {
		Assert.assertNotEquals(GestioneDB.getInstance().tuttiDettagliOrdine(1).size(), 0);
	}

	/**
	 * Test method for {@link model.GestioneDB#tuttiSpedizionieri()}.
	 * @throws ErroreNelDB 
	 */
	@Test
	public void testTuttiSpedizionieri() throws ErroreNelDB {
		Assert.assertNotEquals(GestioneDB.getInstance().tuttiSpedizionieri().size(), 1);
	}

	/**
	 * Test method for {@link model.GestioneDB#cercaPosizione()}.
	 * @throws ErroreNelDB 
	 */
	@Test
	public void testCercaPosizione() throws ErroreNelDB {
		GestioneDB.getInstance().cercaPosizione();
	}

	/**
	 * Test method for {@link model.GestioneDB#articolientrati(int)}.
	 * @throws ErroreNelDB 
	 */
	@Test
	public void testArticolientrati() throws ErroreNelDB {
		GestioneDB.getInstance().articolientrati(1);
	}

	/**
	 * Test method for {@link model.GestioneDB#articoliusciti(int)}.
	 * @throws ErroreNelDB 
	 */
	@Test
	public void testArticoliusciti() throws ErroreNelDB {
		GestioneDB.getInstance().articoliusciti(1);
	}
	
	@Test
	public void testCalcolaGiacenzaZona() throws ErroreNelDB
	{
		Assert.assertNotEquals(GestioneDB.getInstance().calcolaGiacenzaZona(1), 2);
	}
	
	@Test
	public void testCalcolaGiacenza() throws ErroreNelDB
	{
		Assert.assertNotEquals(GestioneDB.getInstance().calcolaGiacenza(2), 0);
	}

	/**
	 * Test method for {@link model.GestioneDB#inserisciArticolo(double, java.util.Date, int)}.
	 * @throws VincoliSbagliati 
	 * @throws ErroreNelDB 
	 */
	@Test
	public void testInserisciArticolo() throws ErroreNelDB, VincoliSbagliati {
		GestioneDB.getInstance().inserisciArticolo("Test", 1, new Date(), 1);
	}

	/**
	 * Test method for {@link model.GestioneDB#inserisciMateriale(java.lang.String)}.
	 * @throws VincoliSbagliati 
	 * @throws ErroreNelDB 
	 */
	@Test
	public void testInserisciMateriale() throws ErroreNelDB, VincoliSbagliati {
		GestioneDB.getInstance().inserisciMateriale("Descrizione");
	}

	/**
	 * Test method for {@link model.GestioneDB#inserisciNuovoMovimentoEntrata(java.util.Date, int, int)}.
	 * @throws VincoliSbagliati 
	 * @throws ErroreNelDB 
	 */
	@Test
	public void testInserisciMovimentoEntrata() throws ErroreNelDB, VincoliSbagliati {
		GestioneDB.getInstance().inserisciNuovoMovimentoEntrata(new Date(), 1, 1);
	}

	/**
	 * Test method for {@link model.GestioneDB#inserisciMovimentoUscita(java.util.Date, int, int, int)}.
	 * @throws VincoliSbagliati 
	 * @throws ErroreNelDB 
	 */
	@Test
	public void testInserisciMovimentoUscita() throws ErroreNelDB, VincoliSbagliati {
		GestioneDB.getInstance().inserisciMovimentoUscita(1);
	}

	/**
	 * Test method for {@link model.GestioneDB#inserisciNegozio(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 * @throws VincoliSbagliati 
	 * @throws ErroreNelDB 
	 */
	@Test
	public void testInserisciNegozio() throws ErroreNelDB, VincoliSbagliati {
		GestioneDB.getInstance().inserisciNegozio("AAAA", "Nome", "Indirizzo", "Citta");
	}

	/**
	 * Test method for {@link model.GestioneDB#inserisciTipologia(java.lang.String, java.lang.String, int)}.
	 * @throws VincoliSbagliati 
	 * @throws ErroreNelDB 
	 */
	@Test
	public void testInserisciTipologia() throws ErroreNelDB, VincoliSbagliati {
		GestioneDB.getInstance().inserisciTipologia("Nome", "Descrizione", 1);
	}

	/**
	 * Test method for {@link model.GestioneDB#inserisciOrdine(java.util.ArrayList, int)}.
	 * @throws ErroreNelDB 
	 * @throws VincoliSbagliati 
	 */
	@Test
	public void testInserisciOrdine() throws VincoliSbagliati, ErroreNelDB {
		ArrayList<DettaglioOrdine> list = new ArrayList<DettaglioOrdine>();
		list.add(new DettaglioOrdine(1, 1, 1, 1));
		
		GestioneDB.getInstance().inserisciOrdine(list, 1);
	}

}
