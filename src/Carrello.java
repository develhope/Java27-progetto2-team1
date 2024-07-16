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

	public int aggiungiProdotto (ProdottoElettronico prodotto){
		carrello.add(prodotto);
		return carrello.size();
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
	public boolean rimozioneTramiteId(int id) throws ProdottoNonTrovatoException{
		 boolean removed = carrello.removeIf( p->p.getId() == id);
		 if(removed){
			 return removed;
		 } else {
			 throw new ProdottoNonTrovatoException("Impossibile rimuovere: il prodotto non è presente nel carrello");
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

	public Set < ProdottoElettronico > getCarrello() {
		return carrello;
	}
}
