package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades;

import java.util.ArrayList;

/**
 * Created by Gabriel on 16/01/2017.
 */
public class Division {
    int id;
    int cantidadEquipos;
    String nombre;
    ArrayList<Equipo> equipos;

    public Division(int cantidadEquipos, String nombre, ArrayList<Equipo> equipos) {
        this.cantidadEquipos = cantidadEquipos;
        this.nombre = nombre;
        this.equipos = equipos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidadEquipos() {
        return cantidadEquipos;
    }

    public void setCantidadEquipos(int cantidadEquipos) {
        this.cantidadEquipos = cantidadEquipos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void addEquipo(Equipo equipo) {
        this.equipos.add(equipo);
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }
}
