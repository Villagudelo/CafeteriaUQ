package co.edu.uniquindio.poo;

public class ClienteEstudiante extends Cliente{
    
    private int semestre;

    public ClienteEstudiante(String Cedula, String nombre, String apellido, String email, int semestre) {
        super(Cedula, nombre, apellido, email);
        
        this.semestre = semestre;
    }

    public int getSemestre() {
        return semestre;
    }
}
