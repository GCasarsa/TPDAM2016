package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades;

/**
 * Created by Gabriel on 16/01/2017.
 */
public class Jugador {
    String id;
    String nombre;
    String apellido;
    String posicion;
    String equipo;
    String titular;
    String ordenadorPorPosicion;
    int goles, amarillas, rojas, partidosJugados;


    public Jugador(String apellido, String nombre, String posicion, String ordenador, String equipo, String titular) {
        this.id = equipo + " " + apellido + nombre;
        this.nombre = nombre;
        this.apellido = apellido;
        this.posicion = posicion;
        this.equipo = equipo;
        this.titular = titular;
        this.ordenadorPorPosicion=ordenador;
        goles = amarillas = rojas = partidosJugados = 0;
    }

    public Jugador(String id, String apellido, String nombre, String posicion, String ordenador, String equipo, String titular, int goles, int amarillas, int rojas, int partidosJugados) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.posicion = posicion;
        this.equipo = equipo;
        this.titular = titular;
        this.id = id;
        this.ordenadorPorPosicion=ordenador;
        this.goles = goles;
        this.amarillas = amarillas;
        this.rojas = rojas;
        this.partidosJugados = partidosJugados;
    }

    public Jugador(String apellido, String nombre, String posicion, String ordenador, String equipo, String titular, int goles, int amarillas, int rojas, int partidosJugados) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.posicion = posicion;
        this.equipo = equipo;
        this.titular = titular;
        this.id = equipo + " " + apellido + nombre;
        this.goles = goles;
        this.amarillas = amarillas;
        this.ordenadorPorPosicion=ordenador;
        this.rojas = rojas;
        this.partidosJugados = partidosJugados;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
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

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getOrdenadorPorPosicion() {
        return ordenadorPorPosicion;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getAmarillas() {
        return amarillas;
    }

    public void setAmarillas(int amarillas) {
        this.amarillas = amarillas;
    }

    public int getRojas() {
        return rojas;
    }

    public void setRojas(int rojas) {
        this.rojas = rojas;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }
}
