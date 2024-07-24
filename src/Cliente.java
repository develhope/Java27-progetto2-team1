import java.util.Set;

public class Cliente extends Utente {

    private Carrello carrelloCliente;

    public Cliente(String nome, String cognome, int age, String email, int idUtente, String password) {
        super(nome, cognome, age, email, idUtente, password);
        this.carrelloCliente = new Carrello();

    }

    public boolean login(String emailCliente, String passwordCliente){
        if(emailCliente.equals(getEmail()) && passwordCliente.equals(getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    public void aggiungiProdottoAlCarrello(ProdottoElettronicoUtente prodotto, int quantita) throws ProdottoNonTrovatoException {
        carrelloCliente.aggiungiProdotto(prodotto, quantita);
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

    public void rimuoviProdottoTramiteId(int id, int quantita) throws ProdottoNonTrovatoException {
	    carrelloCliente.rimozioneTramiteId(id, quantita);
    }

    public double calcoloTotaleCarrello() throws CarrelloVuotoException {
        return carrelloCliente.calcoloTot();
    }

    public void svuotaCarrelloProdotti(){
        carrelloCliente.svuotaCarrello();
    }

    public void concludiAcquistoProdotti() throws CarrelloVuotoException {
        carrelloCliente.concludiAcquisto();
    }

    public Carrello getCarrelloCliente() {
        return carrelloCliente;
    }
}

