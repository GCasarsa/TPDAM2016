package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Equipo;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Jugador;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Partido;

public class Conexion {
    private static FirebaseDatabase database = FirebaseDatabase.getInstance();
    private static DatabaseReference posicionBD;

    public Conexion(){
    }

    public static void buscarEquipos(final ArrayList<Equipo> listaEquipos){
        posicionBD = database.getReference("bd/equipos");
        posicionBD.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                Map<String, Object> newPost = (Map<String, Object>) snapshot.getValue();
                Equipo equipo = new Equipo(newPost.get("id").toString(),newPost.get("nombre").toString(), newPost.get("escudo").toString(),newPost.get("division").toString());
                listaEquipos.add(equipo);
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {}
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}
            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });
    }

    public static void buscarEquipo(final String idEquipo){
        posicionBD = database.getReference("bd/equipos");
        posicionBD.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                Map<String, Object> newPost = (Map<String, Object>) snapshot.getValue();
                if(newPost.get("id") == idEquipo){
                    Equipo equipo = new Equipo(newPost.get("id").toString(),newPost.get("nombre").toString(), newPost.get("escudo").toString(),newPost.get("division").toString());
                }

            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {}
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}
            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });
    }

    public static void buscarPartidos(final ArrayList<Partido> listaPartidos){
        posicionBD = database.getReference("partidos");
        posicionBD.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                Map<String, Object> newPost = (Map<String, Object>) snapshot.getValue();
                Partido partido = new Partido(newPost.get("equipoLocal").toString(),newPost.get("equipoVisitante").toString(), newPost.get("marcadorLocal").toString(),newPost.get("marcadorVisitante").toString(),newPost.get("arbitro").toString(),newPost.get("fechaCronologica").toString(),newPost.get("jornadaTorneo").toString(),newPost.get("estadio").toString());
                listaPartidos.add(partido);
                System.out.println(listaPartidos.size());
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {}
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}
            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });
    }

    public static void buscarJugadores(final ArrayList<Jugador> listaJugadores){
        posicionBD = database.getReference("jugadores");
        posicionBD.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                Map<String, Object> newPost = (Map<String, Object>) snapshot.getValue();
                Jugador jugador = new Jugador(newPost.get("ApellidoNombre").toString(),(long)newPost.get("goles"), (long)newPost.get("Amarillas"),(long)newPost.get("Rojas"),(long)newPost.get("equipoID"));
                listaJugadores.add(jugador);
                System.out.println(listaJugadores.size());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {}
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}
            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });
    }

    public static void buscarPartidosPorFecha(final ArrayList<Partido> listaPartidos, final int fecha){
        posicionBD = database.getReference("partidos");
        posicionBD.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                Map<String, Object> newPost = (Map<String, Object>) snapshot.getValue();
                //System.out.println("FECHA 1: " + fecha + " - FECHA 2: "+Integer.parseInt(newPost.get("jornadaTorneo").toString()));
                if(Integer.parseInt(newPost.get("jornadaTorneo").toString())==fecha) {
                    Partido partido = new Partido(newPost.get("equipoLocal").toString(), newPost.get("equipoVisitante").toString(), newPost.get("marcadorLocal").toString(), newPost.get("marcadorVisitante").toString(), newPost.get("arbitro").toString(), newPost.get("fechaCronologica").toString(), newPost.get("jornadaTorneo").toString(), newPost.get("estadio").toString());
                    listaPartidos.add(partido);
                }
                //System.out.println("PARTIDOS: " + listaPartidos.size());
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {}
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}
            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });
    }

    public static void buscarPartidosPorEquipo(final ArrayList<Partido> listaPartidos, final String nombre){
        posicionBD = database.getReference("partidos");
        posicionBD.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                Map<String, Object> newPost = (Map<String, Object>) snapshot.getValue();
                if(newPost.get("equipoLocal").toString().equals(nombre) || newPost.get("equipoVisitante").toString().equals(nombre)) {
                    Partido partido = new Partido(newPost.get("equipoLocal").toString(), newPost.get("equipoVisitante").toString(), newPost.get("marcadorLocal").toString(), newPost.get("marcadorVisitante").toString(), newPost.get("arbitro").toString(), newPost.get("fechaCronologica").toString(), newPost.get("jornadaTorneo").toString(), newPost.get("estadio").toString());
                    listaPartidos.add(partido);
                }
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {}
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}
            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });
    }

    public static void cargarEquipos(){
        posicionBD = database.getReference("bd");
        ArrayList<Equipo> listaEquipos = new ArrayList<>();
        listaEquipos.add(new Equipo("1","Aldosivi","aldosivi.png","PRIMERA DIVISIÓN", "MAR DEL PLATA", "ARGENTINA","",-38.017944,-57.582333,"Estadio José María Minella"));
        listaEquipos.add(new Equipo("2","Arsenal de Sarandí","arsenal.png","PRIMERA DIVISIÓN", "CAPITAL FEDERAL", "ARGENTINA","",-34.678333, -58.340278,"Estadio Julio Humberto Grondona"));
        listaEquipos.add(new Equipo("3","Banfield","banfield.png","PRIMERA DIVISIÓN", "CAPITAL FEDERAL", "ARGENTINA","",-34.750847, -58.387544,"Estadio Florencio Sola"));
        listaEquipos.add(new Equipo("4","Belgrano","belgrano.png","PRIMERA DIVISIÓN", "CORDOBA", "ARGENTINA", "", -31.368956, -64.246244, "Estadio Mario Alberto Kempes"));
        listaEquipos.add(new Equipo("5","Boca Juniors","boca.png","PRIMERA DIVISIÓN", "CAPITAL FEDERAL", "ARGENTINA", "",-34.63565, -58.36465 , "Estadio Alberto J. Armando"));
        listaEquipos.add(new Equipo("6","Rosario Central","central.png","PRIMERA DIVISIÓN", "ROSARIO", "ARGENTINA", "",-32.913997, -60.674567 , "Estadio Gigante de Arroyito"));
        listaEquipos.add(new Equipo("7","Colon de Santa Fe","colon.png","PRIMERA DIVISIÓN", "SANTA FE", "ARGENTINA", "",-31.663217, -60.725394 , "Estadio Brigadier General Estanislao López"));
        listaEquipos.add(new Equipo("8","Defensa y Justicia","defensa.png","PRIMERA DIVISIÓN", "FLORENCIO VARELA", "ARGENTINA", "",-34.821753, -58.286511 , "Estadio Norberto Tomaghello"));
        listaEquipos.add(new Equipo("9","Estudiantes de la Plata","estudiantes.png","PRIMERA DIVISIÓN", "LA PLATA", "ARGENTINA","",-34.91375, -57.989028,"Estadio Ciudad de la Plata"));
        listaEquipos.add(new Equipo("10","Gimnasia de la Plata","gimnasia.png","PRIMERA DIVISIÓN", "LA PLATA", "ARGENTINA","",-34.91375, -57.989028,"Estadio Ciudad de la Plata"));
        listaEquipos.add(new Equipo("11","Godoy Cruz","godoy.png","PRIMERA DIVISIÓN", "MENDOZA", "ARGENTINA", "",-32.889564, -68.879994 , "Estadio Malvinas Argentinas"));
        listaEquipos.add(new Equipo("12","Huracan","huracan.png","PRIMERA DIVISIÓN", "CAPITAL FEDERAL", "ARGENTINA", "", -34.643494, -58.396511, "Estadio Tomás Adolfo Ducó"));
        listaEquipos.add(new Equipo("13","Independiente","independiente.png","PRIMERA DIVISIÓN", "AVELLANEDA", "ARGENTINA","",-34.670267, -58.370969,"Estadio Libertadores de América"));
        listaEquipos.add(new Equipo("14","Lanus","lanus.png","PRIMERA DIVISIÓN", "LANUS", "ARGENTINA","",-34.717667, -58.383806,"Estadio La Fortaleza"));
        listaEquipos.add(new Equipo("15","Newells Old Boys","newells.png","PRIMERA DIVISIÓN", "ROSARIO", "ARGENTINA", "",-32.956056, -60.661444 , "Estadio Marcelo Bielsa"));
        listaEquipos.add(new Equipo("16","Racing Club","racing.png","PRIMERA DIVISIÓN", "AVELLANEDA", "ARGENTINA","",-34.6675, -58.368611,"Estadio Presidente Perón"));
        listaEquipos.add(new Equipo("17","River Plate","river.png","PRIMERA DIVISIÓN", "CAPITAL FEDERAL", "ARGENTINA", "",-34.545278, -58.449444 , "Estadio Antonio Vespucio Liberti"));
        listaEquipos.add(new Equipo("18","San Lorenzo","sanlorenzo.png","PRIMERA DIVISIÓN", "CAPITAL FEDERAL", "ARGENTINA", "",-34.652064, -58.440119, "Estadio Nuevo Gasometro"));
        listaEquipos.add(new Equipo("19","Union de Santa Fe","union.png","PRIMERA DIVISIÓN", "SANTA FE", "ARGENTINA", "",-31.631853, -60.715867 , "Estadio 15 de Abril"));
        listaEquipos.add(new Equipo("20","Velez","velez.png","PRIMERA DIVISIÓN", "LINIERS", "ARGENTINA", "",-34.635278, -58.520833 , "Estadio José Amalfitani"));

        for(int i = 0; i < listaEquipos.size(); i++){
            Map<String, Object> postValues = toMap(listaEquipos.get((i)));
            Map<String, Object> childUpdates = new HashMap<>();
            childUpdates.put("/equipos/" + listaEquipos.get((i)).getId(), postValues);
            posicionBD.updateChildren(childUpdates);
        }
    }

    public static Map<String, Object> toMap(Equipo equipo) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("id", equipo.getId());
        result.put("nombre", equipo.getNombre().toUpperCase());
        result.put("escudo", equipo.getEscudo());
        result.put("division",equipo.getDivision());
        result.put("ciudad", equipo.getCiudad().toUpperCase());
        result.put("pais", equipo.getPais().toUpperCase());
        result.put("latitud",equipo.getLatitud());
        result.put("longitud",equipo.getLongitud());
        result.put("descripcion", equipo.getDescripcionEstadio().toUpperCase());
        return result;
    }
}
