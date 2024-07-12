import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Carrello {

	HashSet<ProdottoElettronico> carrello;

	public Carrello(){
		carrello = new HashSet <>();
	}

	public void aggiungiProdotto (ProdottoElettronico prodotto){
		Set <ProdottoElettronico> prodottoDaAggiungere = magazzino.getMagazzino().stream()
				.filter(p -> p.equals(prodotto) && p.getQuantita() > 0)
				.collect(Collectors.toSet());
		if(!prodottoDaAggiungere.isEmpty()){
			carrello.addAll(prodottoDaAggiungere);
			System.out.println("Aggiunto il prodotto " + prodotto + " al carrello");
			prodotto.setQuantita(prodotto.getQuantita() - 1) ;
		}else{
			System.err.println("Prodotto non presente in magazzino");
		}
	}

	public Set <ProdottoElettronico> ricercaPerMarca ( String marca){
		return carrello.stream()
				.filter(p -> p.getMarca().equals( marca))
				.collect(Collectors.toSet());
	}

	public Set<ProdottoElettronico> ricercaPerModello (String modello){
		return carrello.stream()
				.filter(p -> Objects.equals(p.getModello(), modello))
				.collect(Collectors.toSet());
	}

	public Set<ProdottoElettronico> ricercaPerPrezzoVendita (double prezzo){
		return carrello.stream()
				.filter(p -> p.getPrezzoVendita() == prezzo)
				.collect(Collectors.toSet());
	}

	public Set<ProdottoElettronico> ricercaPerPrezzoAcquisto (double prezzo){
		return carrello.stream()
				.filter(p -> p.getPrezzoAcquisto() == prezzo)
				.collect(Collectors.toSet());
	}

	public Set<ProdottoElettronico> ricercaPerRange (double prezzoMin, double prezzoMax){
		return carrello.stream()
				.filter(p -> p.getPrezzoAcquisto() > prezzoMin && p.getPrezzoAcquisto() < prezzoMax )
				.collect(Collectors.toSet());
	}

	public Set<ProdottoElettronico> ricercaPerTipo (String tipo){
		return carrello.stream()
				.filter(p -> p.getTipoElettronico().name().equals(tipo))
				.collect(Collectors.toSet());
	}

	public void stampaCarrello (){
		System.out.println("Articoli nel carrello: " + carrello);
	}

	public void aggiuntaTramiteId(int id){
		for(ProdottoElettronico element : magazzino.getMagazzino()) {
			if(element.getId() == id && element.getQuantita() > 0){
				carrello.add(element);
				System.out.println("Aggiunto l'elemento " + element + " al carrello");
				element.setQuantita(element.getQuantita()-1);
			}else{
				System.err.println("Impossibile aggiungere il prodotto :(");
			}
		}
	}

	public void rimozioneTramiteId(int id){
		for(ProdottoElettronico element : carrello){
			if(element.getId() == id){
				carrello.remove(element);
				element.setQuantita(element.getQuantita()+1);
				System.out.println("Rimosso il dispositivo " + element);
			}else{
				System.err.println("Il prodotto non è presente nel carrello");
			}
		}
	}

	public double calcoloTot() throws CarrelloVuotoException {
		double prezzoTot = 0.0;

		if ( carrello.isEmpty()) throw new CarrelloVuotoException("Non ci sono articoli nel carrello");

		for(ProdottoElettronico dispositivo : carrello){
			prezzoTot += dispositivo.getPrezzoVendita();
		}
		return prezzoTot;
	}


	public void svuotaCarrello(){
		carrello.clear();
	}


	public void concludiAcquisto() throws CarrelloVuotoException {
		if(carrello.isEmpty()) throw new CarrelloVuotoException("Non ci sono articoli nel carrello");
		System.out.println("Si è sicuro di voler concludere l'acquisto?");
		stampaCarrello();
		System.out.println(calcoloTot());
		System.out.println("Inserire si per continuare o no per annullare");
		Scanner sc = new Scanner(System.in);
		String conferma = sc.nextLine();
		sc.close();
		if(conferma.equalsIgnoreCase("si")){
			System.out.println("Acquisto effettuato, torna a trovarci!");
			svuotaCarrello();
		}else if(conferma.equalsIgnoreCase("no")){
			System.out.println("Acquisto annullato");
		}else System.err.println("Comando non riconosciuto");
	}

}
