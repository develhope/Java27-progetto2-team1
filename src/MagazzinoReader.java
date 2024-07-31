import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Set;

public class MagazzinoReader {

    public static Set<ProdottoElettronico> leggiMagazzinoDaFile() throws FileNotFoundException {
        FileReader lettore = new FileReader("src/Magazzino.json");
        Gson gson = new Gson();
        Type tipoListaMagazzino = new TypeToken <Set<ProdottoElettronico>>() {}.getType();
        return gson.fromJson(lettore, tipoListaMagazzino);
    }

    public static void aggiungiProdottoAlMagazzino(ProdottoElettronico prodottoElettronico) throws IOException{
        Set<ProdottoElettronico> magazzino = leggiMagazzinoDaFile();
        magazzino.add(prodottoElettronico);
        aggiornaMagazzino(magazzino);
    }

    public static void aggiornaMagazzino(Set<ProdottoElettronico> listaProdotti) throws IOException{
        FileWriter fileWriter = new FileWriter("src/Magazzino.json");
        Gson gson = new Gson();
        gson.toJson(listaProdotti, fileWriter);
    }

    public static void rimuoviProdottoMagazzino(ProdottoElettronico prodottoElettronico) throws IOException {
        Set<ProdottoElettronico> magazzino = leggiMagazzinoDaFile();
        magazzino.remove(prodottoElettronico);
        aggiornaMagazzino(magazzino);
    }
}
