package Products;

import Enums.TipoElettronico;

import java.util.Objects;

public class ProdottoElettronico extends Prodotto {
    private TipoElettronico tipoElettronico;
    private float dimSchermo;


    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProdottoElettronico that)) return false;

        return Float.compare(getDimSchermo(), that.getDimSchermo()) == 0 && getTipoElettronico() == that.getTipoElettronico();
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getTipoElettronico());
        result = 31 * result + Float.hashCode(getDimSchermo());
        return result;
    }

    public ProdottoElettronico() {}

    private ProdottoElettronico(ProdottoElettronicoBuilder peBuilder) {
        super(peBuilder);
        this.tipoElettronico = peBuilder.tipoElettronico;
        this.dimSchermo = peBuilder.dimSchermo;
    }

    public TipoElettronico getTipoElettronico() {
        return tipoElettronico;
    }

    public float getDimSchermo() {
        return dimSchermo;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setTipoElettronico(TipoElettronico tipoElettronico){
        this.tipoElettronico = tipoElettronico;
    }

    public void setDimSchermo(float dimSchermo){
        this.dimSchermo = dimSchermo;
    }

    @Override
    public double calcolaSpesaMedia() {
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        string.append('\n');
        string.append(id)
                .append(") ")
                .append(marca)
                .append(" ")
                .append(modello)
                .append('\n');
        if(descrizione != null) string.append(" Descrizione: ")
                .append(descrizione)
                .append('\n');
        string.append(" Prezzo: ")
                .append(prezzoVendita)
                .append("€")
                .append('\n');
        string.append(" Quantità: ").
                append(quantitaMagazzino)
                .append('\n');

        return string.toString();
    }

    public static class ProdottoElettronicoBuilder extends AbstractBuilder<ProdottoElettronicoBuilder> {

        private TipoElettronico tipoElettronico;
        private final float dimSchermo;

        public ProdottoElettronicoBuilder(String marca, String modello, double prezzoAcquisto, int id, String tipoElettronico, float dimSchermo) {
            super(marca, modello, prezzoAcquisto, id);
            this.tipoElettronico = TipoElettronico.valueOf(tipoElettronico.toUpperCase());
            this.dimSchermo = dimSchermo;
        }

        public ProdottoElettronicoBuilder setId(int id){
            this.id = id;
            return this;
        }

        public ProdottoElettronicoBuilder setTipoElettronico(String tipo){
            this.tipoElettronico = TipoElettronico.valueOf(tipo.toUpperCase());
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
