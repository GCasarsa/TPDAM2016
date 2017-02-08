package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades;

/**
 * Created by Administrador on 18/01/2017.
 */
public class Partido {
    String idPartido;
    String imagenLocal;
    String equipoLocal;
    String resultadoLocal;
    String resultadoVisitante;
    String equipoVisitante;
    String imagenVisitante;
    String arbitro;
    String dia;
    String fecha;
    String lugar;
    String partidoDisputado;

    public String getPartidoDisputado() {
        return partidoDisputado;
    }

    public void setPartidoDisputado(String partidoDisputado) {
        this.partidoDisputado = partidoDisputado;
    }

    public String getCompetenciaId() {
        return competenciaId;
    }

    public void setCompetenciaId(String competenciaId) {
        this.competenciaId = competenciaId;
    }

    String competenciaId;


    public Partido (String idPartido, String equipoLocal, String equipoVisitante, String resultadoLocal, String resultadoVisitante, String arbitro, String dia, String fecha, String lugar, String partidoDisputado){
        this.idPartido = idPartido;
        this.equipoLocal = equipoLocal;
        this.resultadoLocal = resultadoLocal;
        this.resultadoVisitante = resultadoVisitante;
        this.equipoVisitante = equipoVisitante;
        this.fecha = fecha;
        this.dia = dia;
        this.lugar = lugar;
        this.arbitro=arbitro;
        this.partidoDisputado=partidoDisputado;
    }

    public String getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(String idPartido) {
        this.idPartido = idPartido;
    }

    public String getResultadoLocal() {
        return resultadoLocal;
    }

    public void setResultadoLocal(String resultadoLocal) {
        this.resultadoLocal = resultadoLocal;
    }

    public String getResultadoVisitante() {
        return resultadoVisitante;
    }

    public void setResultadoVisitante(String resultadoVisitante) {
        this.resultadoVisitante = resultadoVisitante;
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
        return resultadoLocal;
    }

    public void setResultado(String resultado) {
        this.resultadoLocal = resultado;
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
