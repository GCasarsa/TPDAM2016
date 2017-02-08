package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.partidos;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Map;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.VerEquiposActivity;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.equipo.AdapterTabs;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.equipo.EquipoInicio;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database.BusquedaEquipo;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database.BusquedaFinalizadaListener;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database.BusquedaPartido;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database.CargarEscudos;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Equipo;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Partido;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Inicio;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.R;

/**
 * Created by Gabriel on 01/02/2017.
 */
public class PartidoInicio extends FragmentActivity implements BusquedaFinalizadaListener<Partido> {

    private static ImageView atras, escudoL, escudoV;
    private static TextView nombreLocal, nombreVisita, resultado;
    private static Partido partido;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String id = String.valueOf(getIntent().getExtras().getLong("partido"));
        progressDialog = ProgressDialog.show(this, "Recopilando Información", "Aguarde unos instantes...");
        new BusquedaPartido(this).execute(id);

        setContentView(R.layout.activity_partido);
        escudoL = (ImageView) findViewById(R.id.ivPartidoEscudoLocal);
        escudoV = (ImageView) findViewById(R.id.ivPartidoEscudoVisitante);
        nombreLocal = (TextView) findViewById(R.id.tvPartidoNombreLocal);
        nombreVisita = (TextView) findViewById(R.id.tvPartidoNombreVisitante);
        resultado = (TextView) findViewById(R.id.tvPartidoResultado);
        atras = (ImageView) findViewById(R.id.ivPartidoAtras);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Inicio.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public void busquedaFinalizada(ArrayList<Partido> lista) {
        partido = lista.get(0);
        progressDialog.dismiss();
        nombreLocal.setText(partido.getEquipoLocal());
        nombreVisita.setText(partido.getEquipoVisitante());
        resultado.setText(partido.getResultadoLocal() + "    "+ partido.getResultadoVisitante());
        escudoL.setImageResource(CargarEscudos.cargarEscudo(partido.getEquipoLocal()));
        escudoV.setImageResource(CargarEscudos.cargarEscudo(partido.getEquipoVisitante()));
        AdapterTabsPartido adapterTabs;
        ViewPager mViewPager;
        adapterTabs = new AdapterTabsPartido(getSupportFragmentManager(), partido);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(adapterTabs);
    }
}
