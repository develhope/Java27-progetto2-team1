package Products;
import Enums.TipoElettronico;
import Exceptions.ExceptionHandler;
import Utility.ProdottoVendutoReader;
import java.util.List;

import java.io.FileNotFoundException;

public class ProdottoVenduto {
    private TipoElettronico tipoProdotto;
    private int quantitaVenduta;
    private double spesaTotale;
    private final static String smartphoneLine = "La media dei Smartphone venduti è:";
    private final static String tabletLine = "La media dei Tablet venduti è:";
    private final static String notebookLine = "La media dei Notebook venduti è:";

    public ProdottoVenduto(TipoElettronico tipoProdotto, double spesaTotale, int quantitaVenduta) {
        this.tipoProdotto = tipoProdotto;
        this.spesaTotale = spesaTotale;
        this.quantitaVenduta = quantitaVenduta;
    }

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

    private static double calcoloSpesaMedia(TipoElettronico tipoElettronico) throws FileNotFoundException {
        double [] spesaMedia = {0.00};
        int [] quantita = {0};
        List<ProdottoVenduto> prodottiVenduti = ProdottoVendutoReader.leggiProdottiVenduti();
       prodottiVenduti.stream().filter(p -> p.getTipoProdotto().equals(tipoElettronico)).forEach(p-> {
                spesaMedia[0] += p.getSpesaTotale();
                quantita[0] += p.getQuantitaVenduta();
    });
       return quantita[0] > 0 ? spesaMedia[0] / quantita[0] : 0.00;
    }

    public static String getSpesaMedia() {
         return ExceptionHandler.handlexception(()-> smartphoneLine + " " + calcoloSpesaMedia(TipoElettronico.SMARTPHONE) + " " + tabletLine + " "
                + calcoloSpesaMedia(TipoElettronico.TABLET) + " " + notebookLine + " " + calcoloSpesaMedia(TipoElettronico.NOTEBOOK)
                );
    }


}

