/**
 * Clase para probar el funcionamiento del código
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;


public class TestCalcularPrecio {
    private static final Logger LOG = Logger.getLogger(TestCalcularPrecio.class.getName());

    @Test
    public void calcularPrecioProducto() { // TEST PARA LOS CLIENTES QUE SON PROFESORES
        LOG.info("Iniciado test calcularPrecioProducto");

        Cafeteria cafeteria = new Cafeteria("Los Pollos");
        var cliente1 = new ClienteEstudiante("93928103", "Jorge", "Pelaez", "jorge@gmail.com", 2);
        var cliente2 = new ClienteProfesor("93928103", "Jorge", "Pelaez", "jorge@gmail.com", TipoProfesor.ASISTENTE);


        var producto1 = new ProductoDulce("Pepas", 2000, 0.5);
        var producto2 = new ProductoPanaderia("Pan", 500, true);
        var producto3 = new BebidaAzucarada("BebidaA", 1000, 0.4);
        var producto4 = new BebidaAlcohol("bebAlcoholN", 1000, 24, TipoBebidaAlcohol.NACIONAL);
        var producto5 = new BebidaAlcohol("bebAlcoholI", 1000, 26, TipoBebidaAlcohol.IMPORTADA);
        var producto6 = new BebidaAgua("bebAlcoholN", 1000);
        var producto7 = new ProductoFruta("Manzana", 200, 21); 


        Collection<Producto> productos = new ArrayList<Producto>();
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);
        productos.add(producto6);
        productos.add(producto7);


        Factura factura = new Factura(cliente2, productos);


        assertEquals(2200, factura.calcularPrecioProducto(producto1));
        assertEquals(590, factura.calcularPrecioProducto(producto2));
        assertEquals(1250, factura.calcularPrecioProducto(producto3));
        assertEquals(1480, factura.calcularPrecioProducto(producto4));
        assertEquals(11440, Math.round(factura.calcularPrecioProducto(producto5)));
        assertEquals(1000, factura.calcularPrecioProducto(producto6));
        assertEquals(4200, factura.calcularPrecioProducto(producto7));


        assertEquals(22160, factura.facturaTotal());


        assertEquals(21052, factura.calcularDescuentoFactura());

        LOG.info("Finalizando test calcularPrecioProducto");
    }


        @Test
    public void calcularPrecioProducto2() { // TEST PARA LOS CLIENTES QUE SON ESTUDIANTES 
        LOG.info("Iniciado test calcularPrecioProducto2");

        var cliente = new ClienteEstudiante("93928103", "Jorge", "Pelaez", "jorge@gmail.com", 2);


        var producto1 = new ProductoDulce("Pepas", 2000, 0.5);
        var producto2 = new ProductoPanaderia("Pan", 500, true);
        var producto3 = new BebidaAzucarada("BebidaA", 1000, 0.4);
        var producto4 = new BebidaAlcohol("bebAlcoholN", 1000, 24, TipoBebidaAlcohol.NACIONAL);
        var producto5 = new BebidaAlcohol("bebAlcoholI", 1000, 26, TipoBebidaAlcohol.IMPORTADA);
        var producto6 = new BebidaAgua("bebAlcoholN", 1000);
        var producto7 = new ProductoFruta("Manzana", 100, 11); 


        Collection<Producto> productos = new ArrayList<Producto>();
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);
        productos.add(producto6);
        productos.add(producto7);


        Factura factura = new Factura(cliente, productos);


        assertEquals(2200, factura.calcularPrecioProducto(producto1));
        assertEquals(590, factura.calcularPrecioProducto(producto2));
        assertEquals(1250, factura.calcularPrecioProducto(producto3));
        assertEquals(1480, factura.calcularPrecioProducto(producto4));
        assertEquals(11440, Math.round(factura.calcularPrecioProducto(producto5)));
        assertEquals(1000, factura.calcularPrecioProducto(producto6));
        assertEquals(1155, factura.calcularPrecioProducto(producto7));


        assertEquals(19115, factura.facturaTotal());

        assertEquals(18656.24, factura.calcularDescuentoFactura());

        LOG.info("Finalizando test calcularPrecioProducto2");
    }
}
