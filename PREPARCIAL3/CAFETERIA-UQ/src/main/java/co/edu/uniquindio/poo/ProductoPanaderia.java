package co.edu.uniquindio.poo;

public class ProductoPanaderia extends Producto {
    
    private boolean conservantes;
    private double impuestoAdicional;


    public ProductoPanaderia(String nombre, double valor, boolean conservantes) {
        super(nombre, valor);

        this.conservantes = conservantes;
        this.impuestoAdicional = 0.18;
    }


    public boolean getConservantes() {
        return conservantes;
    }


    public double getImpuestoAdicional() {
        return impuestoAdicional;
    }
}
