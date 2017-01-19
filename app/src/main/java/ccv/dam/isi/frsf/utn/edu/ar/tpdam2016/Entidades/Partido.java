package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades;

/**
 * Created by Administrador on 18/01/2017.
 */
public class Partido {
    String imagenLocal;
    String equipoLocal;
    String resultado;
    String equipoVisitante;
    String imagenVisitante;
    String arbitro;
    String dia;
    String fecha;
    String lugar;

    public Partido(String equipoLocal, String resultado, String equipoVisitante, String fecha) {
        this.equipoLocal = equipoLocal;
        this.resultado = resultado;
        this.equipoVisitante = equipoVisitante;
        this.fecha = fecha;
    }

    public String getImagenLocal() {
        return imagenLocal;
    }

    public void setImagenLocal(String imagenLocal) {
        this.imagenLocal = imagenLocal;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public String getImagenVisitante() {
        return imagenVisitante;
    }

    public void setImagenVisitante(String imagenVisitante) {
        this.imagenVisitante = imagenVisitante;
    }

    public String getArbitro() {
        return arbitro;
    }

    public void setArbitro(String arbitro) {
        this.arbitro = arbitro;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
}
