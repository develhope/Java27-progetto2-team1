import Management.Magazzino;
import Products.ProdottoElettronico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class MagazzinoTest {
    private Magazzino magazzino;
    private ProdottoElettronico prodotto1;
    private ProdottoElettronico prodotto2;

   @BeforeEach
    public void setup() {
        magazzino = new Magazzino();
        magazzino.getMagazzino().clear();
        prodotto1 = new ProdottoElettronico.ProdottoElettronicoBuilder("Samsung", "Galaxy", 500.00, 1, "Smartphone", 5.6f).build();
        prodotto2 = new ProdottoElettronico.ProdottoElettronicoBuilder("Apple", "MacBook Air", 900.00, 2, "Notebook", 13f).build();
        magazzino.addProductToMagazzino(prodotto1);
    }
    @Test
    public void testAggiungiProdottoAlMagazzino() {
        magazzino.addProductToMagazzino(prodotto2);
        assertEquals(2, magazzino.totaleProdotti());
    }


}

