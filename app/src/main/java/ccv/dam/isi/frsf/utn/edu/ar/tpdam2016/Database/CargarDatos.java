package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Equipo;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Jugador;

/**
 * Created by Gabriel on 05/02/2017.
 */

public class CargarDatos {

    private static FirebaseDatabase database = FirebaseDatabase.getInstance();
    private static DatabaseReference posicionBD;

    public static void cargarEquipos(){
        ArrayList<ArrayList<Jugador>> jugadores = new ArrayList<>();
        ArrayList<Jugador> jugadoresArgentino = new ArrayList<>();
        jugadoresArgentino.add(new Jugador("LEIVA","LUIS","A","ARGENTINO DE SAN CARLOS","T"));
        jugadoresArgentino.add(new Jugador("DAMONTE","AGUSTIN","D","ARGENTINO DE SAN CARLOS","T"));
        jugadoresArgentino.add(new Jugador("BERNIA","PABLO","D","ARGENTINO DE SAN CARLOS","T"));
        jugadoresArgentino.add(new Jugador("SALZMAN","A","D","ARGENTINO DE SAN CARLOS","T"));
        jugadoresArgentino.add(new Jugador("NUÑEZ","RODRIGO","D","ARGENTINO DE SAN CARLOS","T"));
        jugadoresArgentino.add(new Jugador("LATUFF","JOAQUÍN","M","ARGENTINO DE SAN CARLOS","T"));
        jugadoresArgentino.add(new Jugador("IPARRAGUIRRE","NICOLÁS","M","ARGENTINO DE SAN CARLOS","T"));
        jugadoresArgentino.add(new Jugador("CHAVARINI","MATÍAS","M","ARGENTINO DE SAN CARLOS","T"));
        jugadoresArgentino.add(new Jugador("AGUIRRE","FERNANDO","M","ARGENTINO DE SAN CARLOS","T"));
        jugadoresArgentino.add(new Jugador("SWICH","GABRIEL","M","ARGENTINO DE SAN CARLOS","S"));
        jugadoresArgentino.add(new Jugador("CENTANI","MAURO","M","ARGENTINO DE SAN CARLOS","S"));
        jugadoresArgentino.add(new Jugador("DEJÓN","DANTE","M","ARGENTINO DE SAN CARLOS","S"));
        jugadoresArgentino.add(new Jugador("MARTINEZ","MATÍAS","F","ARGENTINO DE SAN CARLOS","T"));
        jugadoresArgentino.add(new Jugador("FORMENTO","ANDRÉS","F","ARGENTINO DE SAN CARLOS","T"));
        jugadores.add(jugadoresArgentino);
        cargarJugadores(jugadores);
        ArrayList<Equipo> listaEquipos = new ArrayList<>();
        listaEquipos.add(new Equipo("1",
                "ARGENTINO DE SAN CARLOS",
                "ARGENTINO",
                "https://firebasestorage.googleapis.com/v0/b/tpdam2016.appspot.com/o/recursos%2Fprimeradivision%2Fescudos%2Fargentinodesancarlos.png?alt=media&token=71c06334-6990-4961-8d24-106ac38bacfc",
                "PRIMERA A",
                "SAN CARLOS",
                "https://firebasestorage.googleapis.com/v0/b/tpdam2016.appspot.com/o/recursos%2Fprimeradivision%2Ffoto%2Fargentino.png",
                -31.719082,
                -61.094112,
                "12 DE ENERO",
                "RAÚL FRANCISCO FERRERO"
        ));

        listaEquipos.add(new Equipo("2",
                "COLON DE SANTA FE",
                "COLON",
                "https://firebasestorage.googleapis.com/v0/b/tpdam2016.appspot.com/o/recursos%2Fprimeradivision%2Fescudos%2Fcolon.png?alt=media&token=22f8769e-3a78-440b-b58c-22816d329af4",
                "PRIMERA A",
                "SANTA FE",
                "https://firebasestorage.googleapis.com/v0/b/tpdam2016.appspot.com/o/recursos%2Fprimeradivision%2Ffoto%2Fargentino.png",
                -31.662614,
                -60.726503,
                "ESTANISLAO LÓPEZ",
                "PABLO BONAVERI"
        ));

        listaEquipos.add(new Equipo("3",
                "COSMOS F.C.",
                "COSMOS",
                "https://firebasestorage.googleapis.com/v0/b/tpdam2016.appspot.com/o/recursos%2Fprimeradivision%2Fescudos%2Fclubcosmos.png?alt=media&token=35f0361b-a12a-407f-ae28-bfa6c5f09a21",
                "PRIMERA A",
                "SANTA FE",
                "https://firebasestorage.googleapis.com/v0/b/tpdam2016.appspot.com/o/recursos%2Fprimeradivision%2Ffoto%2Fargentino.png",
                -31.584166,
                -60.684882,
                "LIGA SANTAFESINA",
                "LEANDRO BIROLLO"
        ));

        listaEquipos.add(new Equipo("4",
                "COSMOS F.C.",
                "COSMOS",
                "https://firebasestorage.googleapis.com/v0/b/tpdam2016.appspot.com/o/recursos%2Fprimeradivision%2Fescudos%2Fclubcosmos.png?alt=media&token=35f0361b-a12a-407f-ae28-bfa6c5f09a21",
                "PRIMERA A",
                "SANTA FE",
                "https://firebasestorage.googleapis.com/v0/b/tpdam2016.appspot.com/o/recursos%2Fprimeradivision%2Ffoto%2Fargentino.png",
                -31.584166,
                -60.684882,
                "LIGA SANTAFESINA",
                "LEANDRO BIROLLO"
        ));

        listaEquipos.add(new Equipo("5",
                "NEWELLS DE SANTA FE",
                "NEWELLS",
                "https://firebasestorage.googleapis.com/v0/b/tpdam2016.appspot.com/o/recursos%2Fprimeradivision%2Fescudos%2Fnewells.png?alt=media&token=23b8edc9-85a4-45eb-ad1d-8c72e8bfe8e5",
                "PRIMERA A",
                "SANTA FE",
                "https://firebasestorage.googleapis.com/v0/b/tpdam2016.appspot.com/o/recursos%2Fprimeradivision%2Ffoto%2Fargentino.png",
                -31.645053,
                -60.726395,
                "MIGUEL FRANCONIERI",
                "DARIO SABENA"
        ));

        listaEquipos.add(new Equipo("6",
                "SANJUSTINO",
                "SANJUSTINO",
                "https://firebasestorage.googleapis.com/v0/b/tpdam2016.appspot.com/o/recursos%2Fprimeradivision%2Fescudos%2Fsanjustino.png?alt=media&token=4a20e9be-34b1-4365-a7d7-b3bbd07da148",
                "PRIMERA A",
                "SAN JUSTO",
                "https://firebasestorage.googleapis.com/v0/b/tpdam2016.appspot.com/o/recursos%2Fprimeradivision%2Ffoto%2Fargentino.png",
                -30.788142,
                -60.600725,
                "COLOSO DEL OESTE",
                "SEBASTIÁN BUENO"
        ));


        for(int i = 0; i < listaEquipos.size(); i++){
            posicionBD = database.getReference("datos");
            Map<String, Object> postValues = toMap(listaEquipos.get((i)));
            Map<String, Object> childUpdates = new HashMap<>();
            childUpdates.put("/equipos/primeradivision/" + listaEquipos.get((i)).getId(), postValues);
            posicionBD.updateChildren(childUpdates);
        }
    }

    public static void cargarJugadores(ArrayList<ArrayList<Jugador>> jugadores){
        for(int i = 0; i < jugadores.size(); i++){
            for(int j = 0; j<jugadores.get(i).size(); j++){
                posicionBD = database.getReference("datos");
                Map<String, Object> postValues = toMap(jugadores.get(i).get(j));
                Map<String, Object> childUpdates = new HashMap<>();
                childUpdates.put("/jugadores/" + jugadores.get(i).get(j).getId(), postValues);
                posicionBD.updateChildren(childUpdates);
            }
        }
    }

/*
    class DownloadImageTask extends AsyncTask<String, Void, Drawable> {

        protected void onPreExecute() {
        }
        protected Drawable doInBackground(String... urls) {
            Log.d("DEBUG", "drawable");
            return downloadImage(urls[0]);
        }
        protected void onPostExecute(Drawable imagen) {
            imagenView.setImageDrawable(imagen);
        }

        private Drawable downloadImage(String imageUrl) {
            try {
                URL url = new URL(imageUrl);
                InputStream is = (InputStream)url.getContent();
                return Drawable.createFromStream(is, "src");
            }
            catch (MalformedURLException e) {
                e.printStackTrace();
                return null;
            }
            catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
    */


    public static Map<String, Object> toMap(Equipo equipo) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("nombre", equipo.getNombre());
        result.put("abreviatura", equipo.getAbreviatura());
        result.put("escudo", equipo.getEscudo());
        result.put("division", equipo.getDivision());
        result.put("ciudad", equipo.getCiudad());
        result.put("foto", equipo.getFoto());
        result.put("latitud", equipo.getLatitud());
        result.put("longitud", equipo.getLongitud());
        result.put("descripcionEstadio", equipo.getDescripcionEstadio());
        result.put("directorTecnico", equipo.getDirectorTecnico());
        return result;
    }

    public static Map<String, Object> toMap(Jugador jugador) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("id", jugador.getId());
        result.put("nombre", jugador.getNombre());
        result.put("apellido", jugador.getApellido());
        result.put("posicion", jugador.getPosicion());
        result.put("equipo", jugador.getEquipo());
        result.put("titular", jugador.getTitular());
        result.put("goles", jugador.getGoles());
        result.put("amarillas", jugador.getAmarillas());
        result.put("rojas", jugador.getRojas());
        result.put("partidosJugados", jugador.getPartidosJugados());
        return result;
    }

}
