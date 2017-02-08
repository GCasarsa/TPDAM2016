package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Equipo;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.FilaPosicion;
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
        jugadoresArgentino.add(new Jugador("LEIVA","LUIS","A","ARGENTINO DE SAN CARLOS","T", 2, 1, 0, 4));
        jugadoresArgentino.add(new Jugador("DAMONTE","AGUSTIN","D","ARGENTINO DE SAN CARLOS","T",0,1,0,4));
        jugadoresArgentino.add(new Jugador("BERNIA","PABLO","D","ARGENTINO DE SAN CARLOS","T",1,0,0,4));
        jugadoresArgentino.add(new Jugador("SALZMAN","ANDRÉS","D","ARGENTINO DE SAN CARLOS","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("NUÑEZ","RODRIGO","D","ARGENTINO DE SAN CARLOS","T",1,0,1,4));
        jugadoresArgentino.add(new Jugador("LATUFF","JOAQUÍN","M","ARGENTINO DE SAN CARLOS","T",1,0,0,4));
        jugadoresArgentino.add(new Jugador("IPARRAGUIRRE","NICOLÁS","M","ARGENTINO DE SAN CARLOS","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("CHAVARINI","MATÍAS","M","ARGENTINO DE SAN CARLOS","T",1,0,0,4));
        jugadoresArgentino.add(new Jugador("AGUIRRE","FERNANDO","M","ARGENTINO DE SAN CARLOS","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("SWICH","GABRIEL","M","ARGENTINO DE SAN CARLOS","S",0,0,0,4));
        jugadoresArgentino.add(new Jugador("CENTANI","MAURO","M","ARGENTINO DE SAN CARLOS","S",0,0,0,4));
        jugadoresArgentino.add(new Jugador("DEJÓN","DANTE","M","ARGENTINO DE SAN CARLOS","S",0,0,0,4));
        jugadoresArgentino.add(new Jugador("MARTINEZ","MATÍAS","F","ARGENTINO DE SAN CARLOS","T",0,1,0,4));
        jugadoresArgentino.add (new Jugador("FORMENTO","ANDRÉS","F","ARGENTINO DE SAN CARLOS","T",0,0,0,4));

        ArrayList<Jugador> jugadoresAteneo = new ArrayList<>();
        jugadoresArgentino.add(new Jugador("JIMENEZ","LUIS","A","ATENEO INMACULADA","T", 0, 1, 0, 4));
        jugadoresArgentino.add(new Jugador("BENITEZ","AGUSTIN","D","ATENEO INMACULADA","T",0,1,0,4));
        jugadoresArgentino.add(new Jugador("RODRIGUEZ","PABLO","D","ATENEO INMACULADA","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("GONZALEZ","ANDRÉS","D","ATENEO INMACULADA","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("ALVAREZ","RODRIGO","D","ATENEO INMACULADA","T",0,0,1,4));
        jugadoresArgentino.add(new Jugador("PEREZ","JOAQUÍN","M","ATENEO INMACULADA","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("CASARSA","GABRIEL JESUS","M","ATENEO INMACULADA","T",2,0,1,4));
        jugadoresArgentino.add(new Jugador("FERREYRA","MATÍAS","M","ATENEO INMACULADA","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("SACRIPANTI","FERNANDO","M","ATENEO INMACULADA","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("OBOLO","GABRIEL","M","ATENEO INMACULADA","S",0,0,0,4));
        jugadoresArgentino.add(new Jugador("PERNIA","MAURO","M","ATENEO INMACULADA","S",0,0,0,4));
        jugadoresArgentino.add(new Jugador("SCHMIDT","DANTE","M","ATENEO INMACULADA","S",0,0,0,4));

        ArrayList<Jugador> jugadoresColon = new ArrayList<>();
        jugadoresArgentino.add(new Jugador("BLAZINA","LUIS","A","COLON DE SANTA FE","T", 0, 1, 0, 4));
        jugadoresArgentino.add(new Jugador("BANZINA","AGUSTIN","D","COLON DE SANTA FE","T",0,1,2,4));
        jugadoresArgentino.add(new Jugador("BASSO","PABLO","D","COLON DE SANTA FE","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("ZUBIETA","ANDRÉS","D","COLON DE SANTA FE","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("GRECCO","RODRIGO","D","COLON DE SANTA FE","T",0,0,4,4));
        jugadoresArgentino.add(new Jugador("COLOMBO","JOAQUÍN","M","COLON DE SANTA FE","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("IMBELLONI","GABRIEL JESUS","M","COLON DE SANTA FE","T",0,0,1,4));
        jugadoresArgentino.add(new Jugador("FARRO","MATÍAS","M","COLON DE SANTA FE","T",1,0,0,4));
        jugadoresArgentino.add(new Jugador("PONTONI","FERNANDO","M","COLON DE SANTA FE","T",1,0,0,4));
        jugadoresArgentino.add(new Jugador("MARTINO","GABRIEL","M","COLON DE SANTA FE","S",0,0,0,4));
        jugadoresArgentino.add(new Jugador("SILVA","MAURO","M","COLON DE SANTA FE","S",0,0,0,4));
        jugadoresArgentino.add(new Jugador("PRIETTO","LIVIO","M","COLON DE SANTA FE","S",1,0,0,4));

        ArrayList<Jugador> jugadoresCosmos = new ArrayList<>();
        jugadoresArgentino.add(new Jugador("PASSET","LUIS","A","COSMOS FC","T", 0, 1, 0, 4));
        jugadoresArgentino.add(new Jugador("RIVADERO","AGUSTIN","D","COSMOS FC","T",0,1,0,4));
        jugadoresArgentino.add(new Jugador("MANUSOVICH","PABLO","D","COSMOS FC","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("RUGGERI","ANDRÉS","D","COSMOS FC","T",0,4,0,4));
        jugadoresArgentino.add(new Jugador("GALETTO","RODRIGO","D","COSMOS FC","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("SILAS","JOAQUÍN","M","COSMOS FC","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("GOROSITO","GABRIEL JESUS","M","COSMOS FC","T",0,0,1,4));
        jugadoresArgentino.add(new Jugador("BIAGGIO","MATÍAS","M","COSMOS FC","T",3,0,0,4));
        jugadoresArgentino.add(new Jugador("GONZALEZ","FERNANDO","M","COSMOS FC","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("MONSERRAT","GABRIEL","M","COSMOS FC","S",0,0,0,4));
        jugadoresArgentino.add(new Jugador("AREVALO","MAURO","M","COSMOS FC","S",0,0,0,4));
        jugadoresArgentino.add(new Jugador("ARBARELLO","LIVIO","M","COSMOS FC","S",0,0,0,4));

        ArrayList<Jugador> jugadoresLaSalle = new ArrayList<>();
        jugadoresArgentino.add(new Jugador("SAJA","LUIS","A","LA SALLE JOBSON","T", 0, 1, 0, 4));
        jugadoresArgentino.add(new Jugador("COLOCCINI","AGUSTIN","D","LA SALLE JOBSON","T",1,1,0,4));
        jugadoresArgentino.add(new Jugador("TUZZIO","PABLO","D","LA SALLE JOBSON","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("AMELI","ANDRÉS","D","LA SALLE JOBSON","T",1,1,0,4));
        jugadoresArgentino.add(new Jugador("SERRIZUELA","RODRIGO","D","LA SALLE JOBSON","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("MICHELINI","JOAQUÍN","M","LA SALLE JOBSON","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("ERVITI","GABRIEL JESUS","M","LA SALLE JOBSON","T",0,0,1,4));
        jugadoresArgentino.add(new Jugador("ROMAGNOLI","MATÍAS","M","LA SALLE JOBSON","T",1,0,0,4));
        jugadoresArgentino.add(new Jugador("RODRIGUEZ","FERNANDO","M","LA SALLE JOBSON","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("ESTEVEZ","GABRIEL","M","LA SALLE JOBSON","S",0,0,0,4));
        jugadoresArgentino.add(new Jugador("ROMEO","MAURO","M","LA SALLE JOBSON","S",0,0,0,4));
        jugadoresArgentino.add(new Jugador("CASADO","GONZALO","M","LA SALLE JOBSON","S",6,0,0,4));

        ArrayList<Jugador> jugadoresNewells = new ArrayList<>();
        jugadoresArgentino.add(new Jugador("BUTTICCE","LUIS","A","NEWELLS DE SANTA FE","T", 0, 1, 0, 4));
        jugadoresArgentino.add(new Jugador("VILLAR","AGUSTIN","D","NEWELLS DE SANTA FE","T",1,1,0,4));
        jugadoresArgentino.add(new Jugador("ALBRETCH","PABLO","D","NEWELLS DE SANTA FE","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("CALICS","ANDRÉS","D","NEWELLS DE SANTA FE","T",1,1,0,4));
        jugadoresArgentino.add(new Jugador("ROSL","RODRIGO","D","NEWELLS DE SANTA FE","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("COCCO","JOAQUÍN","M","NEWELLS DE SANTA FE","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("TELCH","GABRIEL JESUS","M","NEWELLS DE SANTA FE","T",0,0,1,4));
        jugadoresArgentino.add(new Jugador("RENDO","MATÍAS","M","NEWELLS DE SANTA FE","T",1,0,0,4));
        jugadoresArgentino.add(new Jugador("GONZALEZ","FERNANDO","M","NEWELLS DE SANTA FE","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("FISCHER","GABRIEL","M","NEWELLS DE SANTA FE","S",0,0,0,4));
        jugadoresArgentino.add(new Jugador("VEGLIO","MAURO","M","NEWELLS DE SANTA FE","S",0,0,0,4));
        jugadoresArgentino.add(new Jugador("DE LA MATA","GONZALO","M","NEWELLS DE SANTA FE","S",0,0,0,4));

        ArrayList<Jugador> jugadoresSanjustino = new ArrayList<>();
        jugadoresArgentino.add(new Jugador("ROMERO","LUIS","A","SANJUSTINO","T", 0, 1, 0, 4));
        jugadoresArgentino.add(new Jugador("ROJO","AGUSTIN","D","SANJUSTINO","T",1,1,0,4));
        jugadoresArgentino.add(new Jugador("OTAMENDI","PABLO","D","SANJUSTINO","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("FUNES MORI","ANDRÉS","D","SANJUSTINO","T",1,1,0,4));
        jugadoresArgentino.add(new Jugador("BUFFARINI","RODRIGO","D","SANJUSTINO","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("BANEGA","JOAQUÍN","M","SANJUSTINO","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("BIGLIA","GABRIEL","M","SANJUSTINO","T",0,0,1,4));
        jugadoresArgentino.add(new Jugador("DI MARIA","MATÍAS","M","SANJUSTINO","T",1,0,0,4));
        jugadoresArgentino.add(new Jugador("MESSI","FERNANDO","M","SANJUSTINO","T",1,0,0,4));
        jugadoresArgentino.add(new Jugador("PRATTO","GABRIEL","M","SANJUSTINO","S",2,0,0,4));
        jugadoresArgentino.add(new Jugador("CORREA","MAURO","M","SANJUSTINO","S",0,0,0,4));
        jugadoresArgentino.add(new Jugador("ZAMPEDRI","GONZALO","M","SANJUSTINO","S",0,0,0,4));

        ArrayList<Jugador> jugadoresUnion = new ArrayList<>();
        jugadoresArgentino.add(new Jugador("ORION","LUIS","A","UNION DE SANTA FE","T", 0, 1, 0, 4));
        jugadoresArgentino.add(new Jugador("GONZALEZ","AGUSTIN","D","UNION DE SANTA FE","T",0,1,0,4));
        jugadoresArgentino.add(new Jugador("MENDEZ","PABLO","D","UNION DE SANTA FE","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("TULA","ANDRÉS","D","UNION DE SANTA FE","T",0,1,0,4));
        jugadoresArgentino.add(new Jugador("BOTTINELLI","RODRIGO","D","UNION DE SANTA FE","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("LEDESMA","JOAQUÍN","M","UNION DE SANTA FE","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("HIRSIG","GABRIEL","M","UNION DE SANTA FE","T",0,0,1,4));
        jugadoresArgentino.add(new Jugador("RIVERO","MATÍAS","M","UNION DE SANTA FE","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("FERREYRA","FERNANDO","M","UNION DE SANTA FE","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("LAVEZZI","GABRIEL","M","UNION DE SANTA FE","S",1,0,0,4));
        jugadoresArgentino.add(new Jugador("FERNANDEZ","MAURO","M","UNION DE SANTA FE","S",0,0,0,4));
        jugadoresArgentino.add(new Jugador("SILVERA","GONZALO","M","UNION DE SANTA FE","S",3,0,0,4));


        jugadores.add(jugadoresArgentino);
        jugadores.add(jugadoresAteneo);
        jugadores.add(jugadoresColon);
        jugadores.add(jugadoresCosmos);
        jugadores.add(jugadoresLaSalle);
        jugadores.add(jugadoresNewells);
        jugadores.add(jugadoresSanjustino);
        jugadores.add(jugadoresUnion);

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
                "ATENEO INMACULADA",
                "ATENEO",
                "https://firebasestorage.googleapis.com/v0/b/tpdam2016.appspot.com/o/recursos%2Fprimeradivision%2Fescudos%2Fnewells.png?alt=media&token=23b8edc9-85a4-45eb-ad1d-8c72e8bfe8e5",
                "PRIMERA A",
                "SANTA FE",
                "https://firebasestorage.googleapis.com/v0/b/tpdam2016.appspot.com/o/recursos%2Fprimeradivision%2Ffoto%2Fargentino.png",
                -31.623983,
                -60.746279,
                "ATENEO",
                "ALFREDO DIPANCRACIO"
        ));

        listaEquipos.add(new Equipo("3",
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

        listaEquipos.add(new Equipo("4",
                "COSMOS FC",
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
                "LA SALLE JOBSON",
                "LA SALLE",
                "https://firebasestorage.googleapis.com/v0/b/tpdam2016.appspot.com/o/recursos%2Fprimeradivision%2Fescudos%2Flasalle.png?alt=media&token=5dfab3c8-104d-4e64-ac94-8a7df5ce12bc",
                "PRIMERA A",
                "SANTA FE",
                "https://firebasestorage.googleapis.com/v0/b/tpdam2016.appspot.com/o/recursos%2Fprimeradivision%2Ffoto%2Fargentino.png",
                -31.565247,
                -60.722321,
                "CABAÑA LEIVA",
                "REYNALDO BONESSO"
        ));


        listaEquipos.add(new Equipo("6",
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


        listaEquipos.add(new Equipo("7",
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

        listaEquipos.add(new Equipo("8",
                "UNION DE SANTA FE",
                "UNION",
                "https://firebasestorage.googleapis.com/v0/b/tpdam2016.appspot.com/o/recursos%2Fprimeradivision%2Fescudos%2Funion.png?alt=media&token=2160f7db-ba81-4b88-aa05-3597075142df",
                "PRIMERA A",
                "SANTA FE",
                "https://firebasestorage.googleapis.com/v0/b/tpdam2016.appspot.com/o/recursos%2Fprimeradivision%2Ffoto%2Fargentino.png",
                -31.631797,
                -60.716925,
                "15 DE ABRIL",
                "ARIEL DONNET"
        ));


        for(int i = 0; i < listaEquipos.size(); i++){
            posicionBD = database.getReference("datos");
            Map<String, Object> postValues = toMap(listaEquipos.get((i)));
            Map<String, Object> childUpdates = new HashMap<>();
            childUpdates.put("/equipos/primeradivision/" + listaEquipos.get((i)).getId(), postValues);
            posicionBD.updateChildren(childUpdates);
        }

        ArrayList<FilaPosicion> posicionesFilas = new ArrayList<>();
        posicionesFilas.add(new FilaPosicion("La Salle","7","4","2","1","1","9","4","5","0"));
        posicionesFilas.add(new FilaPosicion("Argentino","9","4","3","0","1","6","2","4","1"));
        posicionesFilas.add(new FilaPosicion("Ateneo","4","4","1","1","2","2","6","-4","2"));
        posicionesFilas.add(new FilaPosicion("Newells","3","4","0","3","1","3","5","-2","3"));
        posicionesFilas.add(new FilaPosicion("Cosmos F.C.","5","4","1","2","1","3","4","-1","4"));
        posicionesFilas.add(new FilaPosicion("Sanjustino","7","4","2","1","1","9","6","5","1"));
        posicionesFilas.add(new FilaPosicion("Colon","6","4","2","0","2","3","2","1","6"));
        posicionesFilas.add(new FilaPosicion("Union","2","4","0","2","2","4","7","-3","1"));
        cargarPosiciones(posicionesFilas);
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
        result.put("id", equipo.getId());
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

    public static void cargarPosiciones(ArrayList<FilaPosicion> posiciones){
        for(int i = 0; i < posiciones.size(); i++) {
            posicionBD = database.getReference("datos");
            Map<String, Object> postValues = toMap(posiciones.get(i));
            Map<String, Object> childUpdates = new HashMap<>();
            childUpdates.put("/posiciones/" + posiciones.get(i).getEquipo(), postValues);
            posicionBD.updateChildren(childUpdates);
        }
    }


    public static Map<String, Object> toMap(FilaPosicion filaPosiciones) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("DIF", filaPosiciones.getDif());
        result.put("EQUIPO", filaPosiciones.getEquipo());
        result.put("GC", filaPosiciones.getGc());
        result.put("GF", filaPosiciones.getGf());
        result.put("PE", filaPosiciones.getPe());
        result.put("PG", filaPosiciones.getPg());
        result.put("PP", filaPosiciones.getPp());
        result.put("PJ", filaPosiciones.getPj());
        result.put("PTS", filaPosiciones.getPts());
        return result;
    }

}
