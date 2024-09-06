package Utility;

import Management.Carrello;
import Users.Cliente;
import Users.Magazziniere;
import Users.Utente;

import java.util.HashSet;

public class UserMapper {
	public static Cliente toUtente( Utente utente){
		Cliente cliente = new Cliente();
		cliente.setIdUtente(utente.getIdUtente());
		cliente.setAge(utente.getAge());
		cliente.setNome(utente.getNome());
		cliente.setCognome(utente.getCognome());
		cliente.setEmail(utente.getEmail());
		cliente.setPassword(utente.getPassword());
		cliente.setCarrelloCliente(utente.getCarrelloCliente());
		if(cliente.getCarrelloCliente() == null) cliente.setCarrelloCliente(new Carrello());
		return cliente;
	}

	public static Magazziniere toMagazziniere( Utente utente){
		Magazziniere magazziniere = new Magazziniere();
		magazziniere.setIdUtente(utente.getIdUtente());
		magazziniere.setAge(utente.getAge());
		magazziniere.setNome(utente.getNome());
		magazziniere.setCognome(utente.getCognome());
		magazziniere.setEmail(utente.getEmail());
		magazziniere.setPassword(utente.getPassword());

		return magazziniere;
	}

}
