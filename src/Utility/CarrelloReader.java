package Utility;
import Exceptions.ExceptionHandler;
import Products.ProdottoElettronicoUtente;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;

public class CarrelloReader {

    public static HashSet<ProdottoElettronicoUtente> leggiCarrelloDaFile(){
        return ExceptionHandler.handlexception(() -> {
            FileReader lettore = new FileReader("src/Management/Carrello.json");
            Gson gson = new Gson();
            Type tipoListaCarrello = new TypeToken<HashSet<ProdottoElettronicoUtente>>() {}.getType();
            return gson.fromJson(lettore, tipoListaCarrello);
        });
    }

    public static void aggiungiProdottoAlCarrello(ProdottoElettronicoUtente prodottoElettronico){
        ExceptionHandler.handlexception(()-> {
            HashSet<ProdottoElettronicoUtente> carrello = leggiCarrelloDaFile();
            carrello.add(prodottoElettronico);
            aggiornaCarrello(carrello);
            return null;
        });
    }
    public static void aggiornaCarrello(HashSet<ProdottoElettronicoUtente> listaProdotti){
        ExceptionHandler.handlexception(()-> {
            FileWriter fileWriter = new FileWriter("src/Management/Carrello.json");
            Gson gson = new Gson();
            gson.toJson(listaProdotti, fileWriter);
            fileWriter.flush();
            fileWriter.close();
            return null;
        });
    }

    public static void rimuoviProdottoCarrello(ProdottoElettronicoUtente prodottoElettronico){
        ExceptionHandler.handlexception(()-> {
            HashSet<ProdottoElettronicoUtente> carrello = leggiCarrelloDaFile();
            carrello.remove(prodottoElettronico);
            aggiornaCarrello(carrello);
            return null;
        });
    }
}

