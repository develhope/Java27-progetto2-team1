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


	protected Prodotto(AbstractBuilder<?> abstractBuilder) {
		this.marca = abstractBuilder.getMarca();
		this.modello = abstractBuilder.getModello();
		this.descrizione = abstractBuilder.getDescrizione();
		this.prezzoAcquisto = abstractBuilder.getPrezzoAcquisto();
		this.prezzoVendita = abstractBuilder.getPrezzoVendita();
		this.id = abstractBuilder.getId();
		this.quantitaMagazzino = abstractBuilder.getQuantitaMagazzino();
		this.numVendite = abstractBuilder.getNumVendite();
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

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public void setPrezzoVendita(double prezzoVendita) {
		this.prezzoVendita = prezzoVendita;
	}

	public void setPrezzoAcquisto(double prezzoAcquisto) {
		this.prezzoAcquisto = prezzoAcquisto;
	}

	public void setNumVendite(int numVendite ) {
		this.numVendite = numVendite;
	}

	public abstract double calcolaSpesaMedia();

	public void setQuantitaMagazzino( int quantitaMagazzino ) {
		this.quantitaMagazzino = quantitaMagazzino;
	}

	public static abstract class AbstractBuilder<T extends AbstractBuilder<T> >{
		protected String marca;
		protected String modello;
		protected String descrizione;
		protected double prezzoAcquisto;
		protected double prezzoVendita;
		protected int id;
		protected int quantitaMagazzino;
		protected int numVendite;

		protected abstract T self();

		public AbstractBuilder(String marca, String modello, double prezzoAcquisto, int id){
			this.marca = marca;
			this.modello = modello;
			this.prezzoAcquisto = prezzoAcquisto;
			this.id = id;
		}

		public T setMarca(String marca) {
			this.marca = marca;
			return self();
		}

		public T setModello(String modello) {
			this.modello = modello;
			return self();
		}

		public T setDescrizione(String descrizione) {
			this.descrizione = descrizione;
			return self();
		}

		public T setPrezzoAcquisto(double prezzoAcquisto) {
			this.prezzoAcquisto = prezzoAcquisto;
			return self();
		}

		public T setPrezzoVendita(double prezzoVendita) {
			this.prezzoVendita = prezzoVendita;
			return self();
		}

		public T setId(int id) {
			this.id = id;
			return self();
		}

		public T setQuantitaMagazzino(int quantitaMagazzino) {
			this.quantitaMagazzino = quantitaMagazzino;
			return self();
		}

		public T setNumVendite(int numVendite) {
			this.numVendite = numVendite;
			return self();
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

		public int getNumVendite() {
			return numVendite;
		}

		public abstract Prodotto build();

	}
}

