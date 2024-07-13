import java.util.ArrayList;
import java.util.Iterator;
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
    public void addProductToMagazzino(ProdottoElettronico dispositivo){
        magazzino.add(dispositivo);
    }

    public void removeProductFromMagazzino(int id){
        Iterator<ProdottoElettronico> iterator = magazzino.iterator();
        while (iterator.hasNext()) {
            ProdottoElettronico device = iterator.next();
            if (device.getId() == id) {
                iterator.remove();
            }
        }
    }

    public ArrayList<ProdottoElettronico> filteredById(int id) {
        ArrayList<ProdottoElettronico> filteredList = new ArrayList<>();
        for (ProdottoElettronico device : magazzino) {
            if (device.getId() == id) {
                filteredList.add(device);
            }
        }
        return filteredList;
    }

    public ArrayList<ProdottoElettronico> getMagazzino() {
        return magazzino;
    }

    public void setMagazzino(ArrayList<ProdottoElettronico> magazzino) {
        this.magazzino = magazzino;
    }
}
