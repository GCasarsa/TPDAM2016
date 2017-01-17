package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades;

/**
 * Created by Gabriel on 16/01/2017.
 */
public class Equipo {
    String id;
    String nombre;
    String escudo;

    public Equipo(String nombre, String escudo) {
        this.nombre = nombre;
        this.escudo = escudo;
    }

    public Equipo(String id, String nombre, String escudo) {
        this.id = id;
        this.nombre = nombre;
        this.escudo = escudo;
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

    public String getEscudo() {
        return escudo;
    }

    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }
}
