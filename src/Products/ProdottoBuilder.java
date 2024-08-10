package Products;

public abstract class ProdottoBuilder {
    protected String marca;
    protected String modello;
    protected String descrizione;
    protected double prezzoAcquisto;
    protected double prezzoVendita;
    protected int id;
    protected int quantitaMagazzino;
    protected int numVendite;

    public ProdottoBuilder setMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public ProdottoBuilder setModello(String modello) {
        this.modello = modello;
        return this;
    }

    public ProdottoBuilder setDescrizione(String descrizione) {
        this.descrizione = descrizione;
        return this;
    }

    public ProdottoBuilder setPrezzoAcquisto(double prezzoAcquisto) {
        this.prezzoAcquisto = prezzoAcquisto;
        return this;
    }

    public ProdottoBuilder setPrezzoVendita(double prezzoVendita) {
        this.prezzoVendita = prezzoVendita;
        return this;
    }

    public ProdottoBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public ProdottoBuilder setQuantitaMagazzino(int quantitaMagazzino) {
        this.quantitaMagazzino = quantitaMagazzino;
        return this;
    }

    public ProdottoBuilder setNumVendite(int numVendite) {
        this.numVendite = numVendite;
        return this;
    }


    public abstract Prodotto build();

}

