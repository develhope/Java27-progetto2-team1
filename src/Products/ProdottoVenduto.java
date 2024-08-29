package Products;
import Enums.TipoElettronico;
import Utility.ProdottoVendutoReader;
import java.util.List;

import java.io.FileNotFoundException;

public class ProdottoVenduto {
    private TipoElettronico tipoProdotto;
    private int quantitaVenduta;
    private double spesaTotale;
    private static String stampa1 = "La media dei Smartphone venduti è:";
    private static String stampa2 = "La media dei Tablet venduti è:";
    private static String stampa3 = "La media dei Notebook venduti è:";

    public ProdottoVenduto(TipoElettronico tipoProdotto, double spesaTotale, int quantitaVenduta) {
        this.tipoProdotto = tipoProdotto;
        this.spesaTotale = spesaTotale;
        this.quantitaVenduta = quantitaVenduta;
    }

    public ProdottoVenduto(){};

    public TipoElettronico getTipoProdotto() {
        return tipoProdotto;
    }

    public void setTipoProdotto(TipoElettronico tipoProdotto) {
        this.tipoProdotto = tipoProdotto;
    }

    public int getQuantitaVenduta() {
        return quantitaVenduta;
    }

    public void setQuantitaVenduta(int quantitaVenduta) {
        this.quantitaVenduta = quantitaVenduta;
    }

    public double getSpesaTotale() {
        return spesaTotale;
    }

    public void setSpesaTotale(double spesaTotale) {
        this.spesaTotale = spesaTotale;
    }

    private double calcoloSpesaMediaSmartphone() throws FileNotFoundException {
        double [] spesaMediaSmartphone = {0.00};
        int [] quantitaS = {0};

        ProdottoVendutoReader.leggiProdottiVenduti().stream()
                .filter(p -> p.getTipoProdotto().toString().equals("SMARTPHONE"))
                .forEach(p -> {
                    spesaMediaSmartphone[0] += p.getSpesaTotale();
                    quantitaS[0] += p.getQuantitaVenduta();
                });
       return quantitaS[0] > 0 ? spesaMediaSmartphone[0] / quantitaS[0] : 0.00;
    }

    private double calcoloSpesaMediaTablet() throws FileNotFoundException {
        double [] spesaMediaTablet = {0.00};
        int [] quantitaT = {0};
        ProdottoVendutoReader.leggiProdottiVenduti().stream()
                .filter(p -> p.getTipoProdotto().toString().equals("TABLET"))
                .forEach(p -> {
                    spesaMediaTablet[0] += p.getSpesaTotale();
                    quantitaT[0] += p.getQuantitaVenduta();
                });
        return quantitaT[0] > 0 ? spesaMediaTablet[0] / quantitaT[0] : 0.00;
    }

    private double calcoloSpesaMediaNotebook() throws FileNotFoundException {
        double [] spesaMediaNotebook = {0.00};
        int [] quantitaN = {0};
        List<ProdottoVenduto> prodottiVenduti = ProdottoVendutoReader.leggiProdottiVenduti();
        prodottiVenduti.stream()
                .filter(p -> p.getTipoProdotto().toString().equals("NOTEBOOK"))
                .forEach(p -> {
                    spesaMediaNotebook[0] += p.getSpesaTotale();
                    quantitaN[0] += p.getQuantitaVenduta();
                });
        return quantitaN[0] > 0 ? spesaMediaNotebook[0] / quantitaN[0] : 0.00;
    }

    public String calcoloSpesaMedia() throws FileNotFoundException {
        return stampa1 + " " + calcoloSpesaMediaSmartphone() + " " + stampa2 + " "
                + calcoloSpesaMediaTablet() + " " + stampa3 + " " + calcoloSpesaMediaNotebook();
    }


}

