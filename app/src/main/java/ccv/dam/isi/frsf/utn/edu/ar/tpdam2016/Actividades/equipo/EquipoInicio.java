package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.equipo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.AdapterTabs;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Inicio;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.R;

/**
 * Created by Gabriel on 27/01/2017.
 */
public class EquipoInicio extends FragmentActivity {

    private static ImageView atras;
    private static TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_equipo);
        titulo = (TextView) findViewById(R.id.tvEquipoTitulo);
        titulo.setText("Detalle Equipo");
        atras = (ImageView) findViewById(R.id.ivEquipoAtras);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Inicio.class);
                startActivity(intent);
            }
        });

        AdapterTabs adapterTabs;
        ViewPager mViewPager;
        adapterTabs = new AdapterTabs(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(adapterTabs);

    }
}
