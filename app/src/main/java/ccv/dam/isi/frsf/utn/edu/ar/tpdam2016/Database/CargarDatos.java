package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Equipo;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.FilaPosicion;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Jugador;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Partido;

/**
 * Created by Gabriel on 05/02/2017.
 */

public class CargarDatos {

    private static FirebaseDatabase database = FirebaseDatabase.getInstance();
    private static DatabaseReference posicionBD;

    public static void cargarEquipos(){

        ArrayList<ArrayList<Jugador>> jugadores = new ArrayList<>();
        ArrayList<Jugador> jugadoresArgentino = new ArrayList<>();
        jugadoresArgentino.add(new Jugador("LEIVA","LUIS","ARQ", "a", "ARGENTINO DE SAN CARLOS","T", 2, 1, 0, 4));
        jugadoresArgentino.add(new Jugador("DAMONTE","AGUSTIN","DEF", "b","ARGENTINO DE SAN CARLOS","T",0,1,0,4));
        jugadoresArgentino.add(new Jugador("BERNIA","PABLO","DEF", "b","ARGENTINO DE SAN CARLOS","T",1,0,0,4));
        jugadoresArgentino.add(new Jugador("SALZMAN","ANDRÉS","DEF", "b","ARGENTINO DE SAN CARLOS","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("NUÑEZ","RODRIGO","DEF", "b","ARGENTINO DE SAN CARLOS","T",1,0,1,4));
        jugadoresArgentino.add(new Jugador("LATUFF","JOAQUÍN","MED", "c","ARGENTINO DE SAN CARLOS","T",1,0,0,4));
        jugadoresArgentino.add(new Jugador("IPARRAGUIRRE","NICOLÁS","MED", "c","ARGENTINO DE SAN CARLOS","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("CHAVARINI","MATÍAS","MED", "c","ARGENTINO DE SAN CARLOS","T",1,0,0,4));
        jugadoresArgentino.add(new Jugador("AGUIRRE","FERNANDO","MED", "c","ARGENTINO DE SAN CARLOS","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("SWICH","GABRIEL","MED", "c","ARGENTINO DE SAN CARLOS","S",0,0,0,4));
        jugadoresArgentino.add(new Jugador("CENTANI","MAURO","MED", "c","ARGENTINO DE SAN CARLOS","S",0,0,0,4));
        jugadoresArgentino.add(new Jugador("DEJÓN","DANTE","MED", "c","ARGENTINO DE SAN CARLOS","S",0,0,0,4));
        jugadoresArgentino.add(new Jugador("MARTINEZ","MATÍAS","DEL", "d","ARGENTINO DE SAN CARLOS","T",0,1,0,4));
        jugadoresArgentino.add (new Jugador("FORMENTO","ANDRÉS","DEL", "d","ARGENTINO DE SAN CARLOS","T",0,0,0,4));

        ArrayList<Jugador> jugadoresAteneo = new ArrayList<>();
        jugadoresArgentino.add(new Jugador("JIMENEZ","LUIS","ARQ", "a","ATENEO INMACULADA","T", 0, 1, 0, 4));
        jugadoresArgentino.add(new Jugador("BENITEZ","AGUSTIN","DEF", "b","ATENEO INMACULADA","T",0,1,0,4));
        jugadoresArgentino.add(new Jugador("RODRIGUEZ","PABLO","DEF", "b","ATENEO INMACULADA","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("GONZALEZ","ANDRÉS","DEF", "b","ATENEO INMACULADA","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("ALVAREZ","RODRIGO","DEF", "b","ATENEO INMACULADA","T",0,0,1,4));
        jugadoresArgentino.add(new Jugador("PEREZ","JOAQUÍN","MED", "c","ATENEO INMACULADA","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("CASARSA","GABRIEL JESUS","MED", "c","ATENEO INMACULADA","T",2,0,1,4));
        jugadoresArgentino.add(new Jugador("FERREYRA","MATÍAS","MED", "c","ATENEO INMACULADA","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("SACRIPANTI","FERNANDO","MED", "c","ATENEO INMACULADA","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("OBOLO","GABRIEL","DEL", "d","ATENEO INMACULADA","S",0,0,0,4));
        jugadoresArgentino.add(new Jugador("PERNIA","MAURO","DEL", "d","ATENEO INMACULADA","S",0,0,0,4));
        jugadoresArgentino.add(new Jugador("SCHMIDT","DANTE","DEL", "d","ATENEO INMACULADA","S",0,0,0,4));

        ArrayList<Jugador> jugadoresColon = new ArrayList<>();
        jugadoresArgentino.add(new Jugador("BLAZINA","LUIS","ARQ", "a","COLON DE SANTA FE","T", 0, 1, 0, 4));
        jugadoresArgentino.add(new Jugador("BANZINA","AGUSTIN","DEF", "b","COLON DE SANTA FE","T",0,1,2,4));
        jugadoresArgentino.add(new Jugador("BASSO","PABLO","DEF", "b","COLON DE SANTA FE","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("ZUBIETA","ANDRÉS","DEF", "b","COLON DE SANTA FE","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("GRECCO","RODRIGO","DEF", "b","COLON DE SANTA FE","T",0,0,4,4));
        jugadoresArgentino.add(new Jugador("COLOMBO","JOAQUÍN","MED", "c","COLON DE SANTA FE","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("IMBELLONI","GABRIEL JESUS","MED", "c","COLON DE SANTA FE","T",0,0,1,4));
        jugadoresArgentino.add(new Jugador("FARRO","MATÍAS","MED", "c","COLON DE SANTA FE","T",1,0,0,4));
        jugadoresArgentino.add(new Jugador("PONTONI","FERNANDO","MED", "c","COLON DE SANTA FE","T",1,0,0,4));
        jugadoresArgentino.add(new Jugador("MARTINO","GABRIEL","DEL", "d","COLON DE SANTA FE","S",0,0,0,4));
        jugadoresArgentino.add(new Jugador("SILVA","MAURO","DEL", "d","COLON DE SANTA FE","S",0,0,0,4));
        jugadoresArgentino.add(new Jugador("PRIETTO","LIVIO","DEL", "d","COLON DE SANTA FE","S",1,0,0,4));

        ArrayList<Jugador> jugadoresCosmos = new ArrayList<>();
        jugadoresArgentino.add(new Jugador("PASSET","LUIS","ARQ", "a","COSMOS FC","T", 0, 1, 0, 4));
        jugadoresArgentino.add(new Jugador("RIVADERO","AGUSTIN","DEF", "b","COSMOS FC","T",0,1,0,4));
        jugadoresArgentino.add(new Jugador("MANUSOVICH","PABLO","DEF", "b","COSMOS FC","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("RUGGERI","ANDRÉS","DEF", "b","COSMOS FC","T",0,4,0,4));
        jugadoresArgentino.add(new Jugador("GALETTO","RODRIGO","DEF", "b","COSMOS FC","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("SILAS","JOAQUÍN","MED", "c","COSMOS FC","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("GOROSITO","GABRIEL JESUS","MED", "c","COSMOS FC","T",0,0,1,4));
        jugadoresArgentino.add(new Jugador("BIAGGIO","MATÍAS","MED", "c","COSMOS FC","T",3,0,0,4));
        jugadoresArgentino.add(new Jugador("GONZALEZ","FERNANDO","MED", "c","COSMOS FC","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("MONSERRAT","GABRIEL","DEL", "d","COSMOS FC","S",0,0,0,4));
        jugadoresArgentino.add(new Jugador("AREVALO","MAURO","DEL", "d","COSMOS FC","S",0,0,0,4));
        jugadoresArgentino.add(new Jugador("ARBARELLO","LIVIO","DEL", "d","COSMOS FC","S",0,0,0,4));

        ArrayList<Jugador> jugadoresLaSalle = new ArrayList<>();
        jugadoresArgentino.add(new Jugador("SAJA","LUIS","ARQ", "a","LA SALLE JOBSON","T", 0, 1, 0, 4));
        jugadoresArgentino.add(new Jugador("COLOCCINI","AGUSTIN","DEF", "b","LA SALLE JOBSON","T",1,1,0,4));
        jugadoresArgentino.add(new Jugador("TUZZIO","PABLO","DEF", "b","LA SALLE JOBSON","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("AMELI","ANDRÉS","DEF", "b","LA SALLE JOBSON","T",1,1,0,4));
        jugadoresArgentino.add(new Jugador("SERRIZUELA","RODRIGO","DEF", "b","LA SALLE JOBSON","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("MICHELINI","JOAQUÍN","MED", "c","LA SALLE JOBSON","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("ERVITI","GABRIEL JESUS","MED", "c","LA SALLE JOBSON","T",0,0,1,4));
        jugadoresArgentino.add(new Jugador("ROMAGNOLI","MATÍAS","MED", "c","LA SALLE JOBSON","T",1,0,0,4));
        jugadoresArgentino.add(new Jugador("RODRIGUEZ","FERNANDO","MED", "c","LA SALLE JOBSON","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("ESTEVEZ","GABRIEL","DEL", "d","LA SALLE JOBSON","S",0,0,0,4));
        jugadoresArgentino.add(new Jugador("ROMEO","MAURO","DEL", "d","LA SALLE JOBSON","S",0,0,0,4));
        jugadoresArgentino.add(new Jugador("CASADO","GONZALO","DEL", "d","LA SALLE JOBSON","S",6,0,0,4));

        ArrayList<Jugador> jugadoresNewells = new ArrayList<>();
        jugadoresArgentino.add(new Jugador("BUTTICCE","LUIS","ARQ", "a","NEWELLS DE SANTA FE","T", 0, 1, 0, 4));
        jugadoresArgentino.add(new Jugador("VILLAR","AGUSTIN","DEF", "b","NEWELLS DE SANTA FE","T",1,1,0,4));
        jugadoresArgentino.add(new Jugador("ALBRETCH","PABLO","DEF", "b","NEWELLS DE SANTA FE","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("CALICS","ANDRÉS","DEF", "b","NEWELLS DE SANTA FE","T",1,1,0,4));
        jugadoresArgentino.add(new Jugador("ROSL","RODRIGO","DEF", "b","NEWELLS DE SANTA FE","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("COCCO","JOAQUÍN","MED", "c","NEWELLS DE SANTA FE","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("TELCH","GABRIEL JESUS","MED", "c","NEWELLS DE SANTA FE","T",0,0,1,4));
        jugadoresArgentino.add(new Jugador("RENDO","MATÍAS","MED", "c","NEWELLS DE SANTA FE","T",1,0,0,4));
        jugadoresArgentino.add(new Jugador("GONZALEZ","FERNANDO","MED", "c","NEWELLS DE SANTA FE","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("FISCHER","GABRIEL","DEL", "d","NEWELLS DE SANTA FE","S",0,0,0,4));
        jugadoresArgentino.add(new Jugador("VEGLIO","MAURO","DEL", "d","NEWELLS DE SANTA FE","S",0,0,0,4));
        jugadoresArgentino.add(new Jugador("DE LA MATA","GONZALO","DEL", "d","NEWELLS DE SANTA FE","S",0,0,0,4));

        ArrayList<Jugador> jugadoresSanjustino = new ArrayList<>();
        jugadoresArgentino.add(new Jugador("ROMERO","LUIS","ARQ", "a","SANJUSTINO","T", 0, 1, 0, 4));
        jugadoresArgentino.add(new Jugador("ROJO","AGUSTIN","DEF", "b","SANJUSTINO","T",1,1,0,4));
        jugadoresArgentino.add(new Jugador("OTAMENDI","PABLO","DEF", "b","SANJUSTINO","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("FUNES MORI","ANDRÉS","DEF", "b","SANJUSTINO","T",1,1,0,4));
        jugadoresArgentino.add(new Jugador("BUFFARINI","RODRIGO","DEF", "b","SANJUSTINO","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("BANEGA","JOAQUÍN","MED", "c","SANJUSTINO","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("BIGLIA","GABRIEL","MED", "c","SANJUSTINO","T",0,0,1,4));
        jugadoresArgentino.add(new Jugador("DI MARIA","MATÍAS","MED", "c","SANJUSTINO","T",1,0,0,4));
        jugadoresArgentino.add(new Jugador("MESSI","FERNANDO","MED", "c","SANJUSTINO","T",1,0,0,4));
        jugadoresArgentino.add(new Jugador("PRATTO","GABRIEL","DEL", "d","SANJUSTINO","S",2,0,0,4));
        jugadoresArgentino.add(new Jugador("CORREA","MAURO","DEL", "d","SANJUSTINO","S",0,0,0,4));
        jugadoresArgentino.add(new Jugador("ZAMPEDRI","GONZALO","DEL", "d","SANJUSTINO","S",0,0,0,4));

        ArrayList<Jugador> jugadoresUnion = new ArrayList<>();
        jugadoresArgentino.add(new Jugador("ORION","LUIS","ARQ", "a","UNION DE SANTA FE","T", 0, 1, 0, 4));
        jugadoresArgentino.add(new Jugador("GONZALEZ","AGUSTIN","DEF", "b","UNION DE SANTA FE","T",0,1,0,4));
        jugadoresArgentino.add(new Jugador("MENDEZ","PABLO","DEF", "b","UNION DE SANTA FE","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("TULA","ANDRÉS","DEF", "b","UNION DE SANTA FE","T",0,1,0,4));
        jugadoresArgentino.add(new Jugador("BOTTINELLI","RODRIGO","DEF", "b","UNION DE SANTA FE","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("LEDESMA","JOAQUÍN","MED", "c","UNION DE SANTA FE","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("HIRSIG","GABRIEL","MED", "c","UNION DE SANTA FE","T",0,0,1,4));
        jugadoresArgentino.add(new Jugador("RIVERO","MATÍAS","MED", "c","UNION DE SANTA FE","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("FERREYRA","FERNANDO","MED", "c","UNION DE SANTA FE","T",0,0,0,4));
        jugadoresArgentino.add(new Jugador("LAVEZZI","GABRIEL","DEL", "d","UNION DE SANTA FE","S",1,0,0,4));
        jugadoresArgentino.add(new Jugador("FERNANDEZ","MAURO","DEL", "d","UNION DE SANTA FE","S",0,0,0,4));
        jugadoresArgentino.add(new Jugador("SILVERA","GONZALO","DEL", "d","UNION DE SANTA FE","S",3,0,0,4));


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
                "https://firebasestorage.googleapis.com/v0/b/tpdam2016.appspot.com/o/recursos%2Fprimeradivision%2Fescudos%2Fateneo.png?alt=media&token=8069f740-8137-400b-89ca-bf006c7a4013",
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
                "COSMOS FC",
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

        ArrayList<FilaPosicion> posicionesFilas = new ArrayList<FilaPosicion>();
        posicionesFilas.add(new FilaPosicion("La Salle","7","4","2","1","1","9","4","5",""));
        posicionesFilas.add(new FilaPosicion("Argentino","9","4","3","0","1","6","2","4","1"));
        posicionesFilas.add(new FilaPosicion("Ateneo","4","4","1","1","2","2","6","-4","2"));
        posicionesFilas.add(new FilaPosicion("Newells","3","4","0","3","1","3","5","-2","3"));
        posicionesFilas.add(new FilaPosicion("Cosmos F.C.","5","4","1","2","1","3","4","-1","4"));
        posicionesFilas.add(new FilaPosicion("Sanjustino","7","4","2","1","1","9","6","3","1"));
        posicionesFilas.add(new FilaPosicion("Colon","6","4","2","0","2","3","2","1","6"));
        posicionesFilas.add(new FilaPosicion("Union","2","4","0","2","2","4","7","-3","1"));
        cargarPosiciones(posicionesFilas);


        ArrayList<Partido> partidosArray = new ArrayList<Partido>();
        partidosArray.add(new Partido("0","LA SALLE","NEWELLS","3","1","CASTRILLI","08/02","1","Cabaña Leiva","1"));
        partidosArray.add(new Partido("1","ATENEO","ARGENTINO","0","1","ELIZONDO","08/02","1","Ateneo","1"));
        partidosArray.add(new Partido("2","SANJUSTINO","COSMOS FC","2","0","CEBALLOS","08/02","1","Coloso del Oeste","1"));
        partidosArray.add(new Partido("3","COLON","UNION","2","0","ORTIZ","08/02","1","Brigadier Estanislao López","1"));

        partidosArray.add(new Partido("4","NEWELLS","UNION","1","1","CASTRILLI","15/02","2","Miguel Franconieri","1"));
        partidosArray.add(new Partido("5","COSMOS FC","COLON","1","0","ORTIZ","15/02","2","Liga Santafesina Predio","1"));
        partidosArray.add(new Partido("6","ARGENTINO","SANJUSTINO","2","0","CASTRILLI","15/02","2","12 de Enero","1"));
        partidosArray.add(new Partido("7","LA SALLE","ATENEO","3","0","ORTIZ","22/02","2","Cabaña Leiva","1"));

        partidosArray.add(new Partido("8","ATENEO","NEWELLS","1","1","CEBALLOS","15/02","3","Ateneo","1"));
        partidosArray.add(new Partido("9","SANJUSTINO","LA SALLE","3","2","CASTRILLI","22/02","3","San Justo","1"));
        partidosArray.add(new Partido("10","COLON","ARGENTINO","1","0","ELIZONDO","22/02","3","Brigadier Estanislao Lopez","1"));
        partidosArray.add(new Partido("11","UNION","COSMOS FC","2","2","CASTRILLI","22/02","3","15 de Abril","1"));

        partidosArray.add(new Partido("12","NEWELLS","COSMOS FC","0","0","CASTRILLI","01/03","4","Miguel Franconieri","1"));
        partidosArray.add(new Partido("13","ARGENTINO","UNION","2","1","CEBALLOS","01/03","4","12 de Enero","1"));
        partidosArray.add(new Partido("14","LA SALLE","COLON","1","0","CASTRILLI","01/03","4","Cabaña Leiva","1"));
        partidosArray.add(new Partido("15","ATENEO","SANJUSTINO","1","1","ELIZONDO","01/03","4","Ateneo","1"));

        partidosArray.add(new Partido("16","SANJUSTINO","NEWELLS","","","CASTRILLI","08/03","5","San Justo","0"));
        partidosArray.add(new Partido("17","COLON","ATENEO","","","CASTRILLI","08/03","5","Brigadier Estanislao Lopez","0"));
        partidosArray.add(new Partido("18","UNION","LA SALLE","","","ORTIZ","08/03","5","15 de abril","0"));
        partidosArray.add(new Partido("19","COSMOS FC","ARGENTINO","","","CEBALLOS","08/03","5","Predio Liga","0"));

        partidosArray.add(new Partido("20","NEWELLS","ARGENTINO","","","CASTRILLI","15/03","6","Predio Liga","0"));
        partidosArray.add(new Partido("21","LA SALLE","COSMOS FC","","","ELIZONDO","15/03","6","Cabaña Leiva","0"));
        partidosArray.add(new Partido("22","ATENEO","UNION","","","CEBALLOS","15/03","6","Ateneo","0"));
        partidosArray.add(new Partido("23","SANJUSTINO","COLON","","","CASTRILLI","15/03","6","San Justo","0"));

        partidosArray.add(new Partido("24","COLON","NEWELLS","","","ORTIZ","22/03","7","Brigadier Estanislao Lopez","0"));
        partidosArray.add(new Partido("25","UNION","SANJUSTINO","","","CEBALLOS","22/03","7","15 de abril","0"));
        partidosArray.add(new Partido("26","COSMOS FC","ATENEO","","","CASTRILLI","22/03","7","Cabaña Leiva","0"));
        partidosArray.add(new Partido("27","ARGENTINO","LA SALLE","","","ELIZONDO","22/03","7","12 de enero","0"));

        cargarPartidos(partidosArray);
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


    public static void cargarPartidos(ArrayList<Partido> partidos){
        for(int i = 0; i < partidos.size(); i++) {
            posicionBD = database.getReference("datos");
            Map<String, Object> postValues = toMap(partidos.get(i));
            Map<String, Object> childUpdates = new HashMap<>();
            childUpdates.put("/partidos/" + partidos.get(i).getIdPartido(), postValues);
            posicionBD.updateChildren(childUpdates);
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
        result.put("ordenadorPorPosicion", jugador.getOrdenadorPorPosicion());
        result.put("equipo", jugador.getEquipo());
        result.put("titular", jugador.getTitular());
        result.put("goles", jugador.getGoles());
        result.put("amarillas", jugador.getAmarillas());
        result.put("rojas", jugador.getRojas());
        result.put("partidosJugados", jugador.getPartidosJugados());
        return result;
    }


    public static Map<String, Object> toMap(Partido partidos) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("arbitro", partidos.getArbitro());
        result.put("dia", partidos.getDia());
        result.put("equipoLocal", partidos.getEquipoLocal());
        result.put("equipoVisitante", partidos.getEquipoVisitante());
        result.put("estadio", partidos.getLugar());
        result.put("fecha", partidos.getFecha());
        result.put("resultadoLocal", partidos.getResultadoLocal());
        result.put("resultadoVisitante", partidos.getResultadoVisitante());
        result.put("id", partidos.getIdPartido());
        result.put("partidoDisputado",partidos.getPartidoDisputado());
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
