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

    public void aggiungiProdottoAlCarrello(ProdottoElettronico prodotto){
        carrelloCliente.aggiungiProdotto(prodotto);
    }

    public Set<ProdottoElettronico> ricercaProdottoPerMarca(String marca) {
        return carrelloCliente.ricercaPerMarca(marca);
    }

    public Set<ProdottoElettronico> ricercaProdottoPerModello(String modello) {
        return carrelloCliente.ricercaPerModello(modello);
    }

    public Set<ProdottoElettronico> ricercaProdottoPerPrezzoDiVendita(double prezzo){
        return carrelloCliente.ricercaPerPrezzoVendita(prezzo);
    }

    public Set<ProdottoElettronico> ricercaProdottoPerRange(double prezzoMin, double prezzoMax){
        return carrelloCliente.ricercaPerRange(prezzoMin, prezzoMax);
    }

    public Set<ProdottoElettronico> ricercaProdottoPerTIpo(String tipo){
        return carrelloCliente.ricercaPerTipo(tipo);
    }

    public void stampaCarrelloProdotti(){
        carrelloCliente.stampaCarrello();
    }

    public void aggiuntaProdottoTramiteId(int id){
        carrelloCliente.aggiuntaTramiteId(id);
    }

    public void rimuoviProdottoTramiteId(int id) {
        carrelloCliente.rimozioneTramiteId(id);
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




}

