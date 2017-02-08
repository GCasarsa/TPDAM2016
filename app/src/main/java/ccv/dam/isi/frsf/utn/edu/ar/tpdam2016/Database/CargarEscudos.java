package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.R;

/**
 * Created by Gabriel on 08/02/2017.
 */

public class CargarEscudos {
    public static int cargarEscudo(String nombre){
        if(nombre.equals("ARGENTINO DE SAN CARLOS")) return R.drawable.argentinodesancarlos;
        else if(nombre.equals("EL CADI")) return R.drawable.escudo_elcadi;
        else if(nombre.equals("ATENEO INMACULADA")) return R.drawable.escudo_ateneo;
        else if(nombre.equals("BANCO PROVINCIAL")) return R.drawable.escudo_bancoprovincial;
        else if(nombre.equals("CICLON RACING")) return R.drawable.escudo_ciclonracing;
        else if(nombre.equals("COLON DE SANTA FE")) return R.drawable.escudo_colon;
        else if(nombre.equals("COLON DE SAN JUSTO")) return R.drawable.escudo_colonsanjusto;
        else if(nombre.equals("COSMOS FC")) return R.drawable.escudo_clubcosmos;
        else if(nombre.equals("QUILLA")) return R.drawable.escudo_quilla;
        else if(nombre.equals("GIMNASIA DE CIUDADELA")) return R.drawable.escudo_gimnasiaciudadela;
        else if(nombre.equals("LA PERLA DEL OESTE")) return R.drawable.escudo_laperladeloeste;
        else if(nombre.equals("NEWELLS DE SANTA FE")) return R.drawable.escudo_newells;
        else if(nombre.equals("SANJUSTINO")) return R.drawable.escudo_sanjustino;
        else if(nombre.equals("UNION DE SANTA FE")) return R.drawable.escudo_union;
        else if(nombre.equals("UNL")) return R.drawable.escudo_unl;
        else if(nombre.equals("LA SALLE JOBSON")) return R.drawable.escudo_lasalle;
        else if(nombre.equals("BELGRANO DE CORONDA")) return R.drawable.escudo_belgranodecoronda;
        else if(nombre.equals("PUCARA")) return R.drawable.escudo_pucara;
        else if(nombre.equals("INDEPENDIENTE DE SANTO TOME")) return R.drawable.escudo_independiente;
        else return R.drawable.escudo_vacio;
    }
    public static int cargarPortada(String nombre){
        if(nombre.equals("ARGENTINO DE SAN CARLOS")) return R.drawable.portada_argentino;
        //else if(nombre.equals("EL CADI")) return R.drawable.escudo_elcadi;
        //else if(nombre.equals("ATENEO INMACULADA")) return R.drawable.portada_ateneo;
        //else if(nombre.equals("BANCO PROVINCIAL")) return R.drawable.escudo_bancoprovincial;
        //else if(nombre.equals("CICLON RACING")) return R.drawable.escudo_ciclonracing;
        else if(nombre.equals("COLON DE SANTA FE")) return R.drawable.portada_colon;
        //else if(nombre.equals("COLON DE SAN JUSTO")) return R.drawable.escudo_colonsanjusto;
        else if(nombre.equals("COSMOS FC")) return R.drawable.portada_cosmos;
        //else if(nombre.equals("QUILLA")) return R.drawable.escudo_quilla;
        //else if(nombre.equals("GIMNASIA DE CIUDADELA")) return R.drawable.escudo_gimnasiaciudadela;
        //else if(nombre.equals("LA PERLA DEL OESTE")) return R.drawable.escudo_laperladeloeste;
        else if(nombre.equals("NEWELLS DE SANTA FE")) return R.drawable.portada_newells;
        else if(nombre.equals("SANJUSTINO")) return R.drawable.portada_sanjustino;
        else if(nombre.equals("UNION DE SANTA FE")) return R.drawable.portada_union;
        //else if(nombre.equals("UNL")) return R.drawable.escudo_unl;
        else if(nombre.equals("LA SALLE JOBSON")) return R.drawable.portada_lasalle;
        //else if(nombre.equals("BELGRANO DE CORONDA")) return R.drawable.escudo_belgranodecoronda;
        //else if(nombre.equals("PUCARA")) return R.drawable.escudo_pucara;
        //else if(nombre.equals("INDEPENDIENTE DE SANTO TOME")) return R.drawable.escudo_independiente;
        else return R.drawable.escudo_vacio;
    }
}
