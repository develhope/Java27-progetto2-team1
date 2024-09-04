package Management;
import Exceptions.CarrelloVuotoException;
import Exceptions.ExceptionHandler;
import Exceptions.ProdottoNonTrovatoException;
import Products.ProdottoElettronicoUtente;
import Products.ProdottoVenduto;
import Utility.CarrelloReader;
import Utility.ProdottoVendutoReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class Carrello {

	HashSet< ProdottoElettronicoUtente > carrello;

	public Carrello(){
		carrello = new HashSet <>();
	}


	public void aggiungiProdotto ( ProdottoElettronicoUtente prodotto, int quantita) {
		Optional < ProdottoElettronicoUtente > toAdd = carrello.stream()
				.filter(p -> p.getId() == prodotto.getId())
				.findFirst();
		if (toAdd.isPresent()){
			incrementaQuantita(prodotto.getId(), quantita);
			CarrelloReader.aggiornaCarrello(carrello);
		}
		else {
			prodotto.setQuantitaCarrello(quantita);
			CarrelloReader.aggiungiProdottoAlCarrello(prodotto);
			carrello = CarrelloReader.leggiCarrelloDaFile();
		}

	}

	public ProdottoElettronicoUtente ricercaPerId ( int id){
		return  ExceptionHandler.handlexception(()->
			carrello.stream()
					.filter(p -> p.getId() == id)
					.findFirst().orElseThrow(() -> new ProdottoNonTrovatoException("Nessuna corrispondenza"))
		);
	}

	public Set < ProdottoElettronicoUtente > ricercaPerMarca ( String marca){
		Set< ProdottoElettronicoUtente > tmp = carrello.stream()
				.filter(p -> p.getMarca().equalsIgnoreCase( marca))
				.collect(Collectors.toSet());
		ExceptionHandler.handlexception(()-> {
			if(tmp.isEmpty()){
				throw new ProdottoNonTrovatoException("Nessuna corrispondenza per Marca");
			}
			return tmp;
		});
		return tmp;
	}

	public Set< ProdottoElettronicoUtente > ricercaPerModello ( String modello){
		Set< ProdottoElettronicoUtente > tmp = carrello.stream()
				.filter(p -> p.getModello().equalsIgnoreCase(modello)).collect(Collectors.toSet());
		ExceptionHandler.handlexception(()-> {
			if(tmp.isEmpty()){
				throw new ProdottoNonTrovatoException("Nessuna corrispondenza per Modello");
			}
			return tmp;
		});
		return tmp;
	}

	public Set< ProdottoElettronicoUtente > ricercaPerPrezzoVendita ( double prezzo ){
		Set<ProdottoElettronicoUtente> res = carrello.stream()
				.filter(p -> p.getPrezzoVendita() == prezzo)
				.collect(Collectors.toSet());

		ExceptionHandler.handlexception(()-> {
			if(res.isEmpty()) throw new ProdottoNonTrovatoException("Nessuna corrispondenza");
			return res;
		});
		return res;
	}

	public Set< ProdottoElettronicoUtente > ricercaPerRange ( double prezzoMin, double prezzoMax){
		Set< ProdottoElettronicoUtente > tmp = carrello.stream()
				.filter(p -> p.getPrezzoVendita() > prezzoMin && p.getPrezzoVendita() < prezzoMax )
				.collect(Collectors.toSet());
		ExceptionHandler.handlexception(()-> {if(tmp.isEmpty()){
			throw new ProdottoNonTrovatoException("Nessuna corrispondenza trovata per range di prezzo");
		}
			return tmp;
		});
		return tmp;
	}

	public Set< ProdottoElettronicoUtente > ricercaPerTipo ( String tipo){
		Set <ProdottoElettronicoUtente> res = carrello.stream()
				.filter(p -> p.getTipoElettronico().name().equals(tipo))
				.collect(Collectors.toSet());

		 ExceptionHandler.handlexception(()-> {
			if(res.isEmpty()) throw new ProdottoNonTrovatoException("Nessuna corrispondenza");
			return res;
		});
		return res;
	}

	public void stampaCarrello (){
		if(carrello.isEmpty()){
			System.out.println("Non ci sono articoli nel carrello");
		}else {
			System.out.println("Articoli nel carrello: " + carrello);
		}
	}

	public void rimozioneTramiteId(int id, int quantita){
		ProdottoElettronicoUtente prdToRemove = ricercaPerId(id);
		if(prdToRemove == null){
			return;
		}
			decrementaQuantita(id,quantita);
		CarrelloReader.aggiornaCarrello(carrello);
		if(prdToRemove.getQuantitaCarrello() <= 0){
			CarrelloReader.rimuoviProdottoCarrello(prdToRemove);
			carrello = CarrelloReader.leggiCarrelloDaFile();
		}
	}

	public double calcoloTot() {
		return getaDouble() != null ? getaDouble() : 0.0;
	}

	private Double getaDouble() {
		return ExceptionHandler.handlexception(() -> {
			if (carrello.isEmpty()) {
				throw new CarrelloVuotoException("Non ci sono articoli nel carrello");
			}
			return carrello.stream()
					.mapToDouble(dispositivo -> dispositivo.getPrezzoVendita() * dispositivo.getQuantitaCarrello())
					.sum();
		});
	}


	public void svuotaCarrello() {
		carrello.clear();
		CarrelloReader.aggiornaCarrello(carrello);
	}


	public void concludiAcquisto(  ) throws CarrelloVuotoException, IOException {
		if(carrello.isEmpty()) throw new CarrelloVuotoException("Non ci sono articoli nel carrello");
		System.out.println("Si è sicuro di voler concludere l'acquisto?");
		stampaCarrello();
		System.out.println(calcoloTot());
		System.out.println("Inserire si per continuare o no per annullare");
		Scanner sc = new Scanner(System.in);
		String conferma = sc.nextLine();

		if(conferma.equalsIgnoreCase("si")){
			System.out.println("Acquisto effettuato, torna a trovarci!");
			List<ProdottoVenduto> prodottiVenduti = ProdottoVendutoReader.aggiornaListaProdottoVenduto(carrello);
			ProdottoVendutoReader.aggiungiProdottoVendutoAlFile(prodottiVenduti);
			svuotaCarrello();
		}else if(conferma.equalsIgnoreCase("no")){
			System.out.println("Acquisto annullato");
		}else System.err.println("Comando non riconosciuto");
	}

	public Set < ProdottoElettronicoUtente > getCarrello() {
		return carrello;
	}

	public void incrementaQuantita(int id, int amount){
		ProdottoElettronicoUtente prodotto = ricercaPerId(id);
		int nuovaQuantita = prodotto.getQuantitaCarrello() + amount;
		prodotto.setQuantitaCarrello(nuovaQuantita);
		CarrelloReader.aggiornaCarrello(carrello);
	}

	public void decrementaQuantita (int id, int amount){
		ProdottoElettronicoUtente prodotto = ricercaPerId(id);
		int quantita = prodotto.getQuantitaCarrello() - amount;
		prodotto.setQuantitaCarrello(quantita);
		CarrelloReader.aggiornaCarrello(carrello);
	}
}
