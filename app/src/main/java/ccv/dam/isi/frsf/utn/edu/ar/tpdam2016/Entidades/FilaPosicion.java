package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades;

/**
 * Created by Administrador on 01/02/2017.
 */
public class FilaPosicion {
    String equipo,pts,pj,pg,pe,pp,gf,gc,dif,posicion;

    public FilaPosicion(String equipo, String pts, String pj, String pg, String pe, String pp, String gf, String gc, String dif, String posicion) {
        this.equipo = equipo;
        this.pts = pts;
        this.pj = pj;
        this.pg = pg;
        this.pe = pe;
        this.pp = pp;
        this.gf = gf;
        this.gc = gc;
        this.dif = dif;
        this.posicion = posicion;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getPts() {
        return pts;
    }

    public void setPts(String pts) {
        this.pts = pts;
    }

    public String getPj() {
        return pj;
    }

    public void setPj(String pj) {
        this.pj = pj;
    }

    public String getPg() {
        return pg;
    }

    public void setPg(String pg) {
        this.pg = pg;
    }

    public String getPe() {
        return pe;
    }

    public void setPe(String pe) {
        this.pe = pe;
    }

    public String getPp() {
        return pp;
    }

    public void setPp(String pp) {
        this.pp = pp;
    }

    public String getGf() {
        return gf;
    }

    public void setGf(String gf) {
        this.gf = gf;
    }

    public String getGc() {
        return gc;
    }

    public void setGc(String gc) {
        this.gc = gc;
    }

    public String getDif() {
        return dif;
    }

    public void setDif(String dif) {
        this.dif = dif;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
}
