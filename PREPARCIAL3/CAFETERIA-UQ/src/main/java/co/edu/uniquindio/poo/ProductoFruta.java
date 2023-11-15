package co.edu.uniquindio.poo;

public class ProductoFruta extends Producto {
    
    private double libras;
    private final double impuestoBase = 0.07;
    private final double impuestoPorKilo = 0.01;

    public ProductoFruta(String nombre, double valor, double libras) {
        super(nombre, valor);

        this.libras = libras;
    }

    public double getImpuestoBase() {
        return impuestoBase;
    }

    public double getImpuestoPorKilo() {
        return impuestoPorKilo;
    }

    public double getLibras() {
        return libras;
    }
}
