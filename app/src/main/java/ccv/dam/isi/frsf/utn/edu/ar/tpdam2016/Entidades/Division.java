package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades;

/**
 * Created by Gabriel on 16/01/2017.
 */
public class Division {
    int id, año, cantidadEquipos;
    String categoria, descripcion;

    public Division(int id, int año, int cantidadEquipos, String categoria, String descripcion) {
        this.id = id;
        this.año = año;
        this.cantidadEquipos = cantidadEquipos;
        this.categoria = categoria;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getCantidadEquipos() {
        return cantidadEquipos;
    }

    public void setCantidadEquipos(int cantidadEquipos) {
        this.cantidadEquipos = cantidadEquipos;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescrpicion(String descripcion) {
        this.descripcion = descripcion;
    }
}
