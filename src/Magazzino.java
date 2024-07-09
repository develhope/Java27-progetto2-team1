import java.util.ArrayList;

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
}
