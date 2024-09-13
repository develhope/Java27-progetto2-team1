import Management.Magazzino;
import Products.ProdottoElettronico;
import Users.Magazziniere;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class MagazziniereTest {
    private ProdottoElettronico prodotto1;
    private ProdottoElettronico prodotto2;
    private Magazziniere magazziniere;



    @BeforeEach
    public void setup() {
        magazziniere = new Magazziniere("Mario", "Rossi", 30, "mario.rossi@gmail.com", "1234");
        magazziniere.getMagazzino().getMagazzino().clear();
        prodotto1 = new ProdottoElettronico.ProdottoElettronicoBuilder("Samsung", "Galaxy", 500.00, 1, "Smartphone", 5.6f).setPrezzoVendita(900.00).build();
        prodotto2 = new ProdottoElettronico.ProdottoElettronicoBuilder("Apple", "MacBook Air", 900.00, 2, "Notebook", 13f).setPrezzoVendita(1300.00).build();
        magazziniere.addProductToMagazzino(prodotto1, 5);
    }

    @Test
    public void testAggiungiProdottoAlMagazzino() {
        magazziniere.addProductToMagazzino(prodotto1, 5);
        assertTrue(magazziniere.getMagazzino().getMagazzino().contains(prodotto1), "Il prodotto 1 dovrebbe essere presente nel magazzino");
    }

    @Test
    public void testFilteredById() {
        ProdottoElettronico prodottoFiltrato = magazziniere.filteredById(prodotto1.getId());
        assertEquals(prodotto1, prodottoFiltrato, "Il prodotto filtrato per ID corrisponde al prodotto 1 inserito");
    }

    @Test
    public void testMagazzinoNotNull() {
        // Verifica che il magazzino non sia nullo dopo la creazione del Magazziniere
        assertNotNull(magazziniere.getMagazzino(), "Il magazzino non dovrebbe essere nullo");
    }







}
