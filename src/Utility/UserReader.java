package Utility;

import Exceptions.ExceptionHandler;
import Users.Cliente;
import Users.Utente;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class UserReader {

	public static List < Utente > leggiUtentiDaFile(){
		return ExceptionHandler.handlexception(()-> {
			FileReader lettore = new FileReader("src/Users/Users.json");
			Gson gson = new Gson();
			Type tipoListaUtenti = new TypeToken <List < Utente >>() {}.getType();
			return gson.fromJson(lettore, tipoListaUtenti);
		});
	}

	public static void aggiungiClienteAlFile( Cliente cliente) {
		// Scrivi la lista aggiornata nel file
		ExceptionHandler.handlexception(()-> {
			List < Utente > utenti = UserReader.leggiUtentiDaFile();

			if (utenti == null) {
				utenti = new ArrayList <>();
			}

			utenti.add(cliente);
			FileWriter writer = new FileWriter("src/Users/Users.json");
			Gson gson = new Gson();
			gson.toJson(utenti, writer);
			System.out.println("Nuovo utente aggiunto con successo!");
			writer.flush();
			writer.close();
			return null;
		});
	}
}
