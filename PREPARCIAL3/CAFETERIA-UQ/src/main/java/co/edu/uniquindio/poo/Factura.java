package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.Collection;

public class Factura {
    
    private Cliente cliente;
    private Collection<Producto> listaProductos;
    private Collection<Double> listaPrecios = new ArrayList<Double>();
        
    

    
    public Factura(Cliente cliente, Collection<Producto> listaProductos) {
        this.cliente = cliente;
        this.listaProductos = listaProductos;
    }


    public double calcularPrecioProducto(Producto producto) {
        double precio = producto.getValor(); 

        if (producto instanceof ProductoDulce) {  
            double impuestoBase = producto.getValor() * ((ProductoDulce) producto).getImpuestoBase();
            precio += impuestoBase;
            
            if (((ProductoDulce) producto).getContenidoAzucar() > 0.5) {
                double impuestoAdicional = producto.getValor() * ((ProductoDulce) producto).getImpuestoAdicional();
                precio += impuestoAdicional;
            }
        }
        if (producto instanceof ProductoBebida) { 
            if (producto instanceof BebidaAzucarada) {
                if (((BebidaAzucarada)producto).getContenidoAzucar() > 0.35) {
                    double impuestoTotal = ((BebidaAzucarada)producto).getImpuestoBase() + ((BebidaAzucarada)producto).getImpuestoAdicional();
                    double impuesto = ((BebidaAzucarada)producto).getValor() *impuestoTotal;
                    precio += impuesto;
                }
                else {
                    double impuestoBase = ((BebidaAzucarada)producto).getImpuestoBase() * ((BebidaAzucarada)producto).getValor();
                    precio += impuestoBase;
                }
            }
            if(producto instanceof BebidaAlcohol) {
                BebidaAlcohol bebAlcohol = (BebidaAlcohol)producto;
                if(bebAlcohol.getTipoBebidaAlcohol() == TipoBebidaAlcohol.NACIONAL) {
                    if(bebAlcohol.getContenidoAlcohol() <= 25) {
                        double impuesto = (2 * bebAlcohol.getContenidoAlcohol()) / 100;
                        double impuestoTotal = bebAlcohol.getValor() * impuesto;
                        precio += impuestoTotal;
                    }
                    else {
                        double impuesto = bebAlcohol.getValor() * 0.5;
                        precio += impuesto;
                    }
                }
                if(bebAlcohol.getTipoBebidaAlcohol() == TipoBebidaAlcohol.IMPORTADA) {
                    precio = (bebAlcohol.getValor() * 1.3) * (1 + (0.3 * bebAlcohol.getContenidoAlcohol()));
                }
            }
            else {
                return precio; 
            }
        }
        if (producto instanceof ProductoPanaderia) { 
            if (((ProductoPanaderia) producto).getConservantes() == false) {
                return precio;
            }
            
            double impuestoAdicional = producto.getValor() * ((ProductoPanaderia) producto).getImpuestoAdicional();
            precio += impuestoAdicional;
        }
        if(producto instanceof ProductoFruta)  {
            ProductoFruta fruta = (ProductoFruta) producto;
            double kilos = Math.round(fruta.getLibras() * 0.453592);
            double valorTotal = fruta.getValor() * fruta.getLibras();

            if(kilos > 3 && kilos < 11) { 
                double impuesto = fruta.getImpuestoBase() - (kilos - 3)*0.01;
                double impuestoBase = valorTotal * impuesto;
                precio *= fruta.getLibras();
                precio += impuestoBase;
            }
            else if(kilos >= 11) {
                return precio;
            }
            else { 
            double impuestoBase = fruta.getValor() * fruta.getImpuestoBase();
            precio += impuestoBase;
            }
        }

        return precio; 
    }


    public double facturaTotal() {
        listaPrecios.clear();
        for(Producto producto: listaProductos) {
            listaPrecios.add(calcularPrecioProducto(producto)); 
        }
        double total = 0;
        for(Double precio: listaPrecios) {
            total += precio;   
        }
        return total;
    }

    public double calcularDescuentoFactura () {

        double precioTotal = facturaTotal();
        double descuento = 0;

        if(cliente instanceof ClienteEstudiante) {
            ClienteEstudiante estudiante = (ClienteEstudiante)cliente;

            double descuentoSemestre = estudiante.getSemestre() * 0.012;
            descuento = precioTotal * descuentoSemestre;
        }

        else if(cliente instanceof ClienteProfesor) {
            ClienteProfesor profesor = (ClienteProfesor)cliente;

            if(profesor.getTipoProfesor() == TipoProfesor.ASISTENTE) {
                descuento = precioTotal * 0.05;
            }
            if(profesor.getTipoProfesor() == TipoProfesor.AUXILIAR) {
                descuento = precioTotal * 0.03;
            }
            if(profesor.getTipoProfesor() == TipoProfesor.ASOCIADO) {
                descuento = precioTotal * 0.1;
            }
            if(profesor.getTipoProfesor() == TipoProfesor.TITULAR) {
                descuento = precioTotal * 0.16;
            }
        }

        double precioFinal = precioTotal - descuento;

        return precioFinal;
    }
}