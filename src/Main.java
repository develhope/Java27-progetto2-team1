import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main( String[] args ) {

		Cliente clienteLoggato = new Cliente("Mario", "Rossi", 30, "mariorossi@gmail.com", 0, "mario123");

		ProdottoElettronico prd1 = new ProdottoElettronico("Samsung", "Galaxys24", 700.0, 1300, 0, 10, 6, TipoElettronico.SMARTPHONE);

		Magazzino magazzino1 = new Magazzino();//Inizializza il magazzino

		magazzino1.addProductToMagazzino(prd1);//aggiunge il prodotto al magazzino
		//boolean loggedIn = false;
		Scanner sc = new Scanner(System.in);//Inizializza lo Scanner


		while ( true ) {
			//Controlla che ci sia un cliente loggato

				mostraMenu(clienteLoggato);//Stampa il menu di scelta operazione
				System.out.println("Inserisci la selezione");
				int selezione = sc.nextInt();

				switch ( selezione ) {

					case 0 -> clienteLoggato = null;

					case 1 -> {//Aggiunta tramite id
						try {
							aggiuntaID(sc, clienteLoggato, magazzino1);
						} catch ( ProdottoNonTrovatoException e ) {
							System.err.println(e.getMessage());
						}
					}

					case 2 -> {//Rimozione tramite id
						try {
							rimozioneID(sc, clienteLoggato, magazzino1);
						} catch ( ProdottoNonTrovatoException e ) {
							System.err.println(e.getMessage());
						}
					}

					case 3 -> clienteLoggato.stampaCarrelloProdotti(); //VisualizzaCarrello

					case 4 -> {//CalcoloTotale
						try {
							System.out.println(clienteLoggato.calcoloTotaleCarrello());
						} catch ( CarrelloVuotoException e ) {
							System.err.println(e.getMessage());
						}
					}

					case 5 -> menuRicerca(sc, clienteLoggato);//Ricerche

					case 6 -> clienteLoggato.svuotaCarrelloProdotti();

					case 7 -> {//ConcludiAcquisto
						try {
							clienteLoggato.concludiAcquistoProdotti(sc);
						} catch ( CarrelloVuotoException e ) {
							System.err.println(e.getMessage());
						}
					}

					default -> System.err.println("Comando non riconosciuto");
				}
			}
		}

	private static void mostraMenu ( Cliente cliente ) {
		System.out.println("\n--- Menu Magazzino ---");
		System.out.println();
		System.out.println("1. Aggiungi prodotto al carrello");
		System.out.println("2. Rimuovi prodotto dal carrello");
		System.out.println("3. Visualizza prodotti nel carrello");
		System.out.println("4. Visualizza totale del carrello");
		System.out.println("5. Ricerca");
		System.out.println("6. Svuota il carrello");
		System.out.println("7. Concludi l'acquisto");
		System.out.println("0. LogOut");
		System.out.println();
		System.out.println("Utente loggato: " + cliente.getNome() + " " + cliente.getCognome());
	}

	public static void menuRicerca(Scanner sc, Cliente cliente){

		System.out.println("\n--- Menu Ricerca ---");
		System.out.println();
		System.out.println("1. Ricerca per marca");
		System.out.println("2. Ricerca per modello");
		System.out.println("3. Ricerca per prezzo");
		System.out.println("4. Ricerca per range di prezzo");
		System.out.println("5. Ricerca per tipo");
		System.out.println("6. Ricerca tramite id");
		System.out.println("0. Torna indietro");
		System.out.println();
		sceltaRicerca(sc, cliente);
	}

	public static void sceltaRicerca(Scanner sc, Cliente cliente){

		System.out.println("Selezione il tipo di ricerca da effetuare");
		int ricercaSel = sc.nextInt(); //Legge la ricerca da effettuare

		switch (  ricercaSel ){
			case 1 ->
			{  try {//Ricerca per marca
				Set < ProdottoElettronicoUtente > found = ricercaMarca(cliente,sc);
				System.out.println("Dispositivi trovati: " + found);
			} catch (ProdottoNonTrovatoException e){
				System.err.println(e.getMessage());
			}

			}

			case 2 ->
			{	try {//Ricerca per modello
				Set < ProdottoElettronicoUtente > found = ricercaModello(cliente,sc);
				System.out.println("Dispositivi trovati: " + found);
			} catch (ProdottoNonTrovatoException e){
				System.err.println(e.getMessage());
			}
			}
			case 3 ->
			{	try{//Ricerca per prezzo di vendita
				Set< ProdottoElettronicoUtente > found = ricercaPrezzo(cliente, sc);
				System.out.println("Dispositivi trovati: " + found);
			} catch (ProdottoNonTrovatoException e){
				System.err.println(e.getMessage());
			}
			}

			case 4 ->
			{ 	try{//Ricerca per range di prezzo
				Set< ProdottoElettronicoUtente > found = ricercaRangePrezzo(cliente, sc);
				System.out.println("Dispositivi trovati: " + found);
			} catch (ProdottoNonTrovatoException e){
				System.err.println(e.getMessage());
			}}

			case 5 ->
			{	try {//Ricerca per tipo elettronico
				Set< ProdottoElettronicoUtente > found = ricercaTipo(cliente, sc);
				System.out.println("Dispositivi trovati: " + found);
			} catch (ProdottoNonTrovatoException e){
				System.err.println(e.getMessage());
			}
			}

			case 6 ->
			{	try{//Ricerca tramite ID
				ProdottoElettronicoUtente found = ricercaId(cliente, sc);
				System.out.println("Dispositivi trovati: " + found);
			} catch (ProdottoNonTrovatoException e){
				System.err.println(e.getMessage());
			}
			}

			case 0 -> {}//Torna al menu precedente

			default -> System.err.println("Comando non riconosciuto");
		}
		sc.nextLine();
	}
	//aggiunge prodotti al carrello e ne rimuove la quantità dal magazzino
	public static void aggiuntaID(Scanner sc, Cliente cliente, Magazzino magazzino) throws ProdottoNonTrovatoException {

		System.out.println("Inserisci l'id del prodotto da aggiungere");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Inserisci la quantità di prodotti che desideri aggiungere al carrello");
		int quantita = sc.nextInt();

		ProdottoElettronico toAdd = magazzino.filteredById(id);  //trova il prodotto elettronico da aggiungere in base all'id

		int quantitaProdotto = toAdd.getQuantitaMagazzino();

		if(quantitaProdotto == 0 || quantita>quantitaProdotto) throw new ProdottoNonTrovatoException("Non ci sono sufficienti quantità in magazzino"); //Nel caso non ci siano abbastanza prodotti in magazzino, lancia eccezione

		ProdottoElettronicoUtente prodottoTmp = toAdd.toProdottoUtente(); //tasforma l'oggetto da prodotto a prodotto utente

		cliente.aggiungiProdottoAlCarrello(prodottoTmp, quantita);
		prodottoTmp.setQuantitaCarrello(quantita);
		System.out.println("Prodotto aggiunto con successo");

		magazzino.decrementaQuantita(id, quantita); //Rimuovi dal magazzino i prodotti aggiunti al carrello

	}

	//rimuove il prodotto dal carrello e lo riaggiunge al magazzino
	public static void rimozioneID(Scanner sc, Cliente cliente, Magazzino magazzino) throws ProdottoNonTrovatoException {

		System.out.println("Inserisci l'id del prodotto da rimuovere");

		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Inserire la quantità di prodotti da rimuovere");

		int quantita = sc.nextInt();
		sc.nextLine();

		cliente.rimuoviProdottoTramiteId(id, quantita);
		magazzino.incrementaQuantita(id, quantita);

		System.out.println("Prodotto rimosso con successo");

	}

	public static Set< ProdottoElettronicoUtente > ricercaMarca( Cliente cliente, Scanner sc) throws ProdottoNonTrovatoException {
		System.out.println("Inserisci la marca");
		String marca = sc.nextLine();
		return cliente.ricercaProdottoPerMarca(marca);
	}

	public static Set< ProdottoElettronicoUtente > ricercaModello( Cliente cliente, Scanner sc) throws ProdottoNonTrovatoException {
		System.out.println("Inserisci il modello");
		String modello = sc.nextLine();
		return cliente.ricercaProdottoPerModello(modello);
	}

	public static Set< ProdottoElettronicoUtente > ricercaPrezzo( Cliente cliente, Scanner sc) throws ProdottoNonTrovatoException{
		System.out.println("Inserisci il prezzo:");
		double prezzo = sc.nextDouble();
		return cliente.ricercaProdottoPerPrezzoDiVendita(prezzo);
	}

	public static Set< ProdottoElettronicoUtente > ricercaRangePrezzo( Cliente cliente, Scanner sc) throws ProdottoNonTrovatoException {
		System.out.println("Inserisci il prezzo minore e poi il prezzo maggiore");
		double prezzoMin = sc.nextDouble();
		double prezzoMag = sc.nextDouble();
		return cliente.ricercaProdottoPerRange(prezzoMin, prezzoMag);
	}
	public static Set< ProdottoElettronicoUtente > ricercaTipo( Cliente cliente, Scanner sc) throws ProdottoNonTrovatoException {
		System.out.println("Inserisci il tipo di dispositivo da cercare");
		String tipo = sc.nextLine();
		return cliente.ricercaProdottoPerTIpo(tipo);
	}
	public static ProdottoElettronicoUtente ricercaId( Cliente cliente, Scanner sc) throws ProdottoNonTrovatoException {
		System.out.println("Inserisci l'id da ricercare: ");
		int id = sc.nextInt();
		return cliente.ricercaTramiteId(id);
	}

}