package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades;

/**
 * Created by Gabriel on 16/01/2017.
 */
public class Jugador {
    String nombre, apellido, posicion,equipo;
    long edad, goles, amarillas, rojas;


    public Jugador(String nombre, String apellido, String posicion, long edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.posicion = posicion;
        this.edad = edad;
    }

    public Jugador(String apellido, long goles, long amarillas, long rojas, String equipo) {
        this.goles= goles;
        this.apellido = apellido;
        this.amarillas= amarillas;
        this.rojas=rojas;
        this.equipo= equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String idEquipo) {
        this.equipo = idEquipo;
    }

    public long getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public long getAmarillas() {
        return amarillas;
    }

    public void setAmarillas(int amarillas) {
        this.amarillas = amarillas;
    }

    public long getRojas() {
        return rojas;
    }

    public void setRojas(int rojas) {
        this.rojas = rojas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public long getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
