import java.util.List;

public class Magazziniere extends Utente {

    private Magazzino magazzino;

    public Magazzino getMagazzino() {
        return magazzino;
    }

    public Magazziniere(Magazzino magazzino, String idUtente, String password) {
        super(idUtente, password);
        this.magazzino = magazzino;

    }
    public void addProductToMagazzino(ProdottoElettronico prodotto) {
        magazzino.addProductToMagazzino(prodotto);
    }

    public void removeProductFromMagazzino(int id) {
        magazzino.removeProductFromMagazzino(id);
    }

    public List<ProdottoElettronico> filtredByWhareHousePurchasePrice(float prezzo) {
        return magazzino.filtredByWhareHousePurchasePrice(prezzo);
    }

    public List<ProdottoElettronico>filtredBytype(String tipo){
        return magazzino.filtredBytype(tipo);
    }

    public List<ProdottoElettronico>filtredByModel(String modello){
        return magazzino.filtredByModel(modello);
    }
    public List<ProdottoElettronico>filtredByProducer(String marca){
        return magazzino.filtredByProducer(marca);
    }

    public List<ProdottoElettronico>filtredBySellPrice(float prezzo){
        return magazzino.filtredBySellPrice(prezzo);
    }

    public List<ProdottoElettronico>filtredByRangePrice(float prezzo1, float prezzo2){
        return magazzino.filtredByRangePrice(prezzo1,prezzo2);
    }

    public List<ProdottoElettronico>filteredById(int iD){
        return magazzino.filteredById(iD);
    }
}








