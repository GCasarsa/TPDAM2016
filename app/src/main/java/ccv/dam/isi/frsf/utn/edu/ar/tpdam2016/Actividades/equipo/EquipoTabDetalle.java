package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.equipo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerTitleStrip;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.R;

/**
 * Created by Gabriel on 29/01/2017.
 */
public class EquipoTabDetalle extends Fragment {

    private static ImageView escudo;
    private static TextView nombre;
    private Bundle extras;
    private static FirebaseDatabase database = FirebaseDatabase.getInstance();
    private static DatabaseReference posicionBD;
    private static ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Equipo equipo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_equipo_tab_detalle, container, false);
        extras = getActivity().getIntent().getExtras();
        String id = String.valueOf(extras.getLong("equipo"));
        buscarEquipo(id);

        escudo = (ImageView) rootView.findViewById(R.id.ivEquipoEscudo);
        nombre = (TextView) rootView.findViewById(R.id.tvEquipoNombre);


        return rootView;
    }

    public static EquipoTabDetalle newInstance(int pagina, String titulo) {
        EquipoTabDetalle fragmentFirst = new EquipoTabDetalle();
        Bundle args = new Bundle();
        args.putInt("someInt", pagina);
        args.putString("someTitle", titulo);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    public static void buscarEquipo(final String idEquipo){
        posicionBD = database.getReference("bd/equipos");
        posicionBD.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                Map<String, Object> newPost = (Map<String, Object>) snapshot.getValue();
                if(newPost.get("id").equals(idEquipo)){
                    equipo = new ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Equipo(newPost.get("id").toString(),newPost.get("nombre").toString(), newPost.get("escudo").toString(),newPost.get("division").toString());

                    nombre.setText(equipo.getNombre());

                    if(equipo.getNombre().equals("ALDOSIVI")) escudo.setImageResource(R.drawable.escudo_aldosivi);
                    else if(equipo.getNombre().equals("ARSENAL")) escudo.setImageResource(R.drawable.escudo_arsenal);
                    else if(equipo.getNombre().equals("BANFIELD")) escudo.setImageResource(R.drawable.escudo_banfield);
                    else if(equipo.getNombre().equals("BELGRANO")) escudo.setImageResource(R.drawable.escudo_belgrano);
                    else if(equipo.getNombre().equals("BOCA")) escudo.setImageResource(R.drawable.escudo_boca);
                    else if(equipo.getNombre().equals("CENTRAL")) escudo.setImageResource(R.drawable.escudo_central);
                    else if(equipo.getNombre().equals("COLON")) escudo.setImageResource(R.drawable.escudo_colon);
                    else if(equipo.getNombre().equals("DEFENSA")) escudo.setImageResource(R.drawable.escudo_defensa);
                    else if(equipo.getNombre().equals("ESTUDIANTES")) escudo.setImageResource(R.drawable.escudo_estudiantes);
                    else if(equipo.getNombre().equals("GIMNASIA DE LA PLATA")) escudo.setImageResource(R.drawable.escudo_gimnasia);
                    else if(equipo.getNombre().equals("GODOY CRUZ")) escudo.setImageResource(R.drawable.escudo_godoy);
                    else if(equipo.getNombre().equals("HURACAN")) escudo.setImageResource(R.drawable.escudo_huracan);
                    else if(equipo.getNombre().equals("INDEPENDIENTE")) escudo.setImageResource(R.drawable.escudo_independiente);
                    else if(equipo.getNombre().equals("LANUS")) escudo.setImageResource(R.drawable.escudo_lanus);
                    else if(equipo.getNombre().equals("NEWELLS")) escudo.setImageResource(R.drawable.escudo_newells);
                    else if(equipo.getNombre().equals("RIVER")) escudo.setImageResource(R.drawable.escudo_river);
                    else if(equipo.getNombre().equals("SAN LORENZO")) escudo.setImageResource(R.drawable.escudo_sanlorenzo);
                    else if(equipo.getNombre().equals("UNION")) escudo.setImageResource(R.drawable.escudo_union);
                    else if(equipo.getNombre().equals("VELEZ")) escudo.setImageResource(R.drawable.escudo_velez);
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
}
