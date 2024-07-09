import java.util.HashSet;
import java.util.Set;

public class Magazzino {

    //Accetta tipi ProdottoElettronico
    private Set<ProdottoElettronico> magazzino;

    public Magazzino() {
        magazzino = new HashSet<>();
    }
    //Ritorna il totale degli articoli presenti in magazzino.
    public int totaleProdotti(){
        return magazzino.size();
    }


    //Lista filtrata per tipo
    public Set<ProdottoElettronico> filtredBytype(String type){
        Set<ProdottoElettronico> filteredList = new HashSet<>();
        for (ProdottoElettronico device : magazzino) {
            if (device.getTipoElettronico().toString().equalsIgnoreCase(type)) {
                filteredList.add(device);
            }
        }
        return filteredList;
    }
    public Set<ProdottoElettronico> filtredByModel(String type){
        Set<ProdottoElettronico> filteredList = new HashSet<>();
        for (ProdottoElettronico device : magazzino) {
            if (device.getModello().equalsIgnoreCase(type)) {
                filteredList.add(device);
            }
        }
        return filteredList;
    }
    public Set<ProdottoElettronico> filtredByProducer(String type){
        Set<ProdottoElettronico> filteredList = new HashSet<>();
        for (ProdottoElettronico device : magazzino) {
            if (device.getMarca().equalsIgnoreCase(type)) {
                filteredList.add(device);
            }
        }
        return filteredList;
    }
    public Set<ProdottoElettronico> filtredBySellPrice(float price){
        Set<ProdottoElettronico> filteredList = new HashSet<>();
        for (ProdottoElettronico device : magazzino) {
            if (device.getPrezzoVendita() == (price)) {
                filteredList.add(device);
            }
        }
        return filteredList;
    }
    // Filtrato per prezzo magazzino
    public Set<ProdottoElettronico> filtredByWhareHousePurchasePrice(float price){
        Set<ProdottoElettronico> filteredList = new HashSet<>();
        for (ProdottoElettronico device : magazzino) {
            if (device.getPrezzoAcquisto() == (price)) {
                filteredList.add(device);
            }
        }
        return filteredList;
    }
    public Set<ProdottoElettronico> filtredByRangePrice(float price, float secondPrice){
        Set<ProdottoElettronico> filteredList = new HashSet<>();
        for (ProdottoElettronico device : magazzino) {
            if (device.getPrezzoVendita() >= price && device.getPrezzoVendita() <= secondPrice) {
                filteredList.add(device);
            }
        }
        return filteredList;


    }
}
