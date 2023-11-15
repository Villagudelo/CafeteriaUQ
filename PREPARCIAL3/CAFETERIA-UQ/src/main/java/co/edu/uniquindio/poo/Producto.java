package co.edu.uniquindio.poo;

public abstract class Producto {
    
    private String nombre;
    private double valor;


    public Producto(String nombre, double valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public String getNombre() {
        return nombre;
    }
}
