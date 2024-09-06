package Utility;

import Exceptions.ExceptionHandler;
import Products.ProdottoElettronicoUtente;
import Users.Cliente;
import Users.Utente;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UserReader {

	public static List < Utente > leggiUtentiDaFile(){
		return ExceptionHandler.handlexception(()-> {
			try (FileReader lettore = new FileReader("src/Users/Users.json")) {
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				Type tipoListaUtenti = new TypeToken < List < Utente > >() {}.getType();
				return gson.fromJson(lettore, tipoListaUtenti);
			}
		});
	}

	public static void aggiungiClienteAlFile( Cliente cliente ) {
		// Scrivi la lista aggiornata nel file
		ExceptionHandler.handlexception(()-> {
			List < Utente > utenti = UserReader.leggiUtentiDaFile();

			if (utenti == null) {
				utenti = new ArrayList <>();
			}

			utenti.add(cliente);
			try (FileWriter writer = new FileWriter("src/Users/Users.json")) {
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				gson.toJson(utenti, writer);
				System.out.println("Nuovo utente aggiunto con successo!");
				writer.flush();
				writer.close();
				return null;
			}
		});
	}

	public static void aggiornaCarrello( List < Utente > utenti){
		ExceptionHandler.handlexception(()-> {
			try (FileWriter fileWriter = new FileWriter("src/Users/Users.json")) {
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				gson.toJson(utenti, fileWriter);
				fileWriter.flush();
				fileWriter.close();
				return null;
			}
		});
	}
}
