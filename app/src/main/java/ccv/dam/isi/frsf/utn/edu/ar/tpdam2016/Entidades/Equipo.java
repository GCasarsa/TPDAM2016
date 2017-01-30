package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades;

/**
 * Created by Gabriel on 16/01/2017.
 */
public class Equipo {
    String id;
    String nombre;
    String escudo;
    String division;
    String ciudad;
    String pais;
    String foto;
    Double latitud;
    Double longitud;

    public Equipo(String id, String nombre, String escudo, String division) {
        this.id = id;
        this.nombre = nombre;
        this.escudo = escudo;
        this.division = division;
    }

    public Equipo(String id, String nombre, String escudo, String division, String ciudad, String pais, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.escudo = escudo;
        this.division = division;
        this.ciudad = ciudad;
        this.pais = pais;
        this.foto = foto;
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

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
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
}
