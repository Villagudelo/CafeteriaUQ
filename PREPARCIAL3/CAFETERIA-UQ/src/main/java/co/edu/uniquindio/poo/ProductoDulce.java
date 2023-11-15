package co.edu.uniquindio.poo;

public class ProductoDulce extends Producto {
    
    private double contenidoAzucar;
    private final double ImpuestoBase;
    private final double ImpuestoAdicional;


    public ProductoDulce(String nombre, double valor, double contenidoAzucar) {
        super(nombre, valor);

        this.contenidoAzucar = contenidoAzucar;
        ImpuestoBase = 0.1;
        ImpuestoAdicional = 0.1;
    }


    public double getContenidoAzucar() {
        return contenidoAzucar;
    }


    public void setContenidoAzucar(double contenidoAzucar) {
        this.contenidoAzucar = contenidoAzucar;
    }


    public double getImpuestoBase() {
        return ImpuestoBase;
    }


    public double getImpuestoAdicional() {
        return ImpuestoAdicional;
    }

    
}
