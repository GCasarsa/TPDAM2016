package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.equipo;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.AdapterPartido;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.AdapterResultado;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database.Conexion;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Equipo;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Partido;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.R;

/**
 * Created by Gabriel on 27/01/2017.
 */
public class EquipoTabResultados  extends Fragment {
    private static Equipo equipo;
    ListView listViewPartidos;
    ArrayList<Partido> listaPartidos;
    AdapterResultado adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_equipo_tab_resultados, container, false);
        listViewPartidos = (ListView) rootView.findViewById(R.id.lvEquipoResultado);
        listaPartidos = new ArrayList<>();
        if(equipo!=null)
        new BuscarPorFechaAsyncTask().execute(equipo.getNombre());

        return rootView;
    }

    public static EquipoTabResultados newInstance(int pagina, String titulo, Equipo equipoRecibido) {
        EquipoTabResultados fragmento = new EquipoTabResultados();
        Bundle args = new Bundle();
        args.putInt("someInt", pagina);
        args.putString("someTitle", titulo);
        equipo = equipoRecibido;
        fragmento.setArguments(args);
        return fragmento;
    }


    private class BuscarPorFechaAsyncTask  extends AsyncTask<String, String, String> {
        ProgressDialog dialog = new ProgressDialog(getActivity());
        @Override
        protected void onPreExecute() {
            dialog = ProgressDialog.show(getActivity(), "Recopilando partidos", "aguarde unos instantes...");
            dialog.setCanceledOnTouchOutside(true);
        }
        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            dialog.setMessage(String.valueOf(values[0]));
        }
        @Override
        protected String doInBackground(String... fecha) {
            Conexion.buscarPartidosPorEquipo(listaPartidos,equipo.getNombre());
            return "";
        }
        @Override
        protected void onPostExecute(String r) {
            adapter = new AdapterResultado(getActivity(), listaPartidos);
            listViewPartidos.setAdapter(adapter);
            if (dialog.isShowing()) dialog.dismiss();

        }
    }
}
