package Users;

import Enums.Roles;
import Management.Carrello;
import Products.ProdottoElettronicoUtente;

import java.util.List;
import java.util.Set;

public class Cliente extends Utente {

    public Cliente(){}

    public Cliente(String nome, String cognome, int age, String email, String password) {
        super(nome, cognome, age, email, password);
        role = Roles.CLIENTE;
    }

    public void aggiungiProdottoAlCarrello( ProdottoElettronicoUtente prodotto, int quantita, List<Utente> utenti ){
        carrelloCliente.aggiungiProdotto(prodotto, quantita, utenti);
    }

    public ProdottoElettronicoUtente ricercaTramiteId(int id){
        return carrelloCliente.ricercaPerId(id);
    }

    public Set<ProdottoElettronicoUtente> ricercaProdottoPerMarca(String marca){
        return carrelloCliente.ricercaPerMarca(marca);
    }

    public Set<ProdottoElettronicoUtente> ricercaProdottoPerModello(String modello){
        return carrelloCliente.ricercaPerModello(modello);
    }

    public Set<ProdottoElettronicoUtente> ricercaProdottoPerPrezzoDiVendita(double prezzo){
        return carrelloCliente.ricercaPerPrezzoVendita(prezzo);
    }

    public Set<ProdottoElettronicoUtente> ricercaProdottoPerRange(double prezzoMin, double prezzoMax){
        return carrelloCliente.ricercaPerRange(prezzoMin, prezzoMax);
    }

    public Set<ProdottoElettronicoUtente> ricercaProdottoPerTIpo(String tipo){
        return carrelloCliente.ricercaPerTipo(tipo);
    }

    public void stampaCarrelloProdotti(){
        carrelloCliente.stampaCarrello();
    }

    public void rimuoviProdottoTramiteId(int id, int quantita, List< Utente > utenti){
        carrelloCliente.rimozioneTramiteId(id, quantita, utenti);
    }

    public double calcoloTotaleCarrello(){
        return  carrelloCliente.calcoloTot();
    }

    public void svuotaCarrelloProdotti(List< Utente > utenti){
        carrelloCliente.svuotaCarrello(utenti);
    }

    public void concludiAcquistoProdotti(List< Utente > utenti){
        carrelloCliente.concludiAcquisto(utenti);
    }

}

