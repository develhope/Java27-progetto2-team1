import Management.Magazzino;
import Products.ProdottoElettronico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class MagazzinoTest {
    private Magazzino magazzino;
    private ProdottoElettronico prodotto1;
    private ProdottoElettronico prodotto2;

   @BeforeEach
    public void setup() {
        magazzino = new Magazzino();
        prodotto1 = new ProdottoElettronico.ProdottoElettronicoBuilder("Samsung", "Galaxy", 500.00, 1, "Smartphone", 5.6f).build();
        prodotto2 = new ProdottoElettronico.ProdottoElettronicoBuilder("Apple", "MacBook Air", 900.00, 2, "Notebook", 13f).build();
        magazzino.addProductToMagazzino(prodotto1);
    }
    @Test
    public void testAggiungiProdottoAlMagazzino() {
        magazzino.addProductToMagazzino(prodotto2);
        assertEquals(2, magazzino.getMagazzino().size(), "Il numero dei prodotti nel magazzino dovrebbe essere due");
    }

    @Test
    public void testRimuoviProdottoDaMagazzino() {
        magazzino.addProductToMagazzino(prodotto2);
        magazzino.removeProductFromMagazzino(1);
        assertEquals(1, magazzino.getMagazzino().size(), "Il numero dei prodotti nel magazzino dovrebbe essere uno");
    }

    @Test
    public void testFiltraPerTipo() {
        Set<ProdottoElettronico> filtred = magazzino.filtredBytype("Smartphone");
        assertTrue(filtred.contains(prodotto1), "Il magazzino dovrebbe contenere il prodotto uno");
    }

    @Test
    public void testFiltraPerModello() {
        Set<ProdottoElettronico> filtrato = magazzino.filtredByModel("MacBook");
        assertFalse(filtrato.contains(prodotto1), "Il magazzino non dovrebbe contenere il prodotto uno");
    }


    @Test
    public void testMagazzinoNotNull(){
       assertNotNull(magazzino.getMagazzino(), "Il magazzino non dovrebbe essere null");
    }

    @Test
    public void testCorrispondenzaContenuti(){
       magazzino.addProductToMagazzino(prodotto2);
       ProdottoElettronico [] expectedItems = {prodotto1, prodotto2};
       assertArrayEquals(expectedItems, magazzino.getMagazzino().toArray(), "Il magazzino dovrebbe contenere il prodotto uno e il due");
    }

}

