package Products;

import Enums.TipoElettronico;

public class ProdottoElettronicoUtente{

    private String marca;
    private String modello;
    private String descrizione;
    private double prezzoVendita;
    private int id;
    private TipoElettronico tipoElettronico;
    private float dimSchermo;
    private int quantitaCarrello;

    public ProdottoElettronicoUtente( String marca, String modello, String descrizione, double prezzoVendita, int id, TipoElettronico tipoElettronico, float dimSchermo ) {
        this.marca = marca;
        this.modello = modello;
        this.descrizione = descrizione;
        this.prezzoVendita = prezzoVendita;
        this.id = id;
        this.tipoElettronico = tipoElettronico;
        this.dimSchermo = dimSchermo;
        quantitaCarrello = 1;
    }

    public ProdottoElettronicoUtente() {

    }

    public TipoElettronico getTipoElettronico() {
        return tipoElettronico;
    }

    public void setTipoElettronico( TipoElettronico tipoElettronico) {
        this.tipoElettronico = tipoElettronico;
    }

    public void setDimSchermo(float dimSchermo) {
        this.dimSchermo = dimSchermo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca( String marca ) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello( String modello ) {
        this.modello = modello;
    }

    public float getDimSchermo() { return dimSchermo; }

    public void setDescrizione(String descrizione ) {
        this.descrizione = descrizione;
    }

    public double getPrezzoVendita() {
        return prezzoVendita;
    }

    public void setPrezzoVendita( double prezzoVendita ) {
        this.prezzoVendita = prezzoVendita;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public int getQuantitaCarrello() {
        return quantitaCarrello;
    }

    public void setQuantitaCarrello( int quantitaCarrello ) {
        this.quantitaCarrello = quantitaCarrello;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        string.append('\n');
        string.append(" Marca: ").append(marca).append('\n');
        string.append(" Modello: ").append(modello).append('\n');
        string.append(" Tipo dispositivo: ").append(tipoElettronico).append('\n');
        string.append(" Dimensione Schermo: ").append(dimSchermo).append('\n');
        if(descrizione != null) string.append(" Descrizione: ").append(descrizione).append('\n');
        string.append(" Prezzo: ").append(prezzoVendita).append('\n');
        string.append(" Quantità: ").append(quantitaCarrello).append('\n');
        string.append('\n');

        return string.toString();
    }

    public String getDescrizione() {
        return descrizione;
    }
}
