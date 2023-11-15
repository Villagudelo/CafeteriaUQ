package co.edu.uniquindio.poo;

public class BebidaAlcohol extends ProductoBebida {

    private double contenidoAlcohol;
    private TipoBebidaAlcohol tipoBebidaAlcohol;

    public BebidaAlcohol(String nombre, double valor, double contenidoAlcohol, TipoBebidaAlcohol tipoBebidaAlcohol) {
        super(nombre, valor);

        this.contenidoAlcohol = contenidoAlcohol;
        this.tipoBebidaAlcohol = tipoBebidaAlcohol;
    }

    public double getContenidoAlcohol() {
        return contenidoAlcohol;
    }

    public TipoBebidaAlcohol getTipoBebidaAlcohol() {
        return tipoBebidaAlcohol;
    }   

    
    
}
