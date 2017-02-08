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
/*
    public static void cargarEquipos(){
        posicionBD = database.getReference("bd");
        ArrayList<Equipo> listaEquipos = new ArrayList<>();
        listaEquipos.add(new Equipo("1","Aldosivi","aldosivi.png","PRIMERA DIVISIÓN", "MAR DEL PLATA","",-38.017944,-57.582333,"Estadio José María Minella"));
        listaEquipos.add(new Equipo("2","Arsenal de Sarandí","arsenal.png","PRIMERA DIVISIÓN", "CAPITAL FEDERAL","",-34.678333, -58.340278,"Estadio Julio Humberto Grondona"));
        listaEquipos.add(new Equipo("3","Banfield","banfield.png","PRIMERA DIVISIÓN", "CAPITAL FEDERAL","",-34.750847, -58.387544,"Estadio Florencio Sola"));
        listaEquipos.add(new Equipo("4","Belgrano","belgrano.png","PRIMERA DIVISIÓN", "CORDOBA", "", -31.368956, -64.246244, "Estadio Mario Alberto Kempes"));
        listaEquipos.add(new Equipo("5","Boca Juniors","boca.png","PRIMERA DIVISIÓN", "CAPITAL FEDERAL", "",-34.63565, -58.36465 , "Estadio Alberto J. Armando"));
        listaEquipos.add(new Equipo("6","Rosario Central","central.png","PRIMERA DIVISIÓN", "ROSARIO", "",-32.913997, -60.674567 , "Estadio Gigante de Arroyito"));
        listaEquipos.add(new Equipo("7","Colon de Santa Fe","colon.png","PRIMERA DIVISIÓN", "SANTA FE", "",-31.663217, -60.725394 , "Estadio Brigadier General Estanislao López"));
        listaEquipos.add(new Equipo("8","Defensa y Justicia","defensa.png","PRIMERA DIVISIÓN", "FLORENCIO VARELA", "",-34.821753, -58.286511 , "Estadio Norberto Tomaghello"));
        listaEquipos.add(new Equipo("9","ESTUDIANTES","estudiantes.png","PRIMERA DIVISIÓN", "LA PLATA","",-34.91375, -57.989028,"Estadio Ciudad de la Plata"));
        listaEquipos.add(new Equipo("10","Gimnasia de la Plata","gimnasia.png","PRIMERA DIVISIÓN", "LA PLATA","",-34.91375, -57.989028,"Estadio Ciudad de la Plata"));
        listaEquipos.add(new Equipo("11","Godoy Cruz","godoy.png","PRIMERA DIVISIÓN", "MENDOZA", "",-32.889564, -68.879994 , "Estadio Malvinas Argentinas"));
        listaEquipos.add(new Equipo("12","Huracan","huracan.png","PRIMERA DIVISIÓN", "CAPITAL FEDERAL", "", -34.643494, -58.396511, "Estadio Tomás Adolfo Ducó"));
        listaEquipos.add(new Equipo("13","Independiente","independiente.png","PRIMERA DIVISIÓN", "AVELLANEDA","",-34.670267, -58.370969,"Estadio Libertadores de América"));
        listaEquipos.add(new Equipo("14","Lanus","lanus.png","PRIMERA DIVISIÓN", "LANUS","",-34.717667, -58.383806,"Estadio La Fortaleza"));
        listaEquipos.add(new Equipo("15","Newells Old Boys","newells.png","PRIMERA DIVISIÓN", "ROSARIO", "",-32.956056, -60.661444 , "Estadio Marcelo Bielsa"));
        listaEquipos.add(new Equipo("16","Racing Club","racing.png","PRIMERA DIVISIÓN", "AVELLANEDA","",-34.6675, -58.368611,"Estadio Presidente Perón"));
        listaEquipos.add(new Equipo("17","River Plate","river.png","PRIMERA DIVISIÓN", "CAPITAL FEDERAL", "",-34.545278, -58.449444 , "Estadio Antonio Vespucio Liberti"));
        listaEquipos.add(new Equipo("18","San Lorenzo","sanlorenzo.png","PRIMERA DIVISIÓN", "CAPITAL FEDERAL", "",-34.652064, -58.440119, "Estadio Nuevo Gasometro"));
        listaEquipos.add(new Equipo("19","Union de Santa Fe","union.png","PRIMERA DIVISIÓN", "SANTA FE", "",-31.631853, -60.715867 , "Estadio 15 de Abril"));
        listaEquipos.add(new Equipo("20","Velez","velez.png","PRIMERA DIVISIÓN", "LINIERS", "",-34.635278, -58.520833 , "Estadio José Amalfitani"));

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
        result.put("latitud",equipo.getLatitud());
        result.put("longitud",equipo.getLongitud());
        result.put("descripcion", equipo.getDescripcionEstadio().toUpperCase());
        return result;
    }

    public static void cargarPartidos(){
        posicionBD = database.getReference("bd");
        ArrayList<Partido> listaPartidos = new ArrayList<>();
        listaPartidos.add(new Partido("1","Aldosivi","Racing Club","1", "0", "Lunati","31/01","1", "JOSE MARIA MINELLA"));
        listaPartidos.add(new Partido("2","River Plate","Gimnasia de la plata","3", "2", "Lunati","31/01","1", "ANTONIO VESPUCIO LIBERTI"));
        listaPartidos.add(new Partido("3","Boca juniors","velez","0", "7", "Lunati","31/01","1", "ALBERTO J. ARMANDO"));
        listaPartidos.add(new Partido("4","Union de santa fe","ESTUDIANTES","4", "1", "Lunati","01/02","1", "15 DE ABRIL"));
        listaPartidos.add(new Partido("5","colon de santa fe","independiente","2", "0", "Lunati","01/02","1", "GENERAL ESTANISLAO LOPEZ"));
        listaPartidos.add(new Partido("6","defensa y justicia","san lorenzo","1", "3", "Lunati","01/02","1", "NORBERTO TOMAGHELLO"));

        listaPartidos.add(new Partido("7","independiente","Racing Club","1", "2", "Lunati","31/01","2", "LIBERTADORES DE AMÉRICA"));
        listaPartidos.add(new Partido("8","River Plate","Gimnasia de la plata","3", "2", "Lunati","31/01","2", "ANTONIO VESPUCIO LIBERTI"));
        listaPartidos.add(new Partido("9","ESTUDIANTES","velez","2", "4", "Lunati","31/01","2", "Jose Maria Minella"));
        listaPartidos.add(new Partido("10","Union de santa fe","boca juniors","6", "3", "Lunati","01/02","2", "15 DE ABRIL"));
        listaPartidos.add(new Partido("11","san lorenzo","Aldosivi","2", "0", "Lunati","01/02","2", "NUEVO GASOMETRO"));
        listaPartidos.add(new Partido("12","defensa y justicia","colon de santa fe","1", "3", "Lunati","01/02","2", "NORBERTO TOMAGHELLO"));

        listaPartidos.add(new Partido("13","huracan","Racing Club","", "", "Lunati","31/01","3", "TOMÁS DUCÓ"));
        listaPartidos.add(new Partido("14","colon de santa fe","Gimnasia de la plata","", "", "Lunati","31/01","3", "Monumental"));
        listaPartidos.add(new Partido("15","san lorenzo","Union de santa fe","", "", "Lunati","31/01","3", "Jose Maria Minella"));
        listaPartidos.add(new Partido("16","VELEZ","GODOY CRUZ","", "", "Lunati","01/02","3", "Jose Maria Minella"));
        listaPartidos.add(new Partido("17","ALDOSIVI","LANUS","", "", "Lunati","01/02","3", "Jose Maria Minella"));
        listaPartidos.add(new Partido("18","NEWELLS OLD BOYS","ROSARIO CENTRAL","", "", "Lunati","01/02","3", "Jose Maria Minella"));
        for(int i = 0; i < listaPartidos.size(); i++){
            Map<String, Object> postValues = toMap(listaPartidos.get((i)));
            Map<String, Object> childUpdates = new HashMap<>();
            //childUpdates.put("/fixture/" +listaPartidos.get(i).getFecha() + "/" + listaPartidos.get((i)).getIdPartido(), postValues);
            childUpdates.put("/partidos/" + listaPartidos.get((i)).getIdPartido(), postValues);
            posicionBD.updateChildren(childUpdates);
        }
    }

    public static void cargarFixture(){
        posicionBD = database.getReference("bd");
        ArrayList<Partido> listaPartidos = new ArrayList<>();
        listaPartidos.add(new Partido("1","Aldosivi","Racing Club","1", "0", "Lunati","31/01","1", "Jose Maria Minella"));
        listaPartidos.add(new Partido("2","Aldosivi","Independiente","1", "0", "Lunati","07/02","2", "Jose Maria Minella"));
        listaPartidos.add(new Partido("3","River plate","Aldosivi","1", "0", "Lunati","14/02","3", "Jose Maria Minella"));
        listaPartidos.add(new Partido("4","Aldosivi","estudiantes","1", "0", "Lunati","20/02","4", "Jose Maria Minella"));
        listaPartidos.add(new Partido("5","union de santa fe","Aldosivi","1", "0", "Lunati","28/02","5", "Jose Maria Minella"));
        listaPartidos.add(new Partido("6","Aldosivi","Colon de santa fe","1", "0", "Lunati","05/03","6", "Jose Maria Minella"));
        listaPartidos.add(new Partido("7","Boca Juniors","Aldosivi","1", "0", "Lunati","12/03","7", "Jose Maria Minella"));



        for(int i = 0; i < listaPartidos.size(); i++){
            Map<String, Object> postValues = toMap(listaPartidos.get((i)));
            Map<String, Object> childUpdates = new HashMap<>();
            childUpdates.put("/fixture/" + listaPartidos.get((i)).getIdPartido(), postValues);
            posicionBD.updateChildren(childUpdates);
        }
    }

    public static Map<String, Object> toMap(Partido partido) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("id", partido.getIdPartido());
        result.put("equipoLocal", partido.getEquipoLocal().toUpperCase());
        result.put("resultadoLocal", partido.getResultadoLocal());
        result.put("resultadoVisitante",partido.getResultadoVisitante());
        result.put("equipoVisitante", partido.getEquipoVisitante().toUpperCase());
        result.put("fecha", partido.getFecha());
        result.put("dia",partido.getDia());
        result.put("estadio",partido.getLugar().toUpperCase());
        result.put("arbitro", partido.getArbitro().toUpperCase());
        return result;
    }*/
}
