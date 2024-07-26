import java.util.ArrayList;
import java.util.Iterator;

public class Magazzino {

    //Accetta tipi ProdottoElettronico
    private ArrayList<ProdottoElettronico> magazzino;

    public Magazzino() {
        magazzino = new ArrayList<>();
    }
    //Ritorna il totale degli articoli presenti in magazzino.
    public int totaleProdotti(){
        return magazzino.size();
    }


    //Lista filtrata per tipo
    public ArrayList<ProdottoElettronico> filtredBytype(String type){
        ArrayList<ProdottoElettronico> filteredList = new ArrayList<>();
        for (ProdottoElettronico device : magazzino) {
            if (device.getTipoElettronico().toString().equalsIgnoreCase(type)) {
                filteredList.add(device);
            }
        }
        return filteredList;
    }
    public ArrayList<ProdottoElettronico> filtredByModel(String type){
        ArrayList<ProdottoElettronico> filteredList = new ArrayList<>();
        for (ProdottoElettronico device : magazzino) {
            if (device.getModello().equalsIgnoreCase(type)) {
                filteredList.add(device);
            }
        }
        return filteredList;
    }
    public ArrayList<ProdottoElettronico> filtredByProducer(String type){
        ArrayList<ProdottoElettronico> filteredList = new ArrayList<>();
        for (ProdottoElettronico device : magazzino) {
            if (device.getMarca().equalsIgnoreCase(type)) {
                filteredList.add(device);
            }
        }
        return filteredList;
    }
    public ArrayList<ProdottoElettronico> filtredBySellPrice(float price){
        ArrayList<ProdottoElettronico> filteredList = new ArrayList<>();
        for (ProdottoElettronico device : magazzino) {
            if (device.getPrezzoVendita() == (price)) {
                filteredList.add(device);
            }
        }
        return filteredList;
    }
    // Filtrato per prezzo magazzino
    public ArrayList<ProdottoElettronico> filtredByWhareHousePurchasePrice(float price){
        ArrayList<ProdottoElettronico> filteredList = new ArrayList<>();
        for (ProdottoElettronico device : magazzino) {
            if (device.getPrezzoAcquisto() == (price)) {
                filteredList.add(device);
            }
        }
        return filteredList;
    }
    public ArrayList<ProdottoElettronico> filtredByRangePrice(float price, float secondPrice){
        ArrayList<ProdottoElettronico> filteredList = new ArrayList<>();
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

    // Stampa tutti i dispositivi in magazzino
    public void printAllDevices() {
        System.out.println("Dispositivi in magazzino:");
        for (Prodotto prodotto: magazzino) {
            System.out.println(prodotto);
        }
    }
}
