public abstract class Prodotto {

	protected String marca;
	protected String modello;
	protected String descrizione;

	protected double prezzoAcquisto;
	protected double prezzoVendita;
	protected int id;
	protected int numVendite;

	public Prodotto( String marca, String modello, double prezzoAcquisto, double prezzoVendita, int id ) {
		this.marca = marca;
		this.modello = modello;
		this.prezzoAcquisto = prezzoAcquisto;
		this.prezzoVendita = prezzoVendita;
		this.id = id;
		numVendite = 0;
	}

	public Prodotto( String marca, String modello, String descrizione, double prezzoAcquisto, double prezzoVendita, int id ) {
		this.marca = marca;
		this.modello = modello;
		this.descrizione = descrizione;
		//this.dimSchermo = dimSchermo;
		this.prezzoAcquisto = prezzoAcquisto;
		this.prezzoVendita = prezzoVendita;
		this.id = id;
		numVendite = 0;
	}

	public String getMarca() {
		return marca;
	}

	public String getModello() {
		return modello;
	}

	public String getDescrizione() {
		return descrizione;
	}


	public double getPrezzoAcquisto() {
		return prezzoAcquisto;
	}

	public double getPrezzoVendita() {
		return prezzoVendita;
	}

	public int getId() {
		return id;
	}

	public void setNumVendite( int numVendite ) {
		this.numVendite = numVendite;
	}

	public abstract double calcolaSpesaMedia();

}
