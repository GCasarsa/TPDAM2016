package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades;

/**
 * Created by Gabriel on 16/01/2017.
 */
public class Equipo {
    String nombre;
    String abreviatura;
    String escudo;
    String division;
    String ciudad;
    String foto;
    Double latitud;
    Double longitud;
    String descripcionEstadio;
    String directorTecnico;

    public Equipo(String nombre, String abreviatura, String escudo, String division, String ciudad, String foto, Double latitud, Double longitud, String descripcionEstadio, String directorTecnico) {
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        this.escudo = escudo;
        this.division = division;
        this.ciudad = ciudad;
        this.foto = foto;
        this.latitud = latitud;
        this.longitud = longitud;
        this.descripcionEstadio = descripcionEstadio;
        this.directorTecnico = directorTecnico;
    }

    public Equipo(String nombre, String escudo, String division) {
        this.nombre = nombre;
        this.escudo = escudo;
        this.division = division;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
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

    public String getDescripcionEstadio() {
        return descripcionEstadio;
    }

    public void setDescripcionEstadio(String descripcionEstadio) {
        this.descripcionEstadio = descripcionEstadio;
    }

    public String getDirectorTecnico() {
        return directorTecnico;
    }

    public void setDirectorTecnico(String directorTecnico) {
        this.directorTecnico = directorTecnico;
    }
}
