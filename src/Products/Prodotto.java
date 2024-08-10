package Products;

public abstract class Prodotto {

	protected String marca;
	protected String modello;
	protected String descrizione;
	protected double prezzoAcquisto;
	protected double prezzoVendita;
	protected int id;
	protected int quantitaMagazzino;
	protected int numVendite;


	protected Prodotto(ProdottoBuilder builder) {
		this.marca = builder.marca;
		this.modello = builder.modello;
		this.descrizione = builder.descrizione;
		this.prezzoAcquisto = builder.prezzoAcquisto;
		this.prezzoVendita = builder.prezzoVendita;
		this.id = builder.id;
		this.quantitaMagazzino = builder.quantitaMagazzino;
		this.numVendite = builder.numVendite;
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

	public int getQuantitaMagazzino() {
		return quantitaMagazzino;
	}


	public void setNumVendite( int numVendite ) {
		this.numVendite = numVendite;
	}

	public abstract double calcolaSpesaMedia();

	public void setQuantitaMagazzino( int quantitaMagazzino ) {
		this.quantitaMagazzino = quantitaMagazzino;
	}

}
