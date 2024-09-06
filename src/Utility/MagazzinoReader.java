package Utility;

import Exceptions.ExceptionHandler;
import Products.ProdottoElettronico;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

public class MagazzinoReader {

    public static Set<ProdottoElettronico> leggiMagazzinoDaFile(){
        return ExceptionHandler.handlexception(()-> {
            FileReader lettore = new FileReader("src/Magazzino.json");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Type tipoListaMagazzino = new TypeToken <Set<ProdottoElettronico>>() {}.getType();
            Set<ProdottoElettronico> magazzino = gson.fromJson(lettore, tipoListaMagazzino);
            if(magazzino == null) magazzino = new HashSet<>();
            return magazzino;
        });
    }

    public static void aggiungiProdottoAlMagazzino(ProdottoElettronico prodottoElettronico){
        Set<ProdottoElettronico> magazzino = leggiMagazzinoDaFile();
        if(magazzino == null){
            magazzino = new HashSet<>();
        }
        magazzino.add(prodottoElettronico);
        aggiornaMagazzino(magazzino);
    }

    public static void aggiornaMagazzino(Set<ProdottoElettronico> listaProdotti){
        ExceptionHandler.handlexception(()-> {
            FileWriter fileWriter = new FileWriter("src/Magazzino.json");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(listaProdotti, fileWriter);
            fileWriter.flush();
            fileWriter.close();
            return null;
        });

    }

    public static void rimuoviProdottoMagazzino(ProdottoElettronico prodottoElettronico){
        Set<ProdottoElettronico> magazzino = leggiMagazzinoDaFile();
        magazzino.remove(prodottoElettronico);
        aggiornaMagazzino(magazzino);
    }
}
