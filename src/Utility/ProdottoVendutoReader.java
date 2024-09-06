package Utility;
import Products.ProdottoElettronicoUtente;
import Products.ProdottoVenduto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.HashSet;

public class ProdottoVendutoReader {

    public static List<ProdottoVenduto> leggiProdottiVenduti() throws FileNotFoundException {
        FileReader lettore = new FileReader("src/Products/ProdottiVenduti.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type tipoListaProdotto = new TypeToken<List<ProdottoVenduto>>() {
        }.getType();
        return gson.fromJson(lettore, tipoListaProdotto);
    }

    public static List<ProdottoVenduto> aggiornaListaProdottoVenduto(HashSet<ProdottoElettronicoUtente> carrello) throws IOException {
        List<ProdottoVenduto> prodottiVenduti = leggiProdottiVenduti();
        carrello.forEach(peu ->
                prodottiVenduti.stream()
                        .filter(pv -> pv.getTipoProdotto().equals(peu.getTipoElettronico()))
                        .findFirst()
                        .ifPresent(pv -> {
                            pv.setQuantitaVenduta(pv.getQuantitaVenduta() + peu.getQuantitaCarrello());
                            pv.setSpesaTotale(pv.getSpesaTotale() + (peu.getPrezzoVendita() * peu.getQuantitaCarrello()));
                        })
        );
        return prodottiVenduti;
    }

    public static void aggiungiProdottoVendutoAlFile(List<ProdottoVenduto> prodottiVenduti) throws IOException {
        // Scrivi la lista aggiornata nel file
        FileWriter writer = new FileWriter("src/Products/ProdottiVenduti.json"); {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(prodottiVenduti, writer);
            writer.flush();
            writer.close();
        }
    }

}
