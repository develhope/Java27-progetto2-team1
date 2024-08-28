package Products;
import Enums.TipoElettronico;

public class ProdottoVenduto {
    private TipoElettronico tipoProdotto;
    private int quantitaVenduta;
    private double spesaTotale;

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
}
