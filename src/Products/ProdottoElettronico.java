package Products;

import Enums.TipoElettronico;

public class ProdottoElettronico extends Prodotto {
    private TipoElettronico tipoElettronico;
    private float dimSchermo;


    private ProdottoElettronico(ProdottoElettronicoBuilder peBuilder) {
        super(peBuilder);
        this.tipoElettronico = peBuilder.tipoElettronico;
        this.dimSchermo = peBuilder.dimSchermo;
    }


    public TipoElettronico getTipoElettronico() {
        return tipoElettronico;
    }

    public void setTipoElettronico(TipoElettronico tipoElettronico) {
        this.tipoElettronico = tipoElettronico;
    }

    public float getDimSchermo() {
        return dimSchermo;
    }

    public void setDimSchermo(float dimSchermo) {
        this.dimSchermo = dimSchermo;
    }


    @Override
    public double calcolaSpesaMedia() {
        return 0;
    }

    @Override
    public String toString() {
        return " Products.Prodotto: " + '\'' +
                "Tipo Elettronico: " + tipoElettronico +  '\'' +
                "Dimensione Schermo: " + dimSchermo +
                "Marca: " + marca + '\'' +
                "Modello: " + modello + '\'' +
                "Descrizione: " + descrizione + '\'' +
                "Prezzo: " + prezzoVendita +
                "ID: " + id;

    }

    public static class ProdottoElettronicoBuilder extends AbstractBuilder<ProdottoElettronicoBuilder> {

        private TipoElettronico tipoElettronico;
        private float dimSchermo;

        public ProdottoElettronicoBuilder(String marca, String modello, double prezzoAcquisto, int id, String tipoElettronico, float dimSchermo) {
            super(marca, modello, prezzoAcquisto, id);
            this.tipoElettronico = TipoElettronico.valueOf(tipoElettronico.toUpperCase());
            this.dimSchermo = dimSchermo;
        }


        public ProdottoElettronicoBuilder setTipoElettronico(TipoElettronico tipoElettronico) {
            this.tipoElettronico = tipoElettronico;
            return this;
        }

        public ProdottoElettronicoBuilder setDimSchermo(float dimSchermo) {
            this.dimSchermo = dimSchermo;
            return this;
        }


        @Override
        protected ProdottoElettronicoBuilder self() {
            return this;
        }

        @Override
        public ProdottoElettronico build() {
            // eventuali controlli su campi
            return new ProdottoElettronico(this);
        }
    }
}
