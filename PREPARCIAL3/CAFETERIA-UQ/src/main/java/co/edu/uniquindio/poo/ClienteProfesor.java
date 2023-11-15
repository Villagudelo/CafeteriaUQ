package co.edu.uniquindio.poo;

public class ClienteProfesor extends Cliente{

    private TipoProfesor tipoProfesor;

    public ClienteProfesor(String Cedula, String nombre, String apellido, String email, TipoProfesor tipoProfesor) {
        super(Cedula, nombre, apellido, email);

        this.tipoProfesor = tipoProfesor;
    }

    public TipoProfesor getTipoProfesor() {
        return tipoProfesor;
    }

    
    

}
