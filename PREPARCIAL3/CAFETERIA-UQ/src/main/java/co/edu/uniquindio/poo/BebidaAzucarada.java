package co.edu.uniquindio.poo;

public class BebidaAzucarada extends ProductoBebida{
    
    private double contenidoAzucar;
    private final double impuestoBase = 0.05;
    private final double impuestoAdicional = 0.2;

    public BebidaAzucarada(String nombre, double valor, double contenidoAzucar) {
        super(nombre, valor);

        this.contenidoAzucar = contenidoAzucar;

    }


    public double getContenidoAzucar() {
        return contenidoAzucar;
    }


    public double getImpuestoBase() {
        return impuestoBase;
    }


    public double getImpuestoAdicional() {
        return impuestoAdicional;
    }


    
}