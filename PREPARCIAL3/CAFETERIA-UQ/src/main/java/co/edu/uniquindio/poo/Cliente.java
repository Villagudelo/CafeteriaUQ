package co.edu.uniquindio.poo;

public abstract class Cliente {
    
    private String Cedula;
    private String nombre;
    private String apellido;
    private String email;


    public Cliente(String Cedula, String nombre, String apellido, String email) {
        this.Cedula = Cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }


    public String getCedula() {
        return Cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

}
