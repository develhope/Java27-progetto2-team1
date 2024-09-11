package Management;

import Enums.TipoElettronico;
import Products.ProdottoElettronicoUtente;
import Users.Cliente;
import Users.Utente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarrelloTest {

	private Carrello carrello;
	private ProdottoElettronicoUtente prd1;
	private ProdottoElettronicoUtente prd2;
	private Utente usr1;
	private List<Utente> utenti;

	@BeforeEach
	void setUp() {
		carrello = new Carrello();
		prd1 = new ProdottoElettronicoUtente("Apple", "iPhone 14 pro", "Bello e potente", 1500.00, 0, TipoElettronico.SMARTPHONE, 6.3f);
		prd2 = new ProdottoElettronicoUtente("Samsung", "pc portatile", "molto interessante", 870,1, TipoElettronico.NOTEBOOK, 15.0f);
		usr1 = new Cliente("Piero", "Neri", 35, "piero@gmail.com", "piero13");
		utenti = new ArrayList <>();
		utenti.add(usr1);
	}

	@Test
	public void testSvuotaCarrello() {
		carrello.aggiungiProdotto(prd1, 1, utenti);
		carrello.svuotaCarrello(utenti);
		assertEquals(0, carrello.getCarrello().size(), "Il carrello dovrebbe essere vuoto");
	}

	@Test
	public void testAggiungiProdotto() {
		carrello.aggiungiProdotto(prd1, 1, utenti);
		carrello.aggiungiProdotto(prd2, 1, utenti);
		assertEquals(2, carrello.getCarrello().size(), "Il numero di elementi nel carrello dovrebbe essere 2");
	}

	@Test
	public void testContieneProdotti() {
		carrello.aggiungiProdotto(prd1, 1, utenti);
		assertTrue(carrello.getCarrello().contains(prd1), "Il carrello dovrebbe contenere il prodotto 1");
	}

	@Test
	public void testCarrelloNonNull() {
		assertNotNull(carrello.getCarrello(), "La lista degli items non dovrebbe essere null");
	}

	@Test
	public void testCorrispondenzaContenutiCarrello() {
		carrello.aggiungiProdotto(prd1, 1, utenti);
		carrello.aggiungiProdotto(prd2, 1, utenti);
		ProdottoElettronicoUtente[] expectedItems = {prd1, prd2};
		assertArrayEquals(expectedItems, carrello.getCarrello().toArray(), "Gli items dovrebbero corrispondere");
	}

	@Test
	public void testRimozioneItem() {
		carrello.aggiungiProdotto(prd1, 1, utenti);
		carrello.rimozioneTramiteId(0,1, utenti);
		assertFalse(carrello.getCarrello().contains(prd1), "Il carrello non dovrebbe contenere il prodotto 1");
	}

}