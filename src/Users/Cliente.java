package Users;

import Enums.Roles;
import Exceptions.CarrelloVuotoException;
import Exceptions.ProdottoNonTrovatoException;
import Management.Carrello;
import Products.ProdottoElettronicoUtente;

import java.io.IOException;
import java.util.Set;

public class Cliente extends Utente {

    private final Carrello carrelloCliente = new Carrello();

    public Cliente(){};

    public Cliente(String nome, String cognome, int age, String email, String password) {
        super(nome, cognome, age, email, password);
        role = Roles.CLIENTE;
    }

    public boolean login(String emailCliente, String passwordCliente){
	    return emailCliente.equals(getEmail()) && passwordCliente.equals(getPassword());
    }

    public void aggiungiProdottoAlCarrello( ProdottoElettronicoUtente prodotto, int quantita) throws ProdottoNonTrovatoException, IOException {
        carrelloCliente.aggiungiProdotto(prodotto, quantita);
    }

    public ProdottoElettronicoUtente ricercaTramiteId(int id) throws ProdottoNonTrovatoException{
        return carrelloCliente.ricercaPerId(id);
    }

    public Set<ProdottoElettronicoUtente> ricercaProdottoPerMarca(String marca) throws ProdottoNonTrovatoException {
        return carrelloCliente.ricercaPerMarca(marca);
    }

    public Set<ProdottoElettronicoUtente> ricercaProdottoPerModello(String modello) throws ProdottoNonTrovatoException {
        return carrelloCliente.ricercaPerModello(modello);
    }

    public Set<ProdottoElettronicoUtente> ricercaProdottoPerPrezzoDiVendita(double prezzo) throws ProdottoNonTrovatoException {
        return carrelloCliente.ricercaPerPrezzoVendita(prezzo);
    }

    public Set<ProdottoElettronicoUtente> ricercaProdottoPerRange(double prezzoMin, double prezzoMax) throws ProdottoNonTrovatoException {
        return carrelloCliente.ricercaPerRange(prezzoMin, prezzoMax);
    }

    public Set<ProdottoElettronicoUtente> ricercaProdottoPerTIpo(String tipo) throws ProdottoNonTrovatoException {
        return carrelloCliente.ricercaPerTipo(tipo);
    }

    public void stampaCarrelloProdotti(){
        carrelloCliente.stampaCarrello();
    }

    public void rimuoviProdottoTramiteId(int id, int quantita) throws ProdottoNonTrovatoException, IOException {
	    carrelloCliente.rimozioneTramiteId(id, quantita);
    }

    public double calcoloTotaleCarrello() throws CarrelloVuotoException {
        return carrelloCliente.calcoloTot();
    }

    public void svuotaCarrelloProdotti() throws IOException {
        carrelloCliente.svuotaCarrello();
    }

    public void concludiAcquistoProdotti() throws CarrelloVuotoException, IOException {
        carrelloCliente.concludiAcquisto();
    }

    public Carrello getCarrelloCliente() {
        return carrelloCliente;
    }


}

