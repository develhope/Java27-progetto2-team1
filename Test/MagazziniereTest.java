import Management.Magazzino;
import Products.ProdottoElettronico;
import Users.Magazziniere;
import Utility.MagazzinoReader;
import org.junit.jupiter.api.AfterEach;
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
        Magazzino magazzino = new Magazzino();
        MagazzinoReader.aggiornaMagazzinoBackUp(magazzino.getMagazzino());
        magazziniere.svuotaMagazzino();
        prodotto1 = new ProdottoElettronico.ProdottoElettronicoBuilder("Samsung", "Galaxy", 500.00, 1, "Smartphone", 5.6f).setPrezzoVendita(900.00).build();
        magazziniere.addProductToMagazzino(prodotto1, 5);
        prodotto2 = new ProdottoElettronico.ProdottoElettronicoBuilder("Apple", "MacBook Air", 900.00, 2, "Notebook", 13f).setPrezzoVendita(1300.00).build();
    }

    @AfterEach
    public void tearDown(){
         MagazzinoReader.aggiornaMagazzino(MagazzinoReader.leggiMagazzinoBackUp());
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
    public void testSvuotaMagazzino(){
        magazziniere.svuotaMagazzino();
        assertEquals(0, magazziniere.getMagazzino().getMagazzino().size(), "Il magazzino dovrebbe essere vuoto");
    }

    @Test
    public void testMagazzinoNotNull() {
        assertNotNull(magazziniere.getMagazzino(), "Il magazzino non dovrebbe essere nullo");
    }

    @Test
    public void testFiltredByProducerArrayEquals() {
        magazziniere.addProductToMagazzino(prodotto2, 5);
        ProdottoElettronico[] prodottiAttesi = {prodotto2};
        assertArrayEquals(prodottiAttesi, magazziniere.getMagazzino().filtredByProducer("Apple").toArray(), "I prodotti filtrati per produttore corrispondono a quelli attesi");
    }






}
