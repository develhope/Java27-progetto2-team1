package Management;

import Enums.TipoElettronico;
import Products.Prodotto;
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
	ProdottoElettronicoUtente prd1;
	ProdottoElettronicoUtente prd2;
	Utente usr1 = new Cliente();
	List<Utente> utenti;

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

}