package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades;

/**
 * Created by Gabriel on 30/01/2017.
 */
public class Estadio {
    Double latitud, longitud;
    String descripcion;
    int id, idEquipo;

    public Estadio(Double latitud, Double longitud, String descripcion, int id, int idEquipo) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.descripcion = descripcion;
        this.id = id;
        this.idEquipo = idEquipo;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }
}
