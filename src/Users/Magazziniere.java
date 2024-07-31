import javax.imageio.IIOException;
import java.io.IOException;
package Users;

import Exceptions.ProdottoNonTrovatoException;
import Products.ProdottoElettronico;
import Management.Magazzino;

import java.util.Set;

public class Magazziniere extends Utente {

    private Magazzino magazzino;

    public Magazziniere(){}

    public Magazziniere(String nome, String cognome, int age, String email, String password) {
        super(nome, cognome, age, email, password);
    }
    public void addProductToMagazzino(ProdottoElettronico prodotto) throws IOException {
        magazzino.addProductToMagazzino(prodotto);
    }

    public void removeProductFromMagazzino(int id) throws ProdottoNonTrovatoException, IOException {
        magazzino.removeProductFromMagazzino(id);
    }

    public Set<ProdottoElettronico> filtredByWhareHousePurchasePrice(float prezzo) {
        return magazzino.filtredByWhareHousePurchasePrice(prezzo);
    }

    public Set<ProdottoElettronico>filtredBytype(String tipo){
        return magazzino.filtredBytype(tipo);
    }

    public Set<ProdottoElettronico>filtredByModel(String modello){
        return magazzino.filtredByModel(modello);
    }
    public Set<ProdottoElettronico>filtredByProducer(String marca){
        return magazzino.filtredByProducer(marca);
    }

    public Set<ProdottoElettronico>filtredBySellPrice(float prezzo){
        return magazzino.filtredBySellPrice(prezzo);
    }

    public Set< ProdottoElettronico >filtredByRangePrice( float prezzo1, float prezzo2){
        return magazzino.filtredByRangePrice(prezzo1,prezzo2);
    }

    public ProdottoElettronico filteredById(int iD) throws ProdottoNonTrovatoException {
        return magazzino.filteredById(iD);
    }

    public Magazzino getMagazzino() {
        return magazzino;
    }
}








